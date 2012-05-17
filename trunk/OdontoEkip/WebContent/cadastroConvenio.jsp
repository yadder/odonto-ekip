<%@ page isELIgnored ="false" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Convênios</title>
<script language="javascript">
function formatar(src, mask){
	var i = src.value.length;
	var saida = mask.substring(0,1);
	var texto = mask.substring(i)
	if (texto.substring(0,1) != saida){
	    src.value += texto.substring(0,1);
	}
}
</script>

</head>
<body>
<div id="msg">
${msg}
</div>
<div id="content">

<form name="formCadastroConvenio" action="ServletConvenio" method="post">
	<fieldset id="fieldsetCadastroConvenio">
	<legend><span>Cadastro de Convênios</span></legend>
	
	<ol>
		<li>
			<label for="CodigoConvenio" title="Código do convenio">Código convênio<span></span></label>
			<input type="text" name="codigoConvenio" size="11" maxlength="11" disabled="disabled"/>
		</li>
		<li>
			<label for="NomeConvenio" title="Nome do convênio">Nome convênio<span></span></label>
			<input type="text" name="nomeConvenio" size="50" maxlength="50" />
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