<<<<<<< HEAD
=======
<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
>>>>>>> 362cec57dcceece1c58bdc48eb73cc759bfd2045
<html>
<head>
</head>
<body>
	<center>
<<<<<<< HEAD
		<h2>Welcome to HELL</h2>
=======
		<h2>Welcome to HELL! 
		<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.username" />
		</sec:authorize>
		</h2>
		
>>>>>>> 362cec57dcceece1c58bdc48eb73cc759bfd2045
	</center>

</body>
</html>
