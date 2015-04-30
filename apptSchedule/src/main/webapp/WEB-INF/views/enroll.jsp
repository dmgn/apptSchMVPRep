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
</head>
<body>
<div class="container" style="margin-top: 10px;" align="center">
<div class="row">
        <div class="span12 navbar">
            <div class="navbar-inner">
                <ul class="nav" id="css3menu1">
                  <li ><a href="/apptSchedule/centre/admin/appointments">Appointments</a></li>
                  <li class="active"><a href="/apptSchedule/centre/admin/enroll">Enrollment</a></li>
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
<div class="container" style="margin-top: 10px;">
	<!-- <div class="row">
		<div class="span12 navbar">
			<div class="navbar-inner">
				<ul class="nav">
				  <li ><a href="/apptSchedule/centre/admin/appointments">Appointments</a></li>
  				  <li class="active"><a href="/apptSchedule/centre/admin/enroll">Enrollment</a></li>
				  <li ><a href="/apptSchedule/centre/admin/tutor">Instructors</a></li>
				  <li ><a href="/apptSchedule/centre/admin/package">Packages</a></li>
				  <li ><a href="/apptSchedule/centre/admin/product">Products</a> </li>
  				  <li ><a href="/apptSchedule/centre/admin/reports">Reports</a></li>
				</ul>				
			</div>	
		</div>
	</div> -->
<div style="background: linear-gradient(to bottom,#f0f0f0 0%,#f0f0f0 100%);border-color:#f0f0f0;">
  <form id="enrollForm" method="POST">
  	<div style="background: linear-gradient(to bottom,#78b1ed 0%,#417bb5 100%);border-color: #2b5177;"> <p class="custtitle"> Parent's Information</p> </div>
	<div style="padding-left: 10px;"><input type="email" id="primEmail" placeholder="Enter Email" required> </div>
	<div style="padding-left: 10px;"><input type="text" id="primCntNo" placeholder="Enter Phone Number" digits="true" minlength="10" maxlength="10"  required></div>
  	<div style="background: linear-gradient(to bottom,#78b1ed 0%,#417bb5 100%)"> <p class="custtitle"> Student's Information</p> </div>
	<div style="padding-left: 10px;"><input type="text" id="fName" name="fName" placeholder="Enter First Name" required>
	<input type="text" id="lName" name="lName" placeholder="Enter Last Name" required></div>
	<div style="padding-left: 10px;"><input type="email" id="emailId" placeholder="Enter Email" required></div>
	<div style="padding-left: 10px;"><input type="text" id="phoneNo" placeholder="Enter Phone Number" digits="true" minlength="10" maxlength="10" required></div>
	<div style="padding-left: 10px;"><input type="text" id="dob" placeholder="Enter Birthday" required></div>
	<div style="padding-left: 10px;">
	<button id="enroll">Submit</button>
	</div>
</form>
</div>
  <script type="text/javascript" src="/apptSchedule/js/enroll.js"></script>
</body>
</div>
</html>