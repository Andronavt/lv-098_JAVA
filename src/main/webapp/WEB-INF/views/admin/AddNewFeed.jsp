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

	<form action="newFeed" method="post" name="input_feed">
		<table>
			<tr>
				<th><b>Add new source:</b></th>
			</tr>
			<tr>
				<th>Add source name:</th>
				<th><input name="sourceName" type="text" size="30"
					maxlength="50" value="" /> <br></th>
			</tr>
			<tr>
				<th>Add url:</th>
				<th><input name="url" type="text" size="30" maxlength="50"
					value="" /> <br></th>
			</tr>
			<tr>
				<th>Add type of list:</th>
				<th><input name="typeOfList" type="text" size="30"
					maxlength="50" value="" /> <br></th>
			</tr>
			<tr>
				<th>Add rank of source:</th>
				<th><input name="rankOfSource" type="text" size="30"
					maxlength="50" value="" /> <br></th>
			</tr>
			<tr>
				<th><input type="submit" value="Add new source" /></th>
			</tr>
		</table>
	</form>
</body>
</html>