<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de fornecedor</title>
</head>
<body>
<div class="header">
	<h3>${msg}</h3>
</div>
<form name="formFornecedor" method="post" action="ServletFornecedor">
	<table>
		<tr>
			<td align="right">Nome do fornecedor:</td>
			<td><input type="text" name="nomeFornecedor" value="${fornecedor.nomeFornecedor}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Nome do vendedor:</td>
			<td><input type="text" name="rgFornecedor" value="${fornecedor.nomeVendedor}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">E-mail:</td>
			<td><input type="text" name="cpfFornecedor" value="${fornecedor.emailFornecedor}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Site:</td>
			<td><input type="text" name="dtNascFornecedor" value="${fornecedor.siteFornecedor}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Cnpj:</td>
			<td><input type="text" name="dtNascFornecedor" value="${fornecedor.cnpjFornecedor}" size="14" /></td>
		</tr>
		<tr>
			<td align="right">Logradouro:</td>
			<td><input type="text" name="dtNascFornecedor" value="${fornecedor.logradouroFornecedor}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Número:</td>
			<td><input type="text" name="dtNascFornecedor" value="${fornecedor.numeroLogradouroFornecedor}" size="5" /></td>
		</tr>
		<tr>
			<td align="right">Complemento:</td>
			<td><input type="text" name="dtNascFornecedor" value="${fornecedor.complementoLogradouroFornecedor}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Bairro:</td>
			<td><input type="text" name="dtNascFornecedor" value="${fornecedor.bairroFornecedor}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Cidade:</td>
			<td><input type="text" name="dtNascFornecedor" value="${fornecedor.cidadeFornecedor}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Estado:</td>
			<td>
				<select name="sexoFornecedor">
					<option value="${fornecedor.estadoFornecedor}">MASCULINO</option>
					<option value="${fornecedor.estadoFornecedor}">FEMININO</option>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right">Cep:</td>
			<td><input type="text" name="dtNascFornecedor" value="${fornecedor.cepFornecedor}" size="8" /></td>
		</tr>
		<tr>
			<td align="right">Ddd:</td>
			<td><input type="text" name="dtNascFornecedor" value="${fornecedor.dddFornecedor}" size="2" /></td>
		</tr>
		<tr>
			<td align="right">Telefone:</td>
			<td><input type="text" name="dtNascFornecedor" value="${fornecedor.telefoneFornecedor}" size="8" /></td>
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