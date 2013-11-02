<!DOCTYPE html>
<html>
<body>
	<h3 style="color: green" align="center">Registration</h3>

	<script type="text/javascript">
		function doAjaxPost() {
			// get the form values
			var user_name = $('#user_name').val();
			var first_name = $('#first_name').val();
			var last_name = $('#last_name').val();
			var email = $('#email').val();
			var password = $('#password').val();
			$.ajax({
				type : "POST",
				url : "user/registration",
				data : "user_name=" + user_name + "&first_name=" + first_name
						+ "&last_name=" + last_name + "&email=" + email
						+ "&password=" + password,
				success : function(response) {
					// we have the response
					$('#info').html(response);
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		}
	</script>


	<form action="registration" id="registration" method="post"
		style="text-align: center">
		<table align="center">

			<tr>
				<th>User name:</th>
				<th><input type="text" name="user_name" /></th>
			</tr>

			<tr>
				<th>First name:</th>
				<th><input type="text" name="first_name" /></th>
			</tr>

			<tr>
				<th>Last name:</th>
				<th><input type="text" name="last_name" /></th>
			</tr>

			<tr>
				<th>E-mail:</th>
				<th><input type="text" name="email" /></th>
			</tr>

			<tr>
				<th>Password:</th>
				<th><input type="password" name="pass" /></th>
			</tr>

			<tr>
				<th><input type="button" value="Registration"
					onclick="doAjaxPost()" /></th>
			</tr>
			<tr>
				<td colspan="2"><div id="info" style="color: green;"></div></td>
			</tr>
		</table>
	</form>

</body>
</html>