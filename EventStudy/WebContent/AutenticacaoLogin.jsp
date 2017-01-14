
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1" meta="pt-br">
<title>EventStudy</title>
<link rel="stylesheet" type="text/css" href="_css/estilo.css">
<script language="Javascript">
	function Validate() {
		var email = document.frm.email;
		var senha = document.frm.senha;
		if ((email.value == null) || (email.value == "")) {
			alert("Por Favor Informe um Email");
			email.focus();
			return false;
		}
		if ((senha.value == null) || (senha.value == "")) {
			alert("Por Favor Digite Senha");
			senha.focus();
			return false;
		}
		return true;
	}
</script>


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
						<li><a href="http://localhost:8081/EventStudy/index.html">
								Menu Principal </a></li>
						<li><a
							href="http://localhost:8081/EventStudy/paginas/cadastro.html">
								Cadastrar </a></li>
					</ul>
				</nav>

			</header>
		</hgroup>

		<hgroup id="LoginSenha">

			<form action="/LoginAutenticacao" name="frm"  method="post"
				onSubmit="return Validate()">
				<oi>Email</oi>
				<br> <input type="text" class="campo" name="email"><br>
				<oi>Senha</oi>
				<br> <input type="password" class="campo" name="senha"><br>
				<br> <input type="Submit" class="botao" value="Entrar">


				<h5>
					<a href="../paginas/paginaEsqueciSenha.html"> Esqueceu sua
						Senha?</a>
				</h5>

			</form>


		</hgroup>




		<footer>
			Todos os Direitos Reservados <br> Walteann, Solon, Kevin, Davi
			Ad.
		</footer>


	</div>


</body>
</html>