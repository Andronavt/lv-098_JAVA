$(document).ready(function() {

	$("#singinForm").validate({

		rules : {

			j_username : {
				required : true,
				minlength : 4,
				maxlength : 16,
			},

			j_password : {
				required : true,
			},
		},
		messages : {

			j_username : {
				required : "Please insert login.",
				minlength : "Minimum login lenght can be - 4 characters",
				maxlength : "Maximum login lenght can be - 16 characters",
			},

			j_password : {
				required : "Please insert password.",
			},
		},

	});
});