<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema OdontoEkip - Principal</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body>
<c:import url="cabecalho.jsp" />
<div id="pricipal" style="background-color: #FFFFFF;">
<div id="msg">
	<h3 class="information">${msg}</h3>
</div>
	
	<h4><font color="red">I N C O M P L E T A S <br/> </font></h4>
	<a href="inqueritoOdontologico.jsp">Inquérito odontológico</a><br/>
	<a href="pagamento.jsp">Efetuar pagamento</a><br/>
	<a href="ServletPrincipal?acao=agendar_consulta">Agendar consulta</a><br/>
	<hr/>
	<h2><font color="blue">C R U D _ F U N C I O N A N D O <br/></font></h2>
	<a href="face.jsp">Cadastro de face</a><br/>
	<a href="elemento.jsp">Cadastro de elemento</a><br/>
	<a href="recepcionista.jsp">Cadastro de recepcionista</a><br/>
	<a href="dentista.jsp">Cadastro de dentista</a><br/>
	<a href="paciente.jsp">Cadastro de paciente</a><br/>
	<a href="convenio.jsp">Cadastro de convênio</a><br/>
	<a href="fornecedor.jsp">Cadastro de fornecedor</a> <br/>
	<a href="procedimento.jsp">Cadastro de procedimento</a> <br/>
	<a href="acesso.jsp">Cadastro de acesso</a> <br/>
	
</div>	
<c:import url="rodape.jsp" />	
</body>
</html>