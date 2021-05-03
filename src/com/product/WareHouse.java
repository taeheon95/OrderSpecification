package com.product;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WareHouse {
	
	private final Map<String, Integer> productCounts;

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

	int productCounts(String productId){
		return productCounts.get(productId);
	}

	void storeProduct(String productId, int num) {
		int temp;
		
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof WareHouse)) return false;
		WareHouse wareHouse = (WareHouse) o;
		return getHouseName().equals(wareHouse.getHouseName()) && getHouseAddress().equals(wareHouse.getHouseAddress()) && getHouseTel().equals(wareHouse.getHouseTel());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getHouseName(), getHouseAddress(), getHouseTel());
	}
}
