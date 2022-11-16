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
			String username = (String) session.getAttribute("username");
			if (username == null) {
			%>
			<ul class="nav navbar-nav">
			</ul>
			<ul class="nav navbar-nav navbar-right">
			<!-- TODO: correggere path login -->
				<li><a
					href="/<%=application.getServletContextName()%>login.jsp"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
			<%
			} else {
			%>
			<ul class="nav navbar-nav">
				<li><a href="acquisti.jsp"><span
						class="glyphicon glyphicon-user"></span>Scelta articoli</a></li>
				<li><a href="carrello.jsp"><span
						class="glyphicon glyphicon-shopping-cart"></span>Riepilogo
						carrello</a></li>
			</ul>
			<!-- TODO: correggere path logout -->
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span><%=username%></a></li>
				<li><a href="logout.jsp"><span
						class="glyphicon glyphicon-off"></span> Logout</a></li>
			</ul>
			<%
			}
			%>
		</div>
	</div>
</nav>