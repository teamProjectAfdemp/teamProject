
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

  <main class="container pt-4" class="row pt-4">
       
        
<div class="card-deck">
    <c:forEach items="${allRoutes}" var="route"> 
    <div class="col-12 col-sm-6 col-lg-4 mb-4"> 
      
           
            <div class="card">
                <img src="../resources/img/route1.jpg" class="card-img-top" alt="route1">
                <div class="card-body">
                    <h5 class="card-title">${route.description}</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. </p>
                    <p class="card-text"><small class="text-muted">Dep Time: ${route.dep_time}</small></p>
                    <p class="card-text"><small class="text-muted">Ar Time: ${route.ar_time}</small></p>
                    <div class="card-footer">
                        <a href="/route/${route.id}" class="btn btn-outline-secondary " role="button" aria-pressed="true">View</a>
                        <a href="/editroute${route.id}" class="btn btn-outline-secondary " role="button" aria-pressed="true">Update</a>
                    </div>
                </div>
            </div>
    </div>
    </c:forEach>
    
        
        </main>


