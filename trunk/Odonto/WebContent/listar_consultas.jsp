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
<h1>:: Consultas agendadas</h1>
<div id="msg">
	<h5 class="information">${msg}</h5>
	<h5 class="error">${msgE}</h5>
</div>


<table border=1 bordercolor="#5e8ce9" width="95%" align="center">
<tr>
	<th bgcolor="#5e8ce9" width="8%">Data consulta</th>
	<th bgcolor="#5e8ce9" width="5%">Hora consulta</th>
	<th bgcolor="#5e8ce9" width="37%">Paciente</th>
	<th bgcolor="#5e8ce9" width="23%">Dentista</th>
	<th bgcolor="#5e8ce9" width="11%">Status consulta</th>
	<th bgcolor="#5e8ce9" width="8%">Remarcar</th>
	<th bgcolor="#5e8ce9" width="8%">Cancelar</th>	
</tr>
<c:forEach items="${sessionScope.listaConsulta}" var="colecao">
	<tr>
		<td align="center"><c:out value="${colecao.dataConsulta}" /></td>
		<td align="center"><c:out value="${colecao.horaConsulta}" /></td>
		<td><c:out value="${colecao.paciente}"/></td>
		<td><c:out value="${colecao.dentista}"/></td>
		<td align="center"><c:out value="${colecao.statusConsulta}" /></td>
		<td align="center"><a href="ServletConsulta?btn=Remarcar&id=${colecao.idConsulta}">Remarcar</a></td>
		<td align="center"><input type="button" value="Cancelar" onclick="javascript:confirmarExclusao('ServletConsulta?btn=Cancelar&id=${colecao.idConsulta}');"></td>
	</tr>
</c:forEach>
</table>

<form name="formCancelarConsulta" method="post" action="ServletConsulta">
	<input type="submit" name="btn" value="Voltar" />
</form>

</fieldset>
<c:import url="cabecalho.jsp" />
<c:import url="rodape.jsp" />
</body>
</html>