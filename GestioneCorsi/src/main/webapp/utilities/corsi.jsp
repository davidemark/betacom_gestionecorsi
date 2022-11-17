<%@page import="com.torino.gestionecorsi.businesscomponent.model.Corso"%>
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
<title>Lista Studenti</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:include page="../componenti/navbar.jsp" />

	<div class="container">

		<header class="page-header">
			<h3>Corsisti</h3>
		</header>

		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Data Inizio</th>
						<th>Data Fine</th>
						<th>Costo</th>
						<th>Commenti</th>
						<th>Aula</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<%
					Corso[] c = AdminFacade.getInstance().getCorsi();
					for (int i = 0; i < c.length; i++) {
					%>
					<tr>
						<%
						//Immagine img = ClientFacade.getInstance().findImmagineById(a[i].getIdArticolo());
						%>
						<td><%=c[i].getNome()%></td>
						<td><%=c[i].getDataInizio()%></td>
						<td><%=c[i].getDataFine()%></td>
						<td><%=c[i].getCosto()%></td>
						<td><%=c[i].getCommento()%></td>
						<td><%=c[i].getAula()%></td>
						<td>
							<form
								action="/<%=application.getServletContextName()%>/rimuoviCorso?cod=<%=c[i].getCodcorso()%>"
								method="post">
								<button class="btn btn-danger btn-xs" type="submit">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
							</form>
						</td>
						<%
						}
						%>
					
				</tbody>
			</table>
		</div>
	</div>

	<footer class="footer"><%@ include
			file="../componenti/footer.html"%></footer>
</body>
</html>
<%
} else {
response.sendRedirect("login.jsp");
}
%>