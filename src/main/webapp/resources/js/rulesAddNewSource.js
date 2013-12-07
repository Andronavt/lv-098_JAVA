$(document).ready(function() {

	$("#addNewSource").validate({

		rules : {

			parserIn : {
				required : true,
			},

			sourceNameIn : {
				required : true,
			},

			urlIn : {
				required : true,
				url : true,
			},

			rankIn : {
				required : true,
				range : [ 0.0, 1.0 ]
			},

		},

		messages : {

			parserIn : {
				required : "Please insert parser.",
			},

			sourceNameIn : {
				required : "Please insert name of source.",
			},

			urlIn : {
				required : "Please insert url for upload.",
				url : "Insert correct url",
			},

			rankIn : {
				required : "Please insert rank of source.",
				range : "Insert correct rank 0.0 --> 1.0",
			},

		},

	});
});