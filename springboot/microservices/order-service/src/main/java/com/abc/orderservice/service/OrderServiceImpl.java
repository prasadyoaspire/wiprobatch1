package com.abc.orderservice.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.orderservice.entity.Order;
import com.abc.orderservice.entity.OrderItem;
import com.abc.orderservice.exception.ResourceNotFoundException;
import com.abc.orderservice.model.Customer;
import com.abc.orderservice.model.OrderItemResponse;
import com.abc.orderservice.model.OrderResponse;
import com.abc.orderservice.model.Product;
import com.abc.orderservice.payload.OrderItemPayload;
import com.abc.orderservice.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductServiceConsumer productService ;
	
	@Autowired
	private CustomerServiceConsumer customerService ;

	
	@Override
	public Order saveOrder(Order order) {
		orderRepository.save(order);
		return order;
	}

	@Override
	
	public OrderResponse getOrderDetails(int orderId) {	
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if(optionalOrder.isEmpty()) {
			throw new ResourceNotFoundException("Order not found with id: "+orderId);
		}		
		Order order = optionalOrder.get();		
		
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrderId(order.getOrderId());
		orderResponse.setOrderDate(order.getOrderDate());
		orderResponse.setOrderTotal(order.getOrderTotal());
		orderResponse.setOrderStatus(order.getOrderStatus());
		
		int customerId= order.getCustomerId();		
		Customer customer = customerService.getCustomerDetails(customerId);
		
		orderResponse.setCustomer(customer);
		
		List<OrderItemResponse> orderItems = new ArrayList<>();
		
		List<OrderItem> oitems = order.getOrderItems();
		
		for(OrderItem oi : oitems) {			
			OrderItemResponse oitemResp = new OrderItemResponse();
			oitemResp.setOrderItemId(oi.getOrderItemId());
			oitemResp.setItemTotal(oi.getItemTotal());
			oitemResp.setQuantity(oi.getQuantity());
			
			int pid = oi.getProductId();
			Product product = productService.getProductById(pid);
			oitemResp.setProduct(product);
			
			orderItems.add(oitemResp);
		}
		
		orderResponse.setOrderItems(orderItems);
			
		return orderResponse;
	}
	
	
	
	@Override
	public List<OrderResponse> getAllOrders() {
		List<Order> orderList = orderRepository.findAll();		
		List<OrderResponse> orderResponseList = new ArrayList<>();
		for(Order order: orderList) {
			OrderResponse orderResponse = new OrderResponse();
			orderResponse.setOrderId(order.getOrderId());
			orderResponse.setOrderDate(order.getOrderDate());
			orderResponse.setOrderTotal(order.getOrderTotal());
			orderResponse.setOrderStatus(order.getOrderStatus());
			
			int customerId= order.getCustomerId();		
			Customer customer = customerService.getCustomerDetails(customerId);
			
			orderResponse.setCustomer(customer);
			
			List<OrderItemResponse> orderItems = new ArrayList<>();
			
			List<OrderItem> oitems = order.getOrderItems();
			
			for(OrderItem oi : oitems) {			
				OrderItemResponse oitemResp = new OrderItemResponse();
				oitemResp.setOrderItemId(oi.getOrderItemId());
				oitemResp.setItemTotal(oi.getItemTotal());
				oitemResp.setQuantity(oi.getQuantity());
				
				int pid = oi.getProductId();
				Product product = productService.getProductById(pid);
				oitemResp.setProduct(product);
				
				orderItems.add(oitemResp);
			}
			
			orderResponse.setOrderItems(orderItems);
			orderResponseList.add(orderResponse);
			
		}
		
		return  orderResponseList;
	}

	@Override
	public Order createOrder(int customerId, List<OrderItemPayload> selectedProducts) {
		
		Customer customer = customerService.getCustomerDetails(customerId);
		
		Order order = new Order();
		order.setOrderDate(LocalDate.now());
		order.setOrderStatus("pending");
		order.setCustomerId(customerId);
		
		List<OrderItem> orderItems = new ArrayList<>();		

		double orderTotal = 0;	
		
		for(OrderItemPayload po: selectedProducts)  {			
			int productId = po.getProductId();
			int qty = po.getQantity();			
			Product product = productService.getProductById(productId);
			System.out.println("Itemtotal: "+product.getProductPrice()*qty);
			
			OrderItem orderItem = new OrderItem();
			orderItem.setProductId(productId);
			orderItem.setItemTotal(product.getProductPrice()*qty);			
			orderItem.setQuantity(qty);			
			orderItems.add(orderItem);
			
			orderTotal = orderTotal+(product.getProductPrice()*qty);
			
			orderItem.setOrder(order);		
		};
		
		order.setOrderTotal(orderTotal);
		order.setOrderItems(orderItems);
		return order;
	}

}
