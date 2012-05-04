<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OdontoEkip - Login</title>
</head>
<body>
<div id="content">
<form name="formLogin" action="servletLogin" method="post">
	<fieldset id="fieldsetLogin">
	<legend><span>Faça o login</span></legend>
	
	<ol>
		<li>
			<label for="login" title="login">Login<span></span></label>
			<input type="text" name="login" />
		</li>
		<li>
			<label for="senha" title="senha">Senha<span></span></label>
			<input type="password" name="senha" />
		</li>		
	</ol>
	<ol>
		<li>
			<input type="reset" value="Limpar campos" />
			<input type="submit" value="Entrar" />
		</li>
	</ol>
	</fieldset>
</form>
</div>

<b>${msg}</b>
</body>
</html>