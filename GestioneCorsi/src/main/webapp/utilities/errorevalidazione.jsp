<%@page import="com.torino.gestionecorsi.architecture.dao.DAOException"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../CDN/CDN.html"%>
<meta charset="ISO-8859-1">
<title>Error Page</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="../componenti/navbar.jsp" />
	<div class="container">
		<header class="page-header">
			<h3>Errore di validazione</h3>
		</header>
		<%
		Boolean checkCorsista = (Boolean)session.getAttribute("checkCorsista");
		Boolean checkCorso = (Boolean)session.getAttribute("checkCorso");
		
		if (checkCorsista !=null && !checkCorsista) {
		%>

		<div class="panel panel-danger">
			<div class="panel-heading">
				<h5>Dati del corsista non validi</h5>
			</div>
			<div class="panel-body">
				<h5>Parametri:</h5>
				<p>Nome: 30 caratteri senza numeri</p>
				<p>Cognome: 30 caratteri senza numeri</p>
				
			</div>
		</div>

		<%
		}if (checkCorso!=null && !checkCorso) {
		%>
		<div class="panel panel-danger">
			<div class="panel-heading">
				<H5>Corso non accettabile</H5>
			</div>
			<div class="panel-body">
				<h5>Controllare che il corso:</h5>
				<p>
					Non sia scaduto</p>
				<p>
					abbia le date valide</p>
				
			</div>
		</div>
		<%
		} 
		%>
		<button onclick="window.history.back()" class="btn btn-default">Indietro</button>
	</div>
	<footer class="footer"><%@ include
			file="../componenti/footer.html"%></footer>
			
			
</body>
</html>
