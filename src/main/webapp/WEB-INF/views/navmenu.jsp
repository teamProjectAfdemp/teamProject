

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="<c:url value="/resources/css/navbar.css" />" rel="stylesheet" type="text/css">
<nav class="row navbar navbar-expand-lg navbar-dark">

            <img src="/resources/img/RouteIcon.svg" width="50" height="50" alt="">
            <a id="mainTitle" class="navbar-brand" >route <br> planner</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-555"
                    aria-controls="navbarSupportedContent-555" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

        <div class="collapse navbar-collapse" id="navbardiv">

            <ul class="navbar-nav justify-content-center d-flex flex-fill">
                <li class="nav-item active">
                    <a class="nav-link" href="/index">HOME
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/allroutes" >FIND ROUTES</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/allusers">ALL USERS</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/addroute">ADD ROUTE</a>
                </li>
            </ul>
           
            <ul class="navbar-nav ml-auto nav-flex-icons">
                <li class="nav-item avatar dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-55" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">${curUser.username}
                    </a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-secondary" aria-labelledby="navbarDropdownMenuLink-55">
                        <a class="dropdown-item" href="/index">Profile</a>
                        <a class="dropdown-item" href="/logout">Log Out</a>
                    </div>
                </li>
            </ul>
        </div>
</nav>

