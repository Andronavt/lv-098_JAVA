<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>User</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is NEVER.</P>

	<!--<c:forEach items="${userList}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.age}</td>
		</tr>
	</c:forEach>
	-->


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
				<td>${ip.date_added}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
