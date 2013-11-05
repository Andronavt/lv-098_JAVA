<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function getIP4List() {
			var source = $('select[name=sources]').val();
			$.ajax({
				type : "POST",
				url : "secure/getList",
				data : "source=" + source,
				success : function(response) {
					// we have the response
					$('#divGetIp4List').html(response);
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		}
	</script>


</body>
</html>