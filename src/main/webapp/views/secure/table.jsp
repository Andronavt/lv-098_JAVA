<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Bootstrap -->
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.js" />"></script>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />

<link href="<c:url value="/resources/css/ipTable/table.css" />"
	rel="stylesheet" type="text/css" />

<script type="text/javascript"
	src="<c:url value="/resources/js/ajax.js" />"></script>

<c:if test="${!empty incorrectMsg}">
	<p align="left" style="color: red">Warning: ${incorrectMsg}</p>
</c:if>

<c:if test="${empty incorrectMsg}">
	<table class="table">
		<tr>
			<td><spring:message code="label.ipAddress" /></td>
			<td><spring:message code="label.dateAdded" /></td>
		</tr>
		<c:forEach var="list" items="${ipList}">
			<tr>
				<td>${list.address}</td>
				<td>${list.dateAdded}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<script>
	function sendPageCount(){
		return ${pageCount};
	}
</script>


