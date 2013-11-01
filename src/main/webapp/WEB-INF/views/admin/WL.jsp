<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.0.3.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h2>Delete IP from WhiteList</h2>

	<form class="Delete-IP" >
		<label for="IpRemove" id="IpRemoveLabel">Enter the IP that you
			want to remove: </label> <input id="IpRemoveStr" size="20" maxlength="50"
			type="text"> <input id="btn1" type="button" value="DELETE"
			onclick="actionMeth()"> <br>
		<label for="IpRemoveInfo" id="IpRemoveLabelInfo"> </label>
		<script type="text/javascript">
			function actionMeth() {
				// get the form values
				var ipAddress = $('#IpRemoveStr').val();
				$.ajax({
					type : "POST",
					url : "WL",
					data : "address=" + ipAddress,
					success : function(response) {
						$('#IpRemoveLabelInfo').html(response);
					},
					error : function(e) {
						alert('Error: ' + e);
					}
				});
				return false;
			};
		</script>

	</form>

</body>
</html>