function validateRegForm() {

	$('#loginform').validate();

	$('#btn').click(function() {
		if ($("#loginform").valid()) {
			doAjaxPostRegistration();
		}
	});
}

function AddNewFeed() {
	$('#addNewFeed').validate();

	$('#btnAddNewFeed').click(function() {
		if ($("#addNewFeed").valid()) {
			doAjaxAddNewFeed();
		}
	});
}