<<<<<<< HEAD
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Route</title>
        <%@include file="links.jsp" %>
    </head>
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
                <div class="form-group">
                    <label for="inputDepTime">Dep Time</label>
                    <input type="date" class="form-control" placeholder="Dep Time" name="depTime">
                </div>
                <div class="form-group">
                    <label for="inputArTime">Ar Time</label>
                    <input type="date" class="form-control" placeholder="Ar Time" name="arTime">
                </div>
                <!--    <div class="form-group col-md-4">
                      <label for="inputState">State</label>
                      <select id="inputState" class="form-control">
                        <option selected>Choose...</option>
                        <option>...</option>
                      </select>
                    </div>-->
                <div class="form-group">
                    <label for="inputDescription">Description</label>
                    <textarea  type="text" class="form-control" rows="4" placeholder="Description" name="description"></textarea>
                </div>
                <div class="form-group">
                    <label for="exampleFormControlFile1">Upload an image</label>
                    <input type="file" class="form-control-file" id="exampleFormControlFile1">
                </div>
                <!--  <div class="form-group">
                    <div class="form-check">
                      <input class="form-check-input" type="checkbox" id="gridCheck">
                      <label class="form-check-label" for="gridCheck">
                        Check me out
                      </label>
                    </div>
                  </div>-->
                <button type="submit" class="btn btn-primary">Create a route</button>
            </form>
        </div>
    </body>
</html>
=======

        <div class="d-md-flex flex-column justify-content-center align-items-center border border-dark p-2">
            <form action="/addroute" method="POST" modelAttribute="route"> 
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputCrator">Creator</label>
                        <input type="text" class="form-control" placeholder="Creator" name="creator_id">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputDeparture">Departure</label>
                        <input type="text" class="form-control" placeholder="Departure" name="departure">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputDestination">Destination</label>
                    <input type="text" class="form-control" placeholder="Destination" name="destination">
                </div>
                <div class="form-group">
                    <label for="inputDepTime">Dep Time</label>
                    <input type="text" class="form-control" placeholder="Dep Time" name="depTime">
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputArTime">Ar Time</label>
                        <input type="text" class="form-control">
                    </div>
                    <!--    <div class="form-group col-md-4">
                          <label for="inputState">State</label>
                          <select id="inputState" class="form-control">
                            <option selected>Choose...</option>
                            <option>...</option>
                          </select>
                        </div>-->
                    <div class="form-group col-md-2">
                        <label for="inputDescription">Description</label>
                        <input type="text" class="form-control" placeholder="Description" name="description">
                    </div>
                </div>
                <!--  <div class="form-group">
                    <div class="form-check">
                      <input class="form-check-input" type="checkbox" id="gridCheck">
                      <label class="form-check-label" for="gridCheck">
                        Check me out
                      </label>
                    </div>
                  </div>-->
                <button type="submit" class="btn btn-primary">Create a route</button>
            </form>
        </div>
  
>>>>>>> marios
