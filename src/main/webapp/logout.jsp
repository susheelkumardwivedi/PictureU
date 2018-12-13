<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>logout Page</title>
</head>
<body>
	<%
		session = request.getSession();
		session.invalidate();
		response.sendRedirect("login.jsp");
	%>
</body>
</html>
