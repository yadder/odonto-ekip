<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="modelo.Convenio" %>
<%@ page import="persistencia.DaoConvenio,persistencia.DaoConvenioImp" %>
<%@ page import="java.util.List" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alteração de procedimento</title>
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body>
<c:import url="cabecalho.jsp" />
<div id="pricipal" style="background-color: #FFFFFF;">
<form name="formProcedimento" method="post" action="ServletProcedimento">
	<table>
		<tr>
			<td align="right">Convênio:</td>
			<td><select name="convenio">
				<%
					DaoConvenio daoConvenio = new DaoConvenioImp();
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
				
				<input type="submit" name="btn" value="Excluir" />
				<input type="submit" name="btn" value="Alterar" />
				<input type="submit" name="btn" value="Voltar" />
			</td>
		</tr>
	</table>
</form>
</div>
<c:import url="rodape.jsp" />	
</body>
</html>