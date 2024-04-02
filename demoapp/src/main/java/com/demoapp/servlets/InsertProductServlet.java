package com.demoapp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.demoapp.dao.ProductDao;
import com.demoapp.dto.Product;

/**
 * Servlet implementation class InsertProductServlet
 */
public class InsertProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productId = Integer.parseInt(request.getParameter("pid"));
		String productName = request.getParameter("pname");
		double productPrice = Double.parseDouble(request.getParameter("pprice"));
		LocalDate mfd = LocalDate.parse( request.getParameter("pdate"));
		String category = request.getParameter("pcategory");
		
		Product product = new Product();
		product.setProductId(productId);
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		product.setMfd(mfd);
		product.setCategory(category);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>Insert Product</title></head><body>");
		
		ProductDao productDao = new ProductDao();
		boolean result = productDao.save(product);
		
		if(result) {
			out.println("<h2>New Product Saved</h2>");
		}
		else {
			out.println("<h2>Somthing went wrong!</h2>");
		}
		
		out.println("</body></html>");
		out.close();
	}

}
