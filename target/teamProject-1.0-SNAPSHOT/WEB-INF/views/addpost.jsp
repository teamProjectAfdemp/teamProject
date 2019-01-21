

<!--<form action="/addpost" method="POST"  modelAttribute="newpost">--> 
    <!--<form ng-submit="ctrl.createpost()" name="myForm" >-->
        <form ng-submit="createpost(ctrl.post)" name="myForm" >

    <div class="input-group inline">
        
            <input type="text" ng-model="ctrl.post.post" class="form-control" placeholder="Ask something!" name="post" required placeholder="Ask something" aria-label="Ask something">
            <input type="text" ng-model="ctrl.post.user_id" name="user_id" value="${curUser.id}" hidden>
            <input type="text" ng-model="ctrl.post.route_id" name="route_id" value="${aRoute.id}" hidden>
            <div class="input-group-append p-0">
                <button ng-click="createPost(ctrl.post)" value="" class="btn btn-outline-secondary" type="submit" >Post</button>
            </div>
    </div>
</form>

