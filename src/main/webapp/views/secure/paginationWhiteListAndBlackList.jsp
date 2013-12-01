<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.bootpag.js" />"></script>

<!-- Bootstrap -->
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.js" />"></script>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
		src="<c:url value="/resources/js/ajax.js" />"></script>

<div align="center">
	

	<select name="countIpPerPage" onchange="defaultPaginationWhiteAndBlackList()">
		<c:forEach var="list" items="${pageList}">
			<option value="${list.ipsPerPage}">${list.ipsPerPage}</option>
		</c:forEach>
	</select>
	<!-- List of type ip for white and black list pagination -->
	<select name="ipType" onchange="defaultPaginationWhiteAndBlackList()">
		<option value="allIp"><spring:message code="label.allIp"/></option>
		<option value="ipv4"><spring:message code="label.ipV4"/></option>
		<option value="ipv6"><spring:message code="label.ipV6"/></option>
	</select>
</div>

<div align="left" id="content" class="content"></div>

<div align="center" id="ipListDiv"></div>

<script>
	$(document).ready(function() {		
// 		$('#demo1').bootpag({
// 			total : 100,
// 			maxVisible : 5
// 		}).on("page", function(event, num) {
// 			doAjaxPaginationWhiteAndBlackList(num);
// 		});
		defaultPaginationWhiteAndBlackList();
	});
</script>

