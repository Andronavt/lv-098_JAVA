<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.0.3.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/content.js" />"></script>
<title>Insert title here</title>

<center>
	<h2>Get all Ip from White List</h2>
	<br>
	<div id=showIpListFromWhiteList></div>
</center>
<script type="text/javascript">
	$(document).ready(function() {
		ShowIpListFromWL();
	});
</script>
