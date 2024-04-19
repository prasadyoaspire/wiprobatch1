package com.abc.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.customerservice.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
