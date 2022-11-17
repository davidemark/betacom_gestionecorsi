<%@page
	import="com.torino.gestionecorsi.businesscomponent.model.Corsista"%>
<%@page
	import="com.torino.gestionecorsi.businesscomponent.facade.AdminFacade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../CDN/CDN.html"%>
<meta charset="ISO-8859-1">
<title>Dettaglio corsista</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:include page="../componenti/navbar.jsp" />
	<div class="container">

		<header class="page-header">
		<%
		Corsista corsista = (Corsista)session.getAttribute("corsista");
		%>
			<h3>
				Riepilogo dei corsi frequentati da
				<%=corsista.getNome()%></h3>
		</header>

	</div>
	<footer><%@ include file="../componenti/footer.html"%></footer>
</body>
</html>