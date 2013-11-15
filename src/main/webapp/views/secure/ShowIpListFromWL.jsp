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

<div id="content" class="content">WHAT?</div>
<div id="demo1" class="demo1">Pagination goes here</div>
<script>
	// init bootpag
	$(document).ready(function() {
		$('.demo1').bootpag({
			total : 15
		}).on("page", function(event, num) {
			$(".content").html("Page " + num); // or some ajax content loading...
		});
	});
</script>
