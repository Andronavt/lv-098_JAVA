<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/ajax.js" />"></script>

<form action="" id="updateSource">
	<div id="1">
		<fieldset>
			<legend align="left">Source for update:</legend>
			<select name="sources" size="1">
				<c:forEach var="Source" items="${listSource}">
					<option value="${Source.getSourceName()}">${Source.getSourceName()}</option>
				</c:forEach>
			</select> <br> <input type="button" value="Update source"
				onclick="doAjaxUpdateSource()">
			<!-- 	<input align="left" id="btnUpdate" type="button" name="updateSource" value="Update source" /> -->

		</fieldset>
	</div>
</form>
<br>
<div id="upSource" style="color: black;"></div>