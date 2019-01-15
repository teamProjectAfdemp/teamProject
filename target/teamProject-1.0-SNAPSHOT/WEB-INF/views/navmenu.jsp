
<div class="d-md-flex flex-column justify-content-center align-items-center border border-dark p-2">
    <!--if user is logged in -->
    <% if ("${curUser}"!=null) { %>
    <h6>Logged in as: ${curUser.username}</h6>
    <h6><a href='/profile'>Profile</h6>
    <h6><a href='/logout'>Log out</a></h6>
    <% } %>
</div>
