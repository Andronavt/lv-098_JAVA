<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<title>Insert title here</title>
<script type="text/javascript"
	src="<c:url value="/resources/js/ajax.js" />"></script>

<!-- 	validation -->
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.5.2.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.validate.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/validationIpDeleting.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/rulesIpDeleting.js" />"></script>

<link href="<c:url value="/resources/css/validation.css" />"
	rel="stylesheet" type="text/css" />
	
<!-- Bootstrap -->
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.js" />"></script>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />	
	
<fieldset>

	<legend style="color: green">Delete IP from list</legend>

	<form class="Delete-IP" id="deleteIp" method="post" name="deleteFromWL">

		<div>Insert ip for deleting:</div>
		<br>
		<input class="input-large" id="ipForRemove" type="text" name="deleteIpIn" size="20"
			maxlength="50">
		
	</form>
	<input class="btn btn-primary" id="btnDeleteIp" type="button" name="deleteIp" value="DELETE">
</fieldset>
<br>

<div id="Info" style="color: green;"></div>

<script type="text/javascript">
	$(document).ready(function() {
		validateIpDeleting();
	});
</script>