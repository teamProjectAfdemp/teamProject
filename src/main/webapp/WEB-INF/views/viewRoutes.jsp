
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
        <%@include file="userinfo.jsp" %>
        <h2>Routes: </h2>
        
        <table class="table"> 
            <thead>
                <tr>
                    <th scope="col">No</th>
                    <th scope="col">Route name</th>
                    <th scope="col">Starts</th>
                    <th scope="col">Ends</th>
                    <th scope="col">Participants</th>
                </tr>
            </thead>
            <tbody>
                <% int i =1;%>
                <c:forEach items="${allRoutes}" var="route">
                    <tr>
                        <td><%= i %></td>
                        <td>${route.name}</td>
                        <td>${route.start}</td>
                        <td>${route.end}</td>
                        <td><input type="button" action="update" value="Update"></th>
                        <td><input type="button" action="delete" value="Delete"></th>
                        <%i++;%>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>