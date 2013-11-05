$(document).ready(function() {
			$('#getContentLogin').click(function() {
				$.ajax({
					url : "signin",
					cache : false,
					beforeSend : function() {
						$('#content').html('get login page');
					},
					success : function(html) {
						$("#content").html(html);
					}
				});
				return false;
			});

			$('#getContentAddIp4').click(function() {
				$.ajax({
					url : "admin/AddIpv4",
					cache : false,
					beforeSend : function() {
						$('#content').html('add IP v4');
					},
					success : function(html) {
						$("#content").html(html);
					}
				});
				return false;
			});

			$('#getContentDeleteWlIp').click(function() {
				$.ajax({
					type : 'GET',
					url : "admin/WL",
					cache : false,
					beforeSend : function() {
						$('#content').html('Delete from WhiteList');
					},
					success : function(html) {
						$("#content").html(html);
					}
				});
				return false;
			});

			$('#getContentAddNewFeed').click(function() {
				$.ajax({
					url : "admin/AddNewFeed",
					cache : false,
					beforeSend : function() {
						$('#content').html('Add New Feed');
					},
					success : function(html) {
						$("#content").html(html);
					}
				});
				return false;
			});
			
			$('#getContentDeleteFeed').click(function() {
				$.ajax({
					url : "admin/listOfSource",
					cache : false,
					beforeSend : function() {
						$('#content').html('Delete source');
					},
					success : function(html) {
						$("#content").html(html);
					}
				});
				return false;
			});
			$('#getContentAddIp4List').click(function() {
				$.ajax({
					url : "secure/GetIp4List",
					cache : false,
					beforeSend : function() {
						$('#content').html('Get list form');
					},
					success : function(html) {
						$("#content").html(html);
					}
				});
				return false;
			});
			
			$('#getContentDeleteWlIp').click(function() {
				$.ajax({
					type : 'GET',	
					url : "admin/WL",
					cache : false,
					beforeSend : function() {
						$('#content').html('Delete Ip from WhiteList');
					},
					success : function(html) {
						$("#content").html(html);
					}
				});
				return false;
			});

			$('#getContentAddIpToWl').click(function() {
				$.ajax({
					type : 'GET',
					url : "admin/AddIpToWL",
					cache : false,
					beforeSend : function() {
						$('#content').html('Add Ip to WhiteList');
					},
					success : function(html) {
						$("#content").html(html);
					}
				});
				return false;
			});

			$('#getContentShowIpListFromWl').click(function() {
				$.ajax({
					type : 'GET',
					url : "secure/ShowIpListFromWL",
					cache : false,
					beforeSend : function() {
						$('#content').html('Show Ip list from WhiteList');
					},
					success : function(html) {
						$("#content").html(html);
					}
				});
				return false;
			});
		});