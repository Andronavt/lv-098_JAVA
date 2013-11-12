function validateIpAddress() {
	$('#btnAddIp').click(function() {
		var inputVal = $(this).val();
		var ipRegex = '\b\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}\b';
		if(!ipRegex.test(inputVal)) {
			alert("IP ok");
			/*doAjaxPostAddIpToWhiteList()();*/
		}else {
			alert("Not valid Ip");
		}
	});
	
}