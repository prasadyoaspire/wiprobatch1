package com.abc.orderservice.payload;

import java.util.ArrayList;
import java.util.List;

public class OrderPayload {

	private int customerId;	
	private List<OrderItemPayload> orderItems = new ArrayList<>();

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public List<OrderItemPayload> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemPayload> orderItems) {
		this.orderItems = orderItems;
	}	
}
