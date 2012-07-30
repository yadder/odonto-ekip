<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.7.3.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.7.3.custom.min.js"></script>
<script type="text/javascript" src="js/jquery.ui.datepicker-pt-BR.js"></script>
<script>
	$(function() {
		$("#t1").datepicker($.datepicker.regional['pt-BR']);
	});
</script>


</head>
<body>
<fieldset class="pagina">
<h1>:: Alteração de recepcionista</h1>
<div id="msg">
	<h5 class="information">${msg}</h5>
	<h5 class="error">${msgE}</h5>
</div>

<form name="formRecepcionista" method="post" action="ServletRecepcionista">
	<table>
		<tr>
			<td align="right">Nome:</td>
			<td><input type="text" name="nomeUsuario" value="${usuario.nomeUsuario}" size="20" maxlength="50" /></td>
		</tr>
		<tr>
			<td align="right">Rg:</td>
			<td><input type="text" name="rgUsuario" value="${usuario.rgUsuario}" size="20" maxlength="15" /></td>
		</tr>
		<tr>
			<td align="right">Cpf:</td>
			<td><input type="text" name="cpfUsuario" value="${usuario.cpfUsuario}" size="20" maxlength="14" OnKeyPress="formatar(this, '###.###.###-##')" /></td>
		</tr>
		<tr>
			<td align="right">Data nasc.:</td>
			<td><input type="text" id="t1" name="dtNascUsuario" value="${data}" size="20" maxlength="10" OnKeyPress="formatar(this, '##/##/####')"/></td>
		</tr>
		<tr>
			<td align="right">Sexo:</td>
			<td><input type="radio" name="sexoUsuario" value="M" />Masculino
				<input type="radio" name="sexoUsuario" value="F" checked="checked" />Feminino
			</td>
		</tr>
		<tr>
			<td colspan=2 align="center">
				<input type="button" name="btn" value="Excluir" onclick="javascript:confirmarExclusao('ServletRecepcionista?btn=Excluir');"/>
				<input type="submit" name="btn" value="Alterar" />
				<input type="submit" name="btn" value="Voltar" />
			</td>
		</tr>
	</table>
</form>	
</fieldset>
<c:import url="cabecalho.jsp"/>

</body>
</html>