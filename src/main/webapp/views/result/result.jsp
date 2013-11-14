<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<c:if test="${!empty successMsg}">
	<p align="left">SUCCESS</p>
	<p align="left">${successMsg}</p>
</c:if>
<c:if test="${!empty errorMsg}">
	<p align="left">ERROR</p>
	<p align="left">${errorMsg}</p>
	<c:forEach var="error" items="${errorList}">
		<p>${error}</p>
	</c:forEach>
</c:if>