 $("#scheduleStartDate").datepicker({
    minDate:0,
    changeMonth:true,
    dateFormat:'yy-mm-dd',
     onClose:function( selectedDate ) {
            $( "#scheduleEndDate" ).datepicker( "option", "minDate", selectedDate );
    }
    
  });

  $("#scheduleEndDate").datepicker({
    minDate:0,
    changeMonth:true,
    dateFormat:'yy-mm-dd',
   
 		
  });