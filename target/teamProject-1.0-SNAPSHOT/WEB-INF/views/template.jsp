
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${curUser.username}'s Profile</title>
        <%--<%@include file="links.jsp" %>--%>
        <c:import url="links.jsp"/>
        <link rel="icon" href="/resources/img/RouteIcon.svg">

        <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,600,600i,700,700i,800,800i&amp;subset=greek" rel="stylesheet"> 

    </head>
    <body>
        <!--nav menu-->
    <header >
        <%--<%@include file="navmenu.jsp" %>--%>
         <c:import url="navmenu.jsp"/>
    </header>

    <main class="container-fluid">
        
      <c:import url="${includeView}.jsp"/>

    </main>

    <footer>

    </footer>

</body>
</html>