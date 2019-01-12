
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Users</title>
 <%@include file="links.jsp" %>
</head>
<body>
<h2>Users: </h2>

<table class="table"> 
            <thead>
                <tr>
                    <th scope="col">No</th>
                    <th scope="col">Username</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                </tr>
            </thead>
            <tbody>
                <% int i =1;%>
                <c:forEach items="${allUsers}" var="user">
                    <tr>
                        <td><%= i %></td>
                        <td>${user.username}</td>
                        <td>${user.fname}</td>
                        <td>${user.lname}</td>
                        <td><input type="button" action="update" value="Update"></th>
                        <td><input type="button" action="delete" value="Delete"></th>
                        <%i++;%>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
	
</body>
</html>