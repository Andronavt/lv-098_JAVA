<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>
<html>
<head>
<title>Sign In</title>
<<<<<<< HEAD
</head>
<body>
	<h3 style="color: green" align="center">Login</h3>
	<form class="login-form" action="j_spring_security_check" method="post"
		style="text-align: center">
=======

<!-- 	validation -->
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.5.2.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.validate.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/rulesSinginForm.js" />"></script>

<link href="<c:url value="/resources/css/validation.css" />"
	rel="stylesheet" type="text/css" />


</head>
<body>
	<fieldset>
			<legend style="color: green" align="left">
				Login </legend>
	<form id="singinForm" class="login-form" action="j_spring_security_check" method="post"
		style="text-align: left">
>>>>>>> 4fbc0858ea1b4f17d6b64a6e915bb10be72b4566
		<label for="j_username">Username: </label> <input id="j_username"
			name="j_username" size="20" maxlength="50" type="text" /> <br>
			
		<label for="j_password">Password: </label> <input id="j_password"
			name="j_password" size="20" maxlength="50" type="password" /><br>
			
		<input type="submit" value="Login" />
	</form>
<<<<<<< HEAD
	<br>
	<center>
		<a href="registration" id="registration">Registration</a>
	</center>
=======
	</fieldset>
	
	<br>
	<form action="">
		<a href="registration" id="registration">Registration</a>
	</form>
>>>>>>> 4fbc0858ea1b4f17d6b64a6e915bb10be72b4566

</body>

</html>