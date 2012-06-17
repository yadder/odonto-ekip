<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h3>${msg}</h3>
<form name="formLogin" method="post" action="ServletLogin">
	<table>
		<tr>
			<td>Login:</td>
			<td><input type="text" name="login" size="20" /></td>
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