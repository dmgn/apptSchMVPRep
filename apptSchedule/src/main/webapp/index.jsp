<!DOCTYPE html>
<html>
<head>
    <style>html { font-size: 12px; font-family: Arial, Helvetica, sans-serif; }</style>
    <title></title>
    <link rel="stylesheet" href="css/kendo.common-material.min.css" />
    <link rel="stylesheet" href="css/kendo.material.min.css" />
    <link rel="stylesheet" href="css/kendo.dataviz.min.css" />
    <link rel="stylesheet" href="css/kendo.dataviz.material.min.css" />
    <link rel="stylesheet" href="css/kendo.default.mobile.min.css" />

    <script src="js/jquery.min.js"></script>
    <script src="js/kendo.all.min.js"></script>
    <script src="js/kendo.timezones.min.js"></script>
</head>
<body>
<div id="scheduler"></div>
</body>
</html>
<script>
var dataSourceCustomize = new kendo.data.SchedulerDataSource({
  	transport:{
  		read: function(options){
  			$.ajax({
                    url: '/apptSchedule/appt/status?emailId=gn@gmail.com',
                    type: 'GET',
                    dataType: 'json',
                    success: function (data) {
                        //$dfd.resolve(data);
                       // console.log(data);
                        options.success(data);
                       // console.log(options);
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
  			id:"corpId",
  			fields:{
  				corpId:{from:"corpId"},
  				start:{from:"startTime", type:"date"},
  				end:{from:"endTime", type:"date"},
				title:{from:"status"} 				
  			}

  		}
  	}

  });

dataSourceCustomize.fetch(function() {
    var event = dataSourceCustomize.at(0);
});

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

$("#scheduler").kendoScheduler({
	startTime: 	setStartTime(),
	endTime:   setEndTime(),
	timezone: "Etc/UTC",
	views: [           
            "week"
           ],
  dataSource: dataSourceCustomize
});

console.log($("#scheduler"));

</script>