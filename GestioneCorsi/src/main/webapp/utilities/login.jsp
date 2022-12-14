<!-- controllo di accesso alla pagina login  -->
<%
//if (session.getAttribute("nomeadmin") != null && session.getAttribute("cognomeadmin") != null) {
//response.sendRedirect("index.jsp");
//} else {
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
	response.sendRedirect("/GestioneCorsi/index.jsp");
} else {
%>
<%
if (session.getAttribute("conto") == null) {
	Integer conto = 5;
	session.setAttribute("conto", conto);
}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../CDN/CDN.html"%>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:include page="../componenti/navbar.jsp" />
	<div class="container center-login">
		<header class="page-header">
			<h3 class="text-center">Inserire i dati per accedere</h3>
		</header>

		<!-- TODO: da sistemare il form action="/<%=application.getServletContextName()%>/controllo"
			method="post" -->
		<!-- nomeadmin -->
		<form action="/<%=application.getServletContextName()%>/controllo"
			method="post" class="form-horizontal" id="loginForm">
			<div class="form-group d-flex-center">
				<label class="col-md-2 control-label">Nome Admin</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span><input type="text"
							name="nomeadmin" placeholder="Nome" class="form-control"
							id="nomeadmin">
					</div>
				</div>
			</div>

			<!-- cognomeadmin -->
			<div class="form-group d-flex-center">
				<label class="col-md-2 control-label">Cognome Admin</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span><input type="text"
							name="cognomeadmin" placeholder="Cognome" class="form-control"
							id="cognomeadmin">
					</div>
				</div>
			</div>

			<!-- codadmin -->
			<div class="form-group d-flex-center">
				<label class="col-md-2 control-label">Codice Admin</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-lock"></i></span><input type="password"
							name="codadmin" placeholder="Codice Amministratore"
							class="form-control" id="codadmin">
					</div>
				</div>
			</div>

			<div class="row d-flex-center">
				<div class="col-md-4 text-center">
					<button type="submit" class="btn btn-primary">
						Login&nbsp;&nbsp;<span class="glyphicon glyphicon-log-in"></span>
					</button>
				</div>
			</div>

		</form>
		<%
		if (!session.getAttribute("conto").equals(5)) {
		%>
		<div class="row d-flex-center ">
			<div class="alert alert-danger col-md-3 custom-alert" role="alert">
				Dati inseriti errati! Tentativi rimasti:<%=session.getAttribute("conto")%></div>
		</div>
		<%
		}
		%>
	</div>

	<footer><%@ include file="../componenti/footer.html"%></footer>
</body>
</html>
<%
}
%>