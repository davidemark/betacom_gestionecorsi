<%@page import="com.torino.gestionecorsi.businesscomponent.facade.AdminFacade"%>
<%@page import="com.torino.gestionecorsi.businesscomponent.model.Corsista"%>
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
					<th>Cognome</th>
					<th>Precedenti Formativi</th>
					
				</tr>
			</thead>
			<tbody>
				<%
					Corsista[] c = AdminFacade.getInstance().getCorsisti();
				for(int i=0;i<c.length;i++){
				%>
				
				<tr>
					<%
						//Immagine img = ClientFacade.getInstance().findImmagineById(a[i].getIdArticolo());
					%>
					
					
					<td><%=c[i].getNome() %></td>
					<td><%=c[i].getCognome() %></td>
					<td><%if(c[i].isPrecedentiformativi()){%>&#10003;<%}else{%>&#10060;<%}%></td>
					
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	
	</div>
	
</div>

<footer class="footer"><%@ include file="../componenti/footer.html"%></footer>
</body>
</html>
<%
} else {
	response.sendRedirect("login.jsp");
}
%>