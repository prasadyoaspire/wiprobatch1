package com.demoapp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
			
		//1. get request parameters		
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("upwd");
		
		//2. if password is 1234 then print "Hello <username>" else print "Invalid password"
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Login</title></head><body>");
		
		if(pwd.equals("1234")) {
			out.println("<h2>Welcome "+uname+"<h2>");
		}
		else {
			out.println("<h3>Invalid Password<h3>");
		}
		
		out.println("</body></html>");
		out.close();		
	}

}
