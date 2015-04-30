<!DOCTYPE html>

<%@ include file="header.jsp" %>



<html>
<head>
<title>Appointment Scheduling</title>
 
<link href="/apptSchedule/css/blue/jtable.min.css" rel="stylesheet" type="text/css" />
<link href="/apptSchedule/css/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<link href="/apptSchedule/css/jquery-ui.structure.min.css" rel="stylesheet" type="text/css" />
<link href="/apptSchedule/css/jquery-ui.theme.min.css" rel="stylesheet" type="text/css" />
<script src="/apptSchedule/js/jquery.min.js" type="text/javascript"></script>
<script src="/apptSchedule/js/jquery-ui.min.js" type="text/javascript"></script>
<script src="/apptSchedule/js/jquery.jtable.min.js" type="text/javascript"></script>
<script src="/apptSchedule/js/common.js" type="text/javascript"></script>
<script type="text/javascript" src="/apptSchedule/js/jquery.validate.min.js"></script>
<link href="/apptSchedule/css/menu.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="/apptSchedule/css/jquery-ui.css">
<style>
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
  padding-left: 50px;
  font-family: Verdana,Arial,Helvetica,sans-serif;
}
</style>
</head>
<body>
<div class="container" style="margin-top: 10px;" align="center">
<div class="row">
        <div class="span12 navbar">
            <div class="navbar-inner">
                <ul class="nav" id="css3menu1">
                  <li ><a href="/apptSchedule/centre/admin/appointments">Appointments</a></li>
                  <li ><a href="/apptSchedule/centre/admin/enroll">Enrollment</a></li>
                  <li class="active"><a href="/apptSchedule/centre/admin/tutor">Instructors</a>

                    <div class="submenu">
                    <div class="column">
                     <ul id="css3menu1">
                      <li>
                        <a href="/apptSchedule/centre/admin/tutor" title="Setup">Setup</a>
                      </li>
                      <li>
                        <a href="/apptSchedule/centre/admin/tutorSchd" title="Schedule">Schedule</a>
                      </li>
                     </ul>
                    </div>
                   </div>


                  </li>
                  <li ><a href="/apptSchedule/centre/admin/package">Packages</a></li>
                  <li ><a href="/apptSchedule/centre/admin/product">Products</a> </li>
                  <li ><a href="/apptSchedule/centre/admin/reports">Reports</a></li>
                </ul>               
            </div>  
        </div>
    </div> 
</div>
<div class="container" >
<!-- <div class="row">
    <div class="span12 navbar">
      <div class="navbar-inner">
                <ul class="nav">
                  <li ><a href="/apptSchedule/centre/admin/appointments">Appointments</a></li>
                  <li ><a href="/apptSchedule/centre/admin/enroll">Enrollment</a></li>
                  <li ><a href="/apptSchedule/centre/admin/tutor">Instructors</a>
                   
                  </li>
                  <li ><a href="/apptSchedule/centre/admin/package">Packages</a></li>
                  <li ><a href="/apptSchedule/centre/admin/product">Products</a> </li>
                  <li class="active"><a href="/apptSchedule/centre/admin/reports">Reports</a></li>
                </ul>         
      </div>  
    </div>
</div> -->
<div id="schForm" style="background: linear-gradient(to bottom,#f0f0f0 0%,#f0f0f0 100%);border-color:#f0f0f0;">
<table>
  <form id="tutorScheduleForm" method="POST">
  <div style="background: linear-gradient(to bottom,#78b1ed 0%,#417bb5 100%);border-color: #2b5177;"> <p class="custtitle"> Instructor Schedule</p> </div>
  <tr>
      <div id="tutors">
       <td><label class="displayTextleft"  for="tutorsdropdown">Instructor</label></td>
       <td class="displayTextright"><select id="tutorsdropdown" name="tutorsdropdown">
        </select></td>
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
      <div id="products">
        <td><label class="displayTextleft" for="productsdropdown">Products</label></td>
        <td class="displayTextright"><select id="productsdropdown" name="productsdropdown" multiple required>
        </select>
        </td>
      </div>
</tr>
<tr>
      <div>
      <td><label  class="displayTextleft"  for="scheduleStartDate">Start Date</label></td>
      <td class="displayTextright"><input type="text" id="scheduleStartDate" name="scheduleStartDate" required>
      </td></div>
</tr>
<tr>
      <div>
      <td><label  class="displayTextleft"  for="scheduleEndDate">End Date</label></td>
      <td class="displayTextright"><input type="text" id="scheduleEndDate" name="scheduleEndDate" required>
      </td></div>
</tr>
<tr>
      <div id="timeslotIds">
       <td> <label  class="displayTextleft"  for="timeslotIdsdropdown">Time Availability</label></td>
       <td class="displayTextright"> <select id="timeslotIdsdropdown" name="timeslotIdsdropdown" multiple required>
        </select></td>
      </div>
</tr>
<tr>
  <td></td>
  <td>
      <div style="padding-left: 10px;">
      <button id="enroll">Confirm Schedule</button>
      </div>
  </td>
</tr>
  </form>
  </table>
  </div>
</div>
<script type="text/javascript">  

$(document).ready(function () {
 $( "#enroll" ).button();
 $.ajax({
            url: '/apptSchedule/centre/admin/tutor.json?corpId=1',
            type: 'GET',
            dataType: 'json',
            success: function (tutorList) {              
              $(tutorList.Records).each(
                  function(index, record){
                    $('#tutorsdropdown').append(
                            $('<option>').text(record.tutorName).attr('value', record.tutorId)
                      );
                  }
              );
              getProductsForTutor();
              getTimeSlotIds();
              getLocationIds();
            },
            error: function () {}
        });
  
});



$('#tutorsdropdown').change(function () {
 getProductsForTutor();
});

function getProductsForTutor(){
    $.ajax({
            url: '/apptSchedule/centre/admin/products/tutor/'+$('#tutorsdropdown').find('option:selected').val(),
            type: 'GET',
            dataType: 'json',
            success: function (tutorList) { 

              $('#productsdropdown').empty();          
              $(tutorList.Records).each(
                  function(index, record){
                    $('#productsdropdown').append(
                            $('<option>').text(record.prodName).attr('value', record.prodId)
                      );
                  }
              );
            },
            error: function () {}
        });

}

function getTimeSlotIds(){
     $.ajax({
            url: '/apptSchedule/centre/admin/wrkHrs/1',
            type: 'GET',
            dataType: 'json',
            success: function (timeSlotList) { 
              //$('#timeslotIdsdropdown').empty();          
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
              //$('#timeslotIdsdropdown').empty();          
              $(locIdList.Records).each(
                  function(index, record){
                    $('#locIddropdown').append(
                            $('<option>').text(record.locId).attr('value', record.locId)
                      );
                  }
              );
            },
            error: function () {
              console.log('No location ids found');
            }
        });
}


$().ready(function() {
  $("#tutorScheduleForm").validate(
      {       submitHandler: function(){
                var $tutorId = $('#tutorsdropdown').find('option:selected').val();
//                var $timeSlotId = $('#timeslotIdsdropdown').find('option:selected').val();
                var $timeSlotId = $('#timeslotIdsdropdown').val();

                var $scheduleStartDate = $('#scheduleStartDate').val();
                var $scheduleEndDate = $('#scheduleEndDate').val();
                var $locId = $('#locIddropdown').find('option:selected').val();
                var $selectedOpts = $('#productsdropdown').val();
                var $TutorSchDetails = {
                    "corpId":"1",
                    "tutorId":$tutorId,
                    "locId":$locId,
                    "startDate":$scheduleStartDate,
                    "endDate":$scheduleEndDate,
                    "prodIds":$selectedOpts,
                    "timeSlotIds":$timeSlotId,
                };
                    $.ajax({
                          type:'POST',
                          url:'/apptSchedule/centre/admin/tutorSchedule',
                          contentType:'application/json;charset=UTF-8',
                          dataType:'json',
                          data:JSON.stringify($TutorSchDetails),
                          success: function(response){
                            console.log(response);
                            $("#schForm").html("<p> Tutor Schedule saved successfully..</p>");
                          },
                          error:function(){
                            console.log(response);
                            }
                      });

            }
      }
    );
});
</script>
  <script type="text/javascript" src="/apptSchedule/js/datepicker.js"></script>

</body>
</html>