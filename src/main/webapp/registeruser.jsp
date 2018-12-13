<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Register User</title>
<style type="text/css">
#form {
	width: 500px;
	height: 300px;
	background: cyan;
	margin: 0px auto;
	margin-top: 50px;
}

#Header {
	width: 500px;
	height: 30px;
	background: silver;
	margin: 0px auto;
	margin-top: 100px;
}

#Footer {
	width: 500px;
	height: 30px;
	background: silver;
	margin: 0px auto;
	margin-top: 0px;
}
</style>
</head>
<body>
	<div id="form">
		<div id="Header">
			<p style="margin-left: 15%;">Please Provide All Neccessary(*)
				Information</p>
		</div>
		<form action="registerThisUser" method="post">
			&nbsp;&nbsp;&nbsp;FirstName* <input name="firstName" type="text"
				size="15" style="margin-left: 5%; width: 40%; margin-top: 3%;" required="true"/>
			<hr>
			&nbsp;&nbsp;&nbsp;MiddleName <input name="middleName" type="text"
				size="15" style="margin-left: 3%; width: 40%;" />
			<hr>
			&nbsp;&nbsp;&nbsp;LastName <input name="lastName" type="text"
				size="15" style="margin-left: 6%; width: 40%;" />
			<hr>
			&nbsp;&nbsp;&nbsp;Email* <input name="email" type="text" size="40"
				style="margin-left: 10%; width: 50%;" />
			<hr>
			&nbsp;&nbsp;&nbsp;Password <input name="password" type="password"
				size="20" style="margin-left: 7%; width: 50%" />
			<hr>
			<input type="submit"
				style="margin-left: 15%; width: 25%; margin-top: 3%;" /> <input
				type="reset" size="15" style="margin-left: 5%; width: 25%;" />
		</form>
		<div id="Footer">
			<h5 style="margin-left: 30%; float: inherit;">Email is Your User
				Id</h5>
		</div>
	</div>
</body>
</html>
