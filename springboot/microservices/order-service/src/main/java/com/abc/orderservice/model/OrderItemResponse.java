package com.abc.orderservice.model;

public class OrderItemResponse {

	private int orderItemId;
	private int quantity;	
	private Product product;
	private double itemTotal;
	
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public double getItemTotal() {
		return itemTotal;
	}
	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}	
}
