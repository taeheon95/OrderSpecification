package com.product;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class ProductController {
    private final HashMap<String, Product> products;
    private final HashSet<WareHouse> wareHouses;
    private static ProductController instance;

    private ProductController(){
        products = new HashMap<>();
        wareHouses = new HashSet<>();
    }

    public static ProductController getInstance(){
        if(instance == null)
            instance = new ProductController();
        return instance;
    }

    public boolean productCanOrder(String productId, int quantity){
        if(products.containsKey(productId)){
            int counts = getProductCounts(productId);
            return (counts >= quantity);
        }
        return false;
    }

    private int getProductCounts(String productId) {
        int counts = 0;

        for (WareHouse wareHouse : wareHouses) {
            counts += wareHouse.productCounts(productId);
        }
        return counts;
    }

}
