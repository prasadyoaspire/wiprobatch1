package com.abc.abcmarth2db.service;

import java.util.List;

import com.abc.abcmarth2db.entity.Product;

public interface ProductService {

	Product saveProduct(Product product);
	
	List<Product> getAllProducts();
}
