<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<h2>Participants: </h2>

<table class="table">
    <thead>
        <tr>
            <th scope="col">No</th>
            <th scope="col">User ID</th>
        </tr>
    </thead>
    <tbody>
        <% int i = 1;%>
        <c:forEach items="${routeParticipants}" var="participant">
            <tr>
                <td><%= i%></td>
                <td>${fn:escapeXml(usernamesMap[participant.user_id])}</td>
<!--                <td><a href="/edituser${participant.id}" class="btn btn-outline-secondary " role="button" aria-pressed="true">Update</a></td>
                <td><a href="/deleteuser${participant.id}" class="btn btn-outline-secondary " role="button" aria-pressed="true">Delete</a></td>-->
                <%i++;%>
            </tr>
        </c:forEach>
    </tbody>
</table>
