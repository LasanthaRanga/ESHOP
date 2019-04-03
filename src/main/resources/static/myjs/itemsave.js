$(document).ready(function () {


	$('#maincat').empty();
	const Url = 'http://localhost:8080/maincat';

	$.ajax({
		url: Url,
		type: "GET",

		success: function (result) {
			
			$('#maincat').append($('<option>', {
				value: 0,
				text: 'Please select Main Cat' 
			}));			
			$.each(result, function (i, item) {
				$('#maincat').append($('<option>', {
					value: item.idMaincat,
					text: item.maincatName
				}));
			});


		},
		error: function (error) {
			console.log(`Error ${error}`)
		}
	})	


});



























