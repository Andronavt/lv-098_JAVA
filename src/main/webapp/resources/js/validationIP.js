function validateIpAddress() {

	$('#addIpToWL').validate();

	$('#btnAddIp').click(function() {
		if ($("#addIpToWL").valid()) {
			doAjaxPostAddIpToList();
		}
	});
}