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
	src="<c:url value="/resources/js/validationAddNewFeed.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/rulesAddNewFeed.js" />"></script>

<link href="<c:url value="/resources/css/validation.css" />"
	rel="stylesheet" type="text/css" />


<form action="newFeed" id="addNewFeed" method="post" name="input_feed">
	<fieldset>

		<legend style="color: green">Add new source:</legend>

		<div>
			<b>Add parser:</b>
		</div>

		<input id="parser" type="text" name="parserIn" size="30"
			maxlength="30" />

		<div>
			<b>Add source name:</b>
		</div>

		<input id="sourceName" type="text" name="sourceNameIn" size="30"
			maxlength="50" />

		<div>
			<b>Add url:</b>
		</div>

		<input id="url" type="text" name="urlIn" size="30" maxlength="50" />
		<br> <br>
		<div>
			<b>Chose type of list:</b> <b><select id="list" name="typeList"
				size="1">
					<option>black list</option>
					<option>white list</option>
			</select></b>
		</div>

		<br>
		<div>
			<b>Add rank of source:</b>
		</div>

		<input id="rank" type="text" name="rankIn" size="30" maxlength="50" />

		<div>
<<<<<<< HEAD
			<input id="btnAddNewFeed" type="button" name="addNewFeed" value="Add new feed" />
=======
			<input id="btnAddNewFeed" type="button" name="addNewFeed"
				value="Add new feed" />
>>>>>>> b5ef312b4c1a734acd7422f91169cc5386ac494c
		</div>

	</fieldset>


</form>

<div id="Info" style="color: green;"></div>

<script type="text/javascript">
	$(document).ready(function() {
		validateAddNewFeed();
	});
<<<<<<< HEAD
</script>
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
	src="<c:url value="/resources/js/validationAddNewFeed.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/rulesAddNewFeed.js" />"></script>

<link href="<c:url value="/resources/css/validation.css" />"
	rel="stylesheet" type="text/css" />


<form action="newFeed" id="addNewFeed" method="post" name="input_feed">
	<fieldset>

		<legend style="color: green">Add new source:</legend>

		<div>
			<b>Add parser:</b>
		</div>

		<input id="parser" type="text" name="parserIn" size="30"
			maxlength="30" />

		<div>
			<b>Add source name:</b>
		</div>

		<input id="sourceName" type="text" name="sourceNameIn" size="30"
			maxlength="50" />

		<div>
			<b>Add url:</b>
		</div>

		<input id="url" type="text" name="urlIn" size="30" maxlength="50" />
		<br> <br>
		<div>
			<b>Chose type of list:</b> <b><select id="list" name="typeList"
				size="1">
					<option>black list</option>
					<option>white list</option>
			</select></b>
		</div>

		<br>
		<div>
			<b>Add rank of source:</b>
		</div>

		<input id="rank" type="text" name="rankIn" size="30" maxlength="50" />

		<div>
			<input id="btnAddNewFeed" type="button" name="addNewFeed"
				value="Add new feed" />
		</div>

	</fieldset>


</form>

<div id="Info" style="color: green;"></div>

<script type="text/javascript">
	$(document).ready(function() {
		validateAddNewFeed();
	});
=======
>>>>>>> b5ef312b4c1a734acd7422f91169cc5386ac494c
</script>