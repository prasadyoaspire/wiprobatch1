package com.abc.abcmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.abcmart.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer>{

}
