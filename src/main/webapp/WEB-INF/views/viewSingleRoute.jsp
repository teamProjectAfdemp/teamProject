<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<div class="col-12 col-sm-6 col-lg-4 mb-4 routecard"> <div class="card h-100">
        <a href="/route/${route.id}">
            <img src="${empty route.image ? '../resources/img/route1.jpg' : 'data:image/jpg;base64,'}${route.image }" class="card-img-top" style="height:300px; object-fit: cover;" alt="route1">
        </a>
        <div class="card-body">
            <h4 class="card-title">${fn:escapeXml(route.title)}</h4>
            <p class="card-text">${fn:escapeXml(route.shortdesc)} </p>
            <div class="list-group list-group-flush">
                <p class="card-text"><small class="text-muted">Departure Date: ${fn:escapeXml(route.dep_time)}</small></p>
                <p class="card-text"><small class="text-muted">Arrival Date: ${fn:escapeXml(route.ar_time)}</small></p>
                <ul class="list-group list-group-flush">
                    <a href="/editroute${route.id}" class="btn btn-outline-secondary w-100 <c:if test="${curUser.id != route.creator_id}"> invisible</c:if>" role="button" aria-pressed="true">Update</a>
                    <a href="/route/${route.id}" class="btn btn-outline-secondary w-100 mt-2" role="button" aria-pressed="true">View</a>
                </ul>
            </div>
        </div>
    </div>
</div>


