<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.0.3.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/content.js" />"></script>
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>Get all Ip from White List</h2>
		<br>
		<div id=showIpListFromWhiteList></div>
	</center>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		ShowIpListFromWL();
	});
</script>
</html>
