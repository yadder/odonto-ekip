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
<h1>:: Mapa de navegação</h1>
<div id="msg">
	<h5 class="information">${msg}</h5>
	<h5 class="error">${msgE}</h5>
</div>

<img src="arquivos/mapa_nevegacao_dentista.png" width="1000" height="1000"/>
<br />
<img src="arquivos/mapa_nevegacao_recepcionista.png" width="1000" height="1000"/>
<br />
<img src="arquivos/mapa_nevegacao_paciente.png" width="1000" height="1000"/>

</fieldset>
<c:import url="cabecalho.jsp"/>
</body>
</html>