<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>
<html>
<head>
<title>Sign In</title>
</head>
<body>
	<h3 style="color: green" align="center">Login</h3>
	<form class="login-form" action="j_spring_security_check" method="post"
		style="text-align: center">
		<label for="j_username">Username: </label> <input id="j_username"
			name="j_username" size="20" maxlength="50" type="text" /> <br>
		<label for="j_password">Password: </label> <input id="j_password"
			name="j_password" size="20" maxlength="50" type="password" /><br>
		<input type="submit" value="Login" />
	</form>
	<br>
	<center>
		<a href="registration" id="registration">Registration</a>
	</center>

</body>

</html>