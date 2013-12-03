<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">

<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">

<link href="<c:url value="/resources/css/menu.css" />" rel="stylesheet"
	type="text/css" />

<!-- Bootstrap -->
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.js" />"></script>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />
	
	<script type="text/javascript"
	src="<c:url value="/resources/js/menu.js" />"></script> 

<div id="cssmenu">
<ul>
	<li><a><span><spring:message code="label.home"/></span></a></li>
	<li><a><span><spring:message code="label.home"/></span></a>
	<ul>
	<li><a class="button" href="welcomes" title="<spring:message code="label.about"/>"><spring:message code="label.about"/></a>
        </ul>
        </li>
		
	<sec:authorize access="hasRole('ROLE_USER')">

		<li><a><span><spring:message code="label.statistics"/></span></a>
            <ul>
			
				<li><a class="button" href="secure_showIpListFromWL"
					title="<spring:message code="label.whitelist"/>"><spring:message code="label.whitelist"/></a></li>
			

				<li><a class="button" href="secure_showIpListFromBL"
					title="<spring:message code="label.blacklist"/>"><spring:message code="label.blacklist"/></a></li>
			

				<li><a class="button" href="secure_blackListMap" title="<spring:message code="label.blackmap"/>"><spring:message code="label.blackmap"/></a></li>
		

				<li><a class="button" href="secure_whiteListMap" title="<spring:message code="label.whitemap"/>"><spring:message code="label.whitemap"/></a></li>
			
				<li><a class="button" href="secure_inProgres" title="<spring:message code="label.topOldestIp"/>"><spring:message code="label.topOldestIp"/></a></li>
			</ul>
			</li>

        <li><a><span><spring:message code="label.ipData"/></span></a>
                <ul>			
				<li><a class="button" href="secure_showIpListByCity" title="<spring:message code="label.ipByCity"/>">
					<spring:message code="label.ipByCity"/></a></li>
			

		
				<li><a class="button" href="secure_showIpListByCountry"
					title="<spring:message code="label.ipByCountry"/>"><spring:message code="label.ipByCountry"/></a></li>
					</ul>
			</li>
	</sec:authorize>

	<sec:authorize access="hasRole('ROLE_ADMIN')">
	
	<li><a><span><spring:message code="label.sources"/></span></a>
        <ul>
				<li><a class="button" href="admin_addNewSource" id="getContentAddNewSource"
					title="<spring:message code="label.addNewSource"/>"><spring:message code="label.addNewSource"/></a></li>
		

			
				<li><a class="button" href="admin_deleteSource"
					id="getContentDeleteSource" title="<spring:message code="label.deleteSource"/>"><spring:message code="label.deleteSource"/></a></li>
			

			
				<li><a class="button" href="admin_addIpToList" id="getContentAddIpToWl"
					title="<spring:message code="label.addIpToList"/>"><spring:message code="label.addIpToList"/></a></li>
			

			
				<li><a class="button" href="admin_deleteIpFromList"
					id="getContentDeleteIpFromList" title="<spring:message code="label.deleteIpFromList"/>"><spring:message code="label.deleteIpFromList"/></a></li>
		

			
				<li><a class="button" href="admin_updateSources" title="<spring:message code="label.updateSource"/>"><spring:message code="label.updateSource"/></a></li>
			</ul>
			</li>

		
	</sec:authorize>
</ul>
</div>
