<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,
    dominio.Usuario,
    dados.UsuarioDao"
     %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Events Students</title>
<link rel="stylesheet" type="text/css" href="_css/estilo.css">
</head>
<body>

<div id="TopoPerfil">

	<header id="LogoMarca">
	<hgroup>  
	<h1>EventStudy</h1>
	<h2>Agende seus Eventos</h2>
	</hgroup>
	</header>
</div>
<div>
<hgroup id="Topo">
<header id="cabecalho">

<nav id="MenuTopo">
	<ul>
	<li><a href="http://localhost8081/EventStudy/index.html"> Menu Principal </a></li>
	<li><a href="http://localhost8081/EventStudy/paginas/cadastro.html"> Cadastrar </a></li>
	</ul>
</nav>

</header>
</hgroup>

<hgroup id="EsqueciSenha">

<%
UsuarioDao vamosConsultar = new UsuarioDao();

Usuario usuario = new Usuario();
%>

<h4><% usuario.getNome(); %></h4>
<h4><% usuario.getEmail(); %></h4>
<h3><% usuario.getSenha(); %></h3>

</hgroup>


<footer> 
Todos os Direitos Reservados <br>
Walteann, Solon, Kevin, Davi Ad.</footer>


</div>
</body></html>