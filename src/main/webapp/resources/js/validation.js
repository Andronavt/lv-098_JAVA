function validateRegForm() {

	$('#loginform').validate();

	$('#registration').click(function() {
		if ($("#loginform").valid()) {
			doAjaxPostRegistration();
		}
	});
}