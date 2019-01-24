<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="d-md-flex flex-column justify-content-center align-items-center">
    <h1>Plan Your Journey</h1>
    <div class="d-md-flex"  >
        <div class="d-md-flex flex-column justify-content-center align-items-center"style="margin-top: 50px;">
            <img src="../resources/img/addroute1.jpg" alt="" style="width:700px; height: 450px; margin-left:40px; box-shadow: 10px 10px 10px #888888; border:2px solid #888888; "/>
        </div>
        <div class="d-md-flex flex-column justify-content-end align-items-end"style="margin:40px;">
            <form action="/addroute" method="POST" modelAttribute="route" enctype="multipart/form-data">
                <div class="form-row">
                    <div class="form-group col-md-8">
                        <label for="inputDeparture">Title</label>
                        <spring:bind path="route.title">
                            <input type="text" class="form-control" placeholder="Title" name="${status.expression}" value="${status.value}" required>
                        </spring:bind>
                    </div>
                    <div class="form-group col-md-4">
                        <label id='seats-field'>Available Seats</label>
                        <spring:bind path="route.seats">
                            <input type='number' min="1" max="100" class="form-control" id='seats' name="${status.expression}" value="${status.value}" placeholder="5" required>
                        </spring:bind>
                    </div>
                </div>
                <div class="form-row"> 
                    <div class="form-group col-md-12">
                        <label for="inputDestination">Short Description</label>
                        <spring:bind path="route.shortdesc">
                            <input type="text" class="form-control" placeholder="Short Description" name="${status.expression}" value="${status.value}" required>
                        </spring:bind>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label id='dep-field'> <i class="far fa-calendar-alt"></i> Departure <br></label>
                            <spring:bind path="route.dep_time">
                            <input type='date' class="form-control" id='deptime' name="${status.expression}" value="${status.value}" required>
                        </spring:bind>
                    </div>
                    <div class="form-group col-md-6">
                        <label id='ar-field'><i class="far fa-calendar-alt"></i> Arrival<br></label>
                            <spring:bind path="route.ar_time">
                            <input type='date' class="form-control" id='artime'  name="${status.expression}" value="${status.value}" required>
                        </spring:bind>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-12">
                        <label for="inputDescription">Description</label>
                        <spring:bind path="route.description">
                            <textarea id="textarea" type="text" class="form-control" rows="4" placeholder="Description" name="${status.expression}" value="${status.value}" required></textarea>
                        </spring:bind>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-12">
                        <label class="custom-file-label" for="customFile">Choose Image</label>
                        <input type="file" class="custom-file-input" id="customFile" name="file"> 
                    </div>
                </div>
                <button type="submit" class="btn btn-outline-secondary w-100 p-3">Create your route</button>
            </form>
        </div>
    </div>
</div>

<script src="<c:url value="/resources/js/addroute.js" />"></script>
