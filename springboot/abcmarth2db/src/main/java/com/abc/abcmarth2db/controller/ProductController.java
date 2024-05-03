package com.abc.abcmarth2db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.abcmarth2db.entity.Product;
import com.abc.abcmarth2db.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@GetMapping("/")
	public List<Product> fetchAllProduct() {
		return productService.getAllProducts();
	}
}
