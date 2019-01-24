<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">

    $(document).ready(function () {
//        $("#joinButton").on("click", 'doParticipantsAjaxCall');
//        $('#joinButton').prop('disabled', true);
        doGetParticipantsAjaxCall();
        doPostsAjaxCall();

//        $("#createpost").on("click", createPostAjaxCall);
    });

    function doPostParticipantsAjaxCall() {
        $('#joinButton').prop('disabled', true);
        $.ajax({
            type: "GET",
            url: '/postparticipants${aRoute.id}',
            success: function (response) {
//                console.log(response);
                var a = $(response).filter('#participants').html();
//                console.log(a);
                $('#routeParticipantsDiv').html(a);
                var b = $(response).filter('#joinButtonDiv').html();
                $('#JoinDiv').html(b);
            },
            complete: function () {
                $("#joinButton").on("click", doPostParticipantsAjaxCall);
            }
        });
    };


    function doGetParticipantsAjaxCall() {
        $.ajax({
            type: "GET",
            url: '/getparticipants${aRoute.id}',
            success: function (response) {
                var a = $(response).filter('#participants').html();
//                console.log(a);
                $('#routeParticipantsDiv').html(a);
                var b = $(response).filter('#joinButtonDiv').html();
                $('#JoinDiv').html(b);
            },
            complete: function () {
                $("#joinButton").on("click", doPostParticipantsAjaxCall);
            }

        });
    }
    ;

    function doPostsAjaxCall() {
        $.ajax({
            type: "GET",
            url: '/posts/${aRoute.id}',
            success: function (response) {
                $('#routePosts').html(response);
            }
        });
    }
    ;



// alter the join 
//    function alterJoinButton(count) {
//        let seats = ${aRoute.seats};
//        let left = seats - count;
//        if ($("#joined").val() == undefined) {
//            if (left > 0) {
//                $("#joinButton").html("<h4> JOIN !</h4>" + left + " out of " + seats + "<br> slots open.");
//                $("#joinButton").on("click", joinAjaxCall);
//                $('#joinButton').prop('disabled', false);
//            } else {
//                $("#joinButton").html("<h4> FULL </h4> all " + seats + "<br> slots are closed.");
//                $("#joinButton").on("click", '');
//                $('#joinButton').prop('disabled', false);
//
//            }
//        } else {
//            $("#joinButton").html("<h4> EXIT </h4>" + left + " out of " + seats + "<br> slots open.");
//            $("#joinButton").on("click", exitAjaxCall);
//            $('#joinButton').prop('disabled', false);
//        }
//    }
//    ;

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