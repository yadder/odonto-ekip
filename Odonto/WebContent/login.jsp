<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body bgcolor="#3366FF">
<h3>${msg}</h3>
<form name="formLogin" method="post" action="ServletLogin">
	<table>
		<tr>
			<td>CPF:</td>
			<td><input type="text" name="login" size="20" maxlength="14" OnKeyPress="formatar(this, '###.###.###-##')" /></td>
		</tr>
		<tr>
			<td>Senha:</td>
			<td><input type="password" name="senha" size="20" /></td>
		</tr>
		<tr>
			<td colspan=2 align="right"><input type="submit" value="Entrar" /></td>
		</tr>
	</table>
</form>	
</body>
</html>