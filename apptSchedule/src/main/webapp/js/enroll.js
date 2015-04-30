$( "#enroll" ).button();
$( "#dob" ).datepicker({
	changeMonth: true,
	changeYear:true,
	dateFormat:'yy-mm-dd'
});
$().ready(function() {
	$("#enrollForm").validate(
	{
		submitHandler: function(){
		var $primEmail = $('#primEmail');
		var $primCntNo = $('#primCntNo');
		var $fName = $('#fName');
		var $lName = $('#lName');
		var $emailId = $('#emailId');
		var $phoneNo = $('#phoneNo');
		var $dob = $('#dob');
		//$('#enroll').on('click', function(){	
			var group = {			
				"primEmail":$primEmail.val(),
				"primCntNo":$primCntNo.val(),
				"corpId":"1",
				"list":[{
							"fName":$fName.val(),
							"lName":$lName.val(),
							"emailId":$emailId.val(),
							"phoneNo":$phoneNo.val(),
							"dob":$dob.val(),
							"corpId":"1"
					   }]
			};
			$.ajax({
					type:'POST',
					url:'/apptSchedule/centre/admin/addClient',
					contentType:'application/json;charset=UTF-8',
					dataType:'json',
					data:JSON.stringify(group),
					success: function(response){
						console.log(response.refId);
						// var $refId = response.refId;
						// console.log($refId.val());

					     var form = $('<form action="/apptSchedule/enrollProduct">' +
					  	 '<input type="hidden" name="refId" value="'+response.refId+'"></input>' + '</form>');
					  	 $('body').append(form);
					  	 form.submit();
							
					},
					error:function(){
						//alert('Error saving product');
					}
			});
		//});
		}
	});
});