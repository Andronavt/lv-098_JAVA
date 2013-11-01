<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<title>Add Users using ajax</title>
<script type="text/javascript">
	function doAjaxPost() {
		// get the form values
		var ip = $('#ip').val();
		var source = $('#source').val();
		$.ajax({
			type : "POST",
			url : "admin/AddIpv4",
			data : "ip=" + ip + "&source=" + source,
			success : function(response) {
				// we have the response
				$('#info').html(response);
				$('#ip').val('');
				$('#source').val('');
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
</script>
</head>
<body>
	<h2>Add IP-address ver.4 to Source</h2>
	<table>
		<tr>
			<td>Enter IP-address ver.4 :</td>
			<td><input type="text" id="ip"><br /></td>
		</tr>
		<tr>
			<td>Source # :</td>
			<td><input type="text" id="source"><br /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="Add IP-address"
				onclick="doAjaxPost()"><br /></td>
		</tr>
		<tr>
			<td colspan="2"><div id="info" style="color: green;"></div></td>
		</tr>
	</table>
</body>
</html>

