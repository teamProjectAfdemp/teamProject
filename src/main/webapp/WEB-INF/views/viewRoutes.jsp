
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container pt-4" >
    <div id="routedeck" class="card-deck">
        <c:forEach items="${allRoutes}" var="route"> 
            <div class="col-12 col-sm-6 col-lg-4 mb-4 routecard"> <div class="card">
                     <a href="/route/${route.id}">
                    <!--<img src="../resources/img/route1.jpg" class="card-img-top" alt="route1">-->
                    <!--<img src="data:image/jpg;base64,${route.image}" class="card-img-top" alt="route1">-->
                    <img src="${empty route.image ? '../resources/img/route1.jpg' : 'data:image/jpg;base64,'}${route.image }" class="card-img-top" alt="route1">
                    
                    
                    </a>
                    <div class="card-body">
                        <h4 class="card-title">${route.title}</h4>
                        <p class="card-text">${route.shortdesc} </p>
                        <!--<p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. </p>-->
                        <div class="card-footer">
                        <p class="card-text"><small class="text-muted">Dep Time: ${route.dep_time}</small></p>
                        <p class="card-text"><small class="text-muted">Ar Time: ${route.ar_time}</small></p>
                        <c:if test="${curUser.id == route.creator_id}">
                            <span> <a href="/editroute${route.id}" class="btn btn-outline-secondary " role="button" aria-pressed="true">Update</a></span>
                        </c:if>    
                        </div>
                    </div>
                        
                </div>
            </div>
        </c:forEach>
    </div>
</div>


