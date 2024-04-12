package com.abc.abcmart.service;

import java.util.List;

import com.abc.abcmart.entity.Product;

public interface ProductService {

	void saveProduct(Product product);
	Product getProductDetails(int productId);
	List<Product> getAllProducts();
}
