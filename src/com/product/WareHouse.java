package com.product;

import java.util.HashMap;
import java.util.Map;

public class WareHouse {
	
	private Map<String, Integer> productCounts;

//	private String houseName;
//	private String houseAddress;
//	private String houseTel;
	
	WareHouse() {
		this.productCounts = new HashMap<>();
	}
	
//	public String getHouseName() {
//		return houseName;
//	}
//	public void setHouseName(String houseName) {
//		this.houseName = houseName;
//	}
//	public String getHouseAddress() {
//		return houseAddress;
//	}
//	public void setHouseAddress(String houseAddress) {
//		this.houseAddress = houseAddress;
//	}
//	public String getHouseTel() {
//		return houseTel;
//	}
//	public void setHouseTel(String houseTel) {
//		this.houseTel = houseTel;
//	}
	
	boolean isProductStored(String productId) {
		return productCounts.containsKey(productId);
	}
	
	void storeProduct(Product product, int num) {
		int temp;
		String productId = product.getProductId();
		
		if(isProductStored(productId)) {
			temp = productCounts.get(productId) + num;
		}else {
			temp = num;
		}
		
		productCounts.put(productId, temp);
	}
	
	boolean orderProduct(String productId, int num) {
		
		if(isProductStored(productId)) {
			if(num <= productCounts.get(productId)) {
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
		productCounts.forEach((k,v)-> System.out.println("{"+k+","+v+"}"));
	}
	
	void showProduct(String productId) {
		if(isProductStored(productId))
			System.out.println("{" + productId + "," + productCounts.get(productId) + "}");
	}
}
