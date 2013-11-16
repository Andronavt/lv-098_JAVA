<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>


<c:forEach var="list" items="${ipList}">
	<table border="1">
		<tr>
			<td width="10">${list.id}</td>
			<td width="50">${list.address}</td>
		</tr>
	</table>
</c:forEach>