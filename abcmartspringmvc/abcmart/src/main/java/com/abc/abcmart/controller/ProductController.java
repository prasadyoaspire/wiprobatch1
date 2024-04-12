package com.abc.abcmart.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abc.abcmart.entity.Product;
import com.abc.abcmart.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/addform")
	public ModelAndView getAddProductForm() {
		
		return new ModelAndView("product-form","productForm", new Product());
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView submitSaveForm(@ModelAttribute("productForm") Product product,ModelMap map) {
			
		productService.saveProduct(product);
		
		return new ModelAndView("productsave-success","msg","New Product Added.!");
	}

	@RequestMapping("/all")
	public String fetchAll(ModelMap modelMap) {		
		List<Product> products = productService.getAllProducts();
		modelMap.addAttribute("allProducts", products);
		return "all-products";
	}
	
	@RequestMapping("/get")
	public String fetctProductDetails(@RequestParam("pid") int productId,ModelMap modelMap) {		
		Product product = productService.getProductDetails(productId);
		modelMap.addAttribute("product", product);
		return "product-details";
	}	
}
