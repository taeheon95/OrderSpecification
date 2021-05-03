package com.order;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;

public class Order {
	
	private final int orderNum;
	private final Date date;
	private final int customerNum;
	private LinkedList<OrderSpecification> orderSpecificationList;
	
	Order(int orderNum, Date date, int customerNum, LinkedList<OrderSpecification> os) {
		this.orderNum = orderNum;
		this.date = date;
		this.customerNum = customerNum;
		this.orderSpecificationList = os;
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
		orderSpecificationList.add(os);
	}
	
	boolean deleteProduct(String productId) {
		for (Iterator<OrderSpecification> iterator = orderSpecificationList.iterator(); iterator.hasNext();) {
			if(iterator.next().getProductId().equals(productId)) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}
	
	
	LinkedList<OrderSpecification> getOrderSpecificationList() {
		return orderSpecificationList;
	}

	void setOrderSpecificationList(LinkedList<OrderSpecification> orderSpecificationList) {
		this.orderSpecificationList = orderSpecificationList;
	}

	void deleteAllProduct() {
		orderSpecificationList.clear();
	}

	@Override
	public String toString() {
		return "주문 ["
				+ "주문 번호=" + orderNum + ", "
				+ "주문 날짜=" + getDate() + ", "
				+ "고객 번호=" + customerNum + ", "
				+ "주문 개수=" + orderSpecificationList.size() +
				"]";
	}
}
