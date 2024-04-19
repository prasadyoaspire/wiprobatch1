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
	public Order getOrderDetails(int orderId) {	
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if(optionalOrder.isEmpty()) {
			throw new ResourceNotFoundException("Order not found with id: "+orderId);
		}		
		Order order = optionalOrder.get();		
		return order;
	}
	
	@Override
	public List<Order> getAllOrders() {
		List<Order> orderList = orderRepository.findAll();
		return  orderList;
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
