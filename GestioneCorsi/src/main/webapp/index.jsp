
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
<%@ include file="CDN/CDN.html"%>
<meta charset="ISO-8859-1">
<title>Homepage</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:include page="componenti/navbar.jsp" />
	<div class="container">

		<header class="page-header">
			<h3 class="text-center">
				<b>Benvenuto! <%=ck[1].getValue()%></b>
			</h3>
		</header>
		<div class="row">

			<div class="col-md-3">
				<div class="panel panel-primary">
					<div class="panel-heading text-center">
						<strong>Inserisci Corsista</strong>
					</div>
					<div class="panel-body">
						<div>
							<img src="img/inserisci_corsista.jpg" alt="inseriscicorsista">
							<p>Inserisci un nuovo corsista ad un corso tenuto dai nostri
								docenti!</p>
						</div>
					</div>
					<div class="panel-footer">
						<div class="d-flex-end">
							<a href="utilities/inserisciCorsista.jsp" class="btn btn-primary">
								Inserisci Corsista&nbsp;<span class="glyphicon glyphicon-plus"></span>
							</a>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="panel panel-primary">
					<div class="panel-heading text-center">
						<strong>Lista Corsisti</strong>
					</div>
					<div class="panel-body">
						<div>
							<img src="img/lista_corsisti.jpg" alt="listacorsisti">
							<p>Visualizza la lista completa dei corsisti che frequentano
								i nostri corsi!</p>
						</div>
					</div>
					<div class="panel-footer">
						<div class="d-flex-end">
							<a href="utilities/studenti.jsp" class="btn btn-primary">
								Lista Corsisti&nbsp;<span class="glyphicon glyphicon-list-alt"></span>
							</a>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="panel panel-primary">
					<div class="panel-heading text-center">
						<strong>Visualizza Statistiche</strong>
					</div>
					<div class="panel-body">
						<div>
							<img src="img/visualizza_statistiche.jpg"
								alt="visualizzastatistiche">
							<p>Visualizza tutte le statistiche relative</p>
						</div>
					</div>
					<div class="panel-footer">
						<div class="d-flex-end">
							<a href="utilities/riepilogo.jsp" class="btn btn-primary">
								Visualizza statistiche&nbsp;<span
								class="glyphicon glyphicon-search"></span>
							</a>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="panel panel-primary">
					<div class="panel-heading text-center">
						<strong>Elimina Corsi</strong>
					</div>
					<div class="panel-body">
						<div>
							<img src="img/delete.png" alt="delete">
							<p>Elimina i corsi scaduti!</p>
						</div>
					</div>
					<div class="panel-footer">
						<div class="d-flex-end">
							<a href="utilities/corsi.jsp" class="btn btn-primary">
								Elimina Corsi&nbsp;<span class="glyphicon glyphicon-trash"></span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>



	</div>
	<footer><%@ include file="../componenti/footer.html"%></footer>
</body>
</html>
<%
} else {
response.sendRedirect("utilities/login.jsp");
}
%>