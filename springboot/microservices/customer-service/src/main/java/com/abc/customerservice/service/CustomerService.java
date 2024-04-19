package com.abc.customerservice.service;

import java.util.List;

import com.abc.customerservice.entity.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);
	
	Customer getCustomerById(int customerId);
	
	List<Customer> getAllCustomers();
}
