<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand"
				href="/<%=application.getServletContextName()%>/index.jsp">Gestione
				Corsi</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<%
			String nomeadmin = (String) session.getAttribute("nomeadmin");
			if (nomeadmin == null) {
			%>
			<ul class="nav navbar-nav">
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/GestioneCorsi/utilities/login.jsp"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
			<%
			} else {
			%>

			<ul class="nav navbar-nav">
				<li><a href="/GestioneCorsi/utilities/inserisciCorsista.jsp"><span class="glyphicon glyphicon-user"></span>
						Inserisci Corsista</a></li>
				<li><a href="/GestioneCorsi/utilities/studenti.jsp"><span
						class="glyphicon glyphicon-shopping-cart"></span> Lista Corsisti</a></li>
				<li><a href="#"><span
						class="glyphicon glyphicon-shopping-cart"></span> Visualizza
						Statistiche</a></li>
				<li><a href="/GestioneCorsi/utilities/corsi.jsp"><span
						class="glyphicon glyphicon-trash"></span> Elimina Corsi</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						<%=nomeadmin%></a></li>
				<li><a href="/GestioneCorsi/utilities/logout.jsp"><span
						class="glyphicon glyphicon-off"></span> Logout</a></li>
			</ul>

			<%
			}
			%>
		</div>
	</div>
</nav>