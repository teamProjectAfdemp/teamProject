
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in</title>
        <%@include file="links.jsp" %>
        <style><%@include file="/WEB-INF/resources/css/login.css"%></style>
    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-xl-9 mx-auto">
                    <div class="card card-signin flex-row my-5">
                        <div class="card-img-left d-none d-md-flex">
                            <!-- Background image for card set in CSS! -->
                        </div>
                        <div class="card-body">
                            <h5 class="card-title text-center">Log in</h5>
                            <form class="form-signin" id="Login" action="/login" method="POST" modelAttribute="user">
                                <div class="form-label-group">
                                    <input type="username" id="inputUserame" class="form-control" placeholder="Username" name="username" >
                                    <label for="inputUserame">Username</label>
                                </div>
                                <div class="form-label-group">
                                    <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" >
                                    <label for="inputPassword">Password</label>
                                </div>
                                <hr>
                                <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Log In</button>
                                <a class="d-block text-center mt-2 small" href="/signup">Sign Up</a>
                                <hr class="my-4">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>