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

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />


<div id="content" class="content"></div>
<div id="demo1"></div>
<div id="number">
	<select name="count">
		<option value="10">10</option>
		<option value="20">20</option>
		<option value="30">30</option>
		<option value="40">40</option>
	</select>
	<!-- List of type ip for white and black list pagination -->
	<c:if test="${!empty errorMsg}">
		<select name="ipType">
			<option value="-1">All Ip</option>
			<option value="0">Ip v4</option>
			<option value="1">Ip v6</option>
		</select>
	</c:if>
	<!-- List of country or city for ip by city and country pagination -->
	<c:if test="${!empty errorMsg}">
		<select name="list">
			<option value="-1">All Ip</option>
			<option value="0">Ip v4</option>
			<option value="1">Ip v6</option>
		</select>
	</c:if>
</div>
<script>
	// init bootpag
	function doAjaxPagination(page) {
		$.ajax({
			type : "POST",
			url : location.href,
			data : "page=" + page + "&value=" + $('select[name=count]').val(),
			success : function(response) {
				$("#content").html(response);
			},
			error : function(e) {
				alert('Error: ' + e + page + value);
			}
		});
	}
	$(document).ready(function() {
		$('#demo1').bootpag({
			total : 5
		}).on("page", function(event, num) {
			doAjaxPagination(num);
		});
		doAjaxPagination(1);
	});
</script>

