<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="com.torino.gestionecorsi.businesscomponent.model.Docente"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="com.torino.gestionecorsi.businesscomponent.model.Corso"%>
<%@page
	import="com.torino.gestionecorsi.businesscomponent.utilities.Report"%>
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
<title>Riepilogo dati</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:include page="../componenti/navbar.jsp" />

	<div class="container">

		<header class="page-header">
			<h3>Riepilogo dati</h3>
		</header>

		<form class="form-horizontal">

			<%
			int numerocorsisti = Report.getFactory().getNumeroCorsisti();
			%>
			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Numero
					corsisti</label>
				<div class="col-sm-3">
					<p class="form-control"><%=numerocorsisti%></p>
				</div>
			</div>

			<%
			Corso cpop = Report.getFactory().getCorsoPopolare();
			%>
			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Corso
					pi&ugrave; frequentato</label>
				<div class="col-sm-3">
					<p class="form-control"><%=cpop.getNome() %></p>
				</div>
			</div>

			<%
			Date inizio = Report.getFactory().getInizioUltimoCorso();
			SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
			%>
			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Inizio</label>
				<div class="col-sm-3">
					<p class="form-control"><%= formato.format(inizio) %></p>
				</div>
			</div>

			<%
			int duratamedia = Report.getFactory().getDurataMediaCorsi();
			%>
			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Durata
					media</label>
				<div class="col-sm-3">
					<p class="form-control"><%=duratamedia %></p>
				</div>
			</div>

			<%
			int ncommenti = Report.getFactory().getCommenti();
			%>
			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Numero
					commenti</label>
				<div class="col-sm-3">
					<p class="form-control"><%=ncommenti %></p>
				</div>
			</div>

			<%
			Docente docentepop = Report.getFactory().getDocentePopolare();
			%>
			<div class="form-group">
				<label for="nomecorsista" class="col-sm-4 control-label">Docente
					con pi&ugrave; corsi</label>
				<div class="col-sm-3">
					<p class="form-control"><%=docentepop.getNome() %> <%=docentepop.getCognome() %></p>
				</div>
			</div>
		</form>


		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr class="success">
						<th class="text-center">Corsisti</th>
					</tr>
				</thead>
				<tbody>
					<%
					Corsista[] c = AdminFacade.getInstance().getCorsisti();
					for (int i = 0; i < c.length; i++) {
					%>
					<tr>
						<td class="text-center"><form action="/GestioneCorsi/show"
								method="post">
								<input type="hidden" name="codcorsista"
									value="<%=c[i].getCodcorsista()%>">
								<button type="submit"><%=c[i].getNome()%>
									<%=c[i].getCognome()%></button>
							</form></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>

		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr class="danger">
						<th class="text-center">Corsi disponibili</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<Corso> corsi = Report.getFactory().getCorsiDisponibili();
					for (Corso corso : corsi) {
					%>
					<tr>
						<td class="text-center"><%=corso.getNome()%></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>


	</div>
	<footer><%@ include file="../componenti/footer.html"%></footer>
</body>
</html>
<%
} else {
response.sendRedirect("login.jsp");
}
%>