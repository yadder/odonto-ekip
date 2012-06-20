<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema OdontoEkip - Principal</title>
</head>
<body>
<div class="header">
	<font size="2">${msg} Usuário: ${usuarioLogado.loginUsuario}
	</font>
	<form name="logout" action="ServletPrincipal" method="post">
		<input type="submit" value="Logout" />
	</form>
</div>
	<a href="fornecedor.jsp">Cadastro de fornecedor</a> <br/><br/>
	<a href="inqueritoOdontologico.jsp">Inquérito odontológico</a><br/><br/>
	
	<a href="convenio.jsp">Cadastro de convênio</a><br/><br/>
	<a href="pagamento.jsp">Efetuar pagamento</a><br/><br/>
	
	<hr/>
	testadas e validadas <br/>
	<a href="face.jsp">Cadastro de face</a><br/>
	<a href="elemento.jsp">Cadastro de elemento</a><br/>
	<a href="usuario.jsp">Cadastro de usuário</a><br/>

</body>
</html>