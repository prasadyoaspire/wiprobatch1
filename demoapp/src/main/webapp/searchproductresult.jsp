<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.demoapp.dto.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- 
	<%
	Product product = (Product) request.getAttribute("myproduct");
	if (product != null) {
	%>	
	<h3>Product Details</h3>
	<h4>Id : <%=product.getProductId()%></h4>
	<h4>Name : <%=product.getProductName()%></h4>
	<h4>Price : <%=product.getProductPrice()%></h4>
	<h4>MFD : <%=product.getMfd()%></h4>
	<h4>Category : <%=product.getCategory()%></h4>	
	<%
	} else {
	%>	
	<h2>Product Not existing</h2>	
	<%
	}
	%> --%>
	
	<h3>Product Details</h3>
	
	<jsp:useBean id="myproduct" type="com.demoapp.dto.Product" scope="request"></jsp:useBean>	
	
	 <p>ProductName: <jsp:getProperty property="productName" name="myproduct"/>
	 <p>Price: <jsp:getProperty property="productPrice" name="myproduct"/>
	 <p>MFD: <jsp:getProperty property="mfd" name="myproduct"/>
	 <p>Category: <jsp:getProperty property="category" name="myproduct"/>	
	
</body>
</html>