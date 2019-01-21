<div class="d-md-flex col-3 flex-column justify-content-center align-items-center p-2" >
    <h1>"${userToEdit.username}" Edit</h1>
    <form  class="form-signin" id="updateuser" action="/updateuser" method="POST" modelAttribute="updatedUser">
        <div class="form-label-group">
            username <br><input class="form-control readonlyinput p-3" type="username" name="username" placeholder="${userToEdit.username}" value="${userToEdit.username}" readonly >
        </div>
        <div class="form-label-group">
            first name <br><input class="form-control p-3" type="text" name="fname" placeholder="${userToEdit.fname}" value="${userToEdit.fname}" required>
        </div>
        <div class="form-label-group">
            last name <br><input class="form-control p-3" type="text" name="lname" placeholder="${userToEdit.lname}" value="${userToEdit.lname}" required>
        </div>
        <input type="text" name="id" value="${userToEdit.id}" hidden>
        <div class="form-label-group">
            <button class="form-control btn mybutton p-3" type="submit">UPDATE</button>
        </div>
    </form>
    <%--<c:set var="user.id" value="${userToEdit.id}"/>--%>
</div>
