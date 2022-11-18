
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
	<div class="container">

		<header class="page-header">
			<h3 class="text-center">Benvenuto! <%=session.getAttribute("nomeadmin") %></h3>
		</header>

	</div>
	<footer><%@ include file="../componenti/footer.html"%></footer>
</body>
</html>
<%
} else {
response.sendRedirect("utilities/login.jsp");
}
%>