package com.abc.abcmart.dao;

import java.util.List;

import com.abc.abcmart.entity.Product;

public interface ProductDao {

	void save(Product product);
	Product findById(int productId);
	List<Product> findAll();
}
