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
<h1>:: Gerar pagamento</h1>
<div id="msg">
	<h5 class="information">${msg}</h5>
	<h5 class="error">${msgE}</h5>
</div>

<form name="formGerarPagamento" method="post" action="ServletPagamento">
	<table>
		<tr>
			<td align="right">Nome do paciente:</td>
			<td><input type="text" name="nomePaciente" value="${paciente.nomeUsuario}" size="53" readonly="readonly"/></td>
		</tr>
		<tr>
			<td align="right">Valor do tratamento:</td>
			<td><input type="text" name="valorOdontograma" id="valorOdontograma" value="${odontograma.valorOdontograma}" size="10" readonly="readonly" /></td>
		</tr>
		<tr>
			<td align="right">Forma de pagamento: </td>
			<td>
				<select name="formaPagamento">
					<option value="DINHEIRO">DINHEIRO</option>
					<option value="CARTÃO">CARTÃO</option>
				</select> 
				<select name="parcelas" id="parcelas" onchange="calculaParcela()">
					<option value="1">1 parcela</option>
					<option value="2">2 parcelas</option>
					<option value="3">3 parcelas</option>
					<option value="4">4 parcelas</option>
					<option value="5">5 parcelas</option>
					<option value="6">6 parcelas</option>
					<option value="7">7 parcelas</option>
					<option value="8">8 parcelas</option>
					<option value="9">9 parcelas</option>
					<option value="10">10 parcelas</option>
				</select> 
				<input type="text" name="valorParcela" id="valorParcela" readonly="readonly" />				
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" name="btn" value="Gerar pagamento" /></td>
		</tr>
	</table>
</form>
</fieldset>
<c:import url="cabecalho.jsp" />
<c:import url="rodape.jsp" />
</body>
</html>