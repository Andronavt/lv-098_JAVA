
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/content.js" />"></script>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">

<link href="<c:url value="/resources/css/menu.css" />" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div id="accordion" align="left">

		<h6 style="width: 150px;">Home</h6>
		<div style="width: 125px;">
			<a class="button" href="welcomes" title="Home">Home</a>
		</div>
		<sec:authorize access="hasRole('ROLE_USER')">

			<h6 style="width: 150px;">Statistics:</h6>
			<div style="width: 125px;">
				<a class="button" href="inProgres" title="Charts">Charts</a> 
				<a class="button" href="showIpListFromWL" id="getContentShowIpListFromWl" title="Show Ip list from WList">Show Ip list from WList</a>
				<a class="button" href="inProgres" 	title="Blacklist map">Blacklist map</a>
				<a class="button" href="inProgres" title="Whitelist map">Whitelist map</a>
				<a class="button" href="inProgres" title="Top oldest IP">Top oldest IP</a>
			</div>
			<h6 style="width: 150px;">Ip data:</h6>
			<div style="width: 125px;">
				<a class="button" href="inProgres" title="Black IP by city">Black IP by city</a>
				<a class="button" href="inProgres" title="Black IP by country">Black IP by country</a>
				<a class="button" href="getIp4List" id="getIp4List" title="List of IPv4 from source">List of IPv4 from source</a>
			</div>
		</sec:authorize>

		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<h6 style="width: 150px;">Feeds:</h6>
			<div style="width: 125px;">
				<a class="button" href="listOfSource" id="getContentDeleteFeed" title="Delete Feed">Delete Feed</a>
				<a class="button" href="addNewFeed" id="getContentAddNewFeed" title="Add new Feed">Add new Feed</a>
				<a class="button" href="addIpv4" id="getContentAddIp4" title="Add IP to Source">Add IP to Source</a>
				<a class="button" href="addIpToWL" id="getContentAddIpToWl" title="Add to WList">Add to WList</a>
				<a class="button" href="deleteIpFromWL" id="getContentDeleteWlIp" title="Delete IP from WList">Delete IP from WList</a>
				<a class="button" href="updateSources" title="updateSources">Update Sources</a>
				<a class="button" href="inProgres" title="List downloads">List downloads</a>
			</div>
<!-- 			<a class="button" href="inProgres" title="Daemon controls">Daemon -->
<!-- 				controls</a> -->
<!-- 			<a class="button" href="inProgres" title="Admin">Admin</a> -->
		</sec:authorize>
	</div>

	<script>
		$("#accordion").accordion({
			collapsible : true
		});
	</script>