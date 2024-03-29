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
					<li><a href="pesquisar_paciente_inquerito.jsp">Inqu�rito odontol�gico</a></li>
					<li><a href="pesquisar_paciente.jsp">Novo odontograma</a></li>
					<li><a href="pesquisar_paciente_atendimento.jsp">Atendimento paciente</a></li>
				</ul>
			</li>
			<li><a href="#"><b>Gerenciamento</b></a>
				<ul>
					<li><a href="ServletOdontograma?btn=listarProcedimentosPendentes">Listar procedimentos pendentes</a></li>
					<li><a href="ServletPagamento?btn=listarPagamentosVencidosEmAberto">Pagamentos vencidos em aberto</a></li>
				</ul>
			</li>
			<li><a href="#"><b>Pagamento</b></a>
				<ul>
					<li><a href="pesquisar_paciente_gerar_pagamento.jsp">Gerar pagamento</a></li>
					<li><a href="pesquisar_paciente_efetuar_pagamento.jsp">Efetuar pagamento</a></li>
				</ul>
			</li>
			<li>
				<a href="pesquisar_paciente_prescricao.jsp"><b>Prescri��o</b></a>
			</li>
			<li><a href="#"><b>Relat�rios</b></a>
				<ul>
					<li><a href="relatorioConsulta.jsp">Emitir relat�rio de consultas</a></li>												
					<li><a href="relatorioProcedimento.jsp">Emitir relat�rio de procedimentos</a></li>
					<li><a href="relatorioPagamento.jsp">Emitir relat�rio de pagamentos</a></li>
			<!--		<li><a href="relatorioOdontograma.jsp">Emitir relat�rio de odontogramas</a></li>  -->
				</ul>
			</li>
			<li><a href="#"><b>Ajuda</b></a>
				<ul>
					<li><a href="mapa_de_navegacao.jsp">Mapa de navega��o</a></li>
					<li><a href="sobre.jsp">Sobre</a></li>
				</ul>
			</li>
			<li><a href="ServletPrincipal?acao=logout"><b>Logout</b></a></li>
		</ul>
	</div><!-- fim do div navbar -->	 
	
</div> <!-- fim do div cabe�alho -->
<div class="sessao">
		${msgCabecalho} Usu�rio: ${usuarioLogado.nomeUsuario}<br>
</div><!-- fim do div sessao -->

</body>
</html>