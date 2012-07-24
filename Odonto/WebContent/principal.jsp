<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body>
<fieldset class="pagina">
<h1>:: Sistema OdontoEkip</h1>
<div id="msg" >
	<h5 class="information">${msg}</h5>
	<h5 class="error">${msgE}</h5>
</div>

	<h6><font color="red">À fazer:</font></h6>
	<a href=#>Verificação inicial</a><br/>
	<a href=#>Conceder acesso</a><br/>
	<a href=#>Tratar busca de procedimento por procedimento</a><br/>
	
	<h6><font color="red">Melhorias:</font></h6>
	<a href=#>Na tela de consulta, só mostrar horarios disponiveis</a><br/>
	<a href=#>Trocar o campo data por componente calendario</a><br/>
	<a href=#>Fazer validação com jQuery</a><br/>
	
	
	
</fieldset>
<c:import url="cabecalho.jsp" />
<c:import url="rodape.jsp" />	
</body>
</html>