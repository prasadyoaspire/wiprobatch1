package com.abc.springcore2.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.abc.springcore2.bean.Product;

@Repository
public class ProductDao {

	private List<Product> products = new ArrayList<>();
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public Product findProductById(int productId) {
		Optional<Product> optionalProduct = products.stream().filter(p-> p.getProductId()==productId).findAny();
		return optionalProduct.get();
	}
	
	public List<Product> findAllProducts() {
		return products;
	}
}
