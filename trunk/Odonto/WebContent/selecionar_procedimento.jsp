<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="modelo.Dentista, modelo.Paciente" %>
<%@ page import="persistencia.DaoDentista,persistencia.DaoDentista,persistencia.DaoPaciente,persistencia.DaoPaciente" %>
<%@ page import="java.util.*" %>
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
<h1>:: Selecionar face e procedimento para o elemento: ${elemento}</h1>
<div id="msg">
	<h5 class="information">${msg}</h5>
	<h5 class="error">${msgE}</h5>
</div>
<center>
<form action="ServletOdontograma" method="post" name="formSelecionarProcedimento">
	<table>
		<tr>
			<td align="center">Selecione a face:
				<select name="face">
					<c:forEach items="${sessionScope.listaFace}" var="colecao">
						<option value="${colecao.nomeFace}" >${colecao.nomeFace}</option>
					</c:forEach>
				</select>	
			</td>
		</tr>
		<tr>
			<td align="center"><img src="arquivos/elemento_superior_grande.png"></td>
		</tr>
		<tr>
			<td align="center">Procedimentos ${convenioPaciente}:
				<select name="procedimento">
					<c:forEach items="${sessionScope.listaProcedimento}" var="colecao">
						<option value="${colecao.descricaoProcedimento}" >${colecao.descricaoProcedimento}</option>
					</c:forEach>
				</select>	
			</td>		
		</tr>
		<tr>
			<td align="center">
				<input type="submit" name="btn" value="Voltar" />
				<input type="submit" name="btn" value="Gravar procedimento" />
			</td>
		</tr>
	</table>	
</form>
</center>
</fieldset>
<c:import url="cabecalho.jsp" />
<c:import url="rodape.jsp" />
</body>
</html>