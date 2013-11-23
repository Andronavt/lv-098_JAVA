<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<script type="text/javascript"
	src="<c:url value="/resources/js/ajax.js" />"></script>

<!-- 	validation -->
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.5.2.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.validate.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/validationIP.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/rulesIpValidate.js" />"></script>

<link href="<c:url value="/resources/css/validation.css" />"
	rel="stylesheet" type="text/css" />


<!-- Bootstrap -->
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.js" />"></script>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />

<link href="<c:url value="/resources/css/admin.css" />" rel="stylesheet"
	type="text/css" />

<fieldset>
	<legend>Adding IP to list</legend>

	<form class="Add-IP" id="addIpToWL" method="post" name="ipToWL">
		<div align="left">Insert the IP that you want add to list:</div>
		<br>
		<div>
			<input class="input-large" id="IP" type="text" name="addIp" size="20"
				maxlength="50"> <b>Type of list:</b> <b><select
				id="list" name="typeList" size="1">
					<option value="blackList">black list</option>
					<option value="whiteList">white list</option>
			</select></b>
		</div>
	</form>

	<input class="btn btn-primary" id="btnAddIp" type="button" name="addIp"
		value="ADD">

	<div id="Info"></div>
</fieldset>



<script type="text/javascript">
	$(document).ready(function() {
		validateIpAddress();
	});
</script>