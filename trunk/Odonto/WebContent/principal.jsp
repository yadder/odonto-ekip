<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema OdontoEkip - Principal</title>
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body>
<c:import url="cabecalho.jsp" />
<div id="pricipal" style="background-color: #FFFFFF;">
	<a href="inqueritoOdontologico.jsp">Inquérito odontológico</a><br/><br/>
	<a href="pagamento.jsp">Efetuar pagamento</a><br/><br/>
	
	<hr/>
	testadas e validadas <br/>
	<a href="face.jsp">Cadastro de face</a><br/>
	<a href="elemento.jsp">Cadastro de elemento</a><br/>
	<a href="recepcionista.jsp">Cadastro de recepcionista</a><br/>
	<a href="dentista.jsp">Cadastro de dentista</a><br/>
	<a href="paciente.jsp">Cadastro de paciente</a><br/>
	<a href="convenio.jsp">Cadastro de convênio</a><br/>
	<a href="fornecedor.jsp">Cadastro de fornecedor</a> <br/>
	<a href="procedimento.jsp">Cadastro de procedimento</a> <br/>
	<a href="agendar_consuta.jsp">Agendar consulta</a> <br/>
</div>	
<c:import url="rodape.jsp" />	
</body>
</html>