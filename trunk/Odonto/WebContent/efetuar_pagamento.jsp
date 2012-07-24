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
<h1>:: Efetuar pagamento</h1>
<div id="msg">
	<h5 class="information">${msg}</h5>
	<h5 class="error">${msgE}</h5>
</div>
<div id="paciente">
<center>

	Nome paciente:<input type="text" name="nomePaciente" value="${paciente.nomeUsuario}" size="45" readonly="readonly"/>
	<br><br>
	<table border="1" width="80%" bordercolor="#5e8ce9">
		<tr>
			<td align="center" bgcolor="#5e8ce9"><b>IdOdontograma</b></td>
			<td align="center" bgcolor="#5e8ce9"><b>Nº Parcela</b></td>
			<td align="center" bgcolor="#5e8ce9"><b>Valor</b></td>
			<td align="center" bgcolor="#5e8ce9"><b>Dt Vencimento</b></td>
			<td align="center" bgcolor="#5e8ce9"><b>Status</b>
			<td align="center" bgcolor="#5e8ce9"><b>Ação</b>
		</tr>
		<c:forEach items="${sessionScope.listaPagamento}" var="colecao">
		<tr>
			<td align="center">${colecao.odontograma}</td>
			<td align="center">${colecao.numeroParcela}</td>
			<td align="center">${colecao.valorParcela}</td>
			<td align="center">${colecao.dataVencimento}</td>
			<td align="center">${colecao.statusPagamento}</td>										
			<td align="center"><a href="ServletPagamento?btn=Pagar&index=${colecao.idPagamento}" >Pagar</a></td>
		</tr>	
		</c:forEach>
	</table>
	<form name="formBtn" method="post" action="ServletAtendimento">
		<input type="submit" name="btn" value="Voltar"/>
	</form>	
</center>
</div>
</fieldset>
<c:import url="cabecalho.jsp" />
<c:import url="rodape.jsp"/>
</body>
</html>