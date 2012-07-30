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
<div id="msg">
	<h5 class="information">${msg}</h5>
	<h5 class="error">${msgE}</h5>
</div>

<h1 align="center">Sistema OdontoEkip </h1>
Sistema desenvolvido por:<br />	
 - Josué Freitas <br />
 - Nilo Junior <br />
 - Vanair Rocha <br />

<br />
<h4>O sistema tem a finalizade de controlar o cadastro de pacientes, fornecedores,
consultas, atendimento, odontograma, pagamentos e etc aumentando a velocidade de acesso
a informação e redução de custos, alem de um melhor gerenciamento da clínica. <br />
</h4>

</fieldset>
<c:import url="cabecalho.jsp"/>
<c:import url="rodape.jsp" />
</body>
</html>