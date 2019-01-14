
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in</title>
        <%@include file="links.jsp" %>
        <style><%@include file="/WEB-INF/css/login.css"%></style>
    </head>

    <body id="LoginForm">
        <div class="container">
            <h1 class="form-heading">login Form</h1>
            <div class="login-form">
                <div class="main-div">
                    <div class="panel">
                        <p>Please enter your email and password</p>
                    </div>
                    <form id="Login">
                        <div class="form-group">
                            <input type="email" class="form-control" id="inputEmail" placeholder="Email Address">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" id="inputPassword" placeholder="Password">
                        </div>
                        <div class="forgot">
                            <a href="reset.html">Forgot password?</a>
                        </div>
                        <button type="submit" class="btn btn-primary">Login</button>
                    </form>
                </div>
                <p class="botto-text"> Designed by ...</p>
            </div>
        </div>
    </body>
</html>