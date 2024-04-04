package com.abc.springcore2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abc.springcore2.bean.HelloBean;
import com.abc.springcore2.config.AppConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appcontext.xml");
//       HelloBean helloBean = (HelloBean) context.getBean("hBean");
    	
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	HelloBean helloBean = context.getBean(HelloBean.class);
    	
    	helloBean.sayHello();
    }
}
