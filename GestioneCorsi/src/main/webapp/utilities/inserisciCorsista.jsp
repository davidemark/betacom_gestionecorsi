
<%@page import="java.util.List"%>
<%@page
	import="com.torino.gestionecorsi.businesscomponent.utilities.Report"%>
<%@page import="com.torino.gestionecorsi.businesscomponent.model.Corso"%>
<%@page
	import="com.torino.gestionecorsi.businesscomponent.facade.AdminFacade"%>
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
<title>Inserisci Corsista</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:include page="../componenti/navbar.jsp" />
	<div class="container">
		<header class="page-header">
			<h3 class="text-center">Inserire i dati per l&lsquo;inserimento
				di un nuovo corsista</h3>
		</header>

		<form
			action="/<%=application.getServletContextName()%>/inserisciCorsista"
			method="post" class="form-horizontal">

			<!-- nome -->
			<div class="form-group">
				<label for="nomecorsista" class="col-sm-2 control-label">Nome
					corsista</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="nomecorsista"
						placeholder="Nome" name="nomecorsista">
				</div>
			</div>

			<div class="form-group">
				<label for="cognomecorsista" class="col-sm-2 control-label">Cognome
					corsista</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="cognomecorsista"
						placeholder="Cognome" name="cognomecorsista">
				</div>
			</div>

			<div class="form-group">
				<label for="codcorso" class="col-sm-2 control-label">Corso</label>
				<div class="col-sm-6">
					<select class="form-control" name="codcorso">
						<%
						List<Corso> corsi = Report.getFactory().getCorsiDisponibili();
						for (Corso corso : corsi) {
						%>
						<option value="<%=corso.getCodcorso()%>"><%=corso.getNome()%></option>
						<%
						}
						%>
					</select>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-6">
					<div class="radio">
						<label> <input type="radio" name="precedentiformativi"
							id="precedentiformativi" value="false" checked> Il
							corsista NON ha precedenti formativi
						</label>
					</div>
					<div class="radio">
						<label> <input type="radio" name="precedentiformativi"
							id="precedentiformativi" value="true"> Il corsista ha
							precedenti formativi
						</label>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-6">
					<button type="submit" class="btn btn-primary">
						Inserisci corsista&nbsp;&nbsp;<span
							class="glyphicon glyphicon-send"></span>
					</button>
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