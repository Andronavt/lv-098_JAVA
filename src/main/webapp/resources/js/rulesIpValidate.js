$(document).ready(function() {
	$("#ipAddForm").validate({
		 rules: {
			 
		        login: {
		            regexp: '\b\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}\b'
		        },
		    },
		    
		    messages: {
		        login: {
		            regexp: '����� ����� �������� ������ �� ��������� ����, ���� � ����� �������������'
		        }
		    }
	});
});