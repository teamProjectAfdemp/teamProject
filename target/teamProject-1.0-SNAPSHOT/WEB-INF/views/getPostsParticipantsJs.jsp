<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">

    $(document).ready(function () {
        $("#joinButton").on("click", '');
        $('#joinButton').prop('disabled', true);
        doParticipantsAjaxCall();
        doPostsAjaxCall();
//        $("#createpost").on("click", createPostAjaxCall);
    });

    function doPostsAjaxCall() {
        $.ajax({
            type: "GET",
            url: '/posts/${aRoute.id}',
            success: function (response) {
                $('#routePosts').html(response);
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
    $("#joinButton").on("click", '');
    $('#joinButton').prop('disabled', true);
        $.ajax({
            type: "GET",
            url: '/join${aRoute.id}',
            success: function (response) {
                $('#routeParticipants').empty;
            },
            complete: function () {
                doParticipantsAjaxCall();
            }
        });
    };

    function exitAjaxCall() {
    $("#joinButton").on("click", '');
    $('#joinButton').prop('disabled', true);
        $.ajax({
            type: "GET",
            url: '/exit${aRoute.id}',
            success: function (response) {
                $('#routeParticipants').empty;
            },
            complete: function () {
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
                $('#joinButton').prop('disabled', false);
            } else {
                $("#joinButton").html("<h4> FULL </h4> all " + seats + "<br> slots are closed.");
                $("#joinButton").on("click", '');
                $('#joinButton').prop('disabled', false);
                
            }
        } else {
            $("#joinButton").html("<h4> EXIT </h4>" + left + " out of " + seats + "<br> slots open.");
            $("#joinButton").on("click", exitAjaxCall);
            $('#joinButton').prop('disabled', false);
        }
    };

//    function createPostAjaxCall() {
//        $.ajax({
//            type: "POST",
//            url: '/addpost',
//            data: 'newpost',
//            success: function (data) {
//                console.log('success', data);
//            },
//            error: function (exception) {
//                alert('Exeption:' + exception);
//            },
//            complete: function () {
//                $("#routePosts").empty();
//                doPostsAjaxCall();
//            }
//        });
//        e.preventDefault();
//    };

</script>