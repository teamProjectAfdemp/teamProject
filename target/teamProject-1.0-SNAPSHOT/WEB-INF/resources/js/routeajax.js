$(document).ready(function () {
    doAjaxCall();
});

function doAjaxCall() {
    $.ajax({
        type: "GET",
        url: '/ajaxroutes',
        success: function (response) {
            $('#main').html(response);
        },
        complete: function ()
        {
            $("#loader").empty();
        }
    });
}
