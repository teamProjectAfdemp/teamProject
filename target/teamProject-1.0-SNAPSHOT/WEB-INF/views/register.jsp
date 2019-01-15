
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log in</title>
<%@include file="links.jsp" %>
</head>

<body>

        <div class="d-md-flex flex-column justify-content-center align-items-center border border-dark p-2" >
            <h1>User Sign up</h1>
            <form action="/signup" method="POST" modelAttribute="user">
                <div class="form-group">
                    username <br><input type="username" name="username">
                </div>
                <div class="form-group">
                    password <br><input type="password" name="password">
                </div>
                <div class="form-group">
                    first name <br><input type="text" name="fname">
                </div>
                <div class="form-group">
                    last name <br><input type="text" name="lname">
                </div>
                <div class="form-group">
                    <input type="submit" value="Sign up">
                </div>
            </form>
        </div>
</body>
</html>