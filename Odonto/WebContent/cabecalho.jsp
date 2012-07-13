<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body>
<div class="cabecalho">	
<div id="menu">
	<img src="arquivos/logo_horizontal.png" width="300">
<ul class="navbar">
	<li><a href="principal.jsp"><b>Home</b></a></li>
	<li><a href="#"><b>Cadastro</b></a>
		<ul>
			<li><a href="face.jsp">Face</a></li>
			<li><a href="elemento.jsp">Elemento</a></li>
			<li><a href="recepcionista.jsp">Recepcionista</a></li>
			<li><a href="dentista.jsp">Dentista</a></li>
			<li><a href="paciente.jsp">Paciente</a></li>
			<li><a href="convenio.jsp">Convenio</a></li>
			<li><a href="fornecedor.jsp">Fornecedor</a></li>
			<li><a href="procedimento.jsp">Procedimento</a></li>
			<li><a href="acesso.jsp">Acesso</a></li>
		</ul>
	</li>
	<li><a href="#"><b>Consulta</b></a>
		<ul>
			<li><a href="#">Agendar consulta</a></li>
			<li><a href="#">Remarcar consulta</a></li>
			<li><a href="#">Cancelar consulta</a></li>
			<li><a href="#">Listar consultas</a></li>
		</ul>
	</li>
	<li><a href="#"><b>Pagamento</b></a>
		<ul>
			<li><a href="#">Efetuar pagamento</a></li>
			<li><a href="#">Consultar pagamento</a></li>
		</ul>
	</li>
	<li><a href="#"><b>Relatórios</b></a>
		<ul>
			<li><a href="#">Emitir atestado médico</a></li>
			<li><a href="#">Emitir receituário</a></li>
			<li><a href="#">Emitir relatório de consultas</a></li>
			<li><a href="#">Emitir relatório de procedimentos</a></li>
			<li><a href="#">Emitir relatório de pagamentos</a></li>
			<li><a href="#">Emitir relatório de odontogramas</a></li>
		</ul>
	</li>
	<li><a href="#"><b>Ajuda</b></a>
		<ul>
			<li><a href="#">Sobre</a></li>
			<li><a href="#">Mapa de navegação</a></li>
		</ul>
	</li>
	<li><a href="ServletPrincipal?acao=logout"><b>Logout</b></a></li>
</ul>
</div>
</div>
<div>
	<font size="2">${msgCabecalho} ${usuarioLogado.nomeUsuario}</font>
</div>

</body>
</html>