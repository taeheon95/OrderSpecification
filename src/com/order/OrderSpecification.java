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
	void setProductId(String productId) {
		this.productId = productId;
	}


	@Override
	public String toString() {
		return "주문 상세 : ["
				+ "제품 ID = " + getProductId() + ", "
				+ "제품 수량 = " + getOrderQuantity() + ", "
				+ "할일률 = " + getDiscount() +
				"]";
	}
}
