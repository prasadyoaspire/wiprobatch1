package com.abc.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orderitem_tbl")
public class OrderItem {

	@Id
	@Column(name="orderitem_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int orderItemId;
	
	@Column(length=2)
	private int quantity;
	
	@Column(name="product_id")
	private int productId;
	
	@Column(name="item_total")
	private double itemTotal;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	@JsonIgnore
	private Order order;

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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}	
}
