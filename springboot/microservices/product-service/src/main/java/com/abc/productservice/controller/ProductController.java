package com.abc.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.productservice.entity.Product;
import com.abc.productservice.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
    private Environment environment;

    @GetMapping("/data")
    public String getProductData() {
       return "data of PRODUCT-SERVICE, Running on port: "+environment.getProperty("local.server.port");
    }

	@GetMapping("/all")
	public List<Product> fetchAllProducts() {
		List<Product> products = productService.getAllProducts();
		return products;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> fetchProductDetails(@PathVariable("id") int productId) {
		Product product = productService.getProductById(productId);		 		
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		productService.saveProduct(product);
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(product,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PutMapping("/update")
	public ResponseEntity<Product> editProduct(@RequestBody Product product) {
		productService.updateProduct(product);
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(product,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") int productId) {
		productService.deleteProduct(productId);
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}
		
	@GetMapping("/filter/{category}")
	public List<Product> fetchProductsByCategory(@PathVariable("category") String category) {
		List<Product> products = productService.getProductsByCategory(category);	 		
		return products;
	}
	
	@GetMapping("/filter/{sprice}/{eprice}")
	public List<Product> fetchProductsWithInPrice(@PathVariable("sprice") double startPrice,@PathVariable("eprice")  double endPrice) {
		List<Product> products = productService.getProductsWithInPriceRanage(startPrice, endPrice);
		return products;
	}
}
