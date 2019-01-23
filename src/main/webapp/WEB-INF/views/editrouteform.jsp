<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<div class="d-md-flex flex-column justify-content-center align-items-center">
    <h1>Edit Your Journey</h1>
</div>
<div class="d-md-flex"  >
    <div class="d-md-flex flex-column justify-content-start align-items-start"style="margin-top: 50px;">
        <!-- <img src="../resources/img/map.jpg" alt="addroutemap" class="shadow-sm p-1 mb-5 bg-white rounded"/>-->
        <img src="../resources/img/addroute1.jpg" alt="" style="width:700px; height: 450px; margin-left:40px; box-shadow: 10px 10px 10px #888888; border:2px solid #888888; "/>
    </div>
    <div class="d-md-flex flex-column justify-content-end align-items-end"style="margin:40px;">
        <form action="/updateroute" method="POST" modelAttribute="route" enctype="multipart/form-data">
            <div class="form-row">
                <div class="form-group col-md-8">
                    <label for="inputDeparture">Title</label>
                    <input type="text" class="form-control" placeholder="${fn:escapeXml(routeToEdit.title)}" name="title" value="${fn:escapeXml(routeToEdit.title)}" required>
                </div>

                <div class="form-group col-md-4">
                    <label id='seats-field'>Available Seats</label>
                    <input type='number' min="1" max="100" class="form-control" id='seats' name='seats' placeholder="${fn:escapeXml(routeToEdit.seats)}" value="${fn:escapeXml(routeToEdit.seats)}" required>
                </div>
            </div>
            <div class="form-row"> 
                <div class="form-group col-md-12">
                    <label for="inputDestination">Short Description</label>
                    <input type="text" class="form-control" placeholder="${fn:escapeXml(routeToEdit.shortdesc)}" name="shortdesc" value="${fn:escapeXml(routeToEdit.shortdesc)}" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label id='dep-field'> <i class="far fa-calendar-alt"></i>Current Departure <br></label>
                    <input type='text' class="form-control"  placeholder="${routeToEdit.dep_time}" readonly>
                </div>
                <div class="form-group col-md-6">
                    <label id='ar-field'><i class="far fa-calendar-alt"></i>Current Arrival<br></label>
                    <input type='text' class="form-control"  placeholder="${routeToEdit.ar_time}"  readonly>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label id='dep-field'> <i class="far fa-calendar-alt"></i>New Departure <br></label>
                    <input type='date' class="form-control" id='deptime' name='dep_time'  value="${routeToEdit.dep_time}" >
                </div>
                <div class="form-group col-md-6">
                    <label id='ar-field'><i class="far fa-calendar-alt"></i>New Arrival<br></label>
                    <input type='date' class="form-control" id='artime'  name='ar_time'  value="${routeToEdit.ar_time}" >
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label for="inputDescription">Description</label>
                    <textarea id="textarea" type="text" class="form-control" rows="4" placeholder="${fn:escapeXml(routeToEdit.description)}" name="description" required>${fn:escapeXml(routeToEdit.description)}</textarea>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <label class="custom-file-label" for="customFile">Choose Image</label>
                    <input type="file" class="custom-file-input" id="customFile" name="image"> 
                </div>
            </div>
            <button type="submit" class="btn btn-outline-secondary w-100 p-3">Update your route</button>
        </form>
    </div>
</div>

<script src="<c:url value="/resources/js/addroute.js" />"></script>