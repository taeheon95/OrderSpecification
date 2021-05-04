package com.order;

import java.util.*;
import java.text.SimpleDateFormat;

public class Order {
	
	private final int orderNum;
	private final Date date;
	private final int customerNum;
	private final HashMap<String, OrderSpecification> specificationMap;
	
	Order(int orderNum, Date date, int customerNum) {
		this.orderNum = orderNum;
		this.date = date;
		this.customerNum = customerNum;
		this.specificationMap = new HashMap<>();
	}
	
	int getOrderNum() {
		return orderNum;
	}

	String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM월 dd일");
		return sdf.format(date);
	}
	
	public int getCustomerNum() {
		return customerNum;
	}

	void addProduct(OrderSpecification os) {
		if(specificationMap.containsKey(os.getProductId())){
			specificationMap.get(os.getProductId()).addQuantity(os);
		}
		specificationMap.put(os.getProductId(), os);
	}
	
	boolean deleteProduct(String productId) {
		if(!specificationMap.containsKey(productId))
			return false;
		specificationMap.remove(productId);
		return true;
	}
	
	
	List<OrderSpecification> getOrderSpecificationList() {
		return specificationMap.values().stream().toList();
	}

	void deleteAllProduct() {
		specificationMap.clear();
	}

	OrderSpecification getOrderSpecification(String productId){
		return specificationMap.get(productId);
	}

	@Override
	public String toString() {
		return "주문 ["
				+ "주문 번호 : " + orderNum + ", "
				+ "주문 날짜 : " + getDate() + ", "
				+ "고객 번호 : " + customerNum + ", "
				+ "주문 개수 : " + specificationMap.size() +
				"]";
	}
}
