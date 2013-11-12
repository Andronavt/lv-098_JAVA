<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="<c:url value="/resources/js/ajax.js" />"></script>

<!-- 	validation -->
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.5.2.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.validate.min.js" />"></script>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.0.3.js"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/validation.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/rulesRegForm.js" />"></script>

<link href="<c:url value="/resources/css/validation.css" />"
	rel="stylesheet" type="text/css" />
</head>
<body>

	<form action="newFeed" id="addNewFeed" method="post" name="input_feed">
		<table>
			<tr>
				<th><b>Add new source:</b></th>
			</tr>
			<tr>
				<th>Add adaptor:</th>
				<th><input id="parser" type="text" size="30"
					maxlength="30" /> <br></th>

			</tr>
			<tr>
				<th>Add source name:</th>
				<th><input id="sourceName"  type="text"
					size="30" maxlength="50" /> <br></th>
			</tr>
			<tr>
				<th>Add url:</th>
				<th><input id="url" type="text" size="30"
					maxlength="50" /> <br></th>
			</tr>
			<tr>
				<th>Add type of list:</th>
				<th><input id="listType" type="text" size="30"
					maxlength="50" /> <br></th>
			</tr>
			<tr>
				<th>Add rank of source:</th>
				<th><input id="rank"  type="text" size="30"
					maxlength="50" /> <br></th>
			</tr>
			<tr>
				<th><input id="btnAddNewFeed" type="button" 
					value="Add new feed" onclick="addNewFeed();" /></th>
			</tr>
		</table>

<script type="text/javascript">
		function addNewFeed() {
			// get the form values
			var parser = $('#parser').val();
			var sourceName = $('#sourceName').val();
			var url = $('#url').val();
			var listType = $('#listType').val();
			var rank = $('#rank').val();
			$.ajax({
				type : "POST",
				url : "addNewFeed",
				data : "parser=" + parser + "&sourceName=" + sourceName
						+ "&url=" + url + "&listType=" + listType + "&rank"
						+ rank,
				success : function(response) {
					// we have the response
					alert(parser, sourceName, url);
					$('#info').html(response);
				},
				error : function(e) {
					alert('Error: ' + parser + sourceName + url);
				}
			});
			return false;
		}
	</script>

	</form>

	
</body>
</html>