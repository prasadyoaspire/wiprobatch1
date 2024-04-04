package com.abc.springcore2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abc.springcore2.bean.Product;
import com.abc.springcore2.config.AppConfig;
import com.abc.springcore2.config.MyAppConfig;
import com.abc.springcore2.controller.ProductController;
import com.abc.springcore2.dao.ProductDao;
import com.abc.springcore2.service.ProductService;

public class ProductMain {

	public static void main(String[] args) {
		
		Product product1 = new Product();
		product1.setProductId(10);
		product1.setProductName("SamsungM30");
		product1.setProductPrice(32000);
		
		Product product2 = new Product();
		product2.setProductId(20);
		product2.setProductName("IPhoneX30");
		product2.setProductPrice(82000);
		
		Product product3 = new Product();
		product3.setProductId(30);
		product3.setProductName("MIX30");
		product3.setProductPrice(22000);
		
//		ProductDao pDao = new ProductDao();
//		
//		ProductService pService = new ProductService();
//		pService.setProductDao(pDao); // dao obj injected inside service
//		
//		ProductController pController = new ProductController();
//		pController.setProductService(pService); // service obj injected inside controller
		
	//	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springcontext.xml");
//		ProductController pController = (ProductController) context.getBean("pController");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);
		
		ProductController pController =  context.getBean(ProductController.class);
		
		pController.addProduct(product1);
		pController.addProduct(product2);
		pController.addProduct(product3);
		
		pController.fetchAllProducts();
		
		context.close();

	}

}
