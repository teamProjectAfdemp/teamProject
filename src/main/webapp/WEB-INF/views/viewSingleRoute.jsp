<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<div class="col-12 col-sm-6 col-lg-4 mb-4 routecard"> <div class="card">
        <a href="/route/${route.id}">
            <img src="${empty route.image ? '../resources/img/route1.jpg' : 'data:image/jpg;base64,'}${route.image }" class="card-img-top" alt="route1">
        </a>
        <div class="card-body">
            <h4 class="card-title">${fn:escapeXml(route.title)}</h4>
            <p class="card-text">${fn:escapeXml(route.shortdesc)} </p>
            <div class="card-footer">
                <p class="card-text"><small class="text-muted">Dep Time: ${fn:escapeXml(route.dep_time)}</small></p>
                <p class="card-text"><small class="text-muted">Ar Time: ${fn:escapeXml(route.ar_time)}</small></p>
                <c:if test="${curUser.id == route.creator_id}">
                    <span> <a href="/editroute${route.id}" class="btn btn-outline-secondary " role="button" aria-pressed="true">Update</a></span>
                </c:if>    
            </div>
        </div>
    </div>
</div>


