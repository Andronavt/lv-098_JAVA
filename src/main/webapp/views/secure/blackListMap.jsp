<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link rel="stylesheet" href="jquery-jvectormap-1.0.css" type="text/css"
	media="screen" />

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/jVectorMap/jquery-jvectormap-1.2.2.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/jVectorMap/jquery-jvectormap-world-mill-en.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/jVectorMap/countryJsonBlackList.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/jVectorMap/createMap.js" />"></script>

<link
	href="<c:url value="/resources/css/jVectorMap/jquery-jvectormap-1.2.2.css" />"
	rel="stylesheet" type="text/css" />

<!-- Bootstrap -->
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.js" />"></script>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />

<link
	href="<c:url value="/resources/css/secure.css" />"
	rel="stylesheet" type="text/css" />

<fieldset>
<h3 class="text-info"><spring:message code="label.blackListMap"/></h3>
	<div id="world-map"></div>

</fieldset>

<script>
$(document).ready(function() {
	createMap();
});
</script>
