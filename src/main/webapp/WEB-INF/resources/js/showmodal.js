$(document).ready(function () {
    $("#modal").modal('show');
    setTimeout(function () {
        $('#modal').modal('hide');
    }, 1500);
});