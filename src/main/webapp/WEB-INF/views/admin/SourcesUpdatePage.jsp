<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<select name="sources" size="1">
		<c:forEach  var="Source" items="${listSource}">
			<option value="${Source.getSourceId()}">${Source.getSourceName()} #${Source.getSourceId()}</option>
		</c:forEach>
</select>
<input type="button" value="Add IP-address" onclick="doAjaxPost()"><br/>
<div id="result" style="color: green;"></div></td>

<script type="text/javascript">
	function doAjaxPost() {
		// get the form values
		var source = $('select[name=sources]').val();
		$.ajax({
			type : "POST",
			url : "admin/AddIpv4",
			data : "ip=" + ip + "&source=" + source,
			success : function(response) {
				// we have the response
				$('#result').html(response);

			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	</script>
</body>
</html>