function myfunc(){

    const checkinEl = document.querySelector('#depTime');
    const checkoutEl = document.querySelector('#arTime');
 
    //event for checking date for check-in check-out
    checkinEl.addEventListener('change', function() {

        let checkinDate = new Date(checkinEl.value); 
        let minDate = new Date(checkinEl.value);
        minDate.setDate(checkinDate.getDate() + 1);
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
  

}

window.addEventListener('load',myfunc);
