<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in</title>
        <c:import url="links.jsp"/>
        <link href="<c:url value="/resources/css/login.css" />" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-xl-9 mx-auto">
                    <div class="card card-signin flex-row my-5">
                        <div class="card-img-left d-none d-md-flex">
                        </div>
                        <div class="card-body">
                            <h5 class="card-title text-center">Log in</h5>
                            <form class="form-signin" id="Login" action="/login" method="POST" modelAttribute="user">
                                <div class="form-label-group">
                                    <input pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{2,20}$" type="username" id="inputUserame" class="form-control" placeholder="Username" name="username" required >
                                    <label for="inputUserame">Username</label>
                                </div>
                                <div class="form-label-group">
                                    <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required>
                                    <label for="inputPassword">Password</label>
                                </div>
                                <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Log In</button>
                                <a class="d-block text-center mt-2 small" href="/signup">Sign Up</a>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <c:if test="${!empty modal}">
            <c:import url="modal.jsp"/>
            <script type="text/javascript" src="/resources/js/showmodal.js"></script>
        </c:if>  
    </body>
</html>