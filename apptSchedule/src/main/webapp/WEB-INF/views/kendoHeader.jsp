<!DOCTYPE html>
<html>
<head>
    <base href="http://demos.telerik.com/kendo-ui/menu/index">
    <style>html { font-size: 12px; font-family: Arial, Helvetica, sans-serif; }</style>
    <title></title>
    <link rel="stylesheet" href="http://cdn.kendostatic.com/2015.1.318/styles/kendo.common-material.min.css" />
    <link rel="stylesheet" href="http://cdn.kendostatic.com/2015.1.318/styles/kendo.material.min.css" />
    <link rel="stylesheet" href="http://cdn.kendostatic.com/2015.1.318/styles/kendo.dataviz.min.css" />
    <link rel="stylesheet" href="http://cdn.kendostatic.com/2015.1.318/styles/kendo.dataviz.material.min.css" />

    <script src="http://cdn.kendostatic.com/2015.1.318/js/jquery.min.js"></script>
    <script src="http://cdn.kendostatic.com/2015.1.318/js/kendo.all.min.js"></script>
</head>
<body>

    <div id="example">
        <div id="megaStore">
            <ul id="menu">
               
                <li>
                    Appointments
                    
                </li>
                <li>
                    Enrollments
                </li>
               <li>
                    Tutor
                    <ul>
                        <li>
                            Setup
                        </li>
                        <li>
                            Schedule
                            
                        </li>
                  
                    </ul>
                </li>
                <li>
                    Packages
                </li>
                <li>
                    Products
                </li>
                <li disabled="disabled">
                    Reports
                </li>
            </ul>
        </div>
        <style>
            #megaStore {
                width: 600px;
                margin: 30px auto;
                padding-top: 120px;
                background: url('../content/web/menu/header.jpg') no-repeat 0 0;
            }
            #menu h2 {
                font-size: 1em;
                text-transform: uppercase;
                padding: 5px 10px;
            }
            #template img {
                margin: 5px 20px 0 0;
                float: left;
            }
            #template {
                width: 380px;
            }
            #template ol {
                float: left;
                margin: 0 0 0 30px;
                padding: 10px 10px 0 10px;
            }
            #template:after {
                content: ".";
                display: block;
                height: 0;
                clear: both;
                visibility: hidden;
            }
            #template .k-button {
                float: left;
                clear: left;
                margin: 5px 0 5px 12px;
            }
        </style>
        <script>
            $(document).ready(function() {
                $("#menu").kendoMenu();
            });
        </script>
    </div>


</body>
</html>
