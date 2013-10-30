<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>index JSP</title>
<style type="text/css">
body {
	font: 10pt Arial, Helvetica, sans-serif; /* Шрифт на веб-странице */
	background: #e1dfb9; /* Цвет фона */
}

h2 {
	font-size: 1.1em; /* Размер шрифта */
	color: #800040; /* Цвет текста */
	margin-top: 0; /* Отступ сверху */
}

#container {
	width: 500px; /* Ширина слоя */
	margin: 0 auto; /* Выравнивание по центру */
	background: #f0f0f0; /* Цвет фона левой колонки */
}

#header {
	font-size: 1.5em; /* Размер текста */
	text-align: center; /* Выравнивание по центру */
	padding: 5px; /* Отступы вокруг текста */
	background: #8fa09b; /* Цвет фона шапки */
	color: #ffe; /* Цвет текста */
}

#sidebar {
	margin-top: 0px;
	width: 110px; /* Ширина слоя */
	padding: 0 10px; /* Отступы вокруг текста */
	float: left; /* Обтекание по правому краю */
	background: #CDC9C9;
}

#content {
	margin-left: 130px; /* Отступ слева */
	padding: 10px; /* Поля вокруг текста */
	background: #fff; /* Цвет фона правой колонки */
}

#footer {
	background: #8fa09b; /* Цвет фона подвала */
	color: #fff; /* Цвет текста */
	padding: 5px; /* Отступы вокруг текста */
	clear: left; /* Отменяем действие float */
}
</style>

</head>
<body>
	<div id="container" style="FONT-SIZE: x-small;">
		<div id="header">
			<%@include file="head.jsp"%><br>

		</div>
	</div>

	<div id="sidebar">
		<h4>
			<sec:authorize access="hasRole('ROLE_USER')">
				<spring:url value="/secure/" var="secureUrl" />
				<a href="${secureUrl}" title="Secure">Secure</a>
			</sec:authorize>
			<br>
			<sec:authorize access="hasRole('ROLE_USER')">
				<spring:url value="/secure/TestGetIp4List" var="secureUrl" />
				<a href="${secureUrl}" title="TestGetIp4List">Get IPv4 List</a>
			</sec:authorize>
			<br>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<spring:url value="/admin/" var="adminUrl" />
				<a href="${adminUrl}" title="Admin">Admin</a>
			</sec:authorize>
			<br>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<spring:url value="/admin/TestAddIpv4" var="adminUrl" />
				<a href="#" id="getContentAddIp4">Add IPv4 adress</a>
				<!-- a href="${adminUrl}" title="TestAddIpv4">Add IPv4 adress</a-->
			</sec:authorize>
			<br>

		</h4>
	</div>
	<div id="content">
		<center>
			<h1>Welcome to IP-Info resource</h1>
		</center>
		<div id="divContent"></div>
		<script>
			$(document).ready(function() {
				$('#getContentLogin').click(function() {
					$.ajax({
						url : "signin",
						cache : false,
						beforeSend : function() {
							$('#divContent').html('get login page');
						},
						success : function(html) {
							$("#divContent").html(html);
						}
					});
					return false;
				});
				$('#getContentAddIp4').click(function() {
					$.ajax({
						url : "admin/TestAddIpv4",
						cache : false,
						beforeSend : function() {
							$('#divContent').html('add IP v4');
						},
						success : function(html) {
							$("#divContent").html(html);
						}
					});
					return false;
				});
			});
		</script>

	</div>
	<div id="footer">
		<center>Copyright © 2013 SoftServe, Inc. All rights reserved.
			IT Academy(lv-098JAVA-Team)</center>
	</div>

</body>
</html>