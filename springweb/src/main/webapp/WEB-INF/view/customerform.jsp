<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.error {
color : red
}

</style>

</head>
<body>
 <form:form method="POST" action="register" modelAttribute="mycustomer">
             <table>
                <tr>
                    <td><form:label path="customerId">CustomerId</form:label></td>
                    <td><form:input path="customerId"/></td>
                </tr>
                <tr>
                    <td><form:label path="firstName">FirstName</form:label></td>
                    <td><form:input path="firstName"/>
                    <form:errors path="firstName" class="error"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="lastName">LastName</form:label></td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td><form:label path="age">Age</form:label></td>
                    <td><form:input path="age"/>
                     <form:errors path="age" class="error" />
                    </td>
                </tr>
                 <tr>
                    <td><form:label path="email">Email</form:label></td>
                    <td><form:input path="email"/>
                     <form:errors path="email" class="error"/>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
</body>
</html>