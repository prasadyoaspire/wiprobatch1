package com.demoapp.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.demoapp.dao.ProductDao;
import com.demoapp.dto.Product;

/**
 * Servlet implementation class SearchProductServlet
 */
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productId = Integer.parseInt(request.getParameter("pid"));
		
		ProductDao productDao = new ProductDao();
		Product product = productDao.findProductById(productId);
		
		RequestDispatcher rd = request.getRequestDispatcher("searchproductresult.jsp");		
		request.setAttribute("myproduct", product);		
		rd.forward(request, response);			
	}
}
