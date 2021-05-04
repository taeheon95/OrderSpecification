package com.order;

final class OrderSpecification {
	
	private final String productId;
	private int orderQuantity;
	private double discount;
	
	OrderSpecification(String productId, int orderQuantity) {
		this.productId = productId;
		this.orderQuantity = orderQuantity;
		setDiscount();
	}

	int getOrderQuantity() {
		return orderQuantity;
	}
	void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
		setDiscount();
	}
	double getDiscount() {
		return discount;
	}
	private void setDiscount() {
		if( orderQuantity >= 1000)
			discount = 0.9;
		else discount = 1.0;
	}
	String getProductId() {
		return productId;
	}


	@Override
	public String toString() {
		return "주문 상세 : ["
				+ "제품 ID = " + getProductId() + ", "
				+ "제품 수량 = " + getOrderQuantity() + ", "
				+ "할일률 = " + getDiscount() +
				"]";
	}

	public void addQuantity(OrderSpecification os) {
		this.orderQuantity += os.getOrderQuantity();
	}
}
