<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="sec"
 uri="http://www.springframework.org/security/tags"%> 
 <style type="text/css">
.button {
font-size: 10px;
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
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link rel="stylesheet"
 href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
</head>
<body>
<div id="accordion">

  <h6>Home</h6>
            <div>
     <a class="button" href="" title="Home">Home</a>
    </div> 
    <sec:authorize access="hasRole('ROLE_USER')">
    
   <h6>Statistics:</h6>
   <div>
<!--      <a class="button" href="secure/ip-charts" title="Charts">Charts</a> -->
     <a class="button" href="#" id="" title="Blacklist map">Whitelist info</a>
<!--      <a class="button" href="secure/blacklist-map" title="Blacklist map">Blacklist map</a> -->
<!--      <a class="button" href="secure/whitelist-map" title="Whitelist map">Whitelist map</a> -->
<!--      <a class="button" href="secure/top_old_ip" title="Top oldest IP">Top oldest IP</a> -->
     </div>
   <h6>Ip data:</h6>
   <div>
<!--      <a class="button" href="secure/black_ip_by_city" title="Black IP by city">Black IP by city</a> -->
<!--      <a class="button" href="secure/top_black_ip_by_country" title="Black IP by country">Black IP by country</a> -->
      <a class="button" href="#" id="getContentAddIp4List" title="Add IP to Source">List of IPv4 from source</a>
     </div>
   </sec:authorize>
   
   <sec:authorize access="hasRole('ROLE_ADMIN')">
    <h6>Feeds:</h6>
    <div>
    <a class="button" href="#" id="getContentDeleteFeed" title="Delete Feed">Delete Feed</a>
    <a class="button" href="#" id="getContentAddNewFeed"  title="Add new Feed">Add new Feed</a>
    <a class="button" href="#" id="getContentAddIp4" title="Add IP to Source">Add IP to Source</a>
<!--     <a class="button" href="admin/add_ip_to_wlist" title="Add to WList">Add to WList</a> -->
    <a class="button" href="#" id="getContentDeleteWlIp" title="Delete IP from WList">Delete IP from WList</a>
<!--   TODO  <a class="button" href="admin/list-downloads" title="List downloads">List downloads</a> -->
    </div>
<!--     <a class="button" href="admin/daemon-control" title="Daemon controls">Daemon controls</a> -->
<!--     <a class="button" href="admin/admin" title="Admin">Admin</a> -->
   </sec:authorize>
   </div>

<script>
$("#accordion").accordion({collapsible:true});
</script>
