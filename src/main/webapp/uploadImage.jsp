<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="logout.jsp" style="margin-left: 95%; background: silver;">Logout</a>
	<br>
	<form action="uploadImage" method="post" enctype="multipart/form-data">
		Select your file :<input name="file" type="file"
			style="background-color: cyan; width: 50%; margin-left: 3%;" required="true">
		<input type="submit" value="UPLOAD" />
	</form>
	<br><br>
</body>
</html>