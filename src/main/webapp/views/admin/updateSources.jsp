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
	Update Source
	<br>
	<select multiple>
		<c:forEach var="Source" items="${listSource}">
			<option value="${Source.getSourceId()}">${Source.getSourceName()}
				#${Source.getSourceId()}</option>
		</c:forEach>
	</select>
	<br><br>
	<a href="updateSourcesButton"> Update </a>
	<br><br>
	Result: ${Result}
</body>
</html>