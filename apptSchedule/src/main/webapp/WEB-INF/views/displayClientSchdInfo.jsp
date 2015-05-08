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
<div class="container" style="margin-top: 10px;" align="center">
<div id="ApptTableContainer"></div>

</div>
</div>
     <input type="hidden" id="tutorSchdId" value="${tsId}" >


<script type="text/javascript">
    $(document).ready(function () {
        var $tsId = $('#tutorSchdId').val();
        $('#ApptTableContainer').jtable({
            title: 'Scheduled Appointments',
            actions: {
                listAction: function (postData, jtParams) {
                    return $.Deferred(function ($dfd) {
                        $.ajax({
                            url: '/apptSchedule/appt/view/info?tutorSchId='+$tsId,
                            type: 'GET',
                            dataType: 'json',
                            success: function (data) {
                                $dfd.resolve(data);
                            },
                            error: function () {
                                $dfd.reject();
                            }
                        });
                    });
                }
            },
            fields: {
                /*refId: {
                    key: true,
                    list: false
                },*/
                fName: {
                    title:'First Name',
                    width:'30%'
                },
                lName: {
                    title: 'Last Name',
                    width: '20%'
                },
                tutorName: {
                    title: 'Tutor Name',
                    width: '20%'
                },
                prodName:{
                    title:'Product Name',
                    width:'30%'
                   
                }
                
            }
        });

        $('#ApptTableContainer').jtable('load');
    });
</script>

</html>