<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,com.demoapp.dto.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>All Products</h2>
	<%
	List<Product> productList = (List<Product>) request.getAttribute("mylist");

	for (Product p : productList) {
	%>
	<h3>
		<%=p.getProductId()%>
		<%=p.getProductName()%>
		<%=p.getProductPrice()%>
	</h3>
	<%
	}
	%>
</body>
</html>