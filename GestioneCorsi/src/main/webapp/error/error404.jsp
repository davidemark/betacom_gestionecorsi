<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../CDN/CDN.html" %>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/<%=application.getServletContextName()%>/css/style.css">
<title>Error 404</title></head>
<body>
<jsp:include page="../componenti/navbar.jsp"/>
<div class="container">
	<div class="page-header">
		<h3>Pagina non trovata</h3>	
	</div>
	<div class="panel panel-danger">
		<header class="panel-heading">
			<h4>Impossibile caricare la risorsa richiesta</h4>
		</header>
	 	<div class="panel-body">
	 		<p>Per segnalare un eventuale problema:&nbsp;
	 		<a href="mailto:admin@admin.it">Contattare il supporto tecnico</a>
			<p>
	 		<input type="button" class="btn btn-default" 
	 		value="Indietro" onclick="window.history.back()" /> 
	 		<p>
	 	</div>
	</div>
</div>
<footer class="footer"><%@ include file="../componenti/footer.html"%></footer>
</body>
</html>
