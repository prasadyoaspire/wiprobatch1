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
<form:form method="POST" action="save" modelAttribute="productForm">
             <table>
               <%--  <tr>
                    <td><form:label path="productId">productId</form:label></td>
                    <td><form:input path="productId"/></td>
                </tr> --%>
                <tr>
                    <td><form:label path="productName">ProductName</form:label></td>
                    <td><form:input path="productName"/>                   
                    </td>
                </tr>
                <tr>
                    <td><form:label path="productPrice">ProductPrice</form:label></td>
                    <td><form:input path="productPrice"/></td>
                </tr>
                <tr>
                    <td><form:label path="mfd">MFD</form:label></td>
                    <td><form:input path="mfd"/></td>
                </tr>
                 <tr>
                    <td><form:label path="category">Category</form:label></td>
                    <td><form:input path="category"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Save"/></td>
                </tr>
            </table>
        </form:form>
</body>
</html>