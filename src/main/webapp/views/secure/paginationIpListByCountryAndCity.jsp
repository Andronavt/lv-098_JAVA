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

<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

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
		<c:forEach var="list" items="${pageList}">
			<option value="${list.ipsPerPage}">${list.ipsPerPage}</option>
		</c:forEach>
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
	<input name="clockpick" id="xy" type="text" size=10
		onchange="defaltPaginationByCountryAndCity()">
</div>
<script>
	var source = "${locationList}";
	source = source.replace('[','');
	source = source.replace(']','');	   
	source = source.split(',');
	var page = "${pageCount}";
	$(document).ready(function() {
		$('#demo1').bootpag({
			total : page
		}).on("page", function(event, num) {
			doAjaxPaginationByCountryAndCity(num);
		});
		// 		defaltPaginationByCountryAndCity();
		$("#xy").autocomplete({
			source : source
		});
	});
</script>

