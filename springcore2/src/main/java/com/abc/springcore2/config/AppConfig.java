package com.abc.springcore2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.abc.springcore2.bean.Author;
import com.abc.springcore2.bean.Book;
import com.abc.springcore2.bean.HelloBean;

@Configuration
public class AppConfig {

	@Bean
	public HelloBean getHelloBean() {
		HelloBean hBean = new HelloBean();
		hBean.setMsg("Hello How do you do?");
		return hBean;
	}
	
	@Bean(name = "book1")
	public Book getBookBean() {
		Book book1 = new Book();
		book1.setBookId(1000);
		book1.setBookName("Spring in action");
		book1.setBookPrice(5000);
		
		//book1.setBookAuthor(getAuthorBean()); //DI , used @Autowired annotation
		
		return book1;
	}
	
	@Bean
	public Author getAuthorBean() {
		Author author1 = new Author();
		author1.setAuthorId(23);
		author1.setAuthorName("John");
		author1.setAuthorEmail("john@tmail.com");
		return author1;
	}
}
