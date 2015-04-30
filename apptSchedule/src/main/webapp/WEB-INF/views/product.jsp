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
                  <li ><a href="/apptSchedule/centre/admin/appointments">Appointments</a></li>
                  <li ><a href="/apptSchedule/centre/admin/enroll">Enrollment</a></li>
                  <li ><a href="/apptSchedule/centre/admin/tutor">Instructors</a>
                  </li>
                  <li ><a href="/apptSchedule/centre/admin/package">Packages</a></li>
                  <li class="active"><a href="/apptSchedule/centre/admin/product">Products</a> </li>
                  <li ><a href="/apptSchedule/centre/admin/reports">Reports</a></li>
                </ul>               
            </div>  
        </div>
    </div> 
</div>
</div>

<div class="container" style="margin-top: 10px;" align="center">
  <!--   <div class="row">
        <div class="span12 navbar">
            <div class="navbar-inner">
                <ul class="nav">
                  <li ><a href="/apptSchedule/centre/admin/appointments">Appointments</a></li>
                  <li ><a href="/apptSchedule/centre/admin/enroll">Enrollment</a></li>
                  <li ><a href="/apptSchedule/centre/admin/tutor">Instructors</a></li>
                  <li ><a href="/apptSchedule/centre/admin/package">Packages</a></li>
                  <li class="active"><a href="/apptSchedule/centre/admin/product">Products</a> </li>
                  <li ><a href="/apptSchedule/centre/admin/reports">Reports</a></li>
                </ul>                 
            </div>  
        </div>
    </div>  -->

<div id="ProductTableContainer"></div>

</div>
 
<script type="text/javascript">
    $(document).ready(function () {
        $('#ProductTableContainer').jtable({
            title: 'Product List',
            actions: {
                listAction: function (postData, jtParams) {
                    return $.Deferred(function ($dfd) {
                        $.ajax({
                            url: '/apptSchedule/centre/admin/products/1.json',
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
                },
                createAction: function (postData) {
                        var $prodName = $('#Edit-prodName');
                        var $unitPrice = $('#Edit-unitPrice');
                        var $capacity = $('#Edit-capacity');
                    return $.Deferred(function ($dfd) {
                         var product = {            
                             "prodName":$prodName.val(),
                             "unitPrice":$unitPrice.val(),
                             "capacity":$capacity.val(),
                             "corpId":"1"
                        };
                        $.ajax({
                            type:'POST',
                            url:'/apptSchedule/centre/admin/addProd.json',
                            contentType:'application/json;charset=UTF-8',
                            dataType:'json',
                            data:JSON.stringify(product),
                            success: function (data) {
                                $dfd.resolve(data);
                            },
                            error: function () {
                                $dfd.reject();
                            }
                        });
                    });
                },
                updateAction: 
                function (postData) {
                        var $prodName = $('#Edit-prodName');
                        var $unitPrice = $('#Edit-unitPrice');
                        var $refId = $('#Edit-refId');
                        var $version = $('#Edit-version');
                        var $capacity = $('#Edit-capacity');
                    return $.Deferred(function ($dfd) {
                         var product = {            
                             "prodName":$prodName.val(),
                             "unitPrice":$unitPrice.val(),
                             "refId": $refId.val(),
                             "version": $version.val(),
                             "capacity":$capacity.val(),
                             "corpId":"1"                             
                        };
                        $.ajax({
                            type:'PUT',
                            url:'/apptSchedule/centre/admin/updateProd.json',
                            contentType:'application/json;charset=UTF-8',
                            dataType:'json',
                            data:JSON.stringify(product),
                            success: function (data) {
                                $dfd.resolve(data);
                            },
                            error: function () {
                                $dfd.reject();
                            }
                        });
                    });
                },
                deleteAction: 
                function (postData) {
                        var $delRefId = postData.refId ;
                        return $.Deferred(function ($dfd) {
                        $.ajax({
                            type:'DELETE',
                            url:'/apptSchedule/centre/admin/delProd/'+$delRefId,
                            contentType:'application/json;charset=UTF-8',
                            dataType:'json',
                            success: function (data) {
                                $dfd.resolve(data);
                            },
                            error: function () {
                               
                            }
                        });
                    });
                }
            },
            fields: {
                refId: {
                    key: true,
                    list: false
                },
                prodName: {
                    title: 'Product Name',
                    width: '40%'
                },
                unitPrice: {
                    title: 'Unit Price ($)',
                    width: '20%'
                },
                timest:{
                    title:'Last Update Date',
                    width:'30%',
                    create:false,
                    edit:false
                },               
                capacity: {
                    title: 'Capacity',
                    width: '20%',
                    options: {  '3':'Restricted', '4':'Unrestricted'}
                },
                version: {
                    list: false,
                    create:false,
                    edit:false
                }
            }
        });

        $('#ProductTableContainer').jtable('load');
    });
</script>
 </body>
</html>