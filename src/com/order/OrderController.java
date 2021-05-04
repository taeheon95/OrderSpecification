package com.order;

import java.util.*;

public class OrderController {
	private static int ORDER_NUM = 0;
	private static OrderController instance;
	private final HashMap<Integer,Order> orders;
	
	private OrderController() {
		orders = new HashMap<>();
	}
	
	static OrderController getInstance() {
		if(instance == null){
			instance = new OrderController();
		}
		return instance;
	}

	Order getOrder(int order_num){
		return orders.get(order_num);
	}
	
	int makeOrder(int cus_num) {
		Order newOrder = new Order(ORDER_NUM, new Date(), cus_num);
		orders.put(ORDER_NUM, newOrder);
		return ORDER_NUM++;
	}
	
	void addOrderSpecification(int orderNum, OrderSpecification os) {
		Order order = orders.get(orderNum);
		if(order != null){
			order.addProduct(os);
		}
	}
	
	boolean removeOrder(int orderNum) {
		Order order = orders.get(orderNum);
		if(order != null){
			Order remove = orders.remove(orderNum);
			remove.deleteAllProduct();
			return true;
		}
		return false;
	}
}
