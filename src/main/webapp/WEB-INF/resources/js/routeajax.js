$(document).ready(function () {
    doAjaxRouteList();
});

//function doAjaxCall() {
//    $.ajax({
//        type: "GET",
//        url: '/ajaxroutes',
//        success: function (response) {
//            $('#main').html(response);
//        },
//        complete: function ()
//        {
//            $("#loader").empty();
//        }
//    });
//}

//function routesAjax() {
//
////    var routesids = [];
////    routesids = '@Session["routesIdsList"]';
//    var routesids = []
//    sessionStorage.getItem("routesIdsList");
////    "${sessionScope.routesIdsList}";
//    $.each(routesids, function (index, item) {
//        doAjaxCall(item);
//    });
//}

function doAjaxRouteList() {
    $.ajax({
        type: "GET",
        url: '/ajaxroutelist',
        success: function (response) {
            $.each(response, function (index, item) {
                doAjaxCall(item);
            });
        },
        complete: function ()
        {
            $("#loader").empty();
        }
    });
}

function doAjaxCall(id) {
    $.ajax({
        type: "GET",
        url: '/ajaxroute/' + id,
        success: function (response) {
            $('#routedeck').html(response).add();
        }
    });
}
