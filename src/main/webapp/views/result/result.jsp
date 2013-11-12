<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<p>SUCESS</p>
<p>${addIpV4}</p>
<p>${addIpV6}</p>
<br>
<p>ERROR</p>
<p>${errorMsg}</p>
<c:forEach var="error" items="${errorList}">
	<p>${error}</p>
</c:forEach>