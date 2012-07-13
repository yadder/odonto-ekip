<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body>
<div id="msg">
	<h3 class="information">${msg}</h3>
</div>
<div class="cabecalho">
<center>
<br><br><br>
<img src="arquivos/logo_horizontal.png" width="300">
<br><br><br>
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
			<td colspan=2 align="right">
				<input type="submit" name="btn" value="Entrar" />
			</td>
		</tr>
	</table>
</form>

</div>
</body>
</html>