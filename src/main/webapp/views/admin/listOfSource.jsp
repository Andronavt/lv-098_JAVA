<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<script type="text/javascript" src="<c:url value="/resources/js/ajax.js" />"></script>

<title>Insert title here</title>
</head>
<body>

	<fieldset>
	<legend style="color: green" align="center">List of sources</legend>
	<br>
	
		<div id="1">
			<center>
				<select name="sources" size="1">
					<c:forEach var="Source" items="${listSource}">
						<option value="${Source.getSourceName()}">${Source.getSourceName()}</option>
					</c:forEach>
				</select> <br> <br> <input type="button" value="Delete source"
					onclick="selectSource()">
			</center>
			<br> <br>
		</div>
		
	</fieldset>
	
	<div id="Info" style="color: green;"></div>
	
</body>
</html>