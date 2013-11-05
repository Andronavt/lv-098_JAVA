function getIP4List() {
	var source = $('select[name=sources]').val();
	$.ajax({
		type : "POST",
		url : "secure/getList",
		data : "source=" + source,
		success : function(response) {
			// we have the response
			$('#divGetIp4List').html(response);
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}