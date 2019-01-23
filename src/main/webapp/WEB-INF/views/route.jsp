
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div  class="flex-column justify-content-md-center align-items-center">
        <!--shadow mybutton-->
        <div  class="row">
            <form action="/join${aRoute.id}" method="POST" modelAttribute="route" enctype="multipart/form-data">
                <button id="joinButton" type="submit" class="btn btn-outline-secondary p-3 col-2"><b>JOIN !</b></button></div>
            </form>

    <div id="routePreview" class="row d-flex justify-content-center "> 
        <div id="routeHeader" class="col-3 text-center "> 
            <h1><c:out value="${fn:escapeXml(aRoute.title)}"/></h1>
            <hr class="">
            <p>From ${aRoute.dep_time}<br>To ${fn:escapeXml(aRoute.ar_time)}</p>
        </div>
        <div id="routeSmallInfo" class="col-4 p-3 shadow"> 
            <h4>Details</h4>
            <p>${aRoute.shortdesc}</p>
        </div>
    </div>

    <div id="routePic" class="row d-flex justify-content-center "
         style="background-image: url(${empty aRoute.image ? '../resources/img/route1.jpg' : 'data:image/jpg;base64,'}${aRoute.image });">

    </div>

    <div id="routeDetails"  class="row d-flex justify-content-center ">
        <div class="col-1"></div>
        <div id="routeDetailsText" class="col-7 text-center shadow"> 
            <h4>Program and Details</h4><hr>
            <p> ${aRoute.description}</p>
        </div>
        <div class="col-1"></div>
    </div>

    <section id="routeUsers" class=" row justify-content-center align-items-center">
        <div class="col-5">
            <c:import url="viewParticipants.jsp"/>
        </div>
    </section>

    <section id="routeChat" class=" row justify-content-center align-items-center">
        <div class="col-5">
            <c:import url="viewPosts.jsp"/>
            <c:import url="addpost.jsp"/>
        </div>
    </section>

</div>