function doAjaxPostRegistration() {
	// get the form values
	var user_name = $('#user_name').val();
	var first_name = $('#first_name').val();
	var last_name = $('#last_name').val();
	var email = $('#email').val();
	var pass = $('#pass').val();
	$.ajax({
		type : "POST",
		url : "registration",
		data : "user_name=" + user_name + "&first_name=" + first_name
				+ "&last_name=" + last_name + "&email=" + email + "&pass="
				+ pass,
		success : function(response) {
			// we have the response
			$('#info').html(response);
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}

function doAjaxPostAddIpToWhiteList() {
	// get the form values
	var ipAddress = $('#IP').val();
	$.ajax({
		type : "POST",
		url : "admin/AddIpToWL",
		data : "address=" + ipAddress,
		success : function(response) {
			$('#Info').html(response);
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
	return false;
}

function doAjaxPostAddIpV4() {
	// get the form values
	var ip = $('#ip').val();
	var source = $('select[name=sources]').val();
	$.ajax({
		type : "POST",
		url : "admin/AddIpv4",
		data : "ip=" + ip + "&source=" + source,
		success : function(response) {
			// we have the response
			$('#info').html(response);

		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}

function selectSource() {
	var source = $('select[name=sources]').val();
	$.ajax({
		type : "POST",
		url : "admin/listOfSurce",
		data : "source=" + source,
		success : function(response) {
			// we have the response
			$('#1').html(response);
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}

function doAjaxPostDeleteIp() {
	// get the form values
	var ipAddress = $('#IpRemoveStr').val();
	$.ajax({
		type : "POST",
		url : "admin/WL",
		data : "address=" + ipAddress,
		success : function(response) {
			$('#Info').html(response);
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
	return false;
}

function getIP4List() {
	var source = $('select[name=sources]').val();
	$.ajax({
		type : "POST",
		url : "listIpv4",
		data : "source=" + source,
		success : function(response) {
			// we have the response
			$('#divGetIp4List').html(response);
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
function doAjaxPostRegistration() {
	// get the form values
	var user_name = $('#user_name').val();
	var first_name = $('#first_name').val();
	var last_name = $('#last_name').val();
	var email = $('#email').val();
	var pass = $('#pass').val();
	$.ajax({
		type : "POST",
		url : "registration",
		data : "user_name=" + user_name + "&first_name=" + first_name
				+ "&last_name=" + last_name + "&email=" + email + "&pass="
				+ pass,
		success : function(response) {
			// we have the response
			$('#info').html(response);
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}

function doAjaxPostAddIpToWhiteList() {
	// get the form values
	var ipAddress = $('#IP').val();
	$.ajax({
		type : "POST",
		url : "admin/AddIpToWL",
		data : "address=" + ipAddress,
		success : function(response) {
			$('#Info').html(response);
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
	return false;
}

function doAjaxPostAddIpV4() {
	// get the form values
	var ip = $('#ip').val();
	var source = $('select[name=sources]').val();
	$.ajax({
		type : "POST",
		url : "admin/AddIpv4",
		data : "ip=" + ip + "&source=" + source,
		success : function(response) {
			// we have the response
			$('#info').html(response);

		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}

function selectSource() {
	var source = $('select[name=sources]').val();
	$.ajax({
		type : "POST",
		url : "admin/listOfSurce",
		data : "source=" + source,
		success : function(response) {
			// we have the response
			$('#1').html(response);
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}

function doAjaxPostDeleteIp() {
	// get the form values
	var ipAddress = $('#IpRemoveStr').val();
	$.ajax({
		type : "POST",
		url : "admin/WL",
		data : "address=" + ipAddress,
		success : function(response) {
			$('#Info').html(response);
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
	return false;
}

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