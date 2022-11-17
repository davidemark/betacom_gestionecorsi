
<%@page import="com.torino.gestionecorsi.businesscomponent.model.Corso"%>
<%@page
	import="com.torino.gestionecorsi.businesscomponent.facade.AdminFacade"%>
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
<title>Inserisci Corsista</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:include page="../componenti/navbar.jsp" />
	<div class="container">
		<header class="page-header">
			<h3 class="text-center">Inserire i dati per l&lsquo;inserimento
				di un nuovo corsista</h3>
		</header>

		<form
			action="/<%=application.getServletContextName()%>/confermaCorsista"
			method="post" class="form-horizontal">

			<!-- nome -->
			<div class="form-group">
				<label for="nomecorsista" class="col-sm-2 control-label">Nome
					corsista</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="nomecorsista"
						placeholder="Nome" name="nomecorsista">
				</div>
			</div>

			<div class="form-group">
				<label for="cognomecorsista" class="col-sm-2 control-label">Cognome
					corsista</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" id="cognomecorsista"
						placeholder="Cognome" name="cognomecorsista">
				</div>
			</div>

			<div class="form-group">
				<label for="codcorso" class="col-sm-2 control-label">Corso</label>
				<div class="col-sm-6">
					<select class="form-control" name="codcorso">
						<%
						Corso[] c = AdminFacade.getInstance().getCorsi();
						for (int i = 0; i < c.length; i++) {
						%>
						<option value="<%=c[i].getCodcorso()%>"><%=c[i].getNome()%></option>
						<%
						}
						%>
					</select>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-6">
					<div class="radio">
						<label> <input type="radio" name="precedentiformativi"
							id="precedentiformativi1" value="false" checked> Il
							corsista NON ha precedenti formativi
						</label>
					</div>
					<div class="radio">
						<label> <input type="radio" name="precedentiformativi"
							id="precedentiformativi2" value="true"> Il corsista ha
							precedenti formativi
						</label>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-6">
					<button type="submit" class="btn btn-primary" data-toggle="modal"
						data-target="#confermaModal">
						Inserisci corsista&nbsp;&nbsp;<span
							class="glyphicon glyphicon-send"></span>
					</button>
				</div>
			</div>
			
		</form>
	</div>

	<footer><%@ include file="../componenti/footer.html"%></footer>
</body>
</html>
<%
} else {
response.sendRedirect("login.jsp");
}
%>
<jsp:include page="confermaInserisciCorsistaModal.jsp">
	<jsp:param value="" name="id" />
</jsp:include>