function validateIpDeleting() {

	$('#ipForRemove').validate();

	$('#btnDeleteIp').click(function() {
		if ($("#ipForRemove").valid()) {
			doAjaxPostDeleteIpFromList();
		}
	});
}