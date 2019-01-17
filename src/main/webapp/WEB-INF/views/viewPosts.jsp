
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Posts: </h2>

<table class="table"> 
    <thead>
        <tr>
            <th scope="col">No</th>
            <th scope="col">Post</th>
            <th scope="col">created</th>
        </tr>
    </thead>
    <tbody>
        <% int i = 1;%>
        <c:forEach items="${allPosts}" var="post">
            <tr>
                <td><%= i%></td>
                <td>${post.post}</td>
                <td>${post.created}</td>
                <td><a href="/editpost${post.id}" class="btn btn-outline-secondary " role="button" aria-pressed="true">Update</a></td>
                <td><a href="/deletepost${post.id}" class="btn btn-outline-secondary " role="button" aria-pressed="true">Delete</a></td>
                <%i++;%>
            </tr>
        </c:forEach>
    </tbody>
</table>