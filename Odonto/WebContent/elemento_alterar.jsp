<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alteração de elemento</title>
</head>
<body>
<div class="header">
	<h3>${msg}</h3>
</div>
<form name="formElemento" method="post" action="ServletElemento">
	<table>
		<tr>
			<td align="right">Nome do elemento:</td>
			<td><input type="text" name="nomeElemento" value="${elemento.nomeElemento}" size="20" maxlength="2" /></td>
		</tr>
		<tr>
			<td colspan=2 align="center">
				<input type="submit" name="btn" value="Excluir" />
				<input type="submit" name="btn" value="Alterar" />
				<input type="submit" name="btn" value="Voltar" />
			</td>
		</tr>
	</table>
</form>	
</body>
</html>