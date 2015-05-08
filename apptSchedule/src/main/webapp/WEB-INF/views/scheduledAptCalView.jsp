<!DOCTYPE html>
<html>
<head>
    <style>html { font-size: 12px; font-family: Arial, Helvetica, sans-serif; }</style>
    <title></title>
    <link rel="stylesheet" href="/apptSchedule/css/kendo.common-material.min.css" type="text/css"/>
    <link rel="stylesheet" href="/apptSchedule/css/kendo.material.min.css" type="text/css"/>
    <link rel="stylesheet" href="/apptSchedule/css/kendo.dataviz.min.css" type="text/css"/>
    <link rel="stylesheet" href="/apptSchedule/css/kendo.dataviz.material.min.css" type="text/css"/>
    <link rel="stylesheet" href="/apptSchedule/css/kendo.default.mobile.min.css" type="text/css"/>

    <script type="text/javascript" src="/apptSchedule/js/jquery.min.js"></script>
    <script type="text/javascript" src="/apptSchedule/js/kendo.all.min.js"></script>
    <script type="text/javascript" src="/apptSchedule/js/kendo.timezones.min.js"></script>
</head>
<body>
<div id="scheduler"></div>
</body>
</html>
<script>
function populateDSObject(startDt, endDt){
  if(startDt == null)  {
    var d1 = new Date();
    var d2 = new Date();
    d2.setDate(d1.getDate() + 7);
    var startDt = d1.getFullYear()+"-"+(d1.getMonth() + 1)+"-"+d1.getDate();
    var endDt = d2.getFullYear()+"-"+(d2.getMonth() + 1)+"-"+d2.getDate();
  }
  var dataSourceCustomize = new kendo.data.SchedulerDataSource({
    transport:{
      read: function(options){
        $.ajax({
        url: '/apptSchedule/appt/view/tslots?status=1&startDt='+$startDt+'&endDt='+$endDt,
                    type: 'GET',
                    dataType: 'json',
                    success: function (data) {
                        options.success(data);
                    },
                    error: function () {
                        //$dfd.reject();
                    }
               });
      }
    },
    schema:{
      type:"json",
      data : function(response){
        for (var i = 0; i < response.Records.length; i++) {
          var $startDt = new Date(response.Records[i].reqDate + " " + response.Records[i].startTime);
          var $endDt = new Date(response.Records[i].reqDate + " " + response.Records[i].endTime);
          response.Records[i].startTime = "\/Date("+$startDt.getTime()+")\/";
          response.Records[i].endTime = "\/Date("+$endDt.getTime()+")\/";
        }
        return response.Records;
      },
      model:{
        id:"clientId",
        fields:{
          clientId:{from:"clientId"},
          start:{from:"startTime", type:"date"},
          end:{from:"endTime", type:"date"},
          title:{from:"fName"}        
        }

      }
    }
  });  
  return dataSourceCustomize;
}

function setStartTime(){
  var d = new Date();
  d.setHours(15);
  d.setMinutes(0);
  return d;
}

function setEndTime(){
  var d = new Date();
  d.setHours(20);
  d.setMinutes(0);
  return d;
}

function refreshView(event){
      /*
      changeView - navigate to different view
      next - navigate to next time period
      previous - navigate to previous time period
      today - select today's date
      changeDate - a date is selected via the Calendar

    */
  var d1 = new Date(event.date);
  var d2 = new Date(event.date);
  d2.setDate(d1.getDate() + 7);
  var startDt = d1.getFullYear()+"-"+(d1.getMonth() + 1)+"-"+d1.getDate();
  var endDt = d2.getFullYear()+"-"+(d2.getMonth() + 1)+"-"+d2.getDate();
  populateDSObject(startDt, endDt).read();
}

$("#scheduler").kendoScheduler({
  startTime:  setStartTime(),
  endTime:   setEndTime(),
  //currentTimeMarker: false,
  timezone: "Etc/UTC",
  height:500,
  views: [           
            {
             type:"week",
             allDaySlot: false
            },
             {
             type:"day",
             allDaySlot: false
            }
           // 
           ],
  dataSource: populateDSObject(),
  navigate: function(e) {
    refreshView(e);
  },
  group:{
    resources:["title"],
    orientation:"vertical"
  },
  resources:[ 
    {
      field:"title",
      name:"title",
      dataSource: [
                        { text: "Booked", value: "BOOKED", color: "#f8a398" },
                        { text: "Cancelled", value: "CANCELLED", color: "#f8a398" }
                  ],
    }
  ],
  footer: false
});

//console.log($("#scheduler"));

</script>