<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF8"></meta>
		<script type="text/javascript" src="http://code.jquery.com/jquery-2.0.3.js"></script>
		<title>Insert title here</title>
	</head>
	<body>
		<center>
			<h2>Adding IP to WhiteList</h2>
	
			<form class="Add-IP" >
				<label id="AddToWL">Enter the IP that you want add to WhiteList: </label>
					<input id="IP" size="20" maxlength="50" type="text"> 
					<input id="btn1" type="button" value="ADD" onclick="actionMeth()"> 
					<br>
				<div id="Info" style="color: green;"></div>
			</form>
		</center>
	</body>
	<script type="text/javascript">
		function actionMeth() {
			// get the form values
			var ipAddress = $('#IP').val();
			$.ajax({
				type : "POST",
				url : "admin/AddIpToWL",
				data : "address=" + ipAddress,
				success : function(response) {
					$('#Info').html(response);
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
			return false;
		};
	</script>
</html>