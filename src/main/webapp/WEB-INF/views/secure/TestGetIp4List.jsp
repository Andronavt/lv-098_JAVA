<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<title>Insert title here</title>
</head>
<body>
	<h2>Get all Ipv4 from resource</h2>
	<form action="secure/getList" method="post" name="drop_down_box">
		<select name="sour" size="1">
			<option value="1">Source #1</option>
			<option value="2">Source #2</option>
			<option value="3">Source #3</option>
			<option value="4">Source #4</option>
			<option selected="selected" value="5">Source #5</option>
		</select> <input type="submit" value="Get IP list" />
	</form>
	<table class="data">
		<tr>
			<th>id</th>
			<th>address</th>
			<th>date</th>
		</tr>
		<c:forEach items="${ipList}" var="ip">
			<tr>
				<td>${ip.id}</td>
				<td>${ip.address}</td>
				<td>${ip.dateAdded}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>