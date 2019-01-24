<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<div  class=" col-8">
    <h2>Users: </h2>

    <table class="table"> 
        <thead>
            <tr>
                <th scope="col">No</th>
                <th scope="col">Username</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
            <% int i = 1;%>
            <c:forEach items="${allUsers}" var="user">
                <tr>
                    <td><%= i%></td>
                    <td>${fn:escapeXml(user.username)}</td>
                    <td>${fn:escapeXml(user.fname)}</td>
                    <td>${fn:escapeXml(user.lname)}</td>
                    <td><a href="/edituser${user.id}" class="btn btn-outline-secondary " role="button" aria-pressed="true">Update</a></td>
                    <td><a href="/deleteuser${user.id}" class="btn btn-outline-secondary " role="button" aria-pressed="true">Delete</a></td>
                    <%i++;%>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>