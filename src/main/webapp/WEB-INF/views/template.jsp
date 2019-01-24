<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Route Planner</title>
        <c:import url="links.jsp"/>
    </head>
    <body>
        <header >
            <c:import url="navmenu.jsp"/>
        </header>
        <main id="main" class="container-fluid">
            <c:if test="${!empty includeView}">
                <c:import url="${includeView}.jsp"/>
            </c:if> 
            <c:if test="${!empty modal}">
                <c:import url="modal.jsp"/>
                <script type="text/javascript" src="/resources/js/showmodal.js"></script>
            </c:if>  
        </main>
        <footer>
            <div class="d-md-flex flex-column justify-content-center align-items-center" style=" padding-top: 20px;">
                <p> Copyright 2019 © By Team e-Xcursions afdemp</p>
            </div>
        </footer>
    </body>
</html>