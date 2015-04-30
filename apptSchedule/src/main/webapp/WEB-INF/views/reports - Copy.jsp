<!DOCTYPE html>

<%@ include file="header.jsp" %>



<html>
<head>
<title>Appointment Scheduling</title>
</head>
<body>
<div class="container" style="margin-top: 10px;" align="center">
	<div class="row">
		<div class="span12 navbar">
			<div class="navbar-inner">
				<ul class="nav">
				  <li ><a href="/apptSchedule/centre/admin/product">Manage Products</a> </li>
				  <li ><a href="/apptSchedule/centre/admin/package">Manage Packages</a></li>
  				  <li ><a href="/apptSchedule/centre/admin/enroll">Manage Enrollment</a></li>
				  <li ><a href="/apptSchedule/centre/admin/tutor">Manage Tutors</a></li>
				  <li ><a href="/apptSchedule/centre/admin/appointments">Manage Appointments</a></li>
  				  <li class="active"><a href="/apptSchedule/centre/admin/reports">Manage Reports</a></li>
<!-- 				  <li ><a href="/web/demo/form">Form</a></li>
				  <li ><a href="/web/demo/popup">Popup</a></li>
				  <li ><a href="/web/demo/utils">Utilities</a></li> -->
				</ul>				
			</div>	
		</div>
	</div>
</div>
<h1>Manage Products</h1>
<script type="text/javascript" src="/apptSchedule/js/jquery.min.js"></script>

<h2>Product List</h2>

<ul id="products"></ul>

<!-- 	 <form name="productInfo" id="productInfo" action="/apptSchedule/centre/admin/addProd" method="POST">
 -->	<h3> Add Product</h3>
		<p>Product Name: <input type="text" id="prodName"></p>
		<p>Product Unit Price: <input type="text" id="unitPrice"></p>
		<p>Product Description: <input type="text" id="desc"></p>
		<button id="add-Product">Add Product</button>
		<script type="text/javascript" src="/apptSchedule/js/adminProduct.js"></script>
		<script type="text/javascript" src="/apptSchedule/js/jquery.js"></script>
		<script type="text/javascript" src="/apptSchedule/js/jquery-ui.js"></script>

<!-- 	</form>
 --></body>
</html>