
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit user</title>
        <%@include file="links.jsp" %>
    </head>

    <body>

        <div class="d-md-flex flex-column justify-content-center align-items-center border border-dark p-2" >
            <h1>User Edit</h1>
            <form action="/updateuser" method="POST" modelAttribute="UserToEdit">
                <div class="form-group">
                    username <br><input disabled type="username" name="username" value="${UserToEdit.username}">
                </div>
                <div class="form-group">
                    first name <br><input type="text" name="fname" value="${UserToEdit.fname}">
                </div>
                <div class="form-group">
                    last name <br><input type="text" name="lname" value="${UserToEdit.lname}">
                </div>
                <div class="form-group">
                    <input type="submit" value="Sumbit">
                </div>
            </form>
        </div>
    </body>
</html>