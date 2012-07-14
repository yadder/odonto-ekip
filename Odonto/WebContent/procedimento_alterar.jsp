<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="modelo.Convenio" %>
<%@ page import="persistencia.DaoConvenio,persistencia.DaoConvenio" %>
<%@ page import="java.util.List" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body>
<fieldset class="pagina">
<h1>:: Alteração de procedimento</h1>
<div id="msg">
	<h5 class="information">${msg}</h5>
	<h5 class="error">${msgE}</h5>
</div>

<form name="formProcedimento" method="post" action="ServletProcedimento">
	<table>
		<tr>
			<td align="right">Convênio:</td>
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
			<td align="right">Procedimento:</td>
			<td><input type="text" name="descricaoProcedimento" value="${procedimento.descricaoProcedimento}" size="20" maxlength="20" />
		</tr>
		<tr>
			<td align="right">Valor:</td>
			<td><input type="text" name="valorProcedimento" value="${procedimento.valorProcedimento}" size="20" maxlength="8" />
		
		<tr>
			<td colspan=2 align="center">
				
				<input type="button" name="btn" value="Excluir" onclick="javascript:confirmarExclusao('ServletProcedimento?btn=Excluir');"/>
				<input type="submit" name="btn" value="Alterar" />
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