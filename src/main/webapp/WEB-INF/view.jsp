<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>User Info</h2>

<strong>User Name </strong>: ${user.name} <br>
<strong>Gender </strong> : ${user.gender}<br>
<strong>Email </strong> : ${user.email}<br>
<strong>Language </strong> : <c:forEach var="val" items="${user.language}">
 <c:out value="${val}"></c:out>
 </c:forEach><br>
<strong>Country </strong>: ${user.country} <br> 

	
</body>
</html>