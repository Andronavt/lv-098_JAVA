<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
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