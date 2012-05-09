<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Procedimentos</title>
</head>
<body>
<div id="content">

<form name="formCadastroProcedimento" action="servletCadastroProcedimento" method="post">
	<fieldset id="fieldsetCadastroProcedimento">
	<legend><span>Cadastro de Procedimentos</span></legend>
	
	<ol>
		<li>
		<label for="Convenio" title="Convênio">Convênio<span></span></label>			
				<select>
					  <option  value=""></option>
					  <option  value=""></option>	
					  <option  value=""></option>	
					  <option  value=""></option>
	            </select>
	    </li>		
		<li>
			<label for="CodigoProcedimento" title="Código do Procedimento">Código<span></span></label>
			<input type="text" name="codigoProcedimento" size="50" maxlength="50" />
		</li>		
		<li>
			<label for="DescricaoProcedimento" title="Descrição do Procedimento">Descrição<span></span></label>
			<input type="text" name="descricaoProcedimento"size="50" maxlength="50" />
		</li>
		<li>
			<label for="ValorProcedimento" title="Valor do Procedimento">Valor<span></span></label>
			<input type="text" name="valorProcedimento"size="10" maxlength="10" />
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