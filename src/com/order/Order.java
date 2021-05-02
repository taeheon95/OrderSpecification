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
	
	Order(int orderNum, Date date, int customerNum) {
		this.orderNum = orderNum;
		this.date = date;
		this.customerNum = customerNum;
		this.orderSpecificationList = new LinkedList<OrderSpecification>();
	}
	
	int getOrderNum() {
		return orderNum;
	}

	String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일");
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

	@Override
	public String toString() {
		return "Order ["
				+ "주문 번호=" + orderNum + ", "
				+ "주문 날짜=" + getDate() + ", "
				+ "고객 번호=" + customerNum + ", " 
				+ "주문 개수=" + orderSpecificationList.size() +
				"]";
	}
}
