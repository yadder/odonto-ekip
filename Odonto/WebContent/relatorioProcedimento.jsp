<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ page import="modelo.Convenio" %>
<%@ page import="persistencia.DaoConvenio" %>
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
<h1>:: Relatório de Procedimentos por Convênio</h1>
<div id="msg">
	<h5 class="information">${msg}</h5>
	<h5 class="error">${msgE}</h5>
</div>

<form name="formRelatorioProcedimento" method="post" action="ServletRelatorio">
	<table>
		<tr>
			<td align="right">Selecione o convênio:</td>
			<td><select name="convenio">
				<%
					DaoConvenio daoConvenio = new DaoConvenio();
							List<Convenio> convenios = daoConvenio.pesquisarTodosConvenio();
							for(Convenio convenio : convenios){
				%>
				<option value="<%=convenio.getNomeConvenio() %>"><%=convenio.getNomeConvenio() %></option>
				<%} %>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan=2 align="center">
				
				<input type="submit" name="btn" value="Gerar por Convenio" />				
			</td>
		</tr>		
	</table>
</form>	
</fieldset>
<c:import url="cabecalho.jsp"/>
<c:import url="rodape.jsp" />
</body>
</html>