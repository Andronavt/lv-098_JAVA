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
	<center>
		<h2>List of IP-adresses</h2>
		<table class="data" border="1">
			<col width="100px">
			<col width="100px">
			<col width="150px">
			<tr>
				<th>id</th>
				<th>address</th>
				<th>date</th>
			</tr>
			<c:forEach items="${ipList}" var="ip">
				<tr>
					<td align="center">${ip.id}</td>
					<td align="center">${ip.address}</td>
					<td align="center">${ip.dateAdded}</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>