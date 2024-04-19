package com.abc.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.orderservice.entity.Order;
import com.abc.orderservice.payload.OrderItemPayload;
import com.abc.orderservice.payload.OrderPayload;
import com.abc.orderservice.service.OrderService;


@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@PostMapping("/save")
	public ResponseEntity<Order> placeOrder(@RequestBody OrderPayload orderPayload) {
		
		int customerId = orderPayload.getCustomerId();		
		List<OrderItemPayload> productOrders = orderPayload.getOrderItems();		
		
		Order order = orderService.createOrder(customerId, productOrders);		
		Order newOrder = orderService.saveOrder(order);
		
		return new ResponseEntity<>(newOrder,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> fetchOrderDetails(@PathVariable("id") int orderId) {
		Order order = orderService.getOrderDetails(orderId);
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<Order> fetchAllOrders() {
		List<Order> orders = orderService.getAllOrders();
		return orders;
	}
	
//	@GetMapping("/customer")
//	public List<Order> fetchAllOrdersByCustomer(@RequestParam("customerId") int customerId) {
//		List<Order> orders = orderService.getAllOrdersByCustomer(customerId);
//		return orders;
//	}
}
