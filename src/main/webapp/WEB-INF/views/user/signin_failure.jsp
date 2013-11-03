<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>
<%@ page import="org.apache.log4j.Logger" %>
<html>
<head>
<title>Sign In</title>
</head>
<body>
	<% Logger logger=Logger.getLogger("infoLog"); %>
	<%logger.info("create sign_failure page");%>
	<h1>Spring Security - Sign In Failure</h1>
</body>
</html>