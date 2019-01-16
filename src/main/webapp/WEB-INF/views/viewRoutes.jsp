
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <h2>Routes: </h2>
        
        <table class="table"> 
            <thead>
                <tr>
                    <th scope="col">No</th>
                    <th scope="col">Starts</th>
                    <th scope="col">Ends</th>
                    <th scope="col">Description</th>
                    <th scope="col">Dep Time</th>
                    <th scope="col">Ar Time</th>
                </tr>
            </thead>
            <tbody>
                <% int i =1;%>
                <c:forEach items="${allRoutes}" var="route">
                    <tr>
                        <td><%= i %></td>
                        <td>${route.departure}</td>
                        <td>${route.destination}</td>
                        <td>${route.description}</td>
                        <td>${route.dep_time}</td>
                        <td>${route.ar_time}</td>
                        <td><a href="/editroute${route.id}" class="btn btn-outline-secondary " role="button" aria-pressed="true">Update</a></td>
                        <td><a href="/deleteroute${route.id}" class="btn btn-outline-secondary " role="button" aria-pressed="true">Delete</a></td>
                        <%i++;%>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
