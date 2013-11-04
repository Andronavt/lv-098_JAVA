<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%> 
	<style type="text/css">
.button {
  display: block;
  width: 140px;
  height: 15px;
  padding: 4px;
  text-align: center;
  color: black;
  background-color:#8fa09b;
  background-image: -webkit-linear-gradient(#8fa09b,#838B83); 
} 

.button:hover {
  background: -moz-radial-gradient(#fff, #827e55);
  background: -ms-radial-gradient(#fff, #827e55);
  background: -o-radial-gradient(#fff, #827e55);
  background: -webkit-radial-gradient(#fff, #827e55);
}
</style>
            <sec:authorize access="hasRole('ROLE_USER')">
				<spring:url value="/secure/" var="User">
					<a class="button" href="secure/index" title="Home">Home</a>
<!-- 					<a class="button" href="secure/check-ip-status" title="Ip status">Ip status</a> -->
					<div id="accordion">
			<h6>Statistics:</h6>
			<div>
<!-- 					<a class="button" href="secure/ip-charts" title="Charts">Charts</a> -->
<!-- 					<a class="button" href="secure/blacklist-map" title="Blacklist map">Blacklist map</a> -->
<!-- 					<a class="button" href="secure/whitelist-map" title="Whitelist map">Whitelist map</a> -->
<!-- 					<a class="button" href="secure/top_old_ip" title="Top oldest IP">Top oldest IP</a> -->
					</div>
			<h6>Ip data:</h6>
			<div>
<!-- 					<a class="button" href="secure/black_ip_by_city" title="Black IP by city">Black IP by city</a> -->
<!-- 					<a class="button" href="secure/top_black_ip_by_country" title="Black IP by country">Black IP by country</a> -->
						<a class="button" href="#" id="getContentAddIp4List" title="Add IP to Source">List of IPv4 from source</a>
						<a class="button" href="#" id="getContentShowIpListFromWl" title="Show Ip list from WList">Show Ip list from WList</a>
					</div>
					</div>
				</spring:url>
			</sec:authorize>
			
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<spring:url value="/admin/" var="Admin">
				<div id="accordion1">
				<h6>Feeds:</h6>
				<div>
				<a class="button" href="#" id="getContentDeleteFeed" title="Delete Feed">Delete Feed</a>
				<a class="button" href="#" id="getContentAddNewFeed"  title="Add new Feed">Add new Feed</a>
				<a class="button" href="#" id="getContentAddIp4" title="Add IP to Source">Add IP to Source</a>
 				<a class="button" href="#" id="getContentAddIpToWl" title="Add to WList">Add to WList</a>
				<a class="button" href="#" id="getContentDeleteWlIp" title="Delete IP from WList">Delete IP from WList</a>
<!-- 		TODO		<a class="button" href="admin/list-downloads" title="List downloads">List downloads</a> -->
				</div>
				</div>
<!-- 				<a class="button" href="admin/daemon-control" title="Daemon controls">Daemon controls</a> -->
<!-- 				<a class="button" href="admin/admin" title="Admin">Admin</a> -->
				</spring:url>
			</sec:authorize>
		
<script>
$( "#accordion" ).accordion({collapsible:true,collapsible:true});
$( "#accordion1" ).accordion({collapsible:true,collapsible:true});
</script>
		
			