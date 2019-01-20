
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--        <h2>Users: </h2>
        
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
                        <td><form > <input type="button" value="Update"></form></td>
                        <td><a href="/edituser${user.id}" class="btn btn-outline-secondary " role="button" aria-pressed="true">Update</a></td>
                        <td><a href="/deleteuser${user.id}" class="btn btn-outline-secondary " role="button" aria-pressed="true">Delete</a></td>
                        <%i++;%>
                    </tr>
                </c:forEach>
            </tbody>
        </table>-->
                
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>  
        <title>AngularJS $http Example</title>  
        <style>
            .username.ng-valid {
                background-color: lightgreen;
            }
            .username.ng-dirty.ng-invalid-required {
                background-color: red;
            }
            .username.ng-dirty.ng-invalid-minlength {
                background-color: yellow;
            }

            .email.ng-valid {
                background-color: lightgreen;
            }
            .email.ng-dirty.ng-invalid-required {
                background-color: red;
            }
            .email.ng-dirty.ng-invalid-email {
                background-color: yellow;
            }

        </style>
        <link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"></link>
    <div ng-app="myApp" class="ng-cloak">
        <div class="generic-container" ng-controller="UserController as ctrl">
            <div class="panel panel-default">
                <div class="panel-heading"><span class="lead">User Registration Form </span></div>
                <div class="formcontainer">
                    
                    <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                        <input type="hidden" ng-model="ctrl.user.id" />
                        
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="file">Name</label>
                                <div class="col-md-7">
                                    <input type="username" ng-model="ctrl.user.username" name="username" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
                                    <div class="has-error" ng-show="myForm.$dirty">
                                        <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                        <span ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                                        <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="file">Password</label>
                                <div class="col-md-7">
                                    <input type="password" ng-model="ctrl.user.password" class="form-control input-sm" placeholder="Enter your password."/>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="file">First Name</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.user.fname" name="fname" class="email form-control input-sm" placeholder="Enter your Email" required/>
<!--                                    <div class="has-error" ng-show="myForm.$dirty">
                                        <span ng-show="myForm.email.$error.required">This is a required field</span>
                                        <span ng-show="myForm.email.$invalid">This field is invalid </span>
                                    </div>-->
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable" for="file">Last Name</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="ctrl.user.lname" name="lname" class="email form-control input-sm" placeholder="Enter your Email" required/>
                                   
                                </div>
                            </div>
                        </div>
                        

                        <div class="row">
                            <div class="form-actions floatRight">
                                <input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                                <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading"><span class="lead">List of Users </span></div>
                <div class="tablecontainer">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Username</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th width="20%"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="u in ctrl.users">
                                <td><span ng-bind="u.id"></span></td>
                                <td><span ng-bind="u.username"></span></td>
                                <td><span ng-bind="u.fname"></span></td>
                                <td><span ng-bind="u.lname"></span></td>
                                <td>
                                    <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  
                                    <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.5/angular.min.js"></script>
        <script src="<c:url value='/resources/js/app.js' />"></script>
        <script src="<c:url value='/resources/js/service/user_service.js' />"></script>
        <script src="<c:url value='/resources/js/controller/user_controller.js' />"></script>
    </body>
</html>