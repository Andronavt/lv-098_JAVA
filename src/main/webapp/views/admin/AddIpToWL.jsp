<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
</head>
<body>
	<fieldset>
		<legend style="color: green">Adding IP to WhiteList</legend>
		
		<form class="Add-IP" id="addIpToWL" method="post" name="ipToWL">
			<div align="left">Enter the IP that you want add to WhiteList:</div>

			<input id="IP" type="text" name="addIp" size="20" maxlength="50">

			<br>
		</form>
		
		<input id="btnAddIp" type="button" name="addIp" value="ADD">
	</fieldset>
	
	
	
	<div id="Info" style="color: green;"></div>
	
	<script type="text/javascript">
		$(document).ready(function() {
			validateIpAddress();
		});
	</script>
	
</body>
</html>