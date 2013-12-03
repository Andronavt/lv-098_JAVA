<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="false"%>

<!-- Bootstrap -->
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
	
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.js" />"></script>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />	



<div>
<span id = "Localization">
    <a href="?lang=en">en</a> 
    | 
    <a href="?lang=ua">ua</a>
</span>
	<sec:authorize access="isAnonymous()">
 	<em><strong> <font size="3" color="#FFFFFF"><spring:message code="label.guest"/></font></strong></em>
   </sec:authorize>
	<sec:authorize access="isAuthenticated()">
   <em><strong> <font size="3" color="#FFFFFF"><spring:message code="label.welcome"/>	<sec:authentication property="principal.username" /> </font></strong></em>
	</sec:authorize>
	</div>
	<div>
	<sec:authorize access="isAnonymous()">
		<a class="btn btn-small btn-primary" href="signin" id="getContentLogin"><spring:message code="label.loginOrRegistration"/></a>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<a class="btn btn-small btn-primary" href="<c:url value="/j_spring_security_logout"/>"><spring:message code="label.logout"/></a>
	</sec:authorize>
</div>
