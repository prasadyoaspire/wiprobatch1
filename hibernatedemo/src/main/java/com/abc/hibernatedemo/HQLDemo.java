package com.abc.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.abc.hibernatedemo.entity.Product;
import com.abc.hibernatedemo.util.HibernateUtil;


public class HQLDemo {

	public static void main(String[] args) {
				
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		//fetch all products from database
		
		Query q1 = session.createQuery("from Product p");
		List<Product> productList = q1.getResultList();		
		productList.forEach(p-> System.out.println(p.getProductId()+" "+p.getProductName()+" "+p.getProductPrice()+" "+p.getCategory()));
		
		Query q2 = session.createQuery("select p.productName, p.productPrice from Product p");		
		List<Object[]> products = q2.getResultList();
		products.forEach(p-> System.out.println(p[0]+" "+p[1]));
		
		Query<Product> q3 = session.createQuery("From Product p where p.category = 'PenDrive'", Product.class);
		List<Product> productsByCategory = q3.getResultList();
		productsByCategory.forEach(p-> System.out.println(p.getProductName()+" "+p.getProductPrice()+" "+p.getCategory()));
		
		//positional Paramters
//		Query<Product> q4 = session.createQuery("From Product p where p.productPrice > ?1 and p.productPrice < ?2 ",Product.class);
//		q4.setParameter(1, 30000);
//		q4.setParameter(2, 100000);
		
		//Named Parameters		
		Query<Product> q4 = session.createQuery("From Product p where p.productPrice > :lowerP and p.productPrice < :upperP ",Product.class);
		q4.setParameter("lowerP", 30000);
		q4.setParameter("upperP", 100000);
				
		List<Product> productsWithInPriceRange = q4.getResultList();
		productsWithInPriceRange.forEach(p-> System.out.println(p.getProductName()+" "+p.getProductPrice()+" "+p.getCategory()));
		
		
		session.close();
		sessionFactory.close();
	}

}
