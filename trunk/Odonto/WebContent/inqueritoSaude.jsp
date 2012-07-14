<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body>
<fieldset class="pagina">
<h1>:: Inquérito de saúde</h1>
<div id="msg">
	<h5 class="information">${msg}</h5>
	<h5 class="error">${msgE}</h5>
</div>

<form name="formInqueritoSaude" method="post" action="ServletInqueritoSaude">	
	
	<table>
	
		<tr>				
			<td align="center">INQUÉRITO DE SAÚDE:</td>						
		</tr>		
				
		<tr>
			<td align="right">Em tratamento médico?</td>
			<td><input type="radio" name="tratamento" value="NÃO" />Não
				<input type="radio" name="tratamento" value="SIM" />Sim				
				<input type="text" name="tratamento" size="30" maxlength="30" />
			</td>
		</tr>
		<tr>
			<td align="right">Está usando medicação?</td>
			<td><input type="radio" name="medicacao" value="NÃO" />Não
				<input type="radio" name="medicacao" value="SIM" />Sim				
				<input type="text" name="medicacao" size="30" maxlength="30" />
			</td>
		</tr>
		<tr>
			<td align="right">Alergia?</td>
			<td><input type="radio" name="alergia" value="NÃO" />Não
				<input type="radio" name="alergia" value="SIM" />Sim				
				<input type="text" name="alergia" size="30" maxlength="30" />
				<input type="radio" name="alergia" value="NÃO SEI" />Não sei 
			</td>
		</tr>
		
		<tr>
			<td align="right">Anemia</td>
				<td><input type="radio" name="anemia" value="SIM" />Sim
				<input type="radio" name="anemia" value="NÃO" />Não								
				<input type="radio" name="anemia" value="NÃO SEI" />Não sei 
			</td>
		</tr>	
		<tr>	
			<td align="right">Hepatite</td>
				<td><input type="radio" name="hepatite" value="SIM" />Sim
				<input type="radio" name="hepatite" value="NÃO" />Não								
				<input type="radio" name="hepatite" value="NÃO SEI" />Não sei 
			</td>
		</tr>
		
		<tr>	
			<td align="right">Sífilis</td>
				<td><input type="radio" name="sifilis" value="SIM" />Sim
				<input type="radio" name="sifilis" value="NÃO" />Não								
				<input type="radio" name="sifilis" value="NÃO SEI" />Não sei 
			</td>
		</tr>
		
		<tr>	
			<td align="right">HIV</td>
				<td><input type="radio" name="hiv" value="SIM" />Sim
				<input type="radio" name="hiv" value="NÃO" />Não								
				<input type="radio" name="hiv" value="NÃO SEI" />Não sei 
			</td>
		</tr>
		
		<tr>	
			<td align="right">Tuberculose</td>
				<td><input type="radio" name="tuberculose" value="SIM" />Sim
				<input type="radio" name="tuberculose" value="NÃO" />Não								
				<input type="radio" name="tuberculose" value="NÃO SEI" />Não sei 
			</td>
		</tr>
		
		<tr>	
			<td align="right">Asma</td>
				<td><input type="radio" name="asma" value="SIM" />Sim
				<input type="radio" name="asma" value="NÃO" />Não								
				<input type="radio" name="asma" value="NÃO SEI" />Não sei 
			</td>
		</tr>
		
		<tr>	
			<td align="right">Fumante</td>
				<td><input type="radio" name="fumante" value="SIM" />Sim
				<input type="radio" name="fumante" value="NÃO" />Não								
				<input type="radio" name="fumante" value="NÃO SEI" />Não sei 
			</td>
		</tr>
		
		<tr>	
			<td align="right">Alcoolista</td>
				<td><input type="radio" name="alcoolista" value="SIM" />Sim
				<input type="radio" name="alcoolista" value="NÃO" />Não								
				<input type="radio" name="alcoolista" value="NÃO SEI" />Não sei 
			</td>
		</tr>		
		
		<tr>	
			<td align="right">Herpes/Aftas</td>
				<td><input type="radio" name="herpes/aftas" value="SIM" />Sim
				<input type="radio" name="herpes/aftas" value="NÃO" />Não								
				<input type="radio" name="herpes/aftas" value="NÃO SEI" />Não sei 
			</td>
		</tr>		
		
		<tr>	
			<td align="right">Gravidez</td>
				<td><input type="radio" name="gravidez" value="SIM" />Sim
				<input type="radio" name="gravidez" value="NÃO" />Não								
				<input type="radio" name="gravidez" value="NÃO SEI" />Não sei 
			</td>
		</tr>		
		
		<tr>	
			<td align="right">Diabetes</td>
				<td><input type="radio" name="diabetes" value="SIM" />Sim
				<input type="radio" name="diabetes" value="NÃO" />Não								
				<input type="radio" name="diabetes" value="NÃO SEI" />Não sei 
			</td>
		</tr>		
		
		<tr>	
			<td align="right">Cardíaco</td>
				<td><input type="radio" name="cardiaco" value="SIM" />Sim
				<input type="radio" name="cardiaco" value="NÃO" />Não								
				<input type="radio" name="cardiaco" value="NÃO SEI" />Não sei 
			</td>
		</tr>		
		<tr>
			<td colspan=2 align="center">				
				<input type="submit" name="btn" value="Próximo" />				
			</td>
		</tr>
	</table>
</form>	
</fieldset>
<c:import url="cabecalho.jsp"/>
<c:import url="rodape.jsp" />
</body>
</html>