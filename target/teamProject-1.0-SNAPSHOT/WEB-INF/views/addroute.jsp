<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="d-md-flex flex-column justify-content-center align-items-center border border-dark p-2">
    <form action="/addroute" method="POST" modelAttribute="route" enctype="multipart/form-data">
        <!--        <div class="form-group" hidden>
                    <label for="inputCrator">Creator</label>
                    <input type="text" class="form-control" placeholder="Creator" name="creator_id">
                </div>-->
        <div class="form-group">
            <label for="inputDeparture">Title</label>
            <input type="text" class="form-control" placeholder="Name your route" name="title">
        </div>
        <div class="form-group">
            <label for="inputDestination">Short desc</label>
            <input type="text" class="form-control" placeholder="Write a short description (200 characters max)" name="shortdesc">
        </div>

        <div class="form-group">
            <label id='checkin-field'> <i class="far fa-calendar-alt"></i> Departure <br>
                <input type='date' class="form-control" id='deptime' name='dep_time' placeholder="Check-in">
            </label>
            <label id='checkout-field'><i class="far fa-calendar-alt"></i> Arrival<br>
                <input type='date' class="form-control" id='artime'  name='ar_tim' placeholder="Check-out">
            </label>
        </div>
        
        <div class="form-group">
            <label for="inputDescription">Description</label>
            <textarea  type="text" class="form-control" rows="4" placeholder="Write your route's full description" name="description"></textarea>
        </div>
        <div class="custom-file">
            <input type="file" class="custom-file-input" id="customFile" name="image">
            <label class="custom-file-label" for="customFile">Choose Image</label>
        </div>
<!--        <div class="form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Check me out</label>
        </div>-->
        <button type="submit" class="btn btn-primary">Create a route</button>
    </form>
</div>

<script src="<c:url value="/resources/js/addroute.js" />"></script>
