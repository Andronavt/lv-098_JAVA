<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

<c:if test="${!empty successMsg}">
	<p align="left" style="color: green;">SUCCESS: ${successMsg}</p>
</c:if>
<c:if test="${!empty incorrectMsg}">
	<p align="left" style="color: red">Warning: ${incorrectMsg}</p>
</c:if>
<c:if test="${!empty errorMsg}">
	<p align="left" style="color: red;">ERROR: ${errorMsg}</p>
	<div class="my-item">
		<div class="fulltext">
			<c:forEach var="error" items="${errorList}">
				<p>${error}</p>
			</c:forEach>
		</div>
		<a class="readmore" href="#">Expand stack trace..</a>
	</div>
</c:if>

<script>
	$(document)
			.ready(
					function() {
						$('.fulltext').hide();

						$('.my-item .readmore')
								.click(
										function(event) {
											event.preventDefault();
											$(this).parent().find('.fulltext')
													.slideToggle('slow');
											$(this)
													.text(
															$(this).text() == 'Close Deals' ? 'More Deals'
																	: 'Close Deals');
										});
					});
</script>
