<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alteração de face</title>
</head>
<body>
<div class="header">
	<h3>${msg}</h3>
</div>
<form name="formFace" method="post" action="ServletFace">
	<table>
		<tr>
			<td>Nome da face:</td>
			<td><input type="text" name="nomeFace" value="${face.nomeFace}" size="20" /></td>
		</tr>
		<tr>
			<td colspan=2 align="center">
				<input type="submit" name="btn" value="Excluir" />
				<input type="submit" name="btn" value="Alterar" />
				<input type="submit" name="btn" value="Voltar" />
			</td>
		</tr>
	</table>
</form>	
</body>
</html>