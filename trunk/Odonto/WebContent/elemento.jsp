<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de elemento</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body>
<c:import url="cabecalho.jsp" />
<br>
<fieldset>
<center><h1>Cadastro de elementos</h1>
<div id="msg">
	<h3 class="information">${msg}</h3>
</div>

<form name="formElemento" method="post" action="ServletElemento">
	<table>
		<tr>
			<td align="right">Nome do elemento:</td>
			<td><input type="text" name="nomeElemento" value="${elemento.nomeElemento}" size="20" maxlength="2" />
			<a href="ServletElemento?btn=Pesquisar"><img src="arquivos/pesquisar.png" width="25"></a>
			<input type="submit" name="btn" value="Pesquisar" />
			</td>
		</tr>
		<tr>
			<td colspan=2 align="right">
				<br><br>
				<input type="submit" name="btn" value="Cadastrar" />
				<input type="submit" name="btn" value="Voltar" />
			</td>
		</tr>
	</table>
</form>	
</fieldset>
<c:import url="rodape.jsp" />
</body>
</html>