package com.jbk.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	private long productId;
	private String productName;
	private long supplierId;
	private long categoryId;
	private int productQTY;
	private double productPrice;
	
	
	public Product() {
	}


	public Product(long productId, String productName, long supplierId, long categoryId, int productQTY,
			double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
		this.productQTY = productQTY;
		this.productPrice = productPrice;
	}


	public long getProductId() {
		return productId;
	}


	public void setProductId(long productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public long getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}


	public long getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}


	public int getProductQTY() {
		return productQTY;
	}


	public void setProductQTY(int productQTY) {
		this.productQTY = productQTY;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", supplierId=" + supplierId
				+ ", categoryId=" + categoryId + ", productQTY=" + productQTY + ", productPrice=" + productPrice + "]";
	}


	
	
	
}
