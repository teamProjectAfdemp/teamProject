
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <h2>Users: </h2>
        
        <table class="table"> 
            <thead>
                <tr>
                    <th scope="col">No</th>
                    <th scope="col">Username</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                </tr>
            </thead>
            <tbody>
                <% int i =1;%>
                <c:forEach items="${allUsers}" var="user">
                    <tr>
                        <td><%= i %></td>
                        <td>${user.username}</td>
                        <td>${user.fname}</td>
                        <td>${user.lname}</td>
                        <!--<td><form > <input type="button" value="Update"></form></td>-->
                        <td><a href="/edituser${user.id}" class="btn btn-outline-secondary " role="button" aria-pressed="true">Update</a></td>
                        <td><a href="/deleteuser${user.id}" class="btn btn-outline-secondary " role="button" aria-pressed="true">Delete</a></td>
                        <%i++;%>
                    </tr>
                </c:forEach>
            </tbody>
        </table>