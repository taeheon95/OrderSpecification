package com.product;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WareHouse {

    private final HashMap<String, Integer> productCounts;

    private String houseName;
    private String houseAddress;
    private String houseTel;

    WareHouse() {
        this.productCounts = new HashMap<>();
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public String getHouseTel() {
        return houseTel;
    }

    public void setHouseTel(String houseTel) {
        this.houseTel = houseTel;
    }

    boolean isProductStored(String productId) {
        return productCounts.containsKey(productId);
    }

    int productCounts(String productId) {
        return productCounts.get(productId);
    }

    void storeProduct(String productId, int num) {
        int temp;

        if (isProductStored(productId)) {
            temp = productCounts.get(productId) + num;
        } else {
            temp = num;
        }

        productCounts.put(productId, temp);
    }

    boolean orderProduct(String productId, int num) {

        if (isProductStored(productId)) {
            if (num <= productCounts.get(productId)) {
                int temp;
                temp = productCounts.get(productId) - num;
                productCounts.put(productId, temp);
                return true;
            }
        }

        return false;
    }

    void showProducts() {
        System.out.println("저장된 품목들 :");
        productCounts.forEach((k, v) -> System.out.println("{" + k + "," + v + "}"));
    }

    void showProduct(String productId) {
        if (isProductStored(productId))
            System.out.println("{" + productId + "," + productCounts.get(productId) + "}");
    }

    void setProductCounts(String productId, int counts){
    	productCounts.put(productId, counts);
	}

    @Override
    public String toString() {
        return "창고 [" +
                "창고 이름 = '" + getHouseName() + '\'' +
                ", 창고 주소 = '" + getHouseAddress() + '\'' +
                ", 창고 전화 번호'" + getHouseTel() + '\'' +
                ']';
    }
}
