<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<title>Lista Corsi</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:include page="../componenti/navbar.jsp" />

	<div class="container">

		<header class="page-header">
			<h3 class="text-center">Lista dei corsi</h3>
		</header>

		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th class="text-center">Nome</th>
						<th class="text-center">Data Inizio</th>
						<th class="text-center">Data Fine</th>
						<th class="text-center">Costo&nbsp;[&euro;]</th>
						<th class="text-center">Commenti</th>
						<th class="text-center">Aula</th>
						<th class="text-center">&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<%
					Corso[] c = AdminFacade.getInstance().getCorsi();
					Date oggi = new Date();
					for (int i = 0; i < c.length; i++) {
						if(oggi.getTime()>c[i].getDataFine().getTime()){
							
						
					%>
					<tr>
						<%
						SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
						%>
						<td class="text-center"><%=c[i].getNome()%></td>
						<td class="text-center"><%=formato.format(c[i].getDataInizio())%></td>
						<td class="text-center"><%=formato.format(c[i].getDataFine())%></td>
						<td class="text-center"><%=c[i].getCosto()%></td>
						<td class="text-center"><%=c[i].getCommento()%></td>
						<td class="text-center"><%=c[i].getAula()%></td>
						<td class="text-center">
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