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
<form name="formUsuario" method="post" action="ServletUsuario">
	<table>
		<tr>
			<td align="right">Nome:</td>
			<td><input type="text" name="nomeUsuario" value="${usuario.nomeUsuario}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Rg:</td>
			<td><input type="text" name="rgUsuario" value="${usuario.rgUsuario}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Cpf:</td>
			<td><input type="text" name="cpfUsuario" value="${usuario.cpfUsuario}" size="20" maxlength="11" /></td>
		</tr>
		<tr>
			<td align="right">Data nasc.:</td>
			<td><input type="text" name="dtNascUsuario" value="${usuario.dataNascimentoUsuario}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Sexo:</td>
			<td><select name="sexoUsuario">
					<option value="${usuario.sexoUsuario}">MASCULINO</option>
					<option value="${usuario.sexoUsuario}">FEMININO</option>
				</select>
			</td>
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