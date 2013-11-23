<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<link rel="stylesheet" href="jquery-jvectormap-1.0.css" type="text/css"
	media="screen" />

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/jVectorMap/jquery-jvectormap-1.2.2.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/jVectorMap/jquery-jvectormap-world-mill-en.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/jVectorMap/countryJsonBlackList.js" />"></script>

<link
	href="<c:url value="/resources/css/jVectorMap/jquery-jvectormap-1.2.2.css" />"
	rel="stylesheet" type="text/css" />

<link
	href="<c:url value="/resources/css/secure.css" />"
	rel="stylesheet" type="text/css" />

<fieldset>

	<div id="world-map"></div>

</fieldset>


<script>
	$('#world-map').vectorMap({
		map : 'world_mill_en',
		series : {
			regions : [ {
				values : array,
				scale : [ '#C8EEFF', '#0071A4' ],
				normalizeFunction : 'polynomial'
			} ]
		},
		onRegionLabelShow : function(e, el, code) {
			el.html(el.html() + ' - ' + array[code]);
		}
	});
</script>
