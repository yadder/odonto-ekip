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
	<img src="arquivos/logo_horizontal.png" width="300">
	<div id="barramenu">		
		<ul class="navbar">
			<li><a href="ServletPrincipal?acao=home"><b>Home</b></a></li>
			<li><a href="#"><b>Cadastro</b></a>
				<ul>
					<li><a href="acesso.jsp">Acesso</a></li>
					<li><a href="convenio.jsp">Convenio</a></li>
					<li><a href="dentista.jsp">Dentista</a></li>
					<li><a href="elemento.jsp">Elemento</a></li>
					<li><a href="face.jsp">Face</a></li>
					<li><a href="fornecedor.jsp">Fornecedor</a></li>
					<li><a href="paciente.jsp">Paciente</a></li>
					<li><a href="procedimento.jsp">Procedimento</a></li>
					<li><a href="recepcionista.jsp">Recepcionista</a></li>
				</ul>
			</li>
			<li><a href="#"><b>Consulta</b></a>
				<ul>
					<li><a href="pesquisar_paciente_agendar_consulta.jsp">Agendar consulta</a></li>
					<li><a href="pesquisar_consulta_por_data.jsp">Pesquisar consulta por data</a></li>
					<li><a href="pesquisar_consulta_por_nome.jsp">Pesquisar consulta por paciente</a></li>
					<li><a href="ServletConsulta?btn=listarconsultas">Listar todas as consultas agendadas</a></li>
					
				</ul>
			</li>
			<li><a href="#"><b>Odontograma</b></a>
				<ul>
					<li><a href="pesquisar_paciente_inquerito.jsp">Inquérito odontológico</a></li>
					<li><a href="pesquisar_paciente.jsp">Novo odontograma</a></li>
					<li><a href="#">Atendimento paciente</a></li>
				</ul>
			</li>
			<li><a href="#"><b>Pagamento</b></a>
				<ul>
					<li><a href="#">Consultar pagamento</a></li>
					<li><a href="#">Efetuar pagamento</a></li>
				</ul>
			</li>
			<li>
				<a href="pesquisar_paciente_prescricao.jsp"><b>Prescrição</b></a>
			</li>
			<li><a href="#"><b>Relatórios</b></a>
				<ul>
					<li><a href="#">Emitir atestado médico</a></li>
					<li><a href="#">Emitir receituário</a></li>
					<li><a href="relatorioConsultaStatusPorData.jsp">Emitir consultas por status e data</a></li>												
					<li><a href="relatorioProcedimento.jsp">Emitir relatório de procedimentos</a></li>
					<li><a href="#">Emitir relatório de pagamentos</a></li>
					<li><a href="#">Emitir relatório de odontogramas</a></li>
				</ul>
			</li>
			<li><a href="#"><b>Ajuda</b></a>
				<ul>
					<li><a href="#">Mapa de navegação</a></li>
					<li><a href="#">Sobre</a></li>
				</ul>
			</li>
			<li><a href="ServletPrincipal?acao=logout"><b>Logout</b></a></li>
		</ul>
	</div><!-- fim do div navbar -->	 
	
</div> <!-- fim do div cabeçalho -->
<div class="sessao">
		${msgCabecalho} Usuário: ${usuarioLogado.nomeUsuario}<br>
		Perdidos na sessao: ${perdidosNaSessao}
</div><!-- fim do div sessao -->

</body>
</html>