<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="d-md-flex flex-column justify-content-center align-items-center">
    <h1>Plan Your Journey</h1>
</div>
<div class="d-md-flex"  >
    <div class="d-md-flex flex-column justify-content-start align-items-start"style="margin-top: 50px;">
        <!-- <img src="../resources/img/map.jpg" alt="addroutemap" class="shadow-sm p-1 mb-5 bg-white rounded"/>-->
        <img src="../resources/img/addroute1.jpg" alt="" style="width:700px; height: 450px; margin-left:40px; box-shadow: 10px 10px 10px #888888; border:2px solid #888888; "/>
    </div>
    <div class="d-md-flex flex-column justify-content-end align-items-end"style="margin:40px;">
        <form action="/addroute" method="POST" modelAttribute="route" enctype="multipart/form-data">

            <div class="form-row">
                <div class="form-group col-md-8">
                    <label for="inputDeparture">Title</label>
                    <input type="text" class="form-control" placeholder="Title" name="title" required>
                </div>
              
                <div class="form-group col-md-4">
                    <label id='seats-field'>Available Seats</label>
                    <input type='number' min="1" max="100" class="form-control" id='seats' name='seats' placeholder="5" required>
                </div>
            </div>
             <div class="form-row"> 
                <div class="form-group col-md-12">
                    <label for="inputDestination">Short Description</label>
                    <input type="text" class="form-control" placeholder="Short Description" name="shortdesc" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label id='dep-field'> <i class="far fa-calendar-alt"></i> Departure <br></label>
                    <input type='date' class="form-control" id='deptime' name='dep_time' placeholder="Check-in" required>

                </div>
                <div class="form-group col-md-6">
                    <label id='ar-field'><i class="far fa-calendar-alt"></i> Arrival<br></label>
                    <input type='date' class="form-control" id='artime'  name='ar_tim' placeholder="Check-out" required>

                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="inputDescription">Description</label>
                    <textarea  type="text" class="form-control" rows="4" placeholder="Description" name="description" required></textarea>
                </div>
            </div>
            
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label class="custom-file-label" for="customFile">Choose Image</label>
                    <input type="file" class="custom-file-input" id="customFile" name="image"> 
                </div>
            </div>
            <button type="submit" class="btn btn-outline-secondary w-100 p-3">Create your route</button>
    </div>
</div>

<script src="<c:url value="/resources/js/addroute.js" />"></script>
