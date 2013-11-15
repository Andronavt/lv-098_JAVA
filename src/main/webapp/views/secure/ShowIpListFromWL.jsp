<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.1.1/js/bootstrap.min.js"></script>
<script
	src="//raw.github.com/botmonster/jquery-bootpag/master/lib/jquery.bootpag.js"></script>

<div id="content"></div>
<div id="page-selection">Pagination goes here</div>
<script>
	// init bootpag
	$('#page-selection').bootpag({
		total : 10
	}).on("page", function(event, /* page number here */num) {
		$("#content").html("Test"); // some ajax content loading...
	});
</script>
