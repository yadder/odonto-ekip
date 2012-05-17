<%@ page isELIgnored ="false" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Face</title>

</head>
<body>
<div id="msg">
${msg}
</div>
<div id="content">

<form name="formCadastroFace" action="ServletFace" method="post">
	<fieldset id="fieldsetCadastroFace">
	<legend><span>Cadastro de Face</span></legend>
	
	<ol>
		<li>
			<label for="CodigoFace" title="Código da Face">Código Face<span></span></label>
			<input type="text" name="codigoFace" size="11" maxlength="11" disabled="disabled"/>
		</li>		
		<li>
			<label for="NomeFace" title="Nome da Face">Nome Face<span></span></label>
			<input type="text" name="nomeFace" size="30" maxlength="30" />
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