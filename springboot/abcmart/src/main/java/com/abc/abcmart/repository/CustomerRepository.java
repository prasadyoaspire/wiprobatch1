package com.abc.abcmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.abcmart.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
