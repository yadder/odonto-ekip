<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Fornecedores</title>
</head>
<body>
<div id="content">

<form name="formCadastroFornecedor" action="servletCadastroFornecedor" method="post">
	<fieldset id="fieldsetCadastroFornecedor">
	<legend><span>Cadastro de Fornecedores</span></legend>
	
	<ol>
		<li>
			<label for="NomeFornecedor" title="Nome do fornecedor">Nome do fornecedor<span></span></label>
			<input type="text" name="nomeFornecedor" size="50" maxlength="50" />
		</li>		
		<li>
			<label for="CnpjFornecedor" title="CNPJ do fornecedor">CNPJ do fornecedor<span></span></label>
			<input type="text" name="cnpjFornecedor"size="18" maxlength="18" />
		</li>		
		<li>
			<label for="LogradouroFornecedor" title="Logradouro do fornecedor">Logradouro<span></span></label>
			<input type="text" name="logradouroFornecedor" size="50" maxlength="100"/>
		</li>
		<li>
			<label for="NumeroFornecedor" title="Numero do fornecedor">Numero<span></span></label>
			<input type="text" name="numeroFornecedor"size="10" maxlength="10" />
		</li>
		<li>
			<label for="ComplementoFornecedor" title="Complemento do fornecedor">Complemento<span></span></label>
			<input type="text" name="complementoFornecedor" size="50" maxlength="50"/>
		</li>
		<li>
			<label for="BairroFornecedor" title="Bairro do fornecedor">Bairro<span></span></label>
			<input type="text" name="bairroFornecedor"size="50" maxlength="50" />
		</li>
		<li>
			<label for="CidadeFornecedor" title="Cidade do fornecedor">Cidade<span></span></label>
			<input type="text" name="cidadeFornecedor"size="50" maxlength="50" />
		</li>
		<li>
			<label for="EstadoFornecedor" title="Estado do fornecedor">Estado<span></span></label>			
				<select>  
	                  <option  value="AC">AC</option>  
	                  <option  value="AL">AL</option>  
	                  <option  value="AM">AM</option>  
	                  <option  value="AP">AP</option>  
	                  <option  value="BA">BA</option>  
	                  <option  value="DF">DF</option>  
	                  <option  value="ES">ES</option>  
	                  <option  value="GO">GO</option>  
	                  <option  value="MA">MA</option>  
	                  <option  value="MG">MG</option>  
	                  <option  value="MS">MS</option>  
	                  <option  value="MT">MT</option>  
	                  <option  value="PA">PA</option>  
	                  <option  value="PB">PB</option>  
	                  <option  value="PE">PE</option>  
	                  <option  value="PI">PI</option>  
	                  <option  value="PR">PR</option>  
	                  <option  value="RJ">RJ</option>  
	                  <option  value="RN">RN</option>  
	                  <option  value="RO">RO</option>  
	                  <option  value="RR">RR</option>  
	                  <option  value="RS">RS</option>  
	                  <option  value="SC">SC</option>  
	                  <option  value="SE">SE</option>  
	                  <option  value="SP">SP</option>  
	                  <option  value="TO">TO</option>  
	               </select>
		</li>
		<li>
			<label for="CepFornecedor" title="CEP do fornecedor">CEP<span></span></label>
			<input type="text" name="cepFornecedor" size="9" maxlength="9"/>
		</li>		
		<li>
			<label for="DddFornecedor" title="DDD do fornecedor">DDD<span></span></label>
			<input type="text" name="dddFornecedor"size="3" maxlength="3" />
		</li>
		<li>
			<label for="TelefoneFornecedor" title="Telefone do fornecedor">Telefone<span></span></label>
			<input type="text" name="telefoneFornecedor"size="9" maxlength="9" />
		</li>
		<li>
			<label for="NomeVendedor" title="Nome do vendedor">Nome do vendedor<span></span></label>
			<input type="text" name="nomeVendedor"size="50" maxlength="50"/>
		</li>
		<li>
			<label for="EmailVendedor" title="E-mail do vendedor">E-mail do vendedor<span></span></label>
			<input type="text" name="emailVendedor"size="50" maxlength="50"/>
		</li>
		<li>
			<label for="SiteFornecedor" title="Site do fornecedor">Site do fornecedor<span></span></label>
			<input type="text" name="siteFornecedor"size="30" maxlength="30" />
		</li>
		
	</ol>
	<ol>
		<li>
			<input type="reset" value="Limpar campos" name="botao" />
			<input type="submit" value="Gravar" name="botao" />
			<input type="submit" value="Excluir" name="botao" />
			<input type="submit" value="Pesquisar" name="botao" />
			<input type="submit" value="Sair" name="botao" />
		</li>
	</ol>
	</fieldset>
	
</form>

</div>

</body>
</html>