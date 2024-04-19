package com.abc.productservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.productservice.entity.Product;


public interface ProductRepository extends JpaRepository<Product,Integer> {
	
	Product findByProductName(String productName);
	
	List<Product> findByCategory(String categoryName);
	
	@Query("select p from Product p where p.productPrice >= :min and p.productPrice <= :max")
	List<Product> filterProductsWithInPriceRage(@Param("min") double minPrice, @Param("max") double maxPrice);
}
