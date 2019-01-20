<div class="d-md-flex flex-column justify-content-center align-items-center border border-dark p-2">
    <h1>"${routeToEdit.departure}" Edit</h1>
    <form action="/updateroute" method="POST" modelAttribute="updatedRoute"> 
        <input type="text" name="id" value="${routeToEdit.id}" hidden>
<!--        <div class="form-group">
            <label for="inputCrator">Creator</label>
            <input type="text" class="form-control" name="creator_id" placeholder="${routeToEdit.creator_id}" value="${routeToEdit.creator_id}">
        </div>-->
        <div class="form-group">
            <label for="inputDeparture">Departure</label>
            <input type="text" class="form-control" name="departure" placeholder="${routeToEdit.departure}" value="${routeToEdit.departure}">
        </div>
        <div class="form-group">
            <label for="inputDestination">Destination</label>
            <input type="text" class="form-control" name="destination" placeholder="${routeToEdit.destination}" value="${routeToEdit.destination}">
        </div>
        <div class="form-group"> <!-- Date input -->
            <label class="control-label" for="date">Dep Time</label>
            <input class="form-control" id="date" name="dep_time" placeholder="${routeToEdit.dep_time}" value="${routeToEdit.dep_time}" type="text"/>
        </div>
        <div class="form-group"> <!-- Date input -->
            <label class="control-label" for="date">Ar Time</label>
            <input class="form-control" id="date1" name="ar_time" placeholder="${routeToEdit.ar_time}" value="${routeToEdit.ar_time}" type="text"/>
        </div><div class="form-group">
            <label for="inputDescription">Description</label>
            <textarea  type="text" class="form-control" name="description" rows="4" placeholder="${routeToEdit.description}" value="${routeToEdit.description}"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Update a route</button>
    </form>
</div>
