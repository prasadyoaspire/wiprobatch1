package com.abc.abcmart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.abcmart.entity.Product;
import com.abc.abcmart.exceptions.ProductNotFoundException;
import com.abc.abcmart.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {	
		
		productRepository.save(product);	
		return product;
	}

	@Override
	public Product getProductById(int productId) {			
	
		Optional<Product> optionalProduct = productRepository.findById(productId);		
		if(optionalProduct.isEmpty()) {			
			throw new ProductNotFoundException("Product not existing with id: "+productId);
		}		
		Product product = optionalProduct.get();		
		return product;
	}

	@Override
	public List<Product> getAllProducts() {		
		List<Product> products = productRepository.findAll();
		return products;
	}

	@Override
	public Product updateProduct(Product product) {		
		Optional<Product> optionalProduct = productRepository.findById(product.getProductId());		
		if(optionalProduct.isEmpty()) {
			throw new ProductNotFoundException("Product not existing with id: "+product.getProductId());
		}		
		productRepository.save(product);		
		return product;
	}

	@Override
	public void deleteProduct(int productId) {	
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isEmpty()) {
			throw new ProductNotFoundException("Product not existing with id: "+productId);		
		}		
		Product product = optionalProduct.get();		
		productRepository.delete(product);		
	}

	@Override
	public List<Product> getProductsByCategory(String categoryName) {		
		List<Product> products = productRepository.findByCategory(categoryName);
		return products;
	}

	@Override
	public List<Product> getProductsWithInPriceRanage(double minPrice, double maxPrice) {
		List<Product> products = productRepository.filterProductsWithInPriceRage(minPrice, maxPrice);
		return products;
	}
}
