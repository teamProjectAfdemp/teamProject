
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
        <!--<input name="routeid" type="text" ng-name="routeid" ng-bind="routeid" value="${aRoute.id}" hidden/>-->
        <script>
         var routeid = ${aRoute.id};
        </script>
        <div class="p-3 ml-4 mr-4 border-bottom border-secondary" ng-repeat="p in ctrl.posts">
            
            <span ng-bind="p.id" class="text-muted" ><u></u></span>
            <h6   ng-bind="p.post" class="pl-3 pt-3"  ></h6>
            <div  ng-bind="p.created.substr(0,16)" class="text-muted text-right w-100 p-1">
                <button ng-if="p.id == ${curUser.id}" class="btn btn-outline-secondary p-0" action="/editpost/{{p.id}}" aria-expanded="false" aria-controls="collapseExample" type="button" > edit </button>
            </div>
        <input ng-bind="p.id" type="text" value="{{ post.id }}" hidden/>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.5/angular.min.js"></script>
<script src="<c:url value='/resources/js/app.js' />"></script>
<script src="<c:url value='/resources/js/service/post_service.js' />"></script>
<script src="<c:url value='/resources/js/controller/post_controller.js' />"></script>
