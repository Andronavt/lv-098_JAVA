function registration() {
	$.ajax({
		url : "user/registration",
		cache : false,
		beforeSend : function() {
			$('#content').html('registration not loaded');
		},
		success : function(html) {
			$("#content").html(html);
		}
	});
	return false;
}

function ShowIpListFromWL() {
	$.ajax({
		type : "POST",
		url : "secure/ShowIpListFromWL",
		success : function(response) {
			// we have the response
			$('#showIpListFromWhiteList').html(response);
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}

function getContentLogin() {
	$.ajax({
		url : "signin",
		cache : false,
		beforeSend : function() {
			$('#content').html('get login page');
		},
		success : function(html) {
			$("#content").html(html);
		}
	});
	return false;

}

function getContentAddIp4() {
	$.ajax({
		url : "admin/AddIpv4",
		cache : false,
		beforeSend : function() {
			$('#content').html('add IP v4');
		},
		success : function(html) {
			$("#content").html(html);
		}
	});
	return false;

}

function getContentDeleteWlIp() {
	$.ajax({
		type : 'GET',
		url : "admin/WL",
		cache : false,
		beforeSend : function() {
			$('#content').html('Delete from WhiteList');
		},
		success : function(html) {
			$("#content").html(html);
		}
	});
	return false;

}

function getContentAddNewFeed() {
	$.ajax({
		url : "admin/AddNewFeed",
		cache : false,
		beforeSend : function() {
			$('#content').html('Add New Feed');
		},
		success : function(html) {
			$("#content").html(html);
		}
	});
	return false;

}

function getContentDeleteFeed() {
	$.ajax({
		url : "admin/listOfSource",
		cache : false,
		beforeSend : function() {
			$('#content').html('Delete source');
		},
		success : function(html) {
			$("#content").html(html);
		}
	});
	return false;
}

function getContentAddIp4List() {
	$.ajax({
		url : "secure/GetIp4List",
		cache : false,
		beforeSend : function() {
			$('#content').html('Get list form');
		},
		success : function(html) {
			$("#content").html(html);
		}
	});
	return false;

}

function getContentDeleteWlIp() {
	$.ajax({
		type : 'GET',
		url : "admin/WL",
		cache : false,
		beforeSend : function() {
			$('#content').html('Delete Ip from WhiteList');
		},
		success : function(html) {
			$("#content").html(html);
		}
	});
	return false;

}

function getContentAddIpToWl() {
	$.ajax({
		type : 'GET',
		url : "admin/AddIpToWL",
		cache : false,
		beforeSend : function() {
			$('#content').html('Add Ip to WhiteList');
		},
		success : function(html) {
			$("#content").html(html);
		}
	});
	return false;

}

function getContentShowIpListFromWl() {
	$.ajax({
		type : 'GET',
		url : "secure/ShowIpListFromWL",
		cache : false,
		beforeSend : function() {
			$('#content').html('Show Ip list from WhiteList');
		},
		success : function(html) {
			$("#content").html(html);
		}
	});
	return false;

}