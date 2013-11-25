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

function doAjaxAddNewSource() {
	// get the form values
	var parser = $('#parser').val();
	var sourceName = $('#sourceName').val();
	var url = $('#url').val();
	var listType = $('select[name=typeList]').val();
	var rank = $('#rank').val();
	$.ajax({
		type : "POST",
		url : "admin_addNewSource",
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

function doAjaxPostAddIpToList() {
	// get the form values
	var ipAddress = $('#IP').val();
	var listType = $('select[name=typeList]').val();
	$.ajax({
		type : "POST",
		url : "admin_addIpToList",
		data : "address=" + ipAddress + "&listType=" + listType,
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
		url : "admin_deleteSource",
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

function doAjaxPostDeleteIpFromList() {
	// get the form values
	var ipAddress = $('#ipForRemove').val();
	$.ajax({
		type : "POST",
		url : "admin_deleteIpFromList",
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
	var arrSource = $('select[name=arrSource]').val();
	$.ajax({
		type : "POST",
		url : "admin_updateSourcesButton",
		data : "source=" + arrSource,
		beforeSend: function() {
			$('#upSource').html("Please wait. Source updating");
		  },
		success : function(response) {
			alert('succes' + arrSource);
			$('#upSource').html(response);
		},
		error : function(e) {
			alert('eroor' + arrSource);
			alert('Error: ' + parser);
		}
	});
	
/*	var source = $('select[name=sources]').val();
	$
			.ajax({
				type : "POST",
				url : "admin_updateSourcesButton",
				data : "source=" + source,
				beforeSend : function() {
					$('#upSource')
							.html(
									"<img src='resources/images/ajax-loader.gif'><br>Please wait. Source updating");
				},
				success : function(response) {
					$('#upSource').html(response);
				},
				error : function(e) {
					alert('Error: ' + parser);
				}
			});
}*/

function doAjaxPaginationWhiteAndBlackList(page) {
	$.ajax({
		type : "POST",
		url : location.href,
		data : "pageNumber=" + page + "&countIpPerPage="
				+ $('select[name=count]').val() + "&ipType="
				+ $('select[name=ipType]').val(),
		success : function(response) {
			$("#content").html(response);
		},
		error : function(e) {
			alert(e + pageNumber + countIpPerPage + ipType);
		}
	});
}
function defaultPaginationWhiteAndBlackList() {
	doAjaxPaginationWhiteAndBlackList(1);
}

function doAjaxPaginationByCountryAndCity(page) {
	var pageNumber = page;
	var countIpPerPage = $('select[name=countIpPerPage]').val();
	var location = $('select[name=location]').val();
	var ipType = $('select[name=ipType]').val();
	var typeList = $('select[name=typeList]').val();
	$.ajax({
		type : "POST",
		url : location.href,
		data : "pageNumber=" + pageNumber + "&countIpPerPage=" + countIpPerPage
				+ "&location=" + location + "&ipType=" + ipType + "&status="
				+ typeList,
		success : function(response) {
			$("#content").html(response);
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}
function defaltPaginationByCountryAndCity() {
	doAjaxPaginationByCountryAndCity(1);
}