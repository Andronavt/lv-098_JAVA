$(document).ready(function() {

	jQuery.validator.addMethod(
		    'regexp',
		    function(value, element, regexp) {
				  var re = new RegExp(regexp);
		        return  re.test(value);
		    },
		    "Please check your input."
		); 
	
	$("#deleteIp").validate({
		 rules: {
			 deleteIpIn: {
				 required : true,
				 regexp: '((([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])|([a-f0-9]{1,4}:([a-f0-9]{0,4}:){1,6}[a-f0-9]{1,4}))$',
		        },
		    },
		    
		    messages: {
		    	deleteIpIn: {
		    		required : "Input ip address",
		    		regexp: "Input correct ip",
		        }
		    }
	});
});