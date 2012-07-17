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
<h1>:: Novo odontograma</h1>
<div id="msg">
	<h5 class="information">${msg}</h5>
	<h5 class="error">${msgE}</h5>
</div>
<div id="paciente">
	<h5 class="information">
		Paciente: ${pacienteNovoOdontograma}<br>
		Convênio: ${convenioPaciente}<br>
		Dentista: ${usuarioLogado}<br>
	
	</h5>
</div>

<div id="odontograma">
	<center>
	
	<table>
		<tr>
			<td align="center"><a href="ServletOdontograma?btn=18"><img src="arquivos/elemento_superior.png" name="18"/><br/>18</a></td>
			<td align="center"><a href="selecionar_procedimento.jsp?elemento=17"><img src="arquivos/elemento_superior.png" name="17"/><br/>17</a></td>
			<td align="center"><a href="selecionar_procedimento.jsp?elemento=16"><img src="arquivos/elemento_superior.png" name="16"/><br/>16</a></td>
			<td align="center"><a href="selecionar_procedimento.jsp?elemento=15"><img src="arquivos/elemento_superior.png" name="15"/><br/>15</a></td>
			<td align="center"><img src="arquivos/elemento_superior.png" /><br/>14</td>
			<td align="center"><img src="arquivos/elemento_superior.png" /><br/>13</td>
			<td align="center"><img src="arquivos/elemento_superior.png" /><br/>12</td>
			<td align="center"><img src="arquivos/elemento_superior.png" /><br/>11</td>
			<td>&nbsp;&nbsp;</td>
			<td align="center"><img src="arquivos/elemento_superior.png" /><br/>21</td>
			<td align="center"><img src="arquivos/elemento_superior.png" /><br/>22</td>
			<td align="center"><img src="arquivos/elemento_superior.png" /><br/>23</td>
			<td align="center"><img src="arquivos/elemento_superior.png" /><br/>24</td>
			<td align="center"><img src="arquivos/elemento_superior.png" /><br/>25</td>
			<td align="center"><img src="arquivos/elemento_superior.png" /><br/>26</td>
			<td align="center"><img src="arquivos/elemento_superior.png" /><br/>27</td>
			<td align="center"><img src="arquivos/elemento_superior.png" /><br/>28</td>
		</tr>
		<tr>
			<td align="center">48<br/><img src="arquivos/elemento_inferior.png" /></td>
			<td align="center">47<br/><img src="arquivos/elemento_inferior.png" /></td>
			<td align="center">46<br/><img src="arquivos/elemento_inferior.png" /></td>
			<td align="center">45<br/><img src="arquivos/elemento_inferior.png" /></td>
			<td align="center">44<br/><img src="arquivos/elemento_inferior.png" /></td>
			<td align="center">43<br/><img src="arquivos/elemento_inferior.png" /></td>
			<td align="center">42<br/><img src="arquivos/elemento_inferior.png" /></td>
			<td align="center">41<br/><img src="arquivos/elemento_inferior.png" /></td>
			<td>&nbsp;&nbsp;</td>
			<td align="center">31<br/><img src="arquivos/elemento_inferior.png" /></td>
			<td align="center">32<br/><img src="arquivos/elemento_inferior.png" /></td>
			<td align="center">33<br/><img src="arquivos/elemento_inferior.png" /></td>
			<td align="center">34<br/><img src="arquivos/elemento_inferior.png" /></td>
			<td align="center">35<br/><img src="arquivos/elemento_inferior.png" /></td>
			<td align="center">36<br/><img src="arquivos/elemento_inferior.png" /></td>
			<td align="center">37<br/><img src="arquivos/elemento_inferior.png" /></td>
			<td align="center">38<br/><img src="arquivos/elemento_inferior.png" /></td>
		</tr>
	</table>
	
	</center>
</div>


</fieldset>
<c:import url="cabecalho.jsp" />
<c:import url="rodape.jsp" />
</body>
</html>