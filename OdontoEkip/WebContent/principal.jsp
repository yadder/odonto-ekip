<%@ page isELIgnored ="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema OdontoEkip - Principal</title>
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
	<hr/><BR/>
	
	<ol>
		<li>
			<a href="cadastroUsuario.jsf">Cadastro de usuário</a>
		</li>
		<li>
			<a href="cadastroConvenio.jsf">Cadastro de convênio</a>
		</li>
		<li>
			<a href="cadastroFace.jsf">Cadastro de face</a>
		</li>
		<li>
			<a href="login.jsf">Login</a>
		</li>
	</ol>
</body>
</html>
