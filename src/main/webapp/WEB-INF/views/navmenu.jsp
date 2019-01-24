<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="<c:url value="/resources/css/navbar.css" />" rel="stylesheet" type="text/css">

<nav class="row navbar navbar-expand-lg navbar-dark pb-0">
    <a href="<c:url value="/allroutes"/>"><img src="/resources/img/RouteIcon.svg" width="80" height="80" margin="10px" alt="logo-image"></a>
    <a id="mainTitle" class="navbar-brand p-2" href="<c:url value="/allroutes"/>" > route <br> planner</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse d-flex flex-row align-self-end" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto justify-content-center d-flex flex-fill ">
            <li class="nav-item active">
                <a class="nav-link" href="/allroutes">FIND ROUTES
                    <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="dropdownMyRoutesButton" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false" >MY ROUTES</a>
                <div class="dropdown-menu" >
                    <a class="dropdown-item" href="/alljoinedroutes">JOINED</a>
                    <a class="dropdown-item" href="/allcreatedroutes">CREATED</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/addroute">ADD ROUTE
                    <span class="sr-only">(current)</span>
                </a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto nav-flex-icons">
            <li class="nav-item avatar dropdown">
                <a class="nav-link dropdown-toggle" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false">${curUser.username}
                </a>
                <div class="dropdown-menu" >
                    <a class="dropdown-item" href="/index">Profile</a>
                    <c:if test="${curUser.username == 'admin'}">
                        <a class="dropdown-item" href="/allusers">All users</a>
                    </c:if>
                    <a class="dropdown-item" href="/logout">Log Out</a>
                </div>
            </li>
        </ul>
    </div>
</nav>


