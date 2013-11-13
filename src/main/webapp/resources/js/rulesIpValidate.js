$(document).ready(function() {

	jQuery.validator.addMethod(
		    'regexp',
		    function(value, element, regexp) {
				  var re = new RegExp(regexp);
		        return this.optional(element) || re.test(value);
		    },
		    "Please check your input."
		); 
	
	$("#addIpToWL").validate({
		 rules: {
			 addIp: {
				 required : true,
				 regexp: '(^([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])\.([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])\.([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])\.([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5]))|([a-f0-9]{1,4}:([a-f0-9]{0,4}:){1,6}[a-f0-9]{1,4})$',
		        },
		    },
		    
		    messages: {
		    	addIp: {
		    		required : "Input ip address",
		    		regexp: "Input correct ip",
		        }
		    }
	});
});