<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>Secure</title>
</head>
<body>
	<h1>Secure page</h1>
	
	<p>${user.username}</p>
	
	<table>
		<c:forEach var="a" items="${user.authorities}">
			<tr>
				<td>${a.authority}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
