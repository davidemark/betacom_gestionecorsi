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