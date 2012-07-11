<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de dentista</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body>
<c:import url="cabecalho.jsp" />
<div id="msg">
	<h3 class="information">${msg}</h3>
</div>
<form name="formDentista" method="post" action="ServletDentista">
	<table>
		<tr>
			<td align="right">Nome:</td>
			<td><input type="text" name="nomeDentista" value="${dentista.nomeUsuario}" size="20" /><input type="submit" name="btn" value="Pesquisar" /></td>
		</tr>
		<tr>
			<td align="right">Rg:</td>
			<td><input type="text" name="rgDentista" value="${dentista.rgUsuario}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Cpf:</td>
			<td><input type="text" name="cpfDentista" value="${dentista.cpfUsuario}" size="20" maxlength="14" OnKeyPress="formatar(this, '###.###.###-##')" /></td>
		</tr>
		<tr>
			<td align="right">Data nasc.:</td>
			<td><input type="text" name="dtNascDentista" value="${data}" size="20" maxlength="10" OnKeyPress="formatar(this, '##/##/####')" /></td>
		</tr>
		<tr>
			<td align="right">Sexo:</td>
			<td><input type="radio" name="sexoDentista" value="M" />Masculino
				<input type="radio" name="sexoDentista" value="F" checked="checked" />Feminino
			</td>
		</tr>
		<tr>
			<td align="right">Cro:</td>
			<td><input type="text" name="croDentista" value="${dentista.croDentista}" size="20" maxlength="20" /></td>
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