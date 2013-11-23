<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.bootpag.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/ajax.js" />"></script>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />


<div id="content" class="content"></div>
<div id="demo1"></div>
<div id="number">
	<!-- ip pare page -->
	<select name="countIpPerPage"
		onchange="defaltPaginationByCountryAndCity()">
		<option value="10">10</option>
		<option value="20">20</option>
		<option value="30">30</option>
		<option value="40">40</option>
	</select>
	<!-- List of type ip for white and black list pagination -->
	<select name="ipType" onchange="defaltPaginationByCountryAndCity()">
		<option value="allIp">All Ip</option>
		<option value="ipv4">Ip v4</option>
		<option value="ipv6">Ip v6</option>
	</select>
	<!-- White or black list -->
	<select name="typeList" onchange="defaltPaginationByCountryAndCity()">
		<option value="blackList">black list</option>
		<option value="whiteList">white list</option>
	</select>
	<!-- City or Country -->
	<select name="location" onchange="defaltPaginationByCountryAndCity()">
		<%-- 		<c:forEach var="location" items="${locationList}"> --%>
		<%-- 			<option value="${location.cityName }">${location.cityName}</option> --%>
		<%-- 		</c:forEach> --%>
		<option value="Taiwan">Taiwan</option>
	</select>
</div>
<script>
	$(document).ready(function() {
		$('#demo1').bootpag({
			total : 5
		}).on("page", function(event, num) {
			doAjaxPaginationByCountryAndCity(num);
		});
		defaltPaginationByCountryAndCity();
	});
</script>

