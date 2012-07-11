<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body bgcolor="#D6E0FF">
	<img src="/arquivos/imagem_form.jpg"/>
	<div class="login">
		<font size="2">${msgCabecalho} ${usuarioLogado.nomeUsuario}</font>
		<a href="ServletPrincipal?acao=logout">Logout</a>
	</div>
</body>
</html>