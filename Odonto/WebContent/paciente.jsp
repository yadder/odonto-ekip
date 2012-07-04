<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de paciente</title>
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body>
<div class="header">
	<h3>${msg}</h3>
</div>
<form name="formPaciente" method="post" action="ServletPaciente">
	<table>
		<tr>
			<td align="right">Nome:</td>
			<td><input type="text" name="nomePaciente" value="${paciente.nomeUsuario}" size="20" /><input type="submit" name="btn" value="Pesquisar" /></td>
		</tr>
		<tr>
			<td align="right">Rg:</td>
			<td><input type="text" name="rgPaciente" value="${paciente.rgUsuario}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Cpf:</td>
			<td><input type="text" name="cpfPaciente" value="${paciente.cpfUsuario}" size="20" maxlength="14" OnKeyPress="formatar(this, '###.###.###-##')" /></td>
		</tr>
		<tr>
			<td align="right">Data nasc.:</td>
			<td><input type="text" name="dtNascPaciente" value="${data}" size="20" maxlength="10" OnKeyPress="formatar(this, '##/##/####')" /></td>
		</tr>
		<tr>
			<td align="right">Sexo:</td>
			<td><input type="radio" name="sexoPaciente" value="M" />Masculino
				<input type="radio" name="sexoPaciente" value="F" checked="checked" />Feminino
			</td>
		</tr>
		<tr>
			<td align="right">Responsável:</td>
			<td><input type="text" name="responsavelPaciente" value="${paciente.responsavelPaciente}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Logradouro:</td>
			<td><input type="text" name="logradouroPaciente" value="${paciente.logradouroPaciente}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Número:</td>
			<td><input type="text" name="numeroLogradouroPaciente" value="${paciente.numeroLogradouroPaciente}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Complemento:</td>
			<td><input type="text" name="complementoLogradouroPaciente" value="${paciente.complementoLogradouroPaciente}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Bairro:</td>
			<td><input type="text" name="bairroPaciente" value="${paciente.bairroPaciente}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Cidade:</td>
			<td><input type="text" name="cidadePaciente" value="${paciente.cidadePaciente}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Estado:</td>
			<td><input type="text" name="estadoPaciente" value="${paciente.estadoPaciente}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Cep:</td>
			<td><input type="text" name="cepPaciente" value="${paciente.cepPaciente}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">DDD:</td>
			<td><input type="text" name="ddd1Paciente" value="${paciente.ddd1Paciente}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Telefone1:</td>
			<td><input type="text" name="telefone1Paciente" value="${paciente.telefone1Paciente}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">DDD:</td>
			<td><input type="text" name="ddd2Paciente" value="${paciente.ddd2Paciente}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Telefone2:</td>
			<td><input type="text" name="telefone2Paciente" value="${paciente.telefone2Paciente}" size="20" /></td>
		</tr>
		<tr>
			<td colspan=2 align="center">
				
				<input type="submit" name="btn" value="Cadastrar" />
				<input type="submit" name="btn" value="Voltar" />
			</td>
		</tr>
	</table>
</form>	
</body>
</html>