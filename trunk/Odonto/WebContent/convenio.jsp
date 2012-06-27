<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de convênio</title>
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body>
<div class="header">
	<h3>${msg}</h3>
</div>
<form name="formConvenio" method="post" action="ServletConvenio">
	<table>
		<tr>
			<td align="right">Nome da convênio:</td>
			<td><input type="text" name="nomeConvenio" value="${convenio.nomeConvenio}" size="20" /><input type="submit" name="btn" value="Pesquisar" /></td>
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