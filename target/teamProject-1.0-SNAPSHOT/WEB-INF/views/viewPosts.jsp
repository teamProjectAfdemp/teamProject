
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

        <c:forEach items="${routePosts}" var="post">
            <div class="p-3 ml-4 mr-4 border-bottom border-secondary">

                <span  class="text-muted" ><u>${fn:escapeXml(usernamesMap[post.user_id])}</u></span>
                <h6 class="pl-3 pt-3"> ${fn:escapeXml(post.post)}</h6>
                <div  class="text-muted text-right w-100 p-1" >
                    <%--<c:if test="${curUser.id == post.user_id}">--%>
                        <!--<button class="btn btn-outline-secondary p-0" action="/editpost/${post.id}" aria-expanded="false" aria-controls="collapseExample" type="button" > edit </button>-->
                    <%--</c:if>--%>
                    ${ fn:substring(post.created, 0, 16) } 
                </div>
                <input type="number" hidden value="${post.id}"/>
            </div>
        </c:forEach>
   
