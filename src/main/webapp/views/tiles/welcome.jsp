<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
</head>
<body>
	<center>
<<<<<<< HEAD
		<h2>
			Welcome to HELL!
			<sec:authorize access="isAuthenticated()">
				<sec:authentication property="principal.username" />
			</sec:authorize>
		</h2>
=======
		<h2>Welcome to HELL! 
		<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.username" />
		</sec:authorize>
		</h2>
		
>>>>>>> 4fbc0858ea1b4f17d6b64a6e915bb10be72b4566
	</center>

</body>
</html>
