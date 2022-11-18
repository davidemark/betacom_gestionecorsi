<%@page
	import="com.torino.gestionecorsi.businesscomponent.facade.AdminFacade"%>
<%@page
	import="com.torino.gestionecorsi.businesscomponent.model.Corsista"%>
<%
if (session.getAttribute("nomeadmin") != null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../CDN/CDN.html"%>
<meta charset="ISO-8859-1">
<title>Riepilogo dati corsista</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:include page="../componenti/navbar.jsp" />

	<div class="container">

		<header class="page-header">
			<h3>Corsista inserito con successo</h3>
		</header>

		<form class="form-horizontal">


			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Nome Corsista</label>
				<div class="col-sm-3">
					<p class="form-control"></p>
				</div>
			</div>

	
			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Cognome Corsista</label>
				<div class="col-sm-3">
					<p class="form-control">></p>
				</div>
			</div>


			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Nome Corso</label>
				<div class="col-sm-3">
					<p class="form-control"></p>
				</div>
			</div>


			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Data Inizio</label>
				<div class="col-sm-3">
					<p class="form-control"></p>
				</div>
			</div>

			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Data Fine</label>
				<div class="col-sm-3">
					<p class="form-control"></p>
				</div>
			</div>


			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Commenti</label>
				<div class="col-sm-3">
					<p class="form-control"></p>
				</div>
			</div>


			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Precedenti formativi</label>
				<div class="col-sm-3">
					<p class="form-control"></p>
				</div>
			</div>
			
	
			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Aula corso</label>
				<div class="col-sm-3">
					<p class="form-control"></p>
				</div>
			</div>
	
			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Docente</label>
				<div class="col-sm-3">
					<p class="form-control"></p>
				</div>
			</div>
		</form>

	</div>
	<footer><%@ include file="../componenti/footer.html"%></footer>
</body>
</html>
<%
} else {
response.sendRedirect("login.jsp");
}
%>