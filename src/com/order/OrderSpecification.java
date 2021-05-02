package com.order;

class OrderSpecification {
	
	private String productId;
	private int orderQuantity;
	private double discount;
	
	OrderSpecification(String productId, int orderQuantity, double discount) {
		this.productId = productId;
		this.orderQuantity = orderQuantity;
		this.discount = discount;
	}
	
	
	int getOrderQuantity() {
		return orderQuantity;
	}
	void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	double getDiscount() {
		return discount;
	}
	void setDiscount(double discount) {
		this.discount = discount;
	}
	String getProductId() {
		return productId;
	}
	void setProduct(String productId) {
		this.productId = productId;
	}


	@Override
	public String toString() {
		return "OrderSpecification ["
				+ "productId=" + productId + ", "
				+ "orderQuantity=" + orderQuantity + ", "
				+ "discount=" + discount +
				"]";
	}
	
	
}
