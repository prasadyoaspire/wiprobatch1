package com.abc.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		//HelloBean helloBean = new HelloBean();
		//helloBean.setMessage("Hello How are you?");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("appcontext.xml");
		HelloBean helloBean = (HelloBean) context.getBean("msgBean");		
		
		helloBean.dispaly();
	}
}
