<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
    $(document).ready(function () {
        doGetParticipantsAjaxCall();
        doPostsAjaxCall();
    });

    function doPostParticipantsAjaxCall() {
        $('#joinButton').prop('disabled', true);
        $.ajax({
            type: "GET",
            url: '/postparticipants${aRoute.id}',
            success: function (response) {
                var a = $(response).filter('#participants').html();
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
                $('#routeParticipantsDiv').html(a);
                var b = $(response).filter('#joinButtonDiv').html();
                $('#JoinDiv').html(b);
            },
            complete: function () {
                $("#joinButton").on("click", doPostParticipantsAjaxCall);
            }
        });
    };

    function doPostsAjaxCall() {
        $.ajax({
            type: "GET",
            url: '/posts/${aRoute.id}',
            success: function (response) {
                $('#routePosts').html(response);
            }
        });
    };
</script>