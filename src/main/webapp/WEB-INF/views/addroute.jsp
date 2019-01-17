
<body>
    <div class="d-md-flex flex-column justify-content-center align-items-center border border-dark p-2">
        <form action="/addroute" method="POST" modelAttribute="route"> 
            <div class="form-group">
                <label for="inputCrator">Creator</label>
                <input type="text" class="form-control" placeholder="Creator" name="creator_id">
            </div>
            <div class="form-group">
                <label for="inputDeparture">Departure</label>
                <input type="text" class="form-control" placeholder="Departure" name="departure">
            </div>
            <div class="form-group">
                <label for="inputDestination">Destination</label>
                <input type="text" class="form-control" placeholder="Destination" name="destination">
            </div>
            <div class="form-group"> <!-- Date input -->
                <label class="control-label" for="date">Dep Time</label>
                <input class="form-control" id="date" name="dep_time" placeholder="DD-MM-YYY" type="text"/>
            </div>
            <div class="form-group"> <!-- Date input -->
                <label class="control-label" for="date">Ar Time</label>
                <input class="form-control" id="date" name="ar_time" placeholder="DD-MM-YYY" type="text"/>
            </div>
            <div class="form-group">
                <label for="inputDescription">Description</label>
                <textarea  type="text" class="form-control" rows="4" placeholder="Description" name="description"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Create a route</button>
        </form>
    </div>
