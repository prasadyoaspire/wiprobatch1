package com.abc.springcore2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.abc.springcore2.bean.Product;
import com.abc.springcore2.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService ;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	public void addProduct(Product product) {
		productService.saveProduct(product);
		System.out.println("Prodcut saved!");
	}
	
	public void fetchProductDetails(int productId) {
		Product product = productService.getProductDetails(productId);
		if(product!=null) {
			System.out.println("Name: "+product.getProductName());
			System.out.println("Price: "+product.getProductPrice());
		}
		else {
			System.out.println("Product not existing with id: "+productId);
		}
	}
	
	public void fetchAllProducts() {
		List<Product> products = productService.getAllProducts();
		products.forEach(p-> System.out.println(p.getProductId()+" "+p.getProductName()+" "+p.getProductPrice()));
	}
}
