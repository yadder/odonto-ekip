<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ page import="modelo.Consulta" %>
<%@ page import="persistencia.DaoConsulta" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body>
<fieldset class="pagina">
<h1>:: Relatório de consultas por período e status </h1>
<div id="msg">
	<h5 class="information">${msg}</h5>
	<h5 class="error">${msgE}</h5>
</div>

<form name="formRelatorioConsulta" method="post" action="ServletRelatorio">
	<table>
		<tr>
			<td align="right">Data início:</td>
			<td><input type="text" name="dataConsultaInicio" value="${data}" size="17" maxlength="10" OnKeyPress="formatar(this, '##/##/####')" /></td>
		</tr>
		<tr>
			<td align="right">Data fim:</td>
			<td><input type="text" name="dataConsultaFim" value="${data}" size="17" maxlength="10" OnKeyPress="formatar(this, '##/##/####')" /></td>
		<tr>
		<tr>
			<td align="right">Selecione o status da consulta:</td>
			<td><select name="statusConsulta">
					<option value="AGENDADA">AGENDADA</option>
					<option value="REALIZADA">REALIZADA</option>
					<option value="CANCELADA">CANCELADA</option>					
				</select>
			</td>
		<tr>
		
			<td colspan=2 align="center">
				<input type="submit" name="btn" value="Voltar" />
				<input type="submit" name="btn" value="Gerar relatório de Consultas" />				
			</td>
		</tr>		
	</table>
</form>	
</fieldset>
<c:import url="cabecalho.jsp"/>
<c:import url="rodape.jsp" />
</body>
</html>