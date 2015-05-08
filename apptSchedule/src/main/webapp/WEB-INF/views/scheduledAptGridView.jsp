<!DOCTYPE html>

<%@ include file="header.jsp" %>


<html>
<head>
<title>Appointment Scheduling</title>
<link href="/apptSchedule/css/menu.css" rel="stylesheet" type="text/css" />
<link href="/apptSchedule/css/blue/jtable.min.css" rel="stylesheet" type="text/css" />
<link href="/apptSchedule/css/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<link href="/apptSchedule/css/jquery-ui.structure.min.css" rel="stylesheet" type="text/css" />
<link href="/apptSchedule/css/jquery-ui.theme.min.css" rel="stylesheet" type="text/css" />
<script src="/apptSchedule/js/jquery.min.js" type="text/javascript"></script>
<script src="/apptSchedule/js/jquery-ui.min.js" type="text/javascript"></script>
<script src="/apptSchedule/js/jquery.jtable.min.js" type="text/javascript"></script>


</head>
<body>
<div class="container" style="margin-top: 10px;" align="center">

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
                  <li ><a href="/apptSchedule/centre/admin/tutor">Instructors</a>
                  </li>
                  <li ><a href="/apptSchedule/centre/admin/package">Packages</a></li>
                  <li ><a href="/apptSchedule/centre/admin/product">Products</a> </li>
                  <li ><a href="/apptSchedule/centre/admin/reports">Reports</a></li>
                </ul>               
            </div>  
        </div>
    </div> 
</div>
</div>

<div class="container" style="margin-top: 10px;" align="center">
<div id="ApptTableContainer"></div>

</div>
 
<script type="text/javascript">
    $(document).ready(function () {
        $('#ApptTableContainer').jtable({
            title: 'Scheduled Appointments',
            actions: {
                listAction: function (postData, jtParams) {
                    return $.Deferred(function ($dfd) {
                        $.ajax({
                            url: '/apptSchedule/appt/view/tslots?status=1&viewType=Grid',
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
                reqDate: {
                    title:'Date',
                    width:'30%'
                },
                startTime: {
                    title: 'Start Time',
                    width: '20%'
                },
                endTime: {
                    title: 'End Time',
                    width: '20%'
                },
                count:{
                    title:'Total Attendees',
                    width:'30%',
                    display: function (data) {
    return $('<a href="/apptSchedule/view/tsId?tutorSchId=' + data.record.tutorSchId + '">' + data.record.count + '</a>');
                            }
                }
                
            }
        });

        $('#ApptTableContainer').jtable('load');
    });
</script>
 </body>
</html>