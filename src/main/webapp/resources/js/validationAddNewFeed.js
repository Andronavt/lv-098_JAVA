function validateAddNewFeed() {

	$('#addNewFeed').validate();

	$('#btnAddNewFeed').click(function() {
		if ($("#addNewFeed").valid()) {
			doAjaxAddNewFeed();
		}
	});
}