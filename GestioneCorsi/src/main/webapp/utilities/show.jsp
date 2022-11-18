<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.torino.gestionecorsi.businesscomponent.model.Corso"%>
<%@page
	import="com.torino.gestionecorsi.architecture.dao.CorsoCorsistaDAO"%>
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
			Corsista corsista = (Corsista) session.getAttribute("corsista");
			%>
			<h3>
				Riepilogo dei corsi frequentati da
				<%=corsista.getNome()%>&nbsp;<%=corsista.getCognome()%></h3>
		</header>
		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th class="text-center">Nome</th>
						<th class="text-center">Data Inizio</th>
						<th class="text-center">Data Fine</th>
						<th class="text-center">Costo&nbsp;[&euro;]</th>
						<th class="text-center">Commento</th>
						<th class="text-center">Aula</th>
					</tr>
				</thead>
				<tbody>
					<%
					Corso[] corsi = AdminFacade.getInstance().getCorsiByCorsista(corsista);
					for (int i = 0; i < corsi.length; i++) {
					%>
					<tr>
					<%
						SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
						%>
						<td class="text-center"><%=corsi[i].getNome()%></td>
						<td class="text-center"><%=formato.format(corsi[i].getDataInizio())%></td>
						<td class="text-center"><%=formato.format(corsi[i].getDataFine())%></td>
						<td class="text-center"><%=corsi[i].getCosto()%></td>
						<td class="text-center"><%=corsi[i].getCommento()%></td>
						<td class="text-center"><%=corsi[i].getAula()%></td>
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