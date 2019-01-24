<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<div id="joinButtonDiv">
    <button id="joinButton" type="submit" class="btn btn-outline-secondary p-1 col-2 p-2">
        <c:if test="${buttonState == 'JOIN'}">
            <h4><b>JOIN</b></h4> <span>${fn:length(routeParticipants)} joined</span>
        </c:if>
        <c:if test="${buttonState == 'EXIT'}">
            <h4><b>EXIT</b></h4> <span>${fn:length(routeParticipants)} joined</span>
        </c:if>  
        <c:if test="${buttonState == 'FULL'}">
            <h4><b>FULL</b></h4> <span>${fn:length(routeParticipants)} joined</span>
        </c:if>  
    </button>
</div>
<span id="participants">
    <h2>Participants: </h2>
    <div class=" p-0 mt-1 pt-2 pb-2" >
        <div class="card card-body shadow ">         
            <table class="table">
                <tbody>
                    <% int i = 1;%>
                    <c:forEach items="${routeParticipants}" var="participantid">
                        <tr>
                            <td><%= i%></td>
                            <td>${fn:escapeXml(usernamesMap[participantid])}</td>
                            <%i++;%>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</span>