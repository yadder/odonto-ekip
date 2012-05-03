<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de fornecedor</title>
</head>
<body>
<div id="content">

<form name="formCadastroFornecedor" action="servletCadastroFornecedor" method="post">
	<fieldset id="fieldsetCadastroFornecedor">
	<legend><span>Cadastro de fornecedor</span></legend>
	
	<ol>
		<li>
			<label for="NomeFornecedor" title="Nome do fornecedor">Nome do fornecedor<span></span></label>
			<input type="text" name="nomeFornecedor" />
		</li>
		<li>
			<label for="SiteFornecedor" title="Site do fornecedor">Site do fornecedor<span></span></label>
			<input type="text" name="siteFornecedor" />
		</li>
		<li>
			<label for="CnpjFornecedor" title="CNPJ do fornecedor">CNPJ do fornecedor<span></span></label>
			<input type="text" name="cnpjFornecedor" />
		</li>
		<li>
			<label for="DddFornecedor" title="DDD do fornecedor">DDD<span></span></label>
			<input type="text" name="cnpjFornecedor" />
		</li>
		<li>
			<label for="TelefoneFornecedor" title="Telefone do fornecedor">Telefone<span></span></label>
			<input type="text" name="telefoneFornecedor" />
		</li>
		<li>
			<label for="LogradouroFornecedor" title="Logradouro do fornecedor">Logradouro<span></span></label>
			<input type="text" name="logradouroFornecedor" />
		</li>
		<li>
			<label for="NumeroFornecedor" title="Numero do fornecedor">Numero<span></span></label>
			<input type="text" name="numeroFornecedor" />
		</li>
		<li>
			<label for="ComplementoFornecedor" title="Complemento do fornecedor">Complemento<span></span></label>
			<input type="text" name="complementoFornecedor" />
		</li>
		<li>
			<label for="BairroFornecedor" title="Bairro do fornecedor">Bairro<span></span></label>
			<input type="text" name="bairroFornecedor" />
		</li>
		<li>
			<label for="CidadeFornecedor" title="Cidade do fornecedor">Cidade<span></span></label>
			<input type="text" name="cidadeFornecedor" />
		</li>
		<li>
			<label for="EstadoFornecedor" title="Estado do fornecedor">Estado<span></span></label>
			<input type="text" name="estadoFornecedor" />
		</li>
		<li>
			<label for="CepFornecedor" title="CEP do fornecedor">CEP<span></span></label>
			<input type="text" name="cepVendedor" />
		</li>
		<li>
			<label for="NomeVendedor" title="Nome do vendedor">Nome do vendedor<span></span></label>
			<input type="text" name="nomeVendedor" />
		</li>
		<li>
			<label for="EmailVendedor" title="E-mail do vendedor">E-mail do vendedor<span></span></label>
			<input type="text" name="emailVendedor" />
		</li>
		
	</ol>
	<ol>
		<li>
			<input type="reset" value="Limpar campos" />
			<input type="submit" value="Gravar" />
			<input type="submit" value="Excluir" />
			<input type="submit" value="Pesquisar" />
			<input type="submit" value="Sair" />
		</li>
	</ol>
	</fieldset>
	
</form>

</div>

</body>
</html>