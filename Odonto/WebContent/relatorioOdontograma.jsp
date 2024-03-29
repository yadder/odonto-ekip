<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ page import="modelo.Odontograma" %>
<%@ page import="persistencia.DaoOdontograma" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		$("#t2").datepicker($.datepicker.regional['pt-BR']);
	});
</script>

</head>
<body>
<fieldset class="pagina">
<h1>:: Relatório de odontogramas finalizados por período </h1>
<div id="msg">
	<h5 class="information">${msg}</h5>
	<h5 class="error">${msgE}</h5>
</div>

<form name="formRelatorioOdontograma" method="post" action="ServletRelatorio">
	<table>
		<tr>
			<td align="right">Data início:</td>
			<td><input type="text" id="t1" name="dataInicio" value="${data}" size="17" maxlength="10" OnKeyPress="formatar(this, '##/##/####')" /></td>
		</tr>
		<tr>
			<td align="right">Data fim:</td>
			<td><input type="text" id="t2" name="dataFim" value="${data}" size="17" maxlength="10" OnKeyPress="formatar(this, '##/##/####')" /></td>
		<tr>
				
			<td colspan=2 align="center">
				<input type="submit" name="btn" value="Voltar" />
				<input type="submit" name="btn" value="Gerar relatório de Odontogramas" />				
			</td>
		</tr>		
	</table>
</form>	
</fieldset>
<c:import url="cabecalho.jsp"/>

</body>
</html>