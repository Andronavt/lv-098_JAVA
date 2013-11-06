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
</head>
<body>
	<h3 style="color: green" align="center">Registration</h3>

	<table align="center">

		<tr>
			<th>User name:</th>
			<th><input type="text" id="user_name" /></th>
		</tr>

		<tr>
			<th>First name:</th>
			<th><input type="text" id="first_name" /></th>
		</tr>

		<tr>
			<th>Last name:</th>
			<th><input type="text" id="last_name" /></th>
		</tr>

		<tr>
			<th>E-mail:</th>
			<th><input type="text" id="email" /></th>
		</tr>

		<tr>
			<th>Password:</th>
			<th><input type="password" id="pass" /></th>
		</tr>

		<tr>
			<th><input type="button" value="Registration"
				onclick="doAjaxPostRegistration()" /></th>
		</tr>
		<tr>
			<td colspan="2"><div id="info" style="color: green;"></div></td>
		</tr>
	</table>
</body>
</html>