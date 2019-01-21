<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Participants: </h2>

<table class="table">
    <thead>
        <tr>
            <th scope="col">No</th>
            <th scope="col">Route ID</th>
            <th scope="col">User ID</th>
        </tr>
    </thead>
    <tbody>
        <% int i = 1;%>
        <c:forEach items="${routeParticipants}" var="participant">
            <tr>
                <td><%= i%></td>
                <td>${participant.route_id}</td>
                <td>${usernamesMap[participant.user_id]}</td>
                <td><a href="/edituser${participant.id}" class="btn btn-outline-secondary " role="button" aria-pressed="true">Update</a></td>
                <td><a href="/deleteuser${participant.id}" class="btn btn-outline-secondary " role="button" aria-pressed="true">Delete</a></td>
                <%i++;%>
            </tr>
        </c:forEach>
    </tbody>
</table>
