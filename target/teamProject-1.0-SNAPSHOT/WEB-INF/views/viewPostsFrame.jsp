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
    <div id="routePosts" class="card card-body shadow ">
    </div>
    <div class="collapse p-0 mt-1 pt-2 pb-2" id="collapseExample">
        <c:import url="addpost.jsp"/>    
    </div>
</div>
