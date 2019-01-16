
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
                        <td><input type="button" action="update" value="Update"></th>
                        <td><input type="button" action="delete" value="Delete"></th>
                        <%i++;%>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
