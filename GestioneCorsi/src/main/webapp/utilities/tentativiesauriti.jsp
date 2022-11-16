<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../CDN/CDN.html"%>
<meta charset="ISO-8859-1">
<title>Tentativi esauriti</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:include page="../componenti/navbar.jsp" />
	<div class="container">
		<div class="page-header">
			<h3>Hai esaurito i tentativi</h3>
		</div>
		<div class="panel panel-danger">
			<header class="panel-heading">
				<h4>Non puoi pi&ugrave; tentare l&lsquo;accesso</h4>
			</header>
			<div class="panel-body">
				<p>
					Per ripristinare i tentativi:&nbsp; <a href="mailto:admin@admin.it">Contattare
						il supporto tecnico</a>
				<p>
					<input type="button" class="btn btn-default" value="Indietro"
						onclick="window.history.back()" />
				<p>
			</div>
		</div>
	</div>

	<footer><%@ include file="../componenti/footer.html"%></footer>
</body>
</html>