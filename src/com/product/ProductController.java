package com.product;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class ProductController {
    private final HashMap<String, Product> products;
    private final HashMap<String, WareHouse> wareHouses;
    private static ProductController instance;

    private ProductController(){
        products = new HashMap<>();
        wareHouses = new HashMap<>();
    }

    public static ProductController getInstance(){
        if(instance == null)
            instance = new ProductController();
        return instance;
    }

    public boolean productCanOrder(String productId, int quantity){
        if(products.containsKey(productId)){
            int counts = getProductCounts(productId,
                    wareHouses.values().stream()
                            .filter(wareHouse -> wareHouse.isProductStored(productId)).toList());
            return (counts >= quantity);
        }
        return false;
    }

    private int getProductCounts(String productId, List<WareHouse> list) {
        int counts = 0;

        for (WareHouse wareHouse : list) {
            counts += wareHouse.productCounts(productId);
        }
        return counts;
    }

    public int productPrice(String productId) {
        return products.get(productId).getProductPrice();
    }

    public void addProduct(String productId, String productName, int productPrice){
        products.put(productId, new Product(productId, productName, productPrice));
    }

    public void addWareHouse(String houseName, String houseAddress, String houseTel){
        WareHouse wareHouse = new WareHouse();
        wareHouse.setHouseName(houseName);
        wareHouse.setHouseAddress(houseAddress);
        wareHouse.setHouseTel(houseTel);
        wareHouses.put(houseAddress, wareHouse);
    }

    public void storeProductIntoWareHouse(String houseAddress, String productId, int num){
        wareHouses.get(houseAddress).storeProduct(productId, num);
    }

    public void setProductsIntoWareHouse(String houseAddress, String productId, int num){
        wareHouses.get(houseAddress).setProductCounts(productId, num);
    }

    public boolean orderProductsWhereWareHouse(String productId, int num){
        if(productCanOrder(productId, num)){
            List<WareHouse> wareHouseList = wareHouses.values()
                    .stream().filter(wareHouse -> wareHouse.isProductStored(productId)).toList();
            for(WareHouse wareHouse : wareHouseList){
                if(num >= wareHouse.productCounts(productId)){
                    num -= wareHouse.productCounts(productId);
                    wareHouse.setProductCounts(productId, 0);
                }
                else{
                    return wareHouse.orderProduct(productId, num);
                }
            }
        }
        return false;
    }
}
