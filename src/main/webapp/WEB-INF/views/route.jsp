

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div  class="flex-column justify-content-md-center align-items-center">

    <div  class="row"><button id="joinButton" action="/allusers" class="col-2 shadow mybutton">JOIN !</button></div>

    <div id="routePreview" class="row d-flex justify-content-center "> 
        <div id="routeHeader" class="col-3 text-center "> 
            <h1> 
                <c:out value="${aRoute.title}"/> 
                <!--Road <br>to Hell-->
            </h1><hr class="">

            <p>From ${aRoute.dep_time}
                <!--23 March-->
                <br>
                To ${aRoute.ar_time}
                <!--25 March-->
            </p>

        </div>
        <div id="routeSmallInfo" class="col-4 p-3 shadow"> 
            <h4>Details</h4>
            <p>${aRoute.shortdesc}  
                <!--                        A 4-day trip to the bottom of the wildest
                                        hell you could imagine. Keep reading andz
                                        don’t be afraid to ask for details.-->
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
            <p> ${aRoute.description} 
                <!--                        Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
                                        sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
                                        Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris 
                                        nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor 
                                        in reprehenderit in voluptate velit esse cillum dolore eu fugiat 
                                        nulla pariatur. Excepteur sint occaecat cupidatat non proident,
                                        sunt in culpa qui officia deserunt mollit anim id est laborum.-->
            </p>

        </div>
        <div class="col-1"></div>
    </div>

    <div id="routeUsers" class="row d-flex justify-content-center">
        <h2>Route Users</h2>
    </div>

    <section id="routeChat" class="row justify-content-center align-items-center">
      
        <div class="col-7 ">
           <c:import url="viewPosts.jsp"/>
           <c:import url="addpost.jsp"/>
        </div>

    </section>

</div>