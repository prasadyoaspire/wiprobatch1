package com.abc.abcmarth2db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.abcmarth2db.entity.Product;

public interface ProductRepository  extends JpaRepository<Product,Long>{

}
