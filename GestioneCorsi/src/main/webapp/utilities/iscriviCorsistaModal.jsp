
<%@page import="com.torino.gestionecorsi.businesscomponent.utilities.Report"%>
<%@page import="com.torino.gestionecorsi.businesscomponent.model.Corso"%>
<%@page import="java.util.List"%>
<%@page import="com.torino.gestionecorsi.businesscomponent.model.Corsista"%>
<%
Long cod = Long.parseLong(request.getParameter("cod"));
Corsista c = null;
if (request.getParameter("cod") == null) {
	response.sendRedirect("studenti.jsp");
} else {
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div class="modal fade" id="iscriviCorsista_<%=cod%>" role="dialog">
	<div class="modal-dialog modal-md">
		<form
			action="/GestioneCorsi/iscriviCorsista"
			method="post">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">
						Iscrivi Corsista [<%=cod > 0 ? cod : ""%>]
					</h4>
				</div>
				<div class="modal-body">
					<input type="hidden" name="codcorsista" value="<%=cod%>" />
					<select class="form-control" name="codcorso">
						<%
						List<Corso> corsi = Report.getFactory().getCorsiDisponibili();
						for (Corso corso : corsi) {
						%>
						<option value="<%=corso.getCodcorso()%>"><%=corso.getNome()%></option>
						<%
						}
						%>
					</select>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-success btn-lg">Salva
						modifiche</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Annulla</button>
				</div>
			</div>
		</form>
	</div>
</div>
<%
}
%>