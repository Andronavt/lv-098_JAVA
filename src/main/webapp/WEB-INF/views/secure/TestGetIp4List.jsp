<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h2>Get all Ipv4 from resource</h2>
	<form name="getContentGetIp4List" id="getContentGetIp4List"
		action="secure/getList" method="post" name="drop_down_box">
		<select name="sour" size="1">
			<option selected="selected"value="1">Source #1</option>
			<option value="2">Source #2</option>
			<option value="3">Source #3</option>
			<option value="4">Source #4</option>
			<option  value="5">Source #5</option>
		</select> 
	</form>
	
	<div id=divGetIp4List></div>
	<script>
		$('#getContentGetIp4List').submit(function() {
			var postData = $(this).serializeArray();
			var formURL = $(this).attr("action");
			$.ajax({
				url : formURL,
				type : "POST",
				data : postData,
				success : function(response) {
					alert("seccess");
					$('#divGetIp4List').html(response);
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert("error");      
				}
			});
			e.preventDefault(); //STOP default action
		});
		$("#getContentGetIp4List").submit();
	</script>
	
</body>
</html>