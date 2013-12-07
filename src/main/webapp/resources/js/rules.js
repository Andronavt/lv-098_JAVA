$(document).ready(function() {

	$("#loginform").validate({

		rules : {

			userName : {
				required : true,
				minlength : 4,
				maxlength : 16,
			},

			firstName : {
				required : true,
				minlength : 2,
				maxlength : 25,
			},

			lastName : {
				required : true,
				minlength : 2,
				maxlength : 25,
			},

			email : {
				required : true,
				email : true,
			},

			password : {
				required : true,
				minlength : 6,
			}
		},

		messages : {

			userName : {
				required : "Please insert username.",
				minlength : "Minimum login lenght can be - 4 characters",
				maxlength : "Maximum login lenght can be - 16 characters",
			},

			firstName : {
				required : "Please insert first name.",
				minlength : "Minimum name length can be 2 characters",
				maxlength : "Maximum name lenght can be 25 characters",
			},

			lastName : {
				required : "Please insert last name.",
				minlength : "Minimum last name length can be 2 characters",
				maxlength : "Maximum last name lenght can be 25 characters",
			},

			email : {
				required : "Please insert e-mail.",
				email : "Please insert correct form of e-mail",
			},

			password : {
				required : "Please insert password",
				minlength : "Minimum length of password must be 6 characters",
			},
		},

	});
});