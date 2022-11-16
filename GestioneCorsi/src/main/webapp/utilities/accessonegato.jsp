<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../CDN/CDN.html" %>
<meta charset="ISO-8859-1">
<title>Accesso negato</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="../componenti/navbar.jsp"/>
<div class="container">


    <header class="page-header">
        <h3>Accesso negato a questa pagina</h3>
    </header>

    <div class="panel panel-danger">
        <div class="panel-heading">
            <h3>Risorsa non disponibile</h3>
        </div>
        <div class="panel-body">
            <p>Effettuare la registrazione</p>
            <p><a href="registra.jsp">Sign-up</a>
            <p>Se sei registrato effetua l'accesso</p>
            <p><a href="login.jsp">Login</a>
        </div>

    </div>
</div>

<footer><%@ include file="../componenti/footer.html" %></footer>
</body>
</html>