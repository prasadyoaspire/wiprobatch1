package com.abc.springcore2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abc.springcore2.bean.Author;
import com.abc.springcore2.bean.Book;
import com.abc.springcore2.config.AppConfig;

public class BookAuthorMain {

	public static void main(String[] args) {

		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appcontext.xml");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Book book = (Book) context.getBean("book1");

		System.out.println("BookDetails:");
		System.out.println("BookName:" + book.getBookName());
		System.out.println("BookPrice:" + book.getBookPrice());

		Author author = book.getBookAuthor();
		System.out.println("Author Details:");
		System.out.println("AuthorName :" + author.getAuthorName());
		System.out.println("AuthorEmail :" + author.getAuthorEmail());

		context.close();
	}

}
