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
        <c:forEach items="${participantsUsernamesMap}" var="username">
            <tr>
                <td><%= i%></td>
                <td>${username.value}</td>
                <%i++;%>
            </tr>
        </c:forEach>
    </tbody>
</table>