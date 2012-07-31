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
<h1>:: Pagamentos vencidos em aberto</h1>
<div id="msg">
	<h5 class="information">${msg}</h5>
	<h5 class="error">${msgE}</h5>
</div>
<div id="paciente">
<center>
	<table border="1" width="90%" bordercolor="#5e8ce9">
		<tr>
			<td align="center" bgcolor="#5e8ce9" width="10%"><b>IdOdontograma</b></td>
			<td align="center" bgcolor="#5e8ce9" width="10%"><b>Paciente</b></td>
			<td align="center" bgcolor="#5e8ce9" width="15%"><b>Parcela</b></td>
			<td align="center" bgcolor="#5e8ce9" width="30%"><b>Dt Vencimento</b></td>
			<td align="center" bgcolor="#5e8ce9" width="15%"><b>Status</b>
		</tr>
		<c:forEach items="${sessionScope.listaPendente}" var="colecao">
		<tr>
			<td align="center">${colecao.odontograma}</td>
			<td align="center">${colecao.paciente}</td>
			<td align="center">${colecao.numeroParcela}</td>
			<td align="center">${colecao.dataVencimento}</td>
			<td align="center">${colecao.statusPagamento}</td>										
		</tr>	
		</c:forEach>
	</table>
	<form name="formBtn" method="post" action="ServletPagamento">
		<input type="submit" name="btn" value="Voltar"/>
	</form>	
</center>
</div>
</fieldset>
<c:import url="cabecalho.jsp" />

</body>
</html>