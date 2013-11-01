<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<title>Insert title here</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>

	<script>
		$(document).ready(function() {
			$('#getContentLogin').click(function() {
				$.ajax({
					url : "signin",
					cache : false,
					beforeSend : function() {
						$('#content').html('get login page');
					},
					success : function(html) {
						$("#content").html(html);
					}
				});
				return false;
			});

			$('#getContentAddIp4').click(function() {
				$.ajax({
					url : "admin/AddIpv4",
					cache : false,
					beforeSend : function() {
						$('#content').html('add IP v4');
					},
					success : function(html) {
						$("#content").html(html);
					}
				});
				return false;
			});

			$('#getContentDeleteWlIp').click(function() {
				$.ajax({
					type : 'GET',
					url : "admin/WL",
					cache : false,
					beforeSend : function() {
						$('#content').html('Delete from WhiteList');
					},
					success : function(html) {
						$("#content").html(html);
					}
				});
				return false;
			});

			$('#getContentAddNewFeed').click(function() {
				$.ajax({
					url : "admin/AddNewFeed",
					cache : false,
					beforeSend : function() {
						$('#content').html('Add New Feed');
					},
					success : function(html) {
						$("#content").html(html);
					}
				});
				return false;
			});
			
			$('#getContentDeleteFeed').click(function() {
				$.ajax({
					url : "admin/listOfSource",
					cache : false,
					beforeSend : function() {
						$('#content').html('Delete source');
					},
					success : function(html) {
						$("#content").html(html);
					}
				});
				return false;
			});

		});
	</script>

</body>
</html>