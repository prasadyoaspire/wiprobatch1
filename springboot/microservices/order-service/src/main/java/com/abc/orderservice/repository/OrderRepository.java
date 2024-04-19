package com.abc.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
