package com.order;

import java.util.*;

public class OrderController {
	private static int ORDER_NUM = 0;
	private static OrderController instance;
	private final HashMap<Integer,Order> orders;
	
	private OrderController() {
		orders = new HashMap<>();
	}
	
	public static OrderController getInstance() {
		if(instance == null){
			instance = new OrderController();
		}
		return instance;
	}

	Order getOrder(int order_num){
		return orders.get(order_num);
	}
	
	public int makeOrder(int cus_num, LinkedList<OrderSpecification> os) {
		Order newOrder = new Order(ORDER_NUM, new Date(), cus_num, os);
		orders.put(ORDER_NUM, newOrder);
		return ORDER_NUM++;
	}
	
	public boolean addOrderSpecification(int orderNum, OrderSpecification os) {
		Order order = orders.get(orderNum);
		if(order != null){
			order.addProduct(os);
			return true;
		}
		return false;
	}
	
	public boolean removeOrderSpecification(int orderNum, String productId) {
		Order order = orders.get(orderNum);
		if(order != null){
			return order.deleteProduct(productId);
		}
		return false;
	}
	
	public boolean removeOrder(int orderNum) {
		Order order = orders.get(orderNum);
		if(order != null){
			Order remove = orders.remove(orderNum);
			remove.deleteAllProduct();
			return true;
		}
		return false;
	}
	
	public boolean getOrderDate(int orderNum, StringBuffer orderDateStr) {
		if(getOrder(orderNum) != null){
			orderDateStr = new StringBuffer(getOrder(orderNum).getDate());
			return true;
		}
		return false;
	}
	
	public Order[] returnOrders(){
		return (Order[]) orders.values().toArray();
	}
}
