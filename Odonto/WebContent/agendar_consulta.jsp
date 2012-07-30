<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.7.3.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.7.3.custom.min.js"></script>
<script type="text/javascript" src="js/jquery.ui.datepicker-pt-BR.js"></script>
<script>
	$(function() {
		$("#t1").datepicker($.datepicker.regional['pt-BR']);
	});
</script>

</head>
<body>
<fieldset class="pagina">
<h1>:: Agendar consulta</h1>
<div id="msg">
	<h5 class="information">${msg}</h5>
	<h5 class="error">${msgE}</h5>
</div>

<form name="formAgendarConsulta" method="post" action="ServletConsulta">
	<table>
		<tr>
			<td align="right">Paciente selecionado:</td>
			<td><input type="text" name="nomePaciente" value="${paciente.nomeUsuario}" disabled="disabled" size="45"/></td>
		</tr>
		<tr>
			<td align="right">Selecione o(a) dentista:</td>
				<td><select name="dentista">
					<c:forEach items="${sessionScope.listaDentista}" var="colecao">
						<option value="${colecao.nomeUsuario}">${colecao.nomeUsuario}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right">Selecione a data da consulta:</td>
			<td><input type="text" id="t1" name="dataConsulta" value="${data}" size="17" maxlength="10" OnKeyPress="formatar(this, '##/##/####')" /></td>
		</tr>
		<tr>
			<td align="right">Selecione a hora da consulta:</td>
			<td><select name="horaConsulta">
					<option value="08:00">08:00</option>
					<option value="09:00">09:00</option>
					<option value="10:00">10:00</option>
					<option value="11:00">11:00</option>
					<option value="12:00">12:00</option>
					<option value="13:00">13:00</option>
					<option value="14:00">14:00</option>
					<option value="15:00">15:00</option>
					<option value="16:00">16:00</option>
					<option value="17:00">17:00</option>
					<option value="18:00">18:00</option>
				</select>
			</td>
		<tr>
			<td colspan=2 align="center">
				<input type="submit" name="btn" value="Agendar Consulta" />
				<input type="submit" name="btn" value="Voltar" />
			</td>
		</tr>
	</table>
</form>

</fieldset>
<c:import url="cabecalho.jsp" />

</body>
</html>