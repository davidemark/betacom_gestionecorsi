<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand"
				href="/GestioneCorsi/index.jsp">Gestione
				Corsi</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<%
			//String nomeadmin = (String) session.getAttribute("nomeadmin");
			//if (nomeadmin == null) {
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
			if (!flag) {
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
				<li><a href="/GestioneCorsi/utilities/inserisciCorsista.jsp"><span
						class="glyphicon glyphicon-plus"></span> Inserisci Corsista</a></li>
				<li><a href="/GestioneCorsi/utilities/studenti.jsp"><span
						class="glyphicon glyphicon-list-alt"></span> Lista Corsisti</a></li>
				<li><a href="/GestioneCorsi/utilities/riepilogo.jsp"><span
						class="glyphicon glyphicon-search"></span> Visualizza Statistiche</a></li>
				<li><a href="/GestioneCorsi/utilities/corsi.jsp"><span
						class="glyphicon glyphicon-trash"></span> Elimina Corsi</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						<%=ck[1].getValue() %></a></li>
				<li><a href="/GestioneCorsi/utilities/logout.jsp"><span
						class="glyphicon glyphicon-off"></span> Logout</a></li>
			</ul>

			<%
			}
			%>
		</div>
	</div>
</nav>