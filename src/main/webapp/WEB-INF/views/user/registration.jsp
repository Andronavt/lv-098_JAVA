<%@ page language="java" contentType="text/html; charset=UTF8"
<<<<<<< HEAD
	pageEncoding="UTF8"%>
=======
        pageEncoding="UTF8"%>
>>>>>>> master
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
</head>
<body>
<<<<<<< HEAD
	<h3 style="color: green" align="center">Registration</h3>

	<script type="text/javascript">
		function doAjaxPost() {
			// get the form values
			var user_name = $('#user_name').val();
			var first_name = $('#first_name').val();
			var last_name = $('#last_name').val();
			var email = $('#email').val();
			var pass = $('#pass').val();
			$.ajax({
				type : "POST",
				url : "user/registration",
				data : "user_name=" + user_name + "&first_name=" + first_name
						+ "&last_name=" + last_name + "&email=" + email
						+ "&pass=" + pass,
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


	<!-- <form action="registration" id="registration" method="post"
		style="text-align: center"> -->
	<table align="center">

		<tr>
			<th>User name:</th>
			<th><input type="text" id="user_name" /></th>
		</tr>

		<tr>
			<th>First name:</th>
			<th><input type="text" id="first_name" /></th>
		</tr>

		<tr>
			<th>Last name:</th>
			<th><input type="text" id="last_name" /></th>
		</tr>

		<tr>
			<th>E-mail:</th>
			<th><input type="text" id="email" /></th>
		</tr>

		<tr>
			<th>Password:</th>
			<th><input type="password" id="pass" /></th>
		</tr>

		<tr>
			<th><input type="button" value="Registration"
				onclick="doAjaxPost()" /></th>
		</tr>
		<tr>
			<td colspan="2"><div id="info" style="color: green;"></div></td>
		</tr>
	</table>
	<!--	</form>  -->
=======
        <h3 style="color: green" align="center">Registration</h3>
>>>>>>> master

        <script type="text/javascript">
                function doAjaxPost() {
                        // get the form values
                        var user_name = $('#user_name').val();
                        var first_name = $('#first_name').val();
                        var last_name = $('#last_name').val();
                        var email = $('#email').val();
                        var pass = $('#pass').val();
                        $.ajax({
                                type : "POST",
                                url : "user/registration",
                                data : "user_name=" + user_name + "&first_name=" + first_name
                                                + "&last_name=" + last_name + "&email=" + email
                                                + "&pass=" + pass,
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


        <table align="center">

                <tr>
                        <th>User name:</th>
                        <th><input type="text" id="user_name" /></th>
                </tr>

                <tr>
                        <th>First name:</th>
                        <th><input type="text" id="first_name" /></th>
                </tr>

                <tr>
                        <th>Last name:</th>
                        <th><input type="text" id="last_name" /></th>
                </tr>

                <tr>
                        <th>E-mail:</th>
                        <th><input type="text" id="email" /></th>
                </tr>

                <tr>
                        <th>Password:</th>
                        <th><input type="password" id="pass" /></th>
                </tr>

                <tr>
                        <th><input type="button" value="Registration"
                                onclick="doAjaxPost()" /></th>
                </tr>
                <tr>
                        <td colspan="2"><div id="info" style="color: green;"></div></td>
                </tr>
        </table>
</body>
</html>