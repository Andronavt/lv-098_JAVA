<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<script type="text/javascript" src="http://code.jquery.com/jquery-2.0.3.js"></script>
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
	<th>List of sources:</th>
	<th><form action="formListOfSources" method="post" name="list">
	
	<input type="submit" value="Get list of sources">
	<select name="sources" size="1">
		<c:forEach  var="Source" items="${listSource}">
			<option>${Source.getSourceName()}</option>
		</c:forEach>
	</select>	
	</form></th>
	
	<th><script type="text/javascript">
		function selectsource(){
			var deleteString = $('select[name=sources]').val();
		 $.ajax({
		     type : "POST",
		     url : "deleteSource",
		     data : "deleteSource=" + deleteString,
		     success : function(response) {
		      // we have the response
			      alert("succesful");
		     },
		     error : function (e) {
		      alert(deleteString);
		     }
		    });
		    return false;
		   };
		   </script>
		<input type="button" value="Delete source" onclick="selectsource()"></th>
		</tr>
		</table>
</body>
</html>