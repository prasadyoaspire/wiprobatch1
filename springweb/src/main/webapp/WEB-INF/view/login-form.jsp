<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>		
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="login" method="post" modelAttribute="loginform">
		<table>
                <tr>
                    <td><form:label path="username">CustomerId</form:label></td>
                    <td><form:input path="username"/></td>
                </tr>
                <tr>
                    <td><form:label path="password">FirstName</form:label></td>
                    <td><form:input path="password"/></td>
                </tr>                
                <tr>
                    <td><input type="submit" value="Login"/></td>
                </tr>
            </table>
	</form:form>
</body>
</html>