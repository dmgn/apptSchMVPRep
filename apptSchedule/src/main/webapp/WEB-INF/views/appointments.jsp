<!DOCTYPE html>

<%@ include file="header.jsp" %>



<html>
<head>
<title>Appointment Scheduling</title>
<script type="text/javascript" src="/apptSchedule/js/jquery.min.js"></script>
<script type="text/javascript" src="/apptSchedule/js/jquery.validate.min.js"></script>
<link href="/apptSchedule/css/menu.css" rel="stylesheet" type="text/css" />
<link href="/apptSchedule/css/blue/jtable.min.css" rel="stylesheet" type="text/css" />
<link href="/apptSchedule/css/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<link href="/apptSchedule/css/jquery-ui.structure.min.css" rel="stylesheet" type="text/css" />
<link href="/apptSchedule/css/jquery-ui.theme.min.css" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" href="/apptSchedule/css/jquery-ui.css"/>
  <link rel="stylesheet" href="/apptSchedule/css/enrollForm.css"/>
  <script src="/apptSchedule/js/jquery-ui.js"></script>
  <style type="text/css">
    
.displayTextleft {
  -webkit-border-radius: 3px 3px 0 0;
  -moz-border-radius: 3px 3px 0 0;
  border-radius: 3px 3px 0 0;
  position: relative;
  line-height: 34px;
  box-shadow: inset 0 1px 0 0 rgba(255,255,255,.5);
  padding-left: 10px;
  color: #222;
  font-size: 14px;
  font-family: Verdana,Arial,Helvetica,sans-serif;
  font-weight: bold;
  width: 35%;
}

.displayTextright {
  -webkit-border-radius: 3px 3px 0 0;
  -moz-border-radius: 3px 3px 0 0;
  border-radius: 3px 3px 0 0;
  position: relative;
  line-height: 34px;
  box-shadow: inset 0 1px 0 0 rgba(255,255,255,.5);
  color: #222;
  font-size: 14px;
  font-family: Verdana,Arial,Helvetica,sans-serif;
}


</style>
<script src="/apptSchedule/js/jquery.min.js" type="text/javascript"></script>
<script src="/apptSchedule/js/jquery-ui.min.js" type="text/javascript"></script>
<script src="/apptSchedule/js/jquery.jtable.js" type="text/javascript"></script>


</head>
<body>
<div class="container" >
  <div class="row">
      <div class="span12 navbar">
        <div class="navbar-inner">
                  <ul class="nav" id="css3menu1">
                    <li class="active"><a href="/apptSchedule/centre/admin/appointments">Appointments</a>


                        
                    <div class="submenu">
                    <div class="column">
                     <ul id="css3menu1">
                      <li>
                        <a href="/apptSchedule/centre/admin/appointments" title="Setup">Setup</a>
                      </li>
                      <li>
                        <a href="/apptSchedule/centre/admin/appointmentView" title="View Schedule">Schedule</a>
                      </li>
                      <li>
                        <a href="/apptSchedule/centre/admin/scheduledAptGridView" title="View All">View All</a>
                      </li>
                     </ul>
                    </div>
                   </div>


                    </li>
                    <li ><a href="/apptSchedule/centre/admin/enroll">Enrollment</a></li>
                    <li ><a href="/apptSchedule/centre/admin/tutor">Instructors</a></li>
                    <li ><a href="/apptSchedule/centre/admin/package">Packages</a></li>
                    <li ><a href="/apptSchedule/centre/admin/product">Products</a> </li>
                    <li ><a href="/apptSchedule/centre/admin/reports">Reports</a></li>
                  </ul>         
        </div>  
      </div>
  </div>
</div>
<div class="container" >
<div>
  <div style="padding:10px 5px 5px 10px">
      Search For: <input type="email" id="email" placeholder="Enter Email" required> 
      <input type="button" id="go" value="Go"> 
  </div>
</div>

<div id="search" style="background: linear-gradient(to bottom,#f0f0f0 0%,#f0f0f0 100%);border-color:#f0f0f0;">

  <table width="100%" style="background: linear-gradient(to bottom,#f0f0f0 0%,#f0f0f0 100%);border-color:#f0f0f0;">
      <div style="background: linear-gradient(to bottom,#78b1ed 0%,#417bb5 100%);border-color: #2b5177;"> <p class="custtitle"> Make Appointments</p> </div>
    <tr>
      <td class="displayTextleft"> First Name
      </td>
      <td class="displayTextright">
          <div id="fName"></div>
      </td>
    </tr>
    <tr>
      <td class="displayTextleft"> Last Name
      </td>
      <td class="displayTextright">
          <div id="lName"></div>
      </td>
    </tr>
    <tr>
    <td class="displayTextleft">Products</td>
    <td class="displayTextright">
        <div id="products">
           <select id="dropdown" name="dropdown">
            </select>
        </div>
        </td>
    </tr>
    <tr>
      <td class="displayTextleft"> 
          Select day(s) for a date range
      </td>
<!--       <td class="displayTextright">
        <div id="radioset">
         <input type="radio" name="rdSelSch" id="rdSelSingle" value="Single" checked /><label for="rdSelSingle"> Single </label>
         <input type="radio" name="rdSelSch" id="rdSelRange" value="Range" /> <label for="rdSelRange"> Range </label>
        </div>
      </td> -->
      <td class="displayTextRight">
          <input type="text" id="startDate" name="startDate" placeholder="Start Date" required>
          <input type="text" id="endDate" name="endDate" placeholder="End Date" required>
      </td>
    </tr>

    <!-- <tr>
      <td class="displayTextleft">
          <input type="text" id="startDate" name="startDate" placeholder="Date" required>
      </td>
      <td class="displayTextright">
          <input type="text" id="endDate" name="endDate" placeholder="End Date" required>
      </td>
    </tr> -->
    <tr>
      <div id="weekDays">
       <td><label class="displayTextleft" for="weekDaysdropdown"></label></td>
       <td class="displayTextright">
    <!--      <select id="weekDaysdropdown" name="weekDaysdropdown" multiple>
          <option value="2">Monday</option> 
          <option value="3">Tuesday</option> 
          <option value="4">Wednesday</option> 
          <option value="5">Thursday</option> 
          <option value="6">Friday</option> 
          <option value="7">Saturday</option> 
         </select> -->
         <table>
         <tr>
         <td class="displayTextright"><input type="checkbox" name="weekDay" id="weekDay" value="2" > Monday</td>
         <td class="displayTextright"><input type="checkbox" name="weekDay" id="weekDay" value="3"> Tuesday</td>
         <td class="displayTextright"><input type="checkbox" name="weekDay" id="weekDay" value="4"> Wednesday</td>

         </tr>

         <tr>
         <td><input type="checkbox" name="weekDay" id="weekDay" value="5"> Thursday</td>
         <td><input type="checkbox" name="weekDay" id="weekDay" value="6"> Friday</td>
         <td><input type="checkbox" name="weekDay" id="weekDay" value="7"> Saturday</td>  </tr>

         </table>
       </td>
      </div>
    </tr> 

    <tr>
      <div id="timeslotIds">
      <td> 
        <label class="displayTextleft"for="timeslotIdsdropdown">Choose Time</label>
      </td>
      <td class="displayTextright"> 
        <select id="timeslotIdsdropdown" name="timeslotIdsdropdown" required>
        </select>
      </td>
      </div>
    </tr>

    <tr>
      <div id="location">
       <td><label class="displayTextleft"  for="locIddropdown">Location</label></td>
       <td class="displayTextright"><select id="locIddropdown" name="locIddropdown">
        </select></td>
      </div>
    </tr> 
<tr>
<td> </td>
<td>
  <button id="button">Submit</button>
</td>
</tr>
   </table>
   <input type="hidden" id="groupId">
   <input type="hidden" id="pkgStartDt">
   <input type="hidden" id="pkgEndDt">
   <input type="hidden" id="prodId">
   <input type="hidden" id="clientId">
   <input type="hidden" id="locId">

</div>

</div>

</body>
<script>




  
  $('#button').on('click',
     function (){
          var $prodId = $('#dropdown').val();
          var $timeSlotId = $('#timeslotIdsdropdown').val();
          var $clientId = $('#clientId').val();
          var $groupId = $('#groupId').val();
          var $locId = $('#locId').val();
          var $startDt = $('#startDate').val();
          var $endDt = $('#endDate').val();  
          var $selectedDays = [];
         // $('input:checkbox:checked').val();

           $("input[name='weekDay']:checked").each(function ()
           {
            $selectedDays.push($(this).val());
           });


          var $schdInfoDtls = {
              "startDt":$startDt,
              "endDt":$endDt,
              "timeSlotId":$timeSlotId,
              "prodId":$prodId,
              "locId":$locId,
              "clientId":$clientId,
              "groupId":$groupId,
              "selectedDays":$selectedDays
          };      
        $.ajax({
                  url: '/apptSchedule/appt/confirm',
                  contentType:'application/json;charset=UTF-8',
                  data:JSON.stringify($schdInfoDtls),
                  type: 'POST',
                  dataType: 'json',
                  success:  function (result) {
                    $('#search').html("<div id='displayResult'></div>");
                    $('#displayResult').append('<table width="100%" style="background: linear-gradient(to bottom,#f0f0f0 0%,#f0f0f0 100%);border-color:#f0f0f0;">');
                    $('#displayResult').append(
                    '<div style="background: linear-gradient(to bottom,#78b1ed 0%,#417bb5 100%);border-color: #2b5177;"> <p class="custtitle"> Current Schedule Details</p> </div>');


$('#displayResult').append("<thead><td width='30%'><b>Requested Date</b></td><td width='30%'><b>Start Time</b></td><td width='30%'><b>End Time</b></td><td width='40%'><b>Status</b></td></thead>");
                    $(result.Records).each(
                        function(index, record){
                             $('#displayResult').append("<tr>");
                             $('#displayResult').append("<td width='30%' class='displayTextright'><div style='padding-left:2px'>"+record.reqDate);
                             $('#displayResult').append("</div></td>");
                             $('#displayResult').append("<td width='30%' class='displayTextright'>"+record.startTime);
                             $('#displayResult').append("</td>");
                             $('#displayResult').append("<td width='30%' class='displayTextright'>"+record.endTime);
                             $('#displayResult').append("</td>");
                             $('#displayResult').append("<td width='40%' class='displayTextright'>"+record.status);
                             $('#displayResult').append("</td>");
                             $('#displayResult').append("</tr>");
                        });
                    $('#displayResult').append("</table>");

                 /*     $('#search').html(result);
                      $('#search').jtable({

                        fields: {

                                      timest:{
                                          title:'Last Update Date',
                                          width:'30%',
                                          create:false,
                                          edit:false,
                                          list:true
                                      }
                        }
                      });*/

                  },
                  error: function () {
                    console.log('No records available.');
                    $('#returnRecords').html("No records available.");
                  }
              });



  });
  $( "#go" ).button();
  $( "#search" ).hide();
  $( "#button" ).button();
//  $( "#radioset" ).buttonset();
 
  //$( "#endDate" ).hide();
  $( "#rdSelSingle" ).on('click',
    function (){
      $( "#startDate" ).attr('placeholder','Date');
      $( "#endDate" ).hide();
    });
  $( "#rdSelRange" ).on('click',
    function (){
      $( "#startDate" ).attr('placeholder','Start Date');
      $( "#endDate" ).show();
    });
  $('#go').on('click',
     function (){
        var $emailAddr = $('#email');
        $.ajax({
                  url: '/apptSchedule/centre/admin/client?emailId='+$emailAddr.val(),
                  type: 'GET',
                  dataType: 'json',
                  async:false,
                  success:  function (result) {
                    $( "#search" ).show();
                    $('#fName').html(result.fName);
                    $('#lName').html(result.lName);
                    $('#schedule').html("<a href=''>Schedule</a>");
                    $('#groupId').attr('value', result.group.groupId);
                    $('#clientId').attr('value', result.clientId);
                  },
                  error: function () {
                    console.log('No records available.');
                    $('#returnRecords').html("No records available.");
                  }
              });
        getClientService();
        getClientSvcPkg();
         $( "#startDate" ).datepicker({
          dateFormat:'yy-mm-dd',
          minDate:$( "#pkgStartDt" ).val(),
          maxDate:$( "#pkgEndDt" ).val()
        });
        $( "#endDate" ).datepicker({
          dateFormat:'yy-mm-dd',
          minDate:$( "#pkgStartDt" ).val(),
          maxDate:$( "#pkgEndDt" ).val()
        });
        getLocationIds();
  });
$('#dropdown').change(function () {
 getClientSvcPkg();
});
$('#locIddropdown').change(function () {
    getTimeSlotIds();
});
function getClientSvcPkg() {
  var $dropdownValSelectedSvc = $('#dropdown').find('option:selected').val();
  $.ajax({
          url: '/apptSchedule/centre/admin/clientSvcPkg?corpId=1&clientId='+$('#clientId').val()+'&prodId='+$dropdownValSelectedSvc,
          type: 'GET',
          dataType: 'json',
          async:false,
          success:  function (result) {
            $('#pkgStartDt').attr('value', result.pkgStartDate);
            $('#pkgEndDt').attr('value', result.pkgEndDate);
          },
          error: function () {
            console.log('No records available.');
          }
  });
}

function getClientService() {
  $.ajax({
          url: '/apptSchedule/centre/admin/products/client/'+$('#clientId').val(),
          type: 'GET',
          dataType: 'json',
          async:false,
          success:  function (productList) {
             $(productList.Records).each(
                  function(index, record){
                    $('#dropdown').append(
                       $('<option>').text(record.prodName).attr('value', record.prodId)
                    );
                  }
             );
          },
          error: function () {
            console.log('No records available.');
          }
  });
}

function getTimeSlotIds(){
    var $selectedLocation = $('#locIddropdown').find('option:selected').val();
    $.ajax({
            url: '/apptSchedule/centre/admin/wrkHrs/loc?corpId=1&locId='+$selectedLocation,
            type: 'GET',
            dataType: 'json',
            success: function (timeSlotList) { 
              $('#timeslotIdsdropdown').empty();          
              $(timeSlotList.Records).each(
                  function(index, record){
                    $('#timeslotIdsdropdown').append(
                            $('<option>').text(record.startTime + "-" + record.endTime).attr('value', record.timeSlotId)
                      );
                  }
              );
            },
            error: function () {
                console.log('No time slots found');
            }
        });
}

function getLocationIds(){
     $.ajax({
            url: '/apptSchedule/centre/admin/loc?corpId=1',
            type: 'GET',
            dataType: 'json',
            success: function (locIdList) { 
              $('#locIddropdown').empty();          
              $(locIdList.Records).each(
                  function(index, record){
                    if( index == 0){
                      $('#locIddropdown').append(
                            $('<option selected>').text(record.locId).attr('value', record.locId)
                      );
                    }else{
                    $('#locIddropdown').append(
                            $('<option>').text(record.locId).attr('value', record.locId)
                      );
                    }

                  }
              );
              getTimeSlotIds();

            },
            error: function () {
              console.log('No location found');
            }
        });

}
</script>
</html>