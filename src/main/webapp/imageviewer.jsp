<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.nagarro.services.ImageServiceProvider"%>
<%@ page import="com.nagarro.model.Image"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${user != null}" > 
<%@ include file="uploadImage.jsp" %>
<table border=1 style="margin: 0px auto">
   <!-- iterate over the collection using forEach loop -->
   <c:forEach var="image" items="${requestScope.imageList}">
       <tr>
       <td width="15%" align="center">${ image.imageName}</td>
       <td width="15%" align="center">${ image.imageSize}Byte</td>
       <td><img src="getimage?id=${image.id}"/></td>
       <td width="15%" align="center"><a href="deleteimage?id=${image.id}">Delete</a></td>
       <td width="15%" align="center"><a href="updateImage.jsp?id=${image.id}">Update</a></td>
       <!-- close row -->
       </tr>
       <!-- close the loop -->
   </c:forEach>
   <!-- close table -->
   </table>
   </c:if>
</body>
</html>