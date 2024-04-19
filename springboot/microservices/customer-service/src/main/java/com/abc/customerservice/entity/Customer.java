package com.abc.customerservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer_tbl")
public class Customer {

	@Id
	@Column(name="customer_id", length = 5)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int customerId;
	
	@Column(length = 20)
	private String firstName;
	
	@Column(length = 20)
	private String lastName;
	
	@Column(length = 20)
	private String email;
	
	@Column(length = 10)
	private String mobile;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}	

}

