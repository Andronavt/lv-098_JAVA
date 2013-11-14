<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<c:if test="${!empty successMsg}">
	<p align="left" style="color: green;">SUCCESS: ${successMsg}</p>
</c:if>
<c:if test="${!empty incorrectMsg}">
	<p align="left" style="color: red">Warning: ${incorrectMsg}</p>
</c:if>
<c:if test="${!empty errorMsg}">
	<p align="left" style="color: red;">ERROR: ${errorMsg}</p>
		<c:forEach var="error" items="${errorList}">
			<p>${error}</p>
		</c:forEach>
</c:if>
