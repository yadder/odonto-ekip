<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body>
<fieldset class="pagina">
<h1>:: Prescrição médica</h1>
<div id="msg">
	<h5 class="information">${msg}</h5>
	<h5 class="error">${msgE}</h5>
</div>

<form name="formPrescricao" method="post" action="ServletPrescricao">
	<table>
		<tr>
			<td align="right">Nome do paciente:</td>
			<td><input type="text" name="nomePaciente" value="${paciente.nomeUsuario}" size="50" disabled="disabled" /><td>
		</tr>
		<tr>
			<td align="right">Tipo de prescrição:</td>
			<td>
				<select name="tipoPrescricao">
					<option value="ATESTADO">ATESTADO</option>
					<option value="PRESCRIÇÃO">PRESCRIÇÃO</option>
				</select>
			<td>
		</tr>		
		<tr>
			<td align="right">Prescrição:</td>
			<td><textarea rows="10" cols="100" name="observacao" ></textarea> </td>
		</tr>
		<tr>
			<td colspan=2 align="right">				
				<input type="submit" name="btn" value="Cadastrar" />				
				<input type="submit" name="btn" value="Voltar" />
			</td>
		</tr>
	</table>
</form>	
</fieldset>
<c:import url="cabecalho.jsp"/>
<c:import url="rodape.jsp" />
</body>
</html>