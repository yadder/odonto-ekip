<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="modelo.Dentista" %>
<%@ page import="persistencia.DaoDentista,persistencia.DaoDentistaImp" %>
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
			<td align="right">Selecione a dentista:</td>
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
			<td>
				
			</td>
		</tr>
		
		
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