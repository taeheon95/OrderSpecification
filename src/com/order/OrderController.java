package com.order;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import com.customer.Customer;

public class OrderController {
	private static int ORDER_NUM = 0;
	private static OrderController instance = new OrderController();
	private static LinkedList<Order> orders = new LinkedList<Order>();
	
	private OrderController() {
		
	}
	
	public static OrderController getInstance() {
		return instance;
	}
	
	public int makeOrder(Customer customer, OrderSpecification[] os) {
		if(ORDER_NUM < 100) {
			Order newOrder = new Order(ORDER_NUM++, new Date(), customer.getCus_num());
			for (OrderSpecification orderSpecification : os) {
				newOrder.addProduct(orderSpecification);
			}
			orders.add(newOrder);
			return newOrder.getOrderNum();			
		}
		return -1;
	}
	
	public boolean addOrderSpecification(int orderNum, OrderSpecification os) {
		for (Order order : orders) {
			if(order.getOrderNum() == orderNum) {
				order.addProduct(os);
				return true;
			}
		}
		return false;
	}
	
	public boolean removeOrderSpecification(int orderNum, String productId) {
		for (Order order : orders) {
			if(order.getOrderNum() == orderNum) {
				return order.deleteProduct(productId);
			}
		}
		return false;
	}
	
	public boolean removeOrder(int orderNum) {
		for (Iterator<Order> it = orders.iterator(); it.hasNext();) {
			if(it.next().getOrderNum() == orderNum) {
				it.remove();
				return true;
			}
		}
		return false;
	}
	
	public boolean searchOrder(int orderNum, Order order) {
		for(int i=0; i<orders.size(); i++) {
			Order temp = orders.get(i);
			if(temp.getOrderNum() == orderNum) {
				order = temp;
				return true;
			}
		}
		return false;
	}
	
	public boolean getOrderDate(int orderNum, StringBuffer orderDateStr) {
		for (Iterator<Order> iterator = orders.iterator(); iterator.hasNext();) {
			Order order = iterator.next();
			if(order.getOrderNum() == orderNum) {
				orderDateStr = new StringBuffer(order.getDate());
				return true;
			}
		}
		return false;
	}
	
	public LinkedList<Order> returnOrders(){
		return orders;
	}
}
