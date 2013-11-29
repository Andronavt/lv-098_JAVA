<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<title><spring:message code="label.login"/></title>

<!-- 	validation -->
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.5.2.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.validate.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/rulesSinginForm.js" />"></script>

<link href="<c:url value="/resources/css/validation.css" />"
	rel="stylesheet" type="text/css" />
	
<!-- Bootstrap -->
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.js" />"></script>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />	

<fieldset>
	<legend style="color: green" align="left"><strong><spring:message code="label.login"/></strong> </legend>
	<form id="singinForm" class="login-form"
		action="j_spring_security_check" method="post"
		style="text-align: left">
		<label class="control-label" for="j_username"><spring:message code="label.userName"/></label> <input id="j_username"
			name="j_username" size="20" maxlength="50" type="text" /> <br>

		<label for="j_password"><spring:message code="label.password"/></label> <input id="j_password"
			name="j_password" size="20" maxlength="50" type="password" /><br>

		<input  class="btn btn-primary" type="submit" value="<spring:message code="label.enter"/>" />
	</form>
</fieldset>
<form action="">
	<a class="btn btn-link" href="registration" id="registration"><spring:message code="label.registration"/></a>
</form>