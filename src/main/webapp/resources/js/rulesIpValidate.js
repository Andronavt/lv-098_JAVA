$(document).ready(function() {

	jQuery.validator.addMethod(
		    'regexp',
		    function(value, element, regexp) {
				  var regex = new RegExp(regexp);
		        return  regex.test(value);
		    },
		    "Please check your input."
		); 
	
	$("#addIpToWL").validate({
		 rules: {
			 addIp: {
				 required : true,
				 regexp: '(^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?){1}\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?){1}\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?){1}\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?){1}){1}|([a-f0-9]{1,4}:([a-f0-9]{1,4}:){1,6}[a-f0-9]{1,4}))$',
		        },
		    },
		    
		    messages: {
		    	addIp: {
		    		required : "Input ip address",
		    		regexp: "Input correct ip address",
		        }
		    }
	});
});