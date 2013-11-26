var DEFAULT_NUMBER_PAGE = 1;

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
	var source = [ $('select[name=sources]').val() ];
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
}

function doAjaxPaginationWhiteAndBlackList(page) {
	var pageNumber = page;
	var countIpPerPage = $('select[name=countIpPerPage]').val();
	var ipType = $('select[name=ipType]').val();	
	$.ajax({
		type : "POST",
		url : location.href,
		data : "pageNumber=" + pageNumber + "&countIpPerPage=" + countIpPerPage
				+ "&ipType=" + ipType,
		success : function(response) {
			$("#content").html(response);
		},
		error : function(e) {
			alert("Error: "+e);
		}
	});
}

function defaultPaginationWhiteAndBlackList() {
	doAjaxPaginationWhiteAndBlackList(DEFAULT_NUMBER_PAGE);
}

function doAjaxPaginationByCountryAndCity(page) {
	var pageNumber = page;
	var countIpPerPage = $('select[name=countIpPerPage]').val();
	var location = $('input[name=clockpick]').val();
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
	doAjaxPaginationByCountryAndCity(DEFAULT_NUMBER_PAGE);
}