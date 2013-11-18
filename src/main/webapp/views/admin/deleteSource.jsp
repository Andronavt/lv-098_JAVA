<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/ajax.js" />"></script>


<fieldset>
	<legend style="color: green" align="center">List of sources</legend>
	<br>

	<div id="1">
		<center>
			<select name="sources" size="1">
				<c:forEach var="Source" items="${listSource}">
					<option value="${Source.getSourceName()}">${Source.getSourceName()}</option>
				</c:forEach>
			</select> <br> <br> <input type="button" value="Delete source"
				onclick="selectSource()">
		</center>
		<br> <br>
	</div>

</fieldset>

<div id="Info" style="color: green;"></div>
