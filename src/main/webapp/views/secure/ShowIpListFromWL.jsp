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
<div id="demo1" class="demo1"></div>
<script>
	// init bootpag
	function test(page, value) {
		$.ajax({
			type : "POST",
			url : "showIpListFromWL",
			data : "page=" + page + "&value=" + value,
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
			test(num, 10);
		});
	});
</script>
