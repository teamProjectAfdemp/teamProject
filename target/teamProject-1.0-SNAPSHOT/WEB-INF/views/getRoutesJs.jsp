<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
    $(document).ready(function () {
        var routesList = ${routesList};

        $.each(routesList, function (index, item) {
            doAjaxCall(item);
        });
        
        $("#loader").empty();
    });

    function doAjaxCall(id) {
        $.ajax({
            type: "GET",
            url: '/ajaxroute/' + id,
            success: function (response) {
                $('#routedeck').append(response);
            }
        });
    }
</script>