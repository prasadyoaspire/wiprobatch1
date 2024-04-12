package com.abc.abcmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.abcmart.dao.ProductDao;
import com.abc.abcmart.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Transactional
	@Override
	public void saveProduct(Product product) {		
		productDao.save(product);		
	}

	@Override
	public Product getProductDetails(int productId) {
		Product product = productDao.findById(productId);
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = productDao.findAll();
		return products;
	}
}
