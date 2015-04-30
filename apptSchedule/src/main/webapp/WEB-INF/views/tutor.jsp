<!DOCTYPE html>

<%@ include file="header.jsp" %>


<html>
<head>
<title>Appointment Scheduling</title>

<link href="/apptSchedule/css/blue/jtable.min.css" rel="stylesheet" type="text/css" />
<link href="/apptSchedule/css/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<link href="/apptSchedule/css/jquery-ui.structure.min.css" rel="stylesheet" type="text/css" />
<link href="/apptSchedule/css/jquery-ui.theme.min.css" rel="stylesheet" type="text/css" />
<link href="/apptSchedule/css/menu.css" rel="stylesheet" type="text/css" />

<script src="/apptSchedule/js/jquery.min.js" type="text/javascript"></script>
<script src="/apptSchedule/js/jquery-ui.min.js" type="text/javascript"></script>
<script src="/apptSchedule/js/jquery.jtable.js" type="text/javascript"></script>

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

<div class="container" align="center">
    
<div id="TutorTableContainer"></div>

</div>
 
<script type="text/javascript">
    $(document).ready(function () {
        $('#TutorTableContainer').jtable({
            title: 'Instructors List',
            actions: {
                listAction: function (postData, jtParams) {
                    return $.Deferred(function ($dfd) {
                        $.ajax({
                            url: '/apptSchedule/centre/admin/tutor.json?corpId=1',
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
                        var $tutorName = $('#Edit-tutorName');
                        var $productIds = $('#Edit-productIds');
                    return $.Deferred(function ($dfd) {
                         var Tutor = {            
                             "tutorName":$tutorName.val(),
                             "productIds":$productIds.val(),
                             "corpId":"1"
                        };
                        $.ajax({
                            type:'POST',
                            url:'/apptSchedule/centre/admin/addTutor.json',
                            contentType:'application/json;charset=UTF-8',
                            dataType:'json',
                            data:JSON.stringify(Tutor),
                            success: function (data) {
                                $dfd.resolve(data);
                            },
                            error: function () {
                                $dfd.reject();
                            }
                        });
                    });
                },
                updateAction: function (postData) {
                        var $tutorName = $('#Edit-tutorName');
                        var $productIds = $('#Edit-productIds');                      
                        var $version = $('#Edit-version');
                        var $refId = $('#Edit-refId');

                    return $.Deferred(function ($dfd) {
                         var product = {            
                             "tutorName":$tutorName.val(),
                             "productIds":$productIds.val(),
                             "refId": $refId.val(),
                             "version": $version.val(),
                             "corpId":"1"                             
                        };
                        $.ajax({
                            type:'PUT',
                            url:'/apptSchedule/centre/admin/updateTutor.json',
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
                            url:'/apptSchedule/centre/admin/delTutor/'+$delRefId,
                            contentType:'application/json;charset=UTF-8',
                            dataType:'json',
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
                refId: {
                    key: true,
                    list: false
                },
                Schedule: {
                    title: '',
                    width: '5%',
                    sorting: false,
                    edit: false,
                    create: false,
                    display: function (instructorScheduleData) {
                        var $img = $('<img src="/apptSchedule/img/clock.png" title="Schedule" />');
                        $img.click(function () {
                            $('#TutorTableContainer').jtable('openChildTable',
                                    $img.closest('tr'), //Parent row
                                    {
                                        title: 'Schedule',
                                        actions: {
                                          listAction: function (data, jtParams) {
                                            return $.Deferred(function ($dfd) {
                                                $.ajax({
                                                    url: '/apptSchedule/centre/admin/tutorSchedule?tutorId='+instructorScheduleData.record.tutorId,
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
                                            tutorSchdId: {
                                                key: true,
                                                create: false,
                                                edit: false,
                                                list: false
                                            },
                                            prodName: {
                                                title: 'Product name',
                                                width: '20%',
                                                list:true
                                            },
                                            scheduleDt: {
                                                title: 'Schedule Date',
                                                width: '20%',
                                                list:true
                                            },
                                            startTime:{
                                                title: 'Start Time',
                                                width: '20%',
                                                list:true
                                            },
                                            endTime:{
                                                title: 'End Time',
                                                width: '20%',
                                                list:true
                                            },
                                            locId:{
                                                title: 'Location',
                                                width: '20%',
                                                list:true
                                            }
                                        }
                                    }, function (data) { //opened handler
                                    data.childTable.jtable('load');
                                });
                        });
                        //Return image to show on the person row
                        return $img;
                    }
                },
                 Products: {
                    title: '',
                    width: '5%',
                    sorting: false,
                    edit: false,
                    create: false,
                    display: function (instructorData) {
                        var $img = $('<img src="/apptSchedule/img/column-desc.png" title="Products" />');
                        $img.click(function () {
                            $('#TutorTableContainer').jtable('openChildTable',
                                    $img.closest('tr'), //Parent row
                                    {
                                        title: 'Products',
                                        actions: {
                                          listAction: function (data, jtParams) {
                                            console.log(instructorData);
                                            return $.Deferred(function ($dfd) {
                                                $.ajax({
                                                    url: '/apptSchedule/centre/admin/products/tutor/'+instructorData.record.tutorId,
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
                                            prodId: {
                                                key: true,
                                                create: false,
                                                edit: false,
                                                list: false
                                            },
                                            prodName: {
                                                title: 'Product name',
                                                width: '40%',
                                                list:true
                                            }
                                        }
                                    }, function (data) { //opened handler
                                    data.childTable.jtable('load');
                                });
                        });
                        //Return image to show on the person row
                        return $img;
                    }
                },


                tutorId:{
                    type:'hidden',
                    list: false,
                    defaultValue:0
                },


                tutorName: {
                    title: 'Instructor Name',
                    width: '40%'
                },
                
                productIds: {
                    title: 'Product Ids',
                    width: '20%',
                    list: false,
                    edit:true,
                    // display: function (data) {
                    //     console.log(data);
                    // }
                    type: 'multiselect',
                    options: function(data){
                                     
                                     var $result = {};
                                       $.ajax({
                                            url: '/apptSchedule/centre/admin/products/1.json',
                                            type: 'GET',
                                            dataType: 'json',
                                            async:false,
                                            success:  function (productList) {
                                                $(productList.Records).each(
                                                    function(index, record){
                                                      $result[record.prodId]=record.prodName;                  
                                                    }
                                                 );
                                            },
                                            error: function () {
                                            }
                                        });
                                        return $result;
                        }
                    //}
                    //values: { 'false': 'Passive', 'true': 'Active' },
                    //defaultValue: 'test'
                },

                timest:{
                    title:'Last Update Date',
                    width:'30%',
                    create:false,
                    edit:false
                },
                version: {
                    list: false,
                    create:false,
                    edit:false,
                    hidden:true
                }
            }
        });

        $('#TutorTableContainer').jtable('load');
    });
</script>

 </body>
</html>