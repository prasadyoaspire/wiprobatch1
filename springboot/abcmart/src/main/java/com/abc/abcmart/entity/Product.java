package com.abc.abcmart.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="product_tbl")
public class Product {
 	 
	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Positive(message = "productPrice allows only positive value")
	@Column(name="product_price")
	private double productPrice;
	
	private LocalDate mfd;
	
	@Pattern(regexp = "^[a-zA-Z]{4,12}$", message = "Invalid category. Only alphabets are allowed")
	private String category;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	public LocalDate getMfd() {
		return mfd;
	}
	public void setMfd(LocalDate mfd) {
		this.mfd = mfd;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}	
}
