
function doAjaxPostRegistration() {
	// get the form values
	var user_name = $('#user_name').val();
	var first_name = $('#first_name').val();
	var last_name = $('#last_name').val();
	var email = $('#e-mail').val();
	var pass = $('#pass').val();
	$.ajax({
		type : "POST",
		url : "registration",
		data : "user_name=" + user_name + "&first_name=" + first_name
				+ "&last_name=" + last_name + "&e-mail=" + email + "&pass="
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

function doAjaxAddNewFeed() {
	// get the form values
	var parser = $('#parser').val();
	var sourceName = $('#sourceName').val();
	var url = $('#url').val();
	var listType = $('select[name=typeList]').val();
	var rank = $('#rank').val();
	$.ajax({
		type : "POST",
		url : "addNewFeed",
		data : "parser=" + parser + "&sourceName=" + sourceName + "&url=" + url
				+ "&listType=" + listType + "&rank=" + rank,
		success : function(response) {
			// we have the response
			$('#Info').html(response);
		},
		error : function(e) {
			alert('Error: ' + parser + sourceName + url + listType + rank, e);
		}
	});
}

function doAjaxPostAddIpToWhiteList() {
	// get the form values
	var ipAddress = $('#IP').val();
	$.ajax({
		type : "POST",
		url : "addIpToWL",
		data : "address=" + ipAddress,
		success : function(response) {
			$('#Info').html(response);
		},
		error : function(e) {
			alert('address' + ipAddress);
			alert('Error: ' + e);
		}
	});
}


function selectSource() {
	var source = $('select[name=sources]').val();
	$.ajax({
		type : "POST",
		url : "deleteSource",
		data : "source=" + source,
		success : function(response) {
			// we have the response
			$('#Info').html(response);
		},
		error : function(e) {
			alert('Error: ' + source, e);
		}
	});
}

function doAjaxPostDeleteIp() {
	// get the form values
	var ipAddress = $('#ipForRemove').val();
	$.ajax({
		type : "POST",
		url : "deleteIpFromWL",
		data : "address=" + ipAddress,
		success : function(response) {
			$('#Info').html(response);
		},
		error : function(e) {
			alert('Error: ' + ipAddress, e);
		}
	});
	return false;
}


function doAjaxUpdateSource() {
	var source = $('select[name=sources]').val();
	$.ajax({
		type : "POST",
		url : "updateSourcesButton",
		data : "source=" + source,
		beforeSend: function() {
//		    $('#upSource').html("<img src='/resources/images/ajax-loader.gif' />");
			$('#upSource').html("Please wait. Source updating");
		  },
		success : function(response) {
			$('#upSource').html(response);
		},
		error : function(e) {
			alert('Error: ' + parser);
		}
	});
}