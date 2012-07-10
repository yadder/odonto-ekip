<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de fornecedor</title>
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body>
<div class="header">
	<h3>${msg}</h3>
</div>
<form name="formFornecedor" method="post" action="ServletFornecedor">
	<table>
		<tr>
			<td align="right">Nome do fornecedor:</td>
			<td><input type="text" name="nomeFornecedor" value="${fornecedor.nomeFornecedor}" size="20" /><input type="submit" name="btn" value="Pesquisar" /></td>
		</tr>
		<tr>
			<td align="right">Nome do vendedor:</td>
			<td><input type="text" name="nomeVendedor" value="${fornecedor.nomeVendedor}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">E-mail do vendedor:</td>
			<td><input type="text" name="emailVendedor" value="${fornecedor.emailVendedor}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Site:</td>
			<td><input type="text" name="siteFornecedor" value="${fornecedor.siteFornecedor}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Cnpj:</td>
			<td><input type="text" name="cnpjFornecedor" value="${fornecedor.cnpjFornecedor}" size="18" maxlength="18" OnKeyPress="formatar(this, '##.###.###/####-##')" /></td>
		</tr>
		<tr>
			<td align="right">Logradouro:</td>
			<td><input type="text" name="logradouroFornecedor" value="${fornecedor.logradouroFornecedor}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Número:</td>
			<td><input type="text" name="numeroLogradouroFornecedor" value="${fornecedor.numeroLogradouroFornecedor}" size="5" /></td>
		</tr>
		<tr>
			<td align="right">Complemento:</td>
			<td><input type="text" name="complementoLogradouroFornecedor" value="${fornecedor.complementoLogradouroFornecedor}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Bairro:</td>
			<td><input type="text" name="bairroFornecedor" value="${fornecedor.bairroFornecedor}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Cidade:</td>
			<td><input type="text" name="cidadeFornecedor" value="${fornecedor.cidadeFornecedor}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Estado:</td>
			<td>
				<select name="estadoFornecedor">
					<option  value="${fornecedor.estadoFornecedor}">AC</option>  
	                <option  value="${fornecedor.estadoFornecedor}">AL</option>  
	                <option  value="${fornecedor.estadoFornecedor}">AM</option>  
	                <option  value="${fornecedor.estadoFornecedor}">AP</option>  
	                <option  value="${fornecedor.estadoFornecedor}">BA</option>  
	                <option  value="${fornecedor.estadoFornecedor}">DF</option>  
	                <option  value="${fornecedor.estadoFornecedor}">ES</option>  
	                <option  value="${fornecedor.estadoFornecedor}">GO</option>  
	                <option  value="${fornecedor.estadoFornecedor}">MA</option>  
	                <option  value="${fornecedor.estadoFornecedor}">MG</option>  
	                <option  value="${fornecedor.estadoFornecedor}">MS</option>  
	                <option  value="${fornecedor.estadoFornecedor}">MT</option>  
	                <option  value="${fornecedor.estadoFornecedor}">PA</option>  
	                <option  value="${fornecedor.estadoFornecedor}">PB</option>  
	                <option  value="${fornecedor.estadoFornecedor}">PE</option>  
	                <option  value="${fornecedor.estadoFornecedor}">PI</option>  
	                <option  value="${fornecedor.estadoFornecedor}">PR</option>  
	                <option  value="RJ" selected="selected">RJ</option>  
	                <option  value="${fornecedor.estadoFornecedor}">RN</option>  
	                <option  value="${fornecedor.estadoFornecedor}">RO</option>  
	                <option  value="${fornecedor.estadoFornecedor}">RR</option>  
	                <option  value="${fornecedor.estadoFornecedor}">RS</option>  
	                <option  value="${fornecedor.estadoFornecedor}">SC</option>  
	                <option  value="${fornecedor.estadoFornecedor}">SE</option>  
	                <option  value="${fornecedor.estadoFornecedor}">SP</option>  
	                <option  value="${fornecedor.estadoFornecedor}">TO</option>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right">Cep:</td>
			<td><input type="text" name="cepFornecedor" value="${fornecedor.cepFornecedor}" size="10" maxlength="10" OnKeyPress="formatar(this, '##.###-###')" /></td>
		</tr>
		<tr>
			<td align="right">Ddd:</td>
			<td><input type="text" name="ddd1Fornecedor" value="${fornecedor.ddd1Fornecedor}" size="2" maxlength="2"/></td>
		</tr>
		<tr>
			<td align="right">Telefone 1:</td>
			<td><input type="text" name="telefone1Fornecedor" value="${fornecedor.telefone1Fornecedor}" size="9" maxlength="9" OnKeyPress="formatar(this, '####-####')"/></td>
		</tr>
		<tr>
			<td align="right">Ddd:</td>
			<td><input type="text" name="ddd2Fornecedor" value="${fornecedor.ddd2Fornecedor}" size="2" maxlength="2" /></td>
		</tr>
		<tr>
			<td align="right">Telefone 2:</td>
			<td><input type="text" name="telefone2Fornecedor" value="${fornecedor.telefone2Fornecedor}" size="9" maxlength="9" OnKeyPress="formatar(this, '####-####')"/></td>
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