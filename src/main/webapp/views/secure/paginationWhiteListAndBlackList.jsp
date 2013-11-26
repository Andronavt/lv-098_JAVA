<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

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

<div align="center">
	<script type="text/javascript"
		src="<c:url value="/resources/js/ajax.js" />"></script>

	<select name="countIpPerPage" onchange="defaultPaginationWhiteAndBlackList()">
		<c:forEach var="list" items="${pageList}">
			<option value="${list.ipsPerPage}">${list.ipsPerPage}</option>
		</c:forEach>
	</select>
	<!-- List of type ip for white and black list pagination -->
	<select name="ipType" onchange="defaultPaginationWhiteAndBlackList()">
		<option value="allIp">All Ip</option>
		<option value="ipv4">Ip v4</option>
		<option value="ipv6">Ip v6</option>
	</select>
</div>

<div align="left" id="content" class="content"></div>

<div align="center" id="demo1"></div>

<script>
	$(document).ready(function() {		
		$('#demo1').bootpag({
			total : 10,
			maxVisible : 5
		}).on("page", function(event, num) {
			doAjaxPaginationWhiteAndBlackList(num);
		});
		defaultPaginationWhiteAndBlackList();
	});
</script>

