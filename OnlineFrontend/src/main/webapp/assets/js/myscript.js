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
								data:"quantity"
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


});
