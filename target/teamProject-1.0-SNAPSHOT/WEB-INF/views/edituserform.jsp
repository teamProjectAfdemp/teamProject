<div class="d-md-flex flex-column justify-content-center align-items-center" >
    <div class="d-md-flex flex-column justify-content-center align-items-center" > 
        <h2>Welcome to your profile</h2>
        <p>Edit your information</p>
    </div>
    <div class="d-md-flex">
        <div class="d-md-flex flex-column justify-content-start align-items-start"style="margin-top: 50px;">
            <img src="../resources/img/map.png" alt=""/>
        </div>
        <div class="d-md-flex flex-column justify-content-end align-items-end"style="margin:80px;">
            <form  class="form-signin" id="updateuser" action="/updateuser" method="POST" modelAttribute="updatedUser">
                <div class="form-group">
                    <label for="inputUsername">Username</label>
                    <input readonly type="username" placeholder="${userToEdit.username}" value="${userToEdit.username}" class="form-control" name="username">
                </div>
                <div class="form-group">
                    <label for="inputfname">First Name</label>
                    <input class="form-control" type="text" name="fname" placeholder="${userToEdit.fname}" value="${userToEdit.fname}" required>
                </div>
                <div class="form-group">
                    <label for="inputlname">Last Name</label>
                    <input class="form-control p-3" type="text" name="lname" placeholder="${userToEdit.lname}" value="${userToEdit.lname}" required>
                </div>
                <div class="row">
                    <button type="submit" class="btn btn-outline-secondary p-2 w-100">Update</button>
                </div>
            </form>
        </div>
    </div>
</div>

