
$(function(){
	var $products = $('#products');
	var $prodName = $('#prodName');
	var $unitPrice = $('#unitPrice');

	$.ajax({		
		url:'/apptSchedule/centre/admin/products/1.json',
		dataType:'json',
		type:'get',
		success:function(products){
			$(products.list).each(function(index, value){
				$products.append('<li>Product Name: '+ value.prodName +', Unit Price: $'+value.unitPrice+', Last Update Date: '+value.timest+'</li>');
				console.log(value.prodName);
			});
		},
		error:function(){
			alert('Error loading Products');
		}
	});	
	$('#add-Product').on('click', function(){
		var product = {
			
			"prodName":$prodName.val(),
			"unitPrice":$unitPrice.val(),
			"corpId":"1"
		};
		$.ajax({
				type:'POST',
				url:'/apptSchedule/centre/admin/addProd.json',
				contentType:'application/json;charset=UTF-8',
				dataType:'json',
				data:JSON.stringify(product),
				success: function(newProduct){
					$products.append('<li>prodName:'+ newProduct.prodName +', unitPrice:'+newProduct.unitPrice+'</li>');
				},
				error:function(){
					alert('Error saving product');
				}
		});
	});
});