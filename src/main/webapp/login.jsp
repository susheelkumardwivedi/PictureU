<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>login page</title>
<style type="text/css">
#loginform {
	width: 500px;
	height: 200px;
	background: cyan;
	margin: 0px auto;
	margin-top: 100px;
}

#loginHeader {
	width: 500px;
	height: 30px;
	background: silver;
	margin: 0px auto;
	margin-top: 100px;
}

#loginFooter {
	width: 500px;
	height: 30px;
	background: silver;
	margin: 0px auto;
	margin-top: 0px;
}
</style>
</head>
<body>
	<div id="loginform">

		<div id="loginHeader">
			<p
				style="width: 200px; margin-left: 40%; margin-top: 5%; color: yellow;">
				<b>Login</b>
			</p>
		</div>
		<form method="post" action="loginservlet">
			&nbsp;&nbsp;&nbsp;<b>UserName:</b> <input name="userName" type="text"
				name="userName" size="40"
				style="width: 200px; margin-left: 4%; margin-top: 4%" required="true"/>
			<hr>
			&nbsp;&nbsp;&nbsp;<b>Password:</b> &nbsp;&nbsp;&nbsp;<input
				name="userPassword" type="password" name="userPassword" size="15"
				style="width: 200px; margin-left: 3%;"  required="true"/>
			<hr>
			<input type="submit"
				style="width: 100px; margin-left: 30%; background: silver;" />
		</form>
		<div id="loginFooter">
			<a href="registeruser.jsp" style="margin-left: 30%;">Create a new
				Account</a>
		</div>
	</div>
</body>

</html>