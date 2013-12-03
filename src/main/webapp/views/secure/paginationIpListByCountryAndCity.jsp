<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.bootpag.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.js" />"></script>

<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/ajax.js" />"></script>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />

<div id="number">
	<!-- ip pare page -->
	<select name="countIpPerPage"
		onchange="defaltPaginationByCountryAndCity()">
		<c:forEach var="list" items="${pageList}">
			<option value="${list.ipsPerPage}">${list.ipsPerPage}</option>
		</c:forEach>
	</select>
	<!-- List of type ip for white and black list pagination -->
	<select name="ipType" onchange="defaltPaginationByCountryAndCity()">
		<option value="allIp"><spring:message code="label.allIp" /></option>
		<option value="ipv4"><spring:message code="label.ipV4" /></option>
		<option value="ipv6"><spring:message code="label.ipV6" /></option>
	</select>
	<!-- White or black list -->
	<select name="typeList" onchange="defaltPaginationByCountryAndCity()">
		<option value="blackList"><spring:message
				code="label.whiteIpList" /></option>
		<option value="whiteList"><spring:message
				code="label.blackIpList" /></option>
	</select>

	<!-- City or Country -->
	<input name="clockpick" id="inputData" type="text" size=10
		onchange="defaltPaginationByCountryAndCity()"> 

</div>
<div align="center" id="content" class="content"></div>
<div align="center" id="locationDiv"></div>
<script>
	var source = "${locationList}";
	source = source.replace("[", "").replace("]", "").split(',');
	$(document).ready(function() {
		$("#inputData").autocomplete({
			source : source
		});
	});
</script>

