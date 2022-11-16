<%
if (session.getAttribute("nomeadmin") != null && session.getAttribute("cognomeadmin")!=null) {
	session.invalidate();
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../CDN/CDN.html"%>
<meta charset="ISO-8859-1">
<title>Logout</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:include page="../componenti/navbar.jsp" />
	<div class="container">
		<header class="page-header">
			<h3>Logout</h3>
		</header>
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h3>Hai appena effettuato il logout</h3>
			</div>
			<div class="panel-body">
				<p>Per procedere con la gestione dei corsi accedere di nuovo</p>
				<p>
					<a href="login.jsp">Login</a>
				</p>
			</div>
		</div>
	</div>
		<footer><%@ include file="../componenti/footer.html"%></footer>
</body>
</html>
<%
} else {
	response.sendRedirect("accessonegato.jsp");
}
%>