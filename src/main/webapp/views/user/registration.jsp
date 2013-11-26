<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>

<script type="text/javascript"
	src="<c:url value="/resources/js/ajax.js" />"></script>

<!-- 	validation -->
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.5.2.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.validate.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/validation.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/rulesRegForm.js" />"></script>

<link href="<c:url value="/resources/css/validation.css" />"
	rel="stylesheet" type="text/css" />

<!-- Bootstrap -->
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
	
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.js" />"></script>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />	

<form method="post" id="loginform" action="" name="login-form">
	<fieldset>
		<legend style="color: green" align="left"><strong>Registration</strong></legend>

		<div align="left">
			<div align="left">User name:</div>
			<input class="input-large" type="text" id="user_name" name="userName" />
			<div align="left">First name:</div>
			<input class="input-large" type="text" id="first_name" name="firstName" />
			<div align="left">Last name:</div>
			<input class="input-large" type="text" id="last_name" name="lastName" />
			<div align="left">E-mail:</div>
			<input class="input-large" type="text" id="e-mail" name="email" />
			<div align="left">Password:</div>
			<input class="input-large" type="password" id="pass" name="password" />
			<div id="info" style="color: green;"></div>
		</div>

	</fieldset>
	<input class="btn btn-primary" type="button" id="registration" value="Registration" />
</form>

<script type="text/javascript">
	$(document).ready(function() {
		validateRegForm();
	});
</script>