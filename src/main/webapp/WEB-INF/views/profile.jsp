<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${curUser.username}'s Profile</title>
        <%@include file="links.jsp" %>
    </head>
    <body>
        <%--<%@include file="userinfo.jsp" %>--%>
        <%@include file="navmenu.jsp" %>
        <div class="d-md-flex flex-column justify-content-center align-items-center border border-dark p-2" >
            <h2>${curUser.username}'s Profile</h2>
            <!--        <h5><a href="/allusers"> View All Users </a></h5>
                    <h5><a href="/allroutes"> View All Routes </a></h5>
                    <h5><a href="/index"> < Home </a></h5>-->
        </div>       
    </body>
</html>