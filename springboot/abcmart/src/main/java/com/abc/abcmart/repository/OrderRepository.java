package com.abc.abcmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.abcmart.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
