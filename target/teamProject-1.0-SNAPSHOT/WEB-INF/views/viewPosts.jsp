
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<h2>Posts: </h2>
<div class="input-group inline p-0">
    <p type="text" class="form-control" placeholder="Post" name="post" required placeholder="Ask something" aria-label="Ask something">
    <div class="input-group-append p-0">
        <button class="btn btn-outline-secondary" data-toggle="collapse"  data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample" type="button" >View Chat</button>
    </div>
</p>
</div>

<div class="collapse p-0 mt-1 pt-2 pb-2" id="collapseExample">
    <div class="card card-body shadow ">

        <c:forEach items="${routePosts}" var="post">
            <div class="p-3 ml-4 mr-4 border-bottom border-secondary">

                <span  class="text-muted" ><u>${usernamesMap[post.user_id]}</u></span>
                <h6 class="pl-3 pt-3">${post.post}</h6>
                <div  class="text-muted text-right w-100 p-1" >
                    <c:if test="${curUser.id == post.user_id}">
                        <button class="btn btn-outline-secondary p-0" action="/editpost/${post.id}" aria-expanded="false" aria-controls="collapseExample" type="button" > edit </button>
                    </c:if>
                    ${ fn:substring(post.created, 0, 16) } 
                </div>
                <input type="number" hidden value="${post.id}"/>
            </div>

        </c:forEach>


<!--<input name="routeid" type="text" ng-name="routeid" ng-bind="routeid" value="${aRoute.id}" hidden/>-->


    </div>
