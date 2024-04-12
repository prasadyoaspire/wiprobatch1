<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List,com.abc.abcmart.entity.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>All Products</h3>

<h4>Total Products : ${allProducts.size()}</h4>


<%
   List<Product> products = (List<Product>)request.getAttribute("allProducts");
   for(Product p: products) {
%>
<p><%= p.getProductId()%>  <%= p.getProductName()%> <%= p.getProductPrice()%> <%= p.getMfd()%> <%= p.getCategory()%></p>
<%		   
   }
%>





</body>
</html>