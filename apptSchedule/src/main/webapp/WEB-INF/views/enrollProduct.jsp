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
<link rel="stylesheet" href="/apptSchedule/css/jquery-ui.css">
<link href="/apptSchedule/css/menu.css" rel="stylesheet" type="text/css" />
</head>
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
  <!--   <div class="row">
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

<div id="EnrollTableContainer">
<div style="background: linear-gradient(to bottom,#78b1ed 0%,#417bb5 100%);border-color: #2b5177;"> <p class="custtitle"> Enroll for a Product </p> </div>
<table width="100%" style="background: linear-gradient(to bottom,#f0f0f0 0%,#f0f0f0 100%);border-color:#f0f0f0;">
<tr>
<td class="displayTextleft" width="40%" >First Name</td>
<td class="displayTextright">
    <div id="fName"></div>
</td>
</tr>
<tr>
<td class="displayTextleft">Last Name</td>
<td class="displayTextright">
    <div id="lName"></div>
    </td>
</tr>
 <tr>
<td class="displayTextleft">Email</td>
<td class="displayTextright">
   <div id="emailId"></div>
   </td>
</tr>
<tr>
<td class="displayTextleft">Birthday</td>
<td class="displayTextright">
    <div id="dob"></div>
    </td>
</tr>
<tr>
<td class="displayTextleft">Product</td>
<td class="displayTextright">
    <div id="products">
       <select id="dropdown" name="dropdown">
        </select>
    </div>
    </td>
</tr>


<tr id="pkgInfo1">
<td class="displayTextleft">Package</td>
<td class="displayTextright">

    <div id="packages">
    </div>
</td>
</tr>


<tr id="pkgInfo2">
<td class="displayTextleft">Package Start Date</td>
<td class="displayTextright">
    <div><input type="text" id="pkgStartDate" placeholder="Select Start Date" required></div>

</td>
</tr>

<tr id="pkgInfo3">
<td class="displayTextleft">Package End Date</td>
<td class="displayTextright">

    <div id="pkgEndDate">
    </div>
</td>
</tr>

<tr id="pkgInfo4">
<td class="displayTextleft">Package Cost</td>
<td class="displayTextright">

    <div id="pkgCost">
    </div>
</td>
</tr>
<tr>
<td>    
</td>
<td>
<div id="button">
    </div>
</td>
</tr>
</table>
    <input type="hidden" id="refId" value="${refId}" >
    <input type="hidden" id="clientId">
    <input type="hidden" id="productId">
    <input type="hidden" id="enrollId">
    <input type="hidden" id="calcPkgEndDate">
    <input type="hidden" id="cost">

</div>

</div>
 <script type="text/javascript">
    var $prodIdCostMap = {};
    $(document).ready(function () {
                $('#pkgInfo1').hide();
                $('#pkgInfo2').hide();
                $('#pkgInfo3').hide();
                $('#pkgInfo4').hide();
            	var $refId = $('#refId');
                var $divTag = $('#EnrollTableContainer');
                var $dropdownTag = $('#dropdown');
                $('#products').html('<select id="dropdown" name="dropdown"></select>');
                $.ajax({
                            url: '/apptSchedule/centre/admin/client/'+$refId.val(),
                            type: 'GET',
                            dataType: 'json',
                            success: function (data) {
                                var $fName = data.fName;
                                var $lName = data.lName;
                                var $emailId = data.emailId;
                                var $dob = data.dob;
                                var $clientId = data.clientId;
                                $('#fName').append($fName);
                                $('#lName').append($lName);
                                $('#emailId').append($emailId);
                                $('#dob').append($dob);
                                $('#clientId').attr('value', $clientId);
                            },
                            error: function () {
                                console.log('No record found.');
                            }
                    });
                    $.ajax({
                                url: '/apptSchedule/centre/admin/products/1.json',
                                type: 'GET',
                                dataType: 'json',
                                async:false,
                                success:  function (productList) {
                                    $(productList.Records).each(
                                        function(index, record){
                                          $('#dropdown').append(
                                                  $('<option>').text(record.prodName).attr('value', record.prodId)
                                            );
                                          $prodIdCostMap[record.prodId] = record.unitPrice;
                                        }
                                     );
                                $('#button').html('<div class="displayTextright"><button id="enrollProduct">Enroll Product</button></div>');
                                },
                                error: function () {
                                  console.log('No product record found.');
                                }
                            }); 
                                $( "#enrollProduct" ).button();
                  
    });
$(function(){
    var $dropdownValSelected = $('#dropdown');
    var $dropdownValPkgSelected = $('#packages');
    var $clientId = $('#clientId');
    $('#enrollProduct').on('click', function(){ 
        var $dropdownProdValSelectedLabel = $('#dropdown').find('option:selected').text(); 
        var clientInfoDtls = {           
            "clientId":$clientId.val(),
            "productId":$dropdownValSelected.val(),
            "corpId":"1"
        };
        $('#pkgInfo1').show();
        $('#pkgInfo2').show();

        $('#cost').attr('value', $prodIdCostMap[$dropdownValSelected.val()]);
                          //  $('#productId').attr('value', $dropdownValSelected.val());

        $.ajax({
                type:'POST',
                url:'/apptSchedule/centre/admin/enrollClient',
                contentType:'application/json;charset=UTF-8',
                data:JSON.stringify(clientInfoDtls),
                success: function(response){
                    $('#products').html( $dropdownProdValSelectedLabel );
                    $('#packages').html('<select id="pkgdropdown" name="pkgdropdown"></select>');
                    $('#productId').attr('value', $dropdownValSelected.val());
                    $('#button').html('<button id="subscribePkg">Enroll & Pay</button>');
                    $( "#subscribePkg" ).button();
                    console.log(response.refId);
                    $.ajax({
                                url: '/apptSchedule/centre/admin/enroll/id/'+response.refId,
                                type: 'GET',
                                dataType: 'json',
                                async:false,
                                success:  function (resp) {
                                    $('#enrollId').attr('value', resp.enrollId);
                                },
                                error: function () {
                                  console.log('No enrollment found.');
                                }
                    });
                    var $pkgIdDurationMap = {};

                    $.ajax({
                        url: '/apptSchedule/centre/admin/package/1.json',
                        type: 'GET',
                        dataType: 'json',
                        async:false,
                        success:  function (pkgList) {
                            $(pkgList.Records).each(
                                function(index, record){
                                  $('#pkgdropdown').append(
                                    $('<option>').text(record.pkgName + " (" + record.pkgDur + " week(s)) ").attr('value', record.pkgId)
                                   );
                                 $pkgIdDurationMap[record.pkgId]=record.pkgDur;   
                                 //$pkgIdCostMap[record.pkgId]=record.pkgDur;          

                                }
                             );
                            console.log($pkgIdDurationMap);
                            var $productId = $('#productId');
                            var $clientId = $('#clientId');
                            var $enrollId = $('#enrollId');
                            $( "#pkgStartDate" ).datepicker({
                                    minDate: 0,
                                    changeMonth: true,
                                    dateFormat:'yy-mm-dd',
                                    onClose: function(selectedDate){
                                        var endDatesec = Date.parse(selectedDate);
                                        var endDate = new Date (endDatesec);    
                    endDate.setDate( endDate.getDate() + ($pkgIdDurationMap[$('#pkgdropdown').find('option:selected').val()] * 7) );
                            $('#pkgInfo3').show();
                            $('#pkgInfo4').show();
                                        $("#pkgEndDate").html( formatDate( endDate ) );
                                        $("#calcPkgEndDate").attr('value', formatDate( endDate ) );
                                        $("#pkgCost").html("$"+$('#cost').val() * ($pkgIdDurationMap[$('#pkgdropdown').find('option:selected').val()]));
                                    }
                            });
                            $('#subscribePkg').on('click', function(){   
                            var $dropdownValSelectedPkg = $('#pkgdropdown').find('option:selected').val();
                                    console.log($dropdownValSelectedPkg);
                                    var clientProdPkgDtls = {           
                                        "packageId":$dropdownValSelectedPkg,
                                        "productId":$productId.val(),
                                        "enrollId":$enrollId.val(),
                                        "corpId":"1",
                                        "pkgStartDate":$('#pkgStartDate').val(),
                                        "pkgEndDate":$('#calcPkgEndDate').val()
                                    };
                                    $.ajax({
                                            type:'POST',
                                            url:'/apptSchedule/centre/admin/clientSvcPkg',
                                            contentType:'application/json;charset=UTF-8',
                                            dataType:'json',
                                            data:JSON.stringify(clientProdPkgDtls),
                                            success: function(response){
                                                console.log(response);  
                                                $('#EnrollTableContainer').html("Thank you!! Your enrollment is successful.");
                                            },
                                            error:function(){
                                                alert('Error saving product');
                                            }
                                    });
                                });
                        },
                        error: function () {
                          console.log('Error.');
                        }
                    });

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