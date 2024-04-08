package com.abc.hibernatedemo.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		 // Create registry
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		// Create MetadataSources
        MetadataSources sources = new MetadataSources(registry);
        
        // Create Metadata
        Metadata metadata = sources.getMetadataBuilder().build();
        
        // Create SessionFactory
        sessionFactory = metadata.getSessionFactoryBuilder().build();
        
        return sessionFactory;
	}
}
