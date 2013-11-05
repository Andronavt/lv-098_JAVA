
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
<%@include file="/WEB-INF/views/styles/ind.css"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<title>Welcome IP-Info</title>

</head>
<body>

	<div id="container" style="FONT-SIZE: x-small;">
		<div id="header">
			<%@include file="head.jsp"%>
			<%@include file="/WEB-INF/views/scripts/indexS.jsp"%>
			<p align="right">
				<sec:authorize access="isAnonymous()">
    Welcome! Guest
   </sec:authorize>
				<sec:authorize access="isAuthenticated()">
   Welcome! <sec:authentication property="principal.username" />
				</sec:authorize>
		</div>
	</div>

	<div id="sidebar">
		<jsp:include page="menu.jsp"></jsp:include>
	</div>
	<div id="content">
		<center>
			<h1>Welcome to IP-info resource</h1>
			<input action="/updateSources" type="button" name="run" value="Run">
		</center>
		<div id="divContent"></div>
	</div>
	<div id="footer">
		<center>Copyright © 2013 SoftServe, Inc. All rights reserved.
			IT Academy(lv-098JAVA-Team)</center>
	</div>

</body>
</html>