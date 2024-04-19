package com.abc.orderservice.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="order_tbl")
public class Order {

	@Id
	@Column(name="order_id", length=5)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int orderId;
	
	@Column(name="order_total")
	private double orderTotal;
	
	@Column(name="order_date")
	private LocalDate orderDate;
	
	@Column(name="order_status", length = 10)
	private String orderStatus;	
	
	@Column(name="customer_id")
	private int customerId;
	
	@OneToMany(mappedBy="order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
}
