<!DOCTYPE html>
<html>
<head>
    <base href="http://demos.telerik.com/kendo-ui/scheduler/timeline">
    <style>html { font-size: 12px; font-family: Arial, Helvetica, sans-serif; }</style>
    <title></title>
    <link rel="stylesheet" href="http://cdn.kendostatic.com/2014.3.1411/styles/kendo.common.min.css" />
    <link rel="stylesheet" href="http://cdn.kendostatic.com/2014.3.1411/styles/kendo.default.min.css" />
    <link rel="stylesheet" href="http://cdn.kendostatic.com/2014.3.1411/styles/kendo.dataviz.min.css" />
    <link rel="stylesheet" href="http://cdn.kendostatic.com/2014.3.1411/styles/kendo.dataviz.default.min.css" />
    
    <script src="http://cdn.kendostatic.com/2014.3.1411/js/jquery.min.js"></script>
    <script src="http://cdn.kendostatic.com/2014.3.1411/js/kendo.all.min.js"></script>
    <script src="http://cdn.kendostatic.com/2014.3.1411/js/kendo.timezones.min.js"></script>
</head>
<body>
<div id="example" class="k-content">
    <div id="scheduler"></div>
</div>
<script>
    $(function () {
        $("#scheduler").kendoScheduler({
            date: new Date("2013/6/13"),
            startTime: new Date("2013/6/13 07:00 AM"),
            eventHeight: 50,
            majorTick: 60,
            views: [
                "timeline",
                "timelineWeek",
                "timelineWorkWeek",
                {
                    type: "timelineMonth",
                    startTime: new Date("2013/6/13 00:00 AM"),
                    majorTick: 1440
                }
            ],
            timezone: "Etc/UTC",
            dataSource: {
                batch: true,
                transport: {
                    read: {
                        url: "http://demos.telerik.com/kendo-ui/service/meetings",
                        dataType: "jsonp"
                    },
                    update: {
                        url: "http://demos.telerik.com/kendo-ui/service/meetings/update",
                        dataType: "jsonp"
                    },
                    parameterMap: function (options, operation) {
                        if (operation !== "read" && options.models) {
                            return { models: kendo.stringify(options.models) };
                        }
                    }
                },
                schema: {
                    model: {
                        id: "meetingID",
                        fields: {
                            meetingID: { from: "MeetingID", type: "number" },
                            title: { from: "Title", defaultValue: "No title", validation: { required: true } },
                            start: { type: "date", from: "Start" },
                            end: { type: "date", from: "End" },
                            startTimezone: { from: "StartTimezone" },
                            endTimezone: { from: "EndTimezone" },
                            description: { from: "Description" },
                            recurrenceId: { from: "RecurrenceID" },
                            recurrenceRule: { from: "RecurrenceRule" },
                            recurrenceException: { from: "RecurrenceException" },
                            attendees: { from: "Attendees", nullable: true },
                            isAllDay: { type: "boolean", from: "IsAllDay" }
                        }
                    }
                }
            },
            group: {
                resources: ["Attendees"],
                orientation: "vertical"
            },
            resources: [

                {
                    field: "attendees",
                    name: "Attendees",
                    dataSource: [
                        { text: "Alex", value: 1, color: "#f8a398" },
                        { text: "Bob", value: 2, color: "#51a0ed" },
                        { text: "Charlie", value: 3, color: "#56ca85" }
                    ],
                    multiple: true,
                    title: "Attendees"
                }
            ]
        });
    });
</script>

</body>
</html>
