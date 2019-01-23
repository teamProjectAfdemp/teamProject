<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">

    $(document).ready(function () {
        
        doParticipantsAjaxCall();
        doPostsAjaxCall();
//        $("#createpost").on("click", createPostAjaxCall);

//        $("#loader").empty();
    });


    function createPostAjaxCall() {
        $.ajax({
            type: "POST",
            url: '/addpost',
            data: 'newpost',
            success: function (data) {
                console.log('success', data);
            },
            error: function (exception) {
                alert('Exeption:' + exception);
            },
            complete: function () {
                $("#routePosts").empty();
                doPostsAjaxCall();
            }
        });
//        e.preventDefault();
    };

    function doPostsAjaxCall() {
        $.ajax({
            type: "GET",
            url: '/posts/${aRoute.id}',
            success: function (response) {
                $('#routePosts').html(response);
            },
            complete: function () {
                $("#createpost").on("click", createPostAjaxCall);
            }
        });
    };

    function doParticipantsAjaxCall() {
        $.ajax({
            type: "GET",
            url: '/participants/${aRoute.id}',
            success: function (response) {
                $('#routeParticipants').html(response);
            },
            complete: function () {
                let count = $("#countParticipants").val();
                alterJoinButton(count);
            }
        });
    };

    function joinAjaxCall() {
        $.ajax({
            type: "GET",
            url: '/join${aRoute.id}',
            success: function (response) {
                $('#routeParticipants').empty;
                doParticipantsAjaxCall();
            }
        });
    };

    function exitAjaxCall() {
        $.ajax({
            type: "GET",
            url: '/exit${aRoute.id}',
            success: function (response) {
                $('#routeParticipants').empty;
                doParticipantsAjaxCall();
            }
        });
    };

    function alterJoinButton(count) {
        let seats = ${aRoute.seats};
        let joined = ${curUser.id}
        let left = seats - count;
        if ($("#joined").val() == undefined) {
            if (left > 0) {
                $("#joinButton").html("<h4> JOIN !</h4>" + left + " out of " + seats + "<br> slots open.");
                $("#joinButton").on("click", joinAjaxCall);
            } else {
                $("#joinButton").html("<h4> FULL </h4> all " + seats + "<br> slots are closed.");
                $("#joinButton").on("click", '');
            }
        } else {
            $("#joinButton").html("<h4> EXIT </h4>" + left + " out of " + seats + "<br> slots open.");
            $("#joinButton").on("click", exitAjaxCall);
        }
    };


</script>