<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de face</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body>
<c:import url="cabecalho.jsp" />
<div id="msg">
	<h3 class="information">${msg}</h3>
</div>
<form name="formFace" method="post" action="ServletFace">
	<table>
		<tr>
			<td align="right">Nome da face:</td>
			<td><input type="text" name="nomeFace" value="${face.nomeFace}" size="20" /><input type="submit" name="btn" value="Pesquisar" /></td>
		</tr>
		<tr>
			<td colspan=2 align="center">
				
				<input type="submit" name="btn" value="Cadastrar" />
				<input type="submit" name="btn" value="Voltar" />
			</td>
		</tr>
	</table>
</form>	
<c:import url="rodape.jsp" />
</body>
</html>