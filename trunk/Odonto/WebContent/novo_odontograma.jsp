<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<div id="odontograma">
	<center>
		<h5 class="information">
			Paciente: ${pacienteNovoOdontograma}<br>
			Dentista: ${usuarioLogado}<br>	
			Convênio: ${convenioPaciente}<br>
			
		</h5>
	<table border=0 cellspacing="2" cellpadding="5">
		<tr>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=18"><img src="arquivos/elemento_superior.png" name="18"/><br/>18</a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=17"><img src="arquivos/elemento_superior.png" name="17"/><br/>17</a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=16"><img src="arquivos/elemento_superior.png" name="16"/><br/>16</a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=15"><img src="arquivos/elemento_superior.png" name="15"/><br/>15</a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=14"><img src="arquivos/elemento_superior.png" name="14"/><br/>14</a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=13"><img src="arquivos/elemento_superior.png" name="13"/><br/>13</a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=12"><img src="arquivos/elemento_superior.png" name="12"/><br/>12</a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=11"><img src="arquivos/elemento_superior.png" name="11"/><br/>11</a></td>
			<td>&nbsp;&nbsp;</td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=21"><img src="arquivos/elemento_superior.png" name="21"/><br/>21</a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=22"><img src="arquivos/elemento_superior.png" name="22"/><br/>22</a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=23"><img src="arquivos/elemento_superior.png" name="23"/><br/>23</a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=24"><img src="arquivos/elemento_superior.png" name="24"/><br/>24</a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=25"><img src="arquivos/elemento_superior.png" name="25"/><br/>25</a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=26"><img src="arquivos/elemento_superior.png" name="26"/><br/>26</a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=27"><img src="arquivos/elemento_superior.png" name="27"/><br/>27</a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=28"><img src="arquivos/elemento_superior.png" name="28"/><br/>28</a></td>
		</tr>
		<tr>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=48">48<br/><img src="arquivos/elemento_inferior.png" name="48"/></a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=47">47<br/><img src="arquivos/elemento_inferior.png" name="47"/></a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=46">46<br/><img src="arquivos/elemento_inferior.png" name="46"/></a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=45">45<br/><img src="arquivos/elemento_inferior.png" name="45"/></a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=44">44<br/><img src="arquivos/elemento_inferior.png" name="44"/></a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=43">43<br/><img src="arquivos/elemento_inferior.png" name="43"/></a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=42">42<br/><img src="arquivos/elemento_inferior.png" name="42"/></a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=41">41<br/><img src="arquivos/elemento_inferior.png" name="41"/></a></td>
			<td>&nbsp;&nbsp;</td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=31">31<br/><img src="arquivos/elemento_inferior.png" name="31"/></a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=32">32<br/><img src="arquivos/elemento_inferior.png" name="32"/></a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=33">33<br/><img src="arquivos/elemento_inferior.png" name="33"/></a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=34">34<br/><img src="arquivos/elemento_inferior.png" name="34"/></a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=35">35<br/><img src="arquivos/elemento_inferior.png" name="35"/></a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=36">36<br/><img src="arquivos/elemento_inferior.png" name="36"/></a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=37">37<br/><img src="arquivos/elemento_inferior.png" name="37"/></a></td>
			<td align="center"><a href="ServletOdontograma?btn=procedimento&dente=38">38<br/><img src="arquivos/elemento_inferior.png" name="38"/></a></td>
		</tr>
	</table>
	<br><BR>
	<form name="formBtn"  method="post" action="ServletOdontograma">
		<input type="submit" name="btn" value="Cancelar odontograma"/>
		<input type="submit" name="btn" value="Visualizar tratamento"/>
		<input type="submit" name="btn" value="Gravar odontograma"/>
	</form>
</center>
</div>
</fieldset>
<c:import url="cabecalho.jsp" />
<c:import url="rodape.jsp"/>
</body>
</html>