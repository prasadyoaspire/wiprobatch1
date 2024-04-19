package com.abc.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.orderservice.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer>{

}
