<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="modelo.Convenio" %>
<%@ page import="persistencia.DaoConvenio,persistencia.DaoConvenio" %>
<%@ page import="java.util.List" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de procedimento</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body>
<c:import url="cabecalho.jsp" />
<div id="pricipal" style="background-color: #FFFFFF;">
<div id="msg">
	<h3 class="information">${msg}</h3>
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
			<td align="right">Código:</td>
			<td><input type="text" name="codigoProcedimento" value="${procedimento.codigoProcedimento}" size="20" maxlength="20" />
		</tr>
		<tr>
			<td align="right">Descrição:</td>
			<td><input type="text" name="descricaoProcedimento" value="${procedimento.descricaoProcedimento}" size="20" maxlength="20" /><input type="submit" name="btn" value="Pesquisar" />
		</tr>
		<tr>
			<td align="right">Valor:</td>
			<td><input type="text" name="valorProcedimento" value="${procedimento.valorProcedimento}" size="20" maxlength="8" />
		
		<tr>
			<td colspan=2 align="center">
				
				<input type="submit" name="btn" value="Cadastrar" />
				<input type="submit" name="btn" value="Voltar" />
			</td>
		</tr>
	</table>
</form>
</div>
<c:import url="rodape.jsp" />	
</body>
</html>