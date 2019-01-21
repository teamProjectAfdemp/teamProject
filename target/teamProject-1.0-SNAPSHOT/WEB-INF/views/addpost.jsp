

<form action="/addpost" method="POST" modelAttribute="post"> 
    <div class="input-group inline">
        <input type="text" class="form-control" placeholder="Ask something!" name="post" required placeholder="Ask something" aria-label="Ask something">
        <input type="text" name="user_id" value="${curUser.id}" hidden>
        <input type="text" name="route_id" value="${aRoute.id}" hidden>
        <div class="input-group-append p-0">
            <button class="btn btn-outline-secondary" type="sumbit" >Post</button>
        </div>
    </div>
</form>

