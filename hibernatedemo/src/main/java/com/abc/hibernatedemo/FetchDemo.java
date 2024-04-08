package com.abc.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.abc.hibernatedemo.entity.Product;
import com.abc.hibernatedemo.util.HibernateUtil;

public class FetchDemo {

	public static void main(String[] args) {

		int productId = 101;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		//session.load(Product.class, productId);		
		Product product = session.find(Product.class, productId);
		
		if(product!=null) {
			System.out.println("Name : "+product.getProductName());
			System.out.println("Price : "+product.getProductPrice());
			System.out.println("MFD : "+product.getMfd());
			System.out.println("Category : "+product.getCategory());
		}
		else {
			System.out.println("Product not existing with id: "+productId);
		}
		session.close();
		sessionFactory.close();
	}
}
