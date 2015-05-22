<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<center>
		<br /> <br /> <br />
		<div style="border: 1px solid black; width: 300px; padding-top: 10px;">
			<br /> Please enter your username and password to login ! <br /> <span
				style="color: red">${message}</span> <br />
			<form:form method="post" action="j_spring_security_check"
				modelAttribute="users">
				<table>
					<tr>
						<td>Username:</td>
						<td><form:input id="form_username" class="form_input" path="username" maxlength="13" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><form:input id="form_password" class="form_input" path="password" maxlength="20" type="password"/></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</center>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
		$(".form_input").keydown(function(event) {
			<!-- Prevent space(32) key -->
			if ( event.which == 32) {
				event.preventDefault();
			}
		});
	</script>
</body>
</html>