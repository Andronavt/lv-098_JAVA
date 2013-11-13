function validateRegForm() {

	$('#loginform').validate();

	$('#btn').click(function() {
		if ($("#loginform").valid()) {
			doAjaxPostRegistration();
		}
	});
}