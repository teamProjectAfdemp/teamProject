$(document).ready(function () {
    doAjaxRouteList();
     $("#loader").empty();
});

function doAjaxRouteList() {
    $.ajax({
        type: "GET",
        url: '/ajaxroutelist',
        success: function (response) {
            $.each(response, function (index, item) {
                doAjaxCall(item);
            });
        }
    });
}

function doAjaxCall(id) {
    $.ajax({
        type: "GET",
        url: '/ajaxroute/' + id,
        success: function (response) {
            $('#routedeck').append(response);
//            $('#routedeck').html(response).add();
        }
    });
}



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