<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<link href="<c:url value="/resources/css/ipTable/table.css" />"
	rel="stylesheet" type="text/css" />

<center>
	<div class="table">
		
		<table>
			<tr>
				<td>IP address</td>
				<td>Date added</td>
			</tr>
			<c:forEach var="list" items="${ipList}">
				<tr>
					<td>${list.address}</td>
					<td>${list.dateAdded}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</center>
