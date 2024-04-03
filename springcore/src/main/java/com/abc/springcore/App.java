package com.abc.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		
//		Square s = new Square(); // creating dependency object
//		s.setSide(4);
//		
//		Triangle t = new Triangle();
//		t.setBase(2);
//		t.setHeight(3);
//		
//		ShapeService service = new ShapeService();
//		service.setShape(t); // injecting dependency object
		
		ApplicationContext context = new ClassPathXmlApplicationContext("appcontext.xml");
		ShapeService service = (ShapeService) context.getBean("sService");
		
		double area = service.findArea();
		System.out.println(area);
	}
}
