package com.demoapp.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.demoapp.dao.ProductDao;
import com.demoapp.dto.Product;

/**
 * Servlet implementation class FetchAllProducts
 */
public class FetchAllProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		ProductDao productDao = new ProductDao();
		List<Product> products = productDao.findAllProducts();
		
		//dispatch the request to jsp for presentation
		RequestDispatcher rd = request.getRequestDispatcher("displayallproducts.jsp");
		request.setAttribute("mylist", products);
		rd.forward(request, response);
		
	}

}
