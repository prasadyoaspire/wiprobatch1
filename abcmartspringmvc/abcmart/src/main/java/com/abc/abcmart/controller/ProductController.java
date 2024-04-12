package com.abc.abcmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abc.abcmart.entity.Product;
import com.abc.abcmart.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping("/product/all")
	public String fetchAll(ModelMap modelMap) {		
		List<Product> products = productService.getAllProducts();
		modelMap.addAttribute("allProducts", products);
		return "all-products";
	}
	
	@RequestMapping("/product/get")
	public String fetctProductDetails(@RequestParam("pid") int productId,ModelMap modelMap) {		
		Product product = productService.getProductDetails(productId);
		modelMap.addAttribute("product", product);
		return "product-details";
	}	
}
