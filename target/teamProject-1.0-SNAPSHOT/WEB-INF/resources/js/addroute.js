function myfunc(){

    const checkinEl = document.querySelector('#deptime');
    const checkoutEl = document.querySelector('#artime');
    
    var fd = new FormData();
 
    //event for checking date for check-in check-out
    checkinEl.addEventListener('change', function() {

        let checkinDate = new Date(checkinEl.value); 
        let minDate = new Date(checkinEl.value);
        minDate.setDate(checkinDate.getDate());
        let minDateValue = minDate.toISOString().substr(0,10);

        if (checkoutEl.value != ''){
            let checkoutDate = new Date(checkoutEl.value); 
        
            if(checkoutDate<= checkinDate){
                checkoutEl.value = minDateValue;
            }
        }
        else{
            checkoutEl.value = minDateValue; 
        }

        checkoutEl.setAttribute('min',minDateValue);
    });
    
//    
//    fd.append('file', document.getElementById("image").files[0]);
//    var req;
//    if (window.ActiveXObject) {
//        req=new ActiveXObject();
//    } else {
//        req=new XMLHttpRequest();
//    }
//    req.open("post", "Image", true);
//    req.send(fd);
  

}

window.addEventListener('load',myfunc);
