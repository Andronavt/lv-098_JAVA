<%@ page language="java" contentType="text/html; charset=UTF8"
        pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page import="org.apache.log4j.Logger" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/ajax.js" />"></script>
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>Get all Ipv4 from resource</h2>
		<h4>Please select source</h4>
				<select name="sources" size="1">
					<c:forEach  var="Source" items="${listSource}">
						<option value="${Source.getSourceId()}">${Source.getSourceName()} #${Source.getSourceId()}</option>
					</c:forEach>
				</select>
				<br>
				<br>
				<input type="button" value="Get IP-address List"
					onclick="getIP4List()">
	</center>
	<br>
	<br>
	<div id=divGetIp4List></div>

</body>
</html>