<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="links.jsp" %>
        <style><%@include file="/WEB-INF/css/navbar.css"%></style>
    </head>

    <body>
    <nav class="mb-1 navbar navbar-expand-lg navbar-dark secondary-color lighten-1" style="background-color:  #777" style="color:  white">
        <a class="navbar-brand" >Team E</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-555"
                aria-controls="navbarSupportedContent-555" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent-555">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Routes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">My Route</a>
                </li>

            </ul>
            <ul class="navbar-nav ml-auto nav-flex-icons">
                <li class="nav-item avatar dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-55" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">${curUser.username}
                    </a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-secondary" aria-labelledby="navbarDropdownMenuLink-55">
                        <a class="dropdown-item" href="#">Profile</a>
                        <a class="dropdown-item" href="/logout">Log Out</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
</body>
</html>