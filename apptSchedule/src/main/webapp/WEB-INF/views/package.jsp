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
<link href="/apptSchedule/css/menu.css" rel="stylesheet" type="text/css" />


</head>
<body>
<div class="container" style="margin-top: 10px;" align="center">
<div class="row">
        <div class="span12 navbar">
            <div class="navbar-inner">
                <ul class="nav" id="css3menu1">
                  <li ><a href="/apptSchedule/centre/admin/appointments">Appointments</a></li>
                  <li ><a href="/apptSchedule/centre/admin/enroll">Enrollment</a></li>
                  <li ><a href="/apptSchedule/centre/admin/tutor">Instructors</a>         </li>
                  <li class="active"><a href="/apptSchedule/centre/admin/package">Packages</a></li>
                  <li ><a href="/apptSchedule/centre/admin/product">Products</a> </li>
                  <li ><a href="/apptSchedule/centre/admin/reports">Reports</a></li>
                </ul>               
            </div>  
        </div>
    </div> 
</div>
<div class="container" style="margin-top: 10px;" align="center">
<!--     <div class="row">
        <div class="span12 navbar">
            <div class="navbar-inner">
                <ul class="nav">
                  <li ><a href="/apptSchedule/centre/admin/appointments">Appointments</a></li>
                  <li ><a href="/apptSchedule/centre/admin/enroll">Enrollment</a></li>
                  <li ><a href="/apptSchedule/centre/admin/tutor">Instructors</a></li>
                  <li class="active"><a href="/apptSchedule/centre/admin/package">Packages</a></li>
                  <li ><a href="/apptSchedule/centre/admin/product">Products</a> </li>
                  <li ><a href="/apptSchedule/centre/admin/reports">Reports</a></li>
                </ul>            
            </div>  
        </div>
    </div>  -->

<div id="PackageTableContainer"></div>

</div>
 
<script type="text/javascript">
    $(document).ready(function () {
        $('#PackageTableContainer').jtable({
            title: 'Package List',
            actions: {
                listAction: function (postData, jtParams) {
                    return $.Deferred(function ($dfd) {
                        $.ajax({
                            url: '/apptSchedule/centre/admin/package/1.json',
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
                        var $pkgName = $('#Edit-pkgName');
                        var $pkgDur = $('#Edit-pkgDur');
                        var $desc = $('#Edit-desc');
                        var $offerCode = $('#Edit-offerCode');
                    return $.Deferred(function ($dfd) {
                         var Package = {            
                             "pkgName":$pkgName.val(),
                             "pkgDur":$pkgDur.val(),
                             "desc":$desc.val(),
                             "offerCode":$offerCode.val(),
                             "corpId":"1"
                        };
                        $.ajax({
                            type:'POST',
                            url:'/apptSchedule/centre/admin/addPkg.json',
                            contentType:'application/json;charset=UTF-8',
                            dataType:'json',
                            data:JSON.stringify(Package),
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
                        var $pkgName = $('#Edit-pkgName');
                        var $pkgDur = $('#Edit-pkgDur');
                        var $refId = $('#Edit-refId');
                        var $desc = $('#Edit-desc');
                        var $offerCode = $('#Edit-offerCode');
                        var $version = $('#Edit-version')
                        var $form = this;
                    return $.Deferred(function ($dfd) {
                         var Package = {            
                             "pkgName":$pkgName.val(),
                             "pkgDur":$pkgDur.val(),
                             "refId": $refId.val(),
                             "desc":$desc.val(),
                             "offerCode":$offerCode.val(),
                             "corpId":"1",
                             "version": $version.val()
                        };
                        $.ajax({
                            type:'PUT',
                            url:'/apptSchedule/centre/admin/updatePkg.json',
                            contentType:'application/json;charset=UTF-8',
                            dataType:'json',
                            data:JSON.stringify(Package),
                            success: function (data) {
                                $dfd.resolve(data);
                                console.log(data);
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
                            url:'/apptSchedule/centre/admin/delPkg/'+$delRefId,
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
                pkgName: {
                    title: 'Package Name',
                    width: '20%'
                },
                pkgDur: {
                    title: 'Package Duration',
                    width: '20%',
                    options: {  '1':'1 Week', '2':'2 Weeks','3':'3 Weeks',
                                '4':'4 Weeks', '5':'5 Weeks','6':'6 Weeks',
                                '7':'7 Weeks', '8':'8 Weeks','9':'9 Weeks',
                                '10':'10 Weeks', '11':'11 Weeks','12':'12 Weeks',
                                '13':'13 Weeks', '14':'14 Weeks','15':'15 Weeks',
                                '16':'16 Weeks', '17':'17 Weeks','18':'18 Weeks',
                                '19':'19 Weeks', '20':'20 Weeks','21':'21 Weeks',
                                '22':'22 Weeks', '23':'23 Weeks','24':'24 Weeks',
                                '25':'25 Weeks', '26':'26 Weeks','27':'27 Weeks',
                                '28':'28 Weeks', '29':'29 Weeks','30':'30 Weeks',
                                '31':'31 Weeks', '32':'32 Weeks','33':'33 Weeks',
                                '34':'34 Weeks', '35':'35 Weeks','36':'36 Weeks',
                                '37':'37 Weeks', '38':'38 Weeks','39':'39 Weeks',
                                '40':'40 Weeks', '41':'41 Weeks','42':'42 Weeks',
                                '43':'43 Weeks', '44':'44 Weeks','45':'45 Weeks',
                                '46':'46 Weeks', '47':'47 Weeks','48':'48 Weeks',
                                '49':'49 Weeks', '50':'50 Weeks','51':'51 Weeks','52':'52 Weeks'
                            }
                },
                offerCode: {
                    title: 'Package Offer Code',
                    width: '20%'
                },
                desc: {
                    title: 'Package Description',
                    width: '20%'
                },
                timest:{
                    title:'Last Update Date',
                    width:'30%',
                    create:false,
                    edit:false
                },
                version: {
                    list: false,
                    edit:false,
                    create:false
                }
            }
        });

        $('#PackageTableContainer').jtable('load');
    });
</script>
 </body>
</html>