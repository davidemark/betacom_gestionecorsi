<%
if (session.getAttribute("nomeadmin") != null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN/CDN.html"%>
<meta charset="ISO-8859-1">
<title>Homepage</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="componenti/navbar.jsp" />
<h1>Benvenuto</h1>
</body>
</html>
<%
} else {
	response.sendRedirect("utilities/login.jsp");
}
%>