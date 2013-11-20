<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/ajax.js" />"></script>
<!-- Bootstrap -->
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
	
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.js" />"></script>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />	

<fieldset>
	<legend style="color: green" align="center"><strong>List of sources</strong></legend>
	<br>
	<div id="1">
		<center>
			<select name="sources" size="1">
				<c:forEach var="Source" items="${listSource}">
					<option value="${Source.getSourceName()}">${Source.getSourceName()}</option>
				</c:forEach>
			</select>
			 <div><input class="btn btn-primary" type="button" value="Delete source" onclick="selectSource()"></div>
		</center>
	</div>

</fieldset>

<div align="center" id="Info" style="color: green;"></div>
