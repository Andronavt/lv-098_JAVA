<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Spring Security - Hello world!</h1>

	<spring:url value="/secure/" var="secureUrl" />
	<a href="${secureUrl}" title="Secure">Secure</a><br />
	
	<spring:url value="/admin/" var="adminUrl" />
	<a href="${adminUrl}" title="Admin">Admin</a>
</body>
</html>
