<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<c:forEach  var="Source" items="${listSource}">
			<input type="checkbox" name="${Source.getSourceName()}" value="${Source.getSourceName()}" id = "${Source.getSourceId()}">${Source.getSourceName()}<br>
		</c:forEach>

<input type="button" value="Add IP-address" onclick="doAjaxPost()"><br/>
<div id="result" style="color: green;"></div>

<script type="text/javascript">
	function doAjaxPost() {
		// get the form values
		if($('#1').is(":checked")) {
			var source1 = $('#1').val();
        } else {
        	var source1 = "";
        }
		if($('#2').is(":checked")) {
			var source2 = $('#2').val();
        } else {
        	var source2 = "";
        }
		if($('#3').is(":checked")) {
			var source3 = $('#3').val();
        } else {
        	var source3 = "";
        }
		$.ajax({
			type : "POST",
			url : "/admin/updateSources",
			data : "sourceName1=" + source1 + "&ourceName2=" + source2 + "&ourceName3=" + source3,
			beforeSend : function() {
				$('#result').html('update sources');
			},
			success : function(response) {
				// we have the response
				$('#result').html(html);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
	</script>
</body>
</html>