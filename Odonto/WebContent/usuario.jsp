<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de usuário</title>
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
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
			<td><input type="text" name="cpfUsuario" value="${usuario.cpfUsuario}" size="20" maxlength="14" OnKeyPress="formatar(this, '###.###.###-##')" /></td>
		</tr>
		<tr>
			<td align="right">Data nasc.:</td>
			<td><input type="text" name="dtNascUsuario" value="${data}" size="20" maxlength="10" OnKeyPress="formatar(this, '##/##/####')" /></td>
		</tr>
		<tr>
			<td align="right">Sexo:</td>
			<td><input type="radio" name="sexoUsuario" value="M" />Masculino
				<input type="radio" name="sexoUsuario" value="F" />Feminino
			</td>
		</tr>
		<tr>
			<td align="right">Perfil:</td>
			<td>
				<select name="perfilUsuario">
					<option> </option>
					<option>DENTISTA</option>
					<option>PACIENTE</option>
					<option>RECEPCIONISTA</option>			
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