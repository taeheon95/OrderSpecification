package com.product;

public class Product {
	
	private final String productId;
	private String productName;
	private int productPrice;

	Product(String productId, String productName, int productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	String getProductName() {
		return productName;
	}

	void setProductName(String productName) {
		this.productName = productName;
	}

	int getProductPrice() {
		return productPrice;
	}

	void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	String getProductId() {
		return productId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productId == null) {
			return other.productId == null;
		} else return productId.equals(other.productId);
	}
	
	
}
