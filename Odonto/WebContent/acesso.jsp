<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de acessos</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body>
<c:import url="cabecalho.jsp" />
<div id="pricipal" style="background-color: #FFFFFF;">
<div id="msg">
	<h3 class="information">${msg}</h3>
</div>
<form name="formCadastroAcesso" method="post" action="ServletAcesso">
	<table>
		<tr>
			<td align="right">Descri��o do acesso:</td>
			<td><input type="text" name="descricaoAcesso" value="${acesso.descricaoAcesso}" size="20"/><input type="submit" name="btn" value="Pesquisar"/></td>
		</tr>
		<tr>
			<td colspan=2 align="center">
				<input type="submit" name="btn" value="Cadastrar" />
				<input type="submit" name="btn" value="Voltar" />
			</td>
		</tr>
	</table>
</form>

</div>
<c:import url="rodape.jsp" />
</body>
</html>