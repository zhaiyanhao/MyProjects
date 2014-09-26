$(document).ready(function() {
	$( "#category_name" ).autocomplete({	
		serviceUrl: '/Mojoping2/getCategories',
		paramName: "category_name",
		delimiter: ",",		
		transformResult: function(response) {			 
			return {      	
			  //must convert json to javascript object before process
			  suggestions: $.map($.parseJSON(response), function(item) {
				   return { value: item.category_name, data: item.category_id };
			   })	 
			};	 
		}		
	});	 
});
