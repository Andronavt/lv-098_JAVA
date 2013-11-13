<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<script type="text/javascript"
	src="<c:url value="/resources/js/ajax.js" />"></script>
<title>Add IPv4 to Source</title>
</head>
<body>
	<center>
		<h2>Add IP-address ver.4 to Source</h2>
		<table>
			<tr>
				<td>Enter IP-address ver.4 :</td>
				<td><input type="text" id="ip"><br /></td>
			</tr>
			<tr>
				<td>Select Source :</td>
				<td><select name="sources" size="1">
						<c:forEach var="Source" items="${listSource}">
							<option value="${Source.getSourceId()}">${Source.getSourceName()}
								#${Source.getSourceId()}</option>
						</c:forEach>
				</select></td>
			<tr>
				<td colspan="2" align="center"\><input type="button"
					value="Add IP-address" onclick="doAjaxPostAddIpV4()"><br /></td>
			</tr>
			<tr>
				<td colspan="2"><div id="info" style="color: green;"></div></td>
			</tr>
		</table>
	</center>
</body>
</html>

