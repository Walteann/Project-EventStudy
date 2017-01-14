<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.*,
    dominio.Evento,
    dados.EventoDao"
     %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Events Students</title>
<link rel="stylesheet" type="text/css" href="_css/estilo.css">
</head>
<body id="bodyIndex">

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

<nav id="MenuTopo2">
	<ul>
	<li><a href="http://localhost8081/EventStudy/index.html"> Menu Principal </a></li>
	<li><a href="http://localhost8081/EventStudy/paginas/paginasEventos.html"> Eventos </a></li>
	<li><a href="http://localhost8081/EventStudy/paginas/cadastro.html"> Cadastrar </a></li>
	<li><a href="http://localhost8081/EventStudy/paginas/paginaLogin.html"> Entrar </a></li>
	
	</ul>
</nav>

</header>
</hgroup>

<div>
<section id="SessaoEventos">



<br><br>


<form method="post" action="filtro.html">

<fieldset>
    <legend><h1>Buscar Curso</h1></legend>
 	<oi4>Nome do Curso:</oi4>
	<input type="text" class="campo" name="BuscarNomeDoCurso" ><br>

   <oi4>Carga Horaria:</oi4> 
   <select name="opcao_filtro_horas" classe="campo" >
      <option value="TodasAsHoras">Todas</option>
      <option value="UmaHoraA2Horas">1h--2h</option>
      <option value="TresHorasA5Horas">3h--5h</option>
      <option value="SeisHorasA8Horas">6h--8h</option>
      <option value="NovaHorasA16Horas">9h--16h</option>
      <option value="Acima16Horas">16h+</option>
   </select>
   <br> <br>
   <oi4>Preço:</oi4>
   <select name="FreeOuPay"  >
      <option value="CursosGratis">Gratis</option>
      <option value="CursosPago">Pago</option>

   </select>
   <br><br>
  
   
   <input type="submit" class="botao" name="Buscar">
   
   </fieldset>
</form>








</section>
</div>

<div>
<aside id="asideSessao">

	<h1><center> Lista de Eventos</center></h1> <br>
	
<table border="1" width="100%">
			
			
			
			<tr>
				<th>Turma</th>
				<th>Carga horaria</th>
				<th>Investimento</th>
				<th>Localização </th>
				<th>Ministrantes </th>
				
				<th></th>
			</tr>

<%
EventoDao cadastro = new EventoDao();
List<Evento> contatos = cadastro.listar();


for(Evento contato :  contatos){
%>

			<tr>
		
				<td><%=contato.getTurma() %></td>
				<td><%=contato.getCargaHoraria() %></td>
				<td><%=contato.getInvestimento() %></td>
				<td><%=contato.getLocalizacao() %></td>
				<td><%=contato.getMinistrante() %></td>
				
				<td> <input type="button" class="botao" onclick="alert('vc Está Escrito teste')" value="Inscreva-se!"></td>
			</tr>
			
			<%
			}
			%>

			
		</table>
		
		
		<br>

<h4>proximo >> </h4>

</aside>
</div>






<footer id="dosEventos" > 
Todos os Direitos Reservados <br>
Walteann, Solon, Kevin, Davi Ad.</footer>


</div>
</body>
</html>