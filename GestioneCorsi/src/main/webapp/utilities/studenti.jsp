<%@page
	import="com.torino.gestionecorsi.businesscomponent.facade.AdminFacade"%>
<%@page
	import="com.torino.gestionecorsi.businesscomponent.model.Corsista"%>
<%
if (session.getAttribute("nomeadmin") != null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
Cookie nomeadmin = new Cookie("nomeadmin", (String) session.getAttribute("nomeadmin"));
Cookie cognomeadmin = new Cookie("cognomeadmin", (String) session.getAttribute("cognomeadmin"));
Cookie codadmin = new Cookie("codadmin", (String) session.getAttribute("codadmin"));

//nomeadmin.setMaxAge(60*60*10); 
//cognomeadmin.setMaxAge(60*60*10);
//codadmin.setMaxAge(60*60*10);

// Add both the cookies in the response header.
response.addCookie(nomeadmin);
response.addCookie(cognomeadmin);
response.addCookie(codadmin);
%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../CDN/CDN.html"%>
<meta charset="ISO-8859-1">
<title>Lista corsisti</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:include page="../componenti/navbar.jsp" />

	<div class="container">

		<header class="page-header">
			<h3 class="text-center">Lista dei corsisti</h3>
		</header>

		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th class="text-center">Corsista</th>
						<th class="text-center">Precedenti Formativi</th>
					</tr>
				</thead>
				<tbody>
					<%
					Corsista[] c = AdminFacade.getInstance().getCorsisti();
					for (int i = 0; i < c.length; i++) {
					%>
					<tr>
						<%
						//Immagine img = ClientFacade.getInstance().findImmagineById(a[i].getIdArticolo());
						%>
						<td class="text-center"><form action="/GestioneCorsi/show"
								method="post">
								<input type="hidden" name="codcorsista"
									value="<%=c[i].getCodcorsista()%>">
								<button type="submit"><%=c[i].getNome()%>
									<%=c[i].getCognome()%></button>
							</form></td>
						<td class="text-center">
							<%
							if (c[i].isPrecedentiformativi()) {
							%>&#10003;<%
							} else {
							%>&#10060;<%
							}
							%>
						</td>
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