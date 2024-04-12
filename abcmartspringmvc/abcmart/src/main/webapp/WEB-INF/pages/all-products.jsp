<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container">    
  
	<h3 style="text-align: center; color: blue;">All Products</h3>
	
	<table class="table">

		<thead class="thead-dark">
			<tr>
				<td>ProductId</td>
				<td>Name</td>
				<td>Price</td>
				<td></td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var = "p" items="${allProducts }">
			<tr>
				<td>${p.productId }</td>
				<td>${p.productName }</td>
				<td>${p.productPrice }</td>
				<td><a href="get?pid=${p.productId }">View</a></td>
			</tr>
			</c:forEach> 
		</tbody>
		
	</table>
	
</div>

</body>
</html>