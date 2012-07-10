<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="modelo.Dentista, modelo.Paciente" %>
<%@ page import="persistencia.DaoDentista,persistencia.DaoDentistaImp,persistencia.DaoPaciente,persistencia.DaoPacienteImp" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agendamento de consultas</title>
</head>
<body>
<c:import url="cabecalho.jsp" />
<div id="pricipal" style="background-color: #FFFFFF;">


<form name="formAgendarConsulta" method="post" action="ServletConsulta">
	<table>
		<tr>
			<td align="right">Selecione o(a) paciente:</td>
			<td><select name="paciente">
				<%
					DaoPaciente daoPaciente = new DaoPacienteImp();
					List<Paciente> pacientes = daoPaciente.pesquisarTodosPaciente();
					for(Paciente paciente : pacientes){
				%>
				<option value="<%=paciente.getNomeUsuario() %>"><%=paciente.getNomeUsuario() %></option>
				<%} %>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right">Selecione o(a) dentista:</td>
			<td><select name="dentista">
				<%
					DaoDentista daoDentista = new DaoDentistaImp();
					List<Dentista> dentistas = daoDentista.pesquisarTodosDentista();
					for(Dentista dentista : dentistas){
				%>
				<option value="<%=dentista.getNomeUsuario() %>"><%=dentista.getNomeUsuario() %></option>
				<%} %>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right">Selecione a data da consulta:</td>
			<td><input type="text" name="dataConsulta" /></td>
		</tr>
		<tr>
			<td align="right">Selecione a hora da consulta:</td>
			<td>Fazer um for trazendo os horarios livres daquela data escolhida</td>
		<tr>
			<td colspan=2 align="center">
				<input type="submit" name="btn" value="Agendar Consulta" />
				<input type="submit" name="btn" value="Voltar" />
			</td>
		</tr>
	</table>
</form>

</div>
<c:import url="rodape.jsp" />
</body>
</html>