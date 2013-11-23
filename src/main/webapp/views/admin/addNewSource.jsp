<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
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
	src="<c:url value="/resources/js/validationAddNewSource.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/rulesAddNewSource.js" />"></script>

<link href="<c:url value="/resources/css/validation.css" />"
	rel="stylesheet" type="text/css" />

<!-- Bootstrap -->
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.js" />"></script>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />

<!-- custom css -->
<link href="<c:url value="/resources/css/admin.css" />" rel="stylesheet"
	type="text/css" />

<form action="newSource" id="addNewSource" method="post" name="input_feed">
	<fieldset>

		<legend>Add new source:</legend>

		<div>
			<b>Add parser:</b>
		</div>

		<input id="parser" type="text" name="parserIn" maxlength="30" />

		<div>
			<b>Add source name:</b>
		</div>

		<input id="sourceName" type="text" name="sourceNameIn" maxlength="50" />

		<div>
			<b>Add url:</b>
		</div>

		<input id="url" type="text" name="urlIn" maxlength="50" />
		<div>
			<div>
				<b>Chose type of list:</b>
			</div>
			<b><select id="list" name="typeList" size="1">
					<option>black list</option>
					<option>white list</option>
			</select></b>
		</div>
		<div>
			<b>Add rank of source:</b>
		</div>

		<input id="rank" type="text" name="rankIn" size="30" maxlength="50" />

		<div>
			<input class="btn btn-primary" id="btnAddNewSource" type="button"
				name="addNewSource" value="Add new source" />
		</div>

	</fieldset>

</form>

<div id="Info"></div>

<script type="text/javascript">
	$(document).ready(function() {
		validateAddNewSource();
	});
</script>