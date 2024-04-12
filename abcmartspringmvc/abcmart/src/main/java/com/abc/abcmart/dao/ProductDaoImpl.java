package com.abc.abcmart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abc.abcmart.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(product);		
	}

	@Override
	public Product findById(int productId) {	
		Session session = sessionFactory.getCurrentSession();
		Product product = session.get(Product.class, productId);
		return product;
	}

	@Override
	public List<Product> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<Product> findAllQuery = session.createQuery("From Product p",Product.class);
		List<Product> products = findAllQuery.getResultList();
		return products;
	}
}
