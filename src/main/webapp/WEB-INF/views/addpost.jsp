<div class="d-md-flex flex-column justify-content-center align-items-center border border-dark p-2">
    <form action="/addpost" method="POST" modelAttribute="post"> 
        <div class="form-group">
            <label for="post">Post</label>
            <textarea  type="text" class="form-control" rows="4" placeholder="Post" name="post"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Create a Post</button>
    </form>
</div>
