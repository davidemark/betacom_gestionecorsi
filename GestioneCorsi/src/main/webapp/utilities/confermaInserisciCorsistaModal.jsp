
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="modal fade" id="#confermaModal" role="dialog">
	<div class="modal-dialog modal-md">
		<form
			action="/<%=application.getServletContextName()%>/inserisciCorsista"
			method="post">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Riepilogo Inserimento</h4>
				</div>
				<div class="modal-body">

					<input type="hidden" name="codcorso" value="" /> <input
						type="hidden" name="codcorsista" value="" />

					<div class="form-group">
						<label for="nomecorsista" class="col-sm-2 control-label">Nome
							corsista</label>
						<div class="col-sm-6">
							<p>Prova</p>
						</div>
					</div>

					<div class="form-group">
						<label for="nomecorsista" class="col-sm-2 control-label">Cognome
							corsista</label>
						<div class="col-sm-6">
							<p>Prova</p>
						</div>
					</div>

					<div class="form-group">
						<label for="nomecorsista" class="col-sm-2 control-label">Data
							Inizio</label>
						<div class="col-sm-6">
							<p>Prova</p>
						</div>
					</div>

					<div class="form-group">
						<label for="nomecorsista" class="col-sm-2 control-label">Data
							Fine</label>
						<div class="col-sm-6">
							<p>Prova</p>
						</div>
					</div>

					<div class="form-group">
						<label for="nomecorsista" class="col-sm-2 control-label">Commenti</label>
						<div class="col-sm-6">
							<p>Prova</p>
						</div>
					</div>

					<div class="form-group">
						<label for="nomecorsista" class="col-sm-2 control-label">Precedenti
							formativi</label>
						<div class="col-sm-6">
							<p>Prova</p>
						</div>
					</div>

					<div class="form-group">
						<label for="nomecorsista" class="col-sm-2 control-label">Aula</label>
						<div class="col-sm-6">
							<p>Prova</p>
						</div>
					</div>

					<div class="form-group">
						<label for="nomecorsista" class="col-sm-2 control-label">Docente</label>
						<div class="col-sm-6">
							<p>Prova</p>
						</div>
					</div>

				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-success btn-lg">Conferma</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Annulla</button>
				</div>
			</div>
		</form>
	</div>
</div>