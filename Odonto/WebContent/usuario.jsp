<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de usuário</title>
</head>
<body>
<div class="header">
	<h3>${msg}</h3>
</div>
<form name="formFace" method="post" action="ServletUsuario">
	<table>
		<tr>
			<td align="right">Nome:</td>
			<td><input type="text" name="nomeFace" value="${usuario.nomeUsuario}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Login:</td>
			<td><input type="text" name="nomeFace" value="${usuario.loginUsuario}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Senha:</td>
			<td><input type="text" name="nomeFace" value="${usuario.senhaUsuario}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">RG:</td>
			<td><input type="text" name="nomeFace" value="${usuario.rgUsuario}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">CPF:</td>
			<td><input type="text" name="nomeFace" value="${usuario.cpfUsuario}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Data nasc.:</td>
			<td><input type="text" name="nomeFace" value="${usuario.dataNascimentoUsuario}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Sexo:</td>
			<td><input type="text" name="nomeFace" value="${usuario.sexoUsuario}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Perfil:</td>
			<td>
				<select name="perfilUsuario">
					<option value="${usuario.perfilUsuario }">DENTISTA</option>
					<option value="${usuario.perfilUsuario }">PACIENTE</option>
					<option value="${usuario.perfilUsuario }">RECEPCIONISTA</option>			
				</select>
			</td>
		</tr>
		<tr>
			<td colspan=2 align="center">
				<input type="submit" name="btn" value="Pesquisar" />
				<input type="submit" name="btn" value="Cadastrar" />
				<input type="submit" name="btn" value="Voltar" />
			</td>
		</tr>
	</table>
</form>	
</body>
</html>