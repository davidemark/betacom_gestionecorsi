<!-- controllo di accesso alla pagina login  -->
<!-- TODO: modificare questo scriplet -->
<%
if (session.getAttribute("admin") != null) {
	response.sendRedirect("acquisti.jsp");
} else if (session.getAttribute("admin") != null) {
	session.getAttribute("admin/admin.jsp");
} else {
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
	<div class="container bg-warning">
		<header class="page-header">
			<h3>Inserire i dati per accedere</h3>
		</header>

		<!-- TODO: da sistemare il form action="/<%=application.getServletContextName()%>/controllo"
			method="post" -->
		<!-- nomeadmin -->
		<form class="form-horizontal">
			<div class="form-group">
				<label class="col-md-1 control-label">Nome Admin</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span><input type="text"
							name="nomeadmin" placeholder="Mario" class="form-control"
							id="nomeadmin">
					</div>
				</div>
			</div>

			<!-- cognomeadmin -->
			<div class="form-group">
				<label class="col-md-1 control-label">Cognome Admin</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span><input type="text"
							name="cognomeadmin" placeholder="Rossi" class="form-control"
							id="cognomeadmin">
					</div>
				</div>
			</div>

			<!-- codadmin -->
			<div class="form-group">
				<label class="col-md-1 control-label">Codice Admin</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-lock"></i></span><input type="password"
							name="codadmin" placeholder="Codice Amministratore"
							class="form-control" id="codadmin">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4 col-md-offset-1">
					<button type="submit" class="btn btn-primary">
						Login&nbsp;&nbsp;<span class="glyphicon glyphicon-log-in"></span>
					</button>
				</div>
			</div>

		</form>
	</div>
	<footer><%@ include file="../componenti/footer.html"%></footer>
</body>
</html>
<%
}
%>