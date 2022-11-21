<%@page
	import="com.torino.gestionecorsi.businesscomponent.model.Docente"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.torino.gestionecorsi.businesscomponent.model.Corso"%>
<%@page
	import="com.torino.gestionecorsi.businesscomponent.facade.AdminFacade"%>
<%@page
	import="com.torino.gestionecorsi.businesscomponent.model.Corsista"%>
<%
//if (session.getAttribute("nomeadmin") != null) {
Cookie[] ck = request.getCookies();
Boolean flag = false;
for (int j = 0; j < ck.length && !flag; j++) {
	flag = ck[j].getName().equals("nomeadmin") || ck[j].getName().equals("cognomeadmin");
}
for (int i = 0; i < ck.length && flag; i++) {
	if (ck[i].getName().equals("nomeadmin") || ck[i].getName().equals("cognomeadmin")) {
		flag = ck[i].getValue() != null && !ck[i].getValue().equals("");
	}
}
if (flag) {
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

		<%
		Corsista corsista = (Corsista) session.getAttribute("corsista");
		%>

		<form class="form-horizontal">


			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Nome
					Corsista</label>
				<div class="col-sm-3">
					<p class="form-control"><%=corsista.getNome()%></p>
				</div>
			</div>


			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Cognome
					Corsista</label>
				<div class="col-sm-3">
					<p class="form-control"><%=corsista.getCognome()%></p>
				</div>
			</div>

			<%
			long codcorso = (Long) session.getAttribute("codcorso");
			Corso corso = AdminFacade.getInstance().findCorsoByCod(codcorso);
			%>
			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Nome
					Corso</label>
				<div class="col-sm-3">
					<p class="form-control"><%=corso.getNome()%></p>
				</div>
			</div>
			<%
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			%>

			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Data
					Inizio</label>
				<div class="col-sm-3">
					<p class="form-control"><%=format.format(corso.getDataInizio())%></p>
				</div>
			</div>

			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Data
					Fine</label>
				<div class="col-sm-3">
					<p class="form-control"><%=format.format(corso.getDataFine())%></p>
				</div>
			</div>


			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Commenti</label>
				<div class="col-sm-3">
					<p class="form-control"><%=corso.getCommento() != null ? corso.getCommento() : "nessun commento"%></p>
				</div>
			</div>


			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Precedenti
					formativi</label>
				<div class="col-sm-3">
					<p class="form-control"><%=corsista.isPrecedentiformativi() ? "Ha precedenti" : "nNon ha precedenti"%></p>
				</div>
			</div>


			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Aula
					corso</label>
				<div class="col-sm-3">
					<p class="form-control"><%=corso.getAula()%></p>
				</div>
			</div>
			<%
			Docente docente = AdminFacade.getInstance().findDocenteByCod(corso.getCoddocente());
			%>
			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Docente</label>
				<div class="col-sm-3">
					<p class="form-control"><%=docente.getNome()%></p>
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