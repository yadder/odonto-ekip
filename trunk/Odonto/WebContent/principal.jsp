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
<div id="msg">
	<h3 class="information">${msg}</h3>
</div>
<div class="pagina">	
	<h6><font color="red">INCOMPLETAS<br/> </font></h6>
	<a href="inqueritoOdontologico.jsp">Inquérito odontológico</a><br/>
	<a href="pagamento.jsp">Efetuar pagamento</a><br/>
	<a href="ServletPrincipal?acao=agendar_consulta">Agendar consulta</a><br/>
</div>	
<c:import url="rodape.jsp" />	
</body>
</html>