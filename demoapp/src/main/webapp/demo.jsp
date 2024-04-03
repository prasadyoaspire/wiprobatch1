<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.time.LocalDate" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Jsp Page</h2>
<%
    int a = 10;
    int b = 20;
    int c = a+b;
   
    LocalDate today = LocalDate.now();

%>

<h3>Sum = <%= c %></h3>
<h2 style="color:green;">Today : <%= today %></h2>

</body>
</html>