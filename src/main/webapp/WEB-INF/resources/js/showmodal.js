$(document).ready(function(){
// Open modal on page load
$("#modal").modal('show');
//redirect after 5seconds
  setTimeout(function(){ 
    $('#modal').modal('hide'); 
     },1500);

});