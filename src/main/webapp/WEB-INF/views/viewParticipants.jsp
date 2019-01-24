<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<h2>Participants: </h2>
<div class=" p-0 mt-1 pt-2 pb-2" >
    <div class="card card-body shadow ">
        <input id="countParticipants" value="${fn:length(routeParticipants)}" hidden/>
        <table class="table">
            <tbody>
                <% int i = 1;%>
                <c:forEach items="${routeParticipants}" var="participant">
                    <c:if test="${participant.user_id == curUser.id}">
                    <input id="joined" hidden value="true"/>
                </c:if>
                <tr>
                    <td><%= i%></td>
                    <td>${fn:escapeXml(usernamesMap[participant.user_id])}</td>
                    <%i++;%>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
