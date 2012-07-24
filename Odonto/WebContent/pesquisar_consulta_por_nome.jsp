<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body>
<fieldset class="pagina">
<h1>:: Pesquisar consulta por paciente</h1>
<div id="msg">
	<h5 class="information">${msg}</h5>
	<h5 class="error">${msgE}</h5>
</div>

<form name="formRemarcarConsulta" method="post" action="ServletConsulta">
	<table>
		<tr>
			<td align="right">Nome do paciente:</td>
			<td><input type="text" name="nomePaciente" size="45" /><input type="submit" name="btn" value="Pesquisar por paciente" /></td>
		</tr>
		<tr>
			<td colspan=2 align="right">
				<input type="submit" name="btn" value="Voltar" />
			</td>
		</tr>
	</table>
</form>

</fieldset>
<c:import url="cabecalho.jsp" />
<c:import url="rodape.jsp" />
</body>
</html>