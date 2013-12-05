function validateAddNewSource() {

	$('#addNewSource').validate();

	$('#btnAddNewSource').click(function() {
		if ($("#addNewSource").valid()) {
			doAjaxAddNewSource();
		}
	});
}