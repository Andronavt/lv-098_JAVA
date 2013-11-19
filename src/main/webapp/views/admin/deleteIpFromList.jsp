<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<title>Insert title here</title>
<script type="text/javascript"
	src="<c:url value="/resources/js/ajax.js" />"></script>

<!-- 	validation -->
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.5.2.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.validate.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/validationIpDeleting.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/rulesIpDeleting.js" />"></script>

<link href="<c:url value="/resources/css/validation.css" />"
	rel="stylesheet" type="text/css" />
<fieldset>

	<legend style="color: green">Delete IP from WhiteList</legend>

	<form class="Delete-IP" id="deleteIp" method="post" name="deleteFromWL">

		<div>Insert ip for deleting:</div>
		<input id="ipForRemove" type="text" name="deleteIpIn" size="20"
			maxlength="50">
			
		<div>
			<b>Chose type of list:</b> <b><select id="list" name="typeList"
				size="1">
					<option value="1">black list</option>
					<option value="0">white list</option>
			</select></b>
		</div>
		
	</form>
	<input id="btnDeleteIp" type="button" name="deleteIp" value="DELETE">
</fieldset>
<br>

<div id="Info" style="color: green;"></div>

<script type="text/javascript">
	$(document).ready(function() {
		validateIpDeleting();
	});
</script>