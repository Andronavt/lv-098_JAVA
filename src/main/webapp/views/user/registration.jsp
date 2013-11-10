<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
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
	src="<c:url value="/resources/js/rules.js" />"></script>

<link href="<c:url value="/resources/css/validation.css" />"
	rel="stylesheet" type="text/css" />

</head>
<body>
	<form method="post" id="loginform" action="" name="login-form">
		<fieldset>
			<legend style="color: green" align="center">
				Registration
			</legend>
			<div align="left">
				User name: <input type="text" id="user_name" name="userName" />
				<br>
				First name: <input type="text" id="first_name" name="firstName" />
				<br>
				Last name: <input type="text" id="last_name" name="lastName" />
				<br>
				E-mail: <input type="text" id="e-mail" name="email" />
				<br>
				Password: <input type="password" id="pass" name="password" />
				<br>
				<div id="info" style="color: green;"></div>
			</div>
		</fieldset>
		<input id="btn" type="button" name="registration" value="Registration" />
	</form>
<script type="text/javascript">
$(document).ready(function() { validateRegForm();});
</script>


</body>
</html>