$(function() 
{
	

	var $table = $('#productTable');

	if ($table.length) {
		var jsonUrl = '';
		
		if(window.categoryId == '')
			{
				jsonUrl = window.contextRoot + '/json/show/all/products';
				console.log(jsonUrl);
			}
		else
			{
				jsonUrl = window.contextRoot + '/json/show/category/' + window.categoryId + '/products';
				console.log(jsonUrl);
			}
		
		$table.DataTable({
					lengthMenu : [ [ 2,3, 5, 10,-1 ],
									[ '2 Records', '3 Records', '5 Records', '10 Records','ALL' ] ],
									
					pageLength : 5,
					
					ajax :{	
						url : jsonUrl,
						dataSrc : ''
					},
					columns:[
					         {

								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) 
								{

										return '<img src="' + window.contextRoot
												+ '/rs/images/' + data
												+ '.jpg" class="dataTableImg"/>';

									}
					         },
					        {
					        	data:"id"
					        },
							{
								data : "name"
							},
							{
								data:"brand" 
										
							},
							{
								data:"unitPrice",
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							},
							{
								data:"quantity",
								mRender : function(data, type, row) 
								{
									if(data == 0)
										return '<span style="color: red">Out of Stock!</span>';
									else
										return data;
								}
								
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span>View Details</a> &#160;';
									str += '<a href="'
											+ window.contextRoot
											+ '/cart/add/'
											+ data
											+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a>';

									return str;

								}      
							}
							]
				});
	}

	
	//JQUERY VALIDATIONS
	
	
	$categoryForm = $('#categoryForm');

	if ($categoryForm.length) {

		$categoryForm
				.validate({

					rule : {

						name : {
							required : true,
							minlength : 2,
						},

						desc : {
							required : true,
							minlength : 10,
						}
					},

					message : {
						name : {
							required : "You cannot leave the name as empty",
							minlength : "Minimum length of the name should be 2 characters",
						},

						desc : {
							required : "You cannot leave the description as empty",
							minlength : "Minimum length should be 10 characters",
						}
					},

					errorElement : "em",
					errorPlacement : function(error, element) {

						error.addClass('help-block');

						error.insertAfter(element);

					}

				});

	}

});
