<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<center>
	<h2>
		Welcome to HELL!
		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal.username" />
		</sec:authorize>
	</h2>

</center>

