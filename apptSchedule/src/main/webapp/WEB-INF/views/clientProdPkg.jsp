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


</head>
<body>

<div class="container" style="margin-top: 10px;" align="center">
    <div class="row">
        <div class="span12 navbar">
            <div class="navbar-inner">
                <ul class="nav">
                  <li ><a href="/apptSchedule/centre/admin/product">Manage Products</a> </li>
                  <li ><a href="/apptSchedule/centre/admin/package">Manage Packages</a></li>
                  <li class="active"><a href="/apptSchedule/centre/admin/enroll">Manage Enrollment</a></li>
                  <li ><a href="/apptSchedule/centre/admin/tutor">Manage Tutors</a></li>
                  <li ><a href="/apptSchedule/centre/admin/appointments">Manage Appointments</a></li>
                  <li ><a href="/apptSchedule/centre/admin/reports">Manage Reports</a></li>
                </ul>               
            </div>  
        </div>
    </div> 

<div id="SubscribePkgTableContainer">
    
<div id="fName">

</div>

<div id="lName">
    
</div>

<div id="emailId">
    
</div>

<div id="dob">
    
</div>

<div id="packages">


<select id="dropdown" name="dropdown">
</select>

</div>
</div>
<input type="hidden" id="enrollRefId" value="${enrollRefId}" >
<input type="hidden" id="productId" value="${productId}">
<input type="hidden" id="enrollId" >

<button id="subscribePkg">Subscribe</button>

</div>
 <script type="text/javascript">
    $(document).ready(function () {
            	var $enrollRefId = $('#enrollRefId');
                $.ajax({
                            url: '/apptSchedule/centre/admin/package/'+$enrollRefId,
                            type: 'GET',
                            dataType: 'json',
                            success: function (data) {
                                console.log(data);
                                // var $fName = data.fName;
                                // var $lName = data.lName;
                                // var $emailId = data.emailId;
                                // var $dob = data.dob;
                                // var $clientId = data.clientId;
                                // $('#fName').append( " First Name : " + $fName);
                                // $('#lName').append( " Last Name : " + $lName);
                                // $('#emailId').append( " Email Id : " + $emailId);
                                // $('#dob').append( " Date of Birth : " + $dob);
                                $('#enrollId').attr('value', data.enrollId);
                            },
                            error: function () {
                                console.log('No record found.');
                            }
                    });
                    $.ajax({
                                url: '/apptSchedule/centre/admin/package/1.json',
                                type: 'GET',
                                dataType: 'json',
                                async:false,
                                success:  function (pkgList) {
                                    $(pkgList.Records).each(
                                        function(index, record){
                                          $('#dropdown').append(
                                                  $('<option>').text(record.pkgName).attr('value', record.pkgId)
                                            );
                                        }
                                     );
                                },
                                error: function () {
                                  console.log('No package record found.');
                                }
                            });                   
    });




$(function(){
    var $productId = $('#productId');
    var $clientId = $('#clientId');
    var $enrollId = $('#enrollId');
    var $dropdownValSelected = $('#dropdown').val();

    $('#subscribePkg').on('click', function(){   

        var clientProdPkgDtls = {           
            //"clientId":$clientId.val(),
            "packageId":$dropdownValSelected,
            "productId":$productId.val(),
            "enrollId":$enrollId.val(),
            "corpId":"1"
        };
        //console.log(JSON.stringify(clientProdPkgDtls));
        $.ajax({
                type:'POST',
                url:'/apptSchedule/centre/admin/clientSvcPkg',
                contentType:'application/json;charset=UTF-8',
                dataType:'json',
                data:JSON.stringify(clientProdPkgDtls),
                success: function(response){
                    console.log(response);  
                },
                error:function(){
                    alert('Error saving product');
                }
        });
    });
});



</script>
 </body>
</html>