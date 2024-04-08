package com.abc.hibernatedemo;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.abc.hibernatedemo.entity.Product;
import com.abc.hibernatedemo.util.HibernateUtil;

public class InsertDemo {

	public static void main(String[] args) {
		
		Product product1 = new Product();
		product1.setProductId(101);
		product1.setProductName("IPhoneX");
		product1.setProductPrice(228000);
		product1.setMfd(LocalDate.of(2024, 04, 8));
		product1.setCategory("Mobile");
		
	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	    
	    Session session = sessionFactory.openSession();
	    
	    Transaction txn=  session.beginTransaction();	    
	    session.persist(product1); //saving entity	    
	    txn.commit();
	    
	    System.out.println("Product saved!");	    
	    session.close();	    
	    sessionFactory.close();	   
	}
}
