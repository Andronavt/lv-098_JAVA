<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="admin/addIpv4" method="post" name="drop_down_box">
	IP adress v4: <input name="ip" type="text" size="25" maxlength="30" value="" /> <br> 
	Source number: <input name="source" type="text" size="25" maxlength="30" value="" /> <br> 
	<input type="submit" value="OK" />
	</form>
	<P>Added ip ${added_ip}!</P>
	<P>in Source # ${added_source}!</P>
</body>
</html>