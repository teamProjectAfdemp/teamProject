<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${curUser.username}'s Profile</title>
        <%@include file="links.jsp" %>

        <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,600,600i,700,700i,800,800i&amp;subset=greek" rel="stylesheet"> 

    </head>
    <body>
        <!--nav menu-->
    <header >
        <%@include file="navmenu.jsp" %>
    </header>

    <main class="container-fluid">
        <div  class="flex-column justify-content-md-center align-items-center">
            
            <div  class="row"><button id="joinButton" action="/allusers" class="col-2 shadow mybutton">JOIN !</button></div>

            <div id="routePreview" class="row d-flex justify-content-center "> 
                <div id="routeHeader" class="col-3 text-center "> 
                    <h1>Road <br>to Hell</h1><hr class="">
                    <p>From 23 March<br>
                       To 25 March
                    </p>


                </div>
                <div id="routeSmallInfo" class="col-4 p-3 shadow"> 
                    <h4>Details</h4>
                    <p>
                        A 4-day trip to the bottom of the wildest
                        hell you could imagine. Keep reading andz
                        don’t be afraid to ask for details.
                    </p>
                </div>

            </div>

            <div id="routePic" class="row d-flex justify-content-center "
                style="background-image: url('<c:url value="/resources/img/routesample.jpg"/>');">
                    
            </div>

            <div id="routeDetails"  class="row d-flex justify-content-center ">
                <div class="col-1"></div>
                <div id="routeDetailsText" class="col-7 text-center shadow"> 
                    <h4>Program and Details</h4><hr>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
                        sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
                        Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris 
                        nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor 
                        in reprehenderit in voluptate velit esse cillum dolore eu fugiat 
                        nulla pariatur. Excepteur sint occaecat cupidatat non proident,
                        sunt in culpa qui officia deserunt mollit anim id est laborum.
                    </p>

                </div>
                <div class="col-1"></div>
            </div>

            <div id="routeUsers" class="row d-flex justify-content-center">
                <h2>Route Users</h2>
            </div>

            <section id="routeChat" class="row justify-content-center align-items-center">
                <div class="col-7 d-flex flex-row ">
                    <div class="backlight"></div>
                    <button action="/allusers" class="shadow mybutton">View Chats</button>
                </div>
                <div class="col-7 shadow backlight"></div>
                <div class="col-7 shadow backlight"></div>
               
            </section>

        </div>

    </main>

    <footer>

    </footer>

</body>
</html>