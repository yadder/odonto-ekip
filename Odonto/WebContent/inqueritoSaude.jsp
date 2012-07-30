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

<form name="formInqueritoSaude" method="post" action="ServletInquerito">	
	<table>
		<tr>
			<td align="right">Nome do paciente:</td>
			<td><input type="text" name="nomePaciente" value="${paciente.nomeUsuario}" disabled="disabled" size="50" /></td>
		</tr>
		<tr>
			<td align="right">Em tratamento médico?</td>
			<td><input type="radio" name="tratamento" value="S" />Sim
				<input type="radio" name="tratamento" value="N" />Não								
				<input type="text" name="qualtratamento" size="33" maxlength="30" />
			</td>
		</tr>
		<tr>
			<td align="right">Está usando medicação?</td>
			<td><input type="radio" name="medicacao" value="S" />Sim
				<input type="radio" name="medicacao" value="N" />Não								
				<input type="text" name="qualmedicacao" size="33" maxlength="30" />
			</td>
		</tr>
		<tr>
			<td align="right">Alergia?</td>
			<td><input type="radio" name="alergia" value="S" />Sim	
				<input type="radio" name="alergia" value="N" />Não							
				<input type="text" name="qualalergia" size="33" maxlength="30" />
			</td>
		</tr>
		
		<tr>
			<td align="right">Anemia</td>
				<td><input type="radio" name="anemia" value="S" />Sim
					<input type="radio" name="anemia" value="N" />Não					
				</td>
		</tr>	
		<tr>
			<td align="right">Fumante</td>
				<td><input type="radio" name="fumante" value="S" />Sim
					<input type="radio" name="fumante" value="N" />Não					
				</td>
		</tr>
		<tr>	
			<td align="right">Hepatite</td>
				<td><input type="radio" name="hepatite" value="S" />Sim
				<input type="radio" name="hepatite" value="N" />Não								
			</td>
		</tr>
		<tr>	
			<td align="right">Alcoolista</td>
				<td><input type="radio" name="alcoolista" value="S" />Sim
				<input type="radio" name="alcoolista" value="N" />Não								
			</td>
		</tr>
		<tr>	
			<td align="right">Sífilis</td>
				<td><input type="radio" name="sifilis" value="S" />Sim
				<input type="radio" name="sifilis" value="N" />Não								
			</td>
		</tr>
		<tr>	
			<td align="right">Herpes/Aftas</td>
				<td><input type="radio" name="herpes_aftas" value="S" />Sim
				<input type="radio" name="herpes_aftas" value="N" />Não								
			</td>
		</tr>
		<tr>	
			<td align="right">HIV</td>
				<td><input type="radio" name="hiv" value="S" />Sim
				<input type="radio" name="hiv" value="N" />Não								
			</td>
		</tr>
		<tr>	
			<td align="right">Gravidez</td>
				<td><input type="radio" name="gravidez" value="S" />Sim
				<input type="radio" name="gravidez" value="N" />Não								
			</td>
		</tr>	
		<tr>	
			<td align="right">Tuberculose</td>
				<td><input type="radio" name="tuberculose" value="S" />Sim
				<input type="radio" name="tuberculose" value="N" />Não								
			</td>
		</tr>
		<tr>	
			<td align="right">Diabetes</td>
				<td><input type="radio" name="diabetes" value="S" />Sim
				<input type="radio" name="diabetes" value="N" />Não								
			</td>
		</tr>	
		<tr>	
			<td align="right">Asma</td>
				<td><input type="radio" name="asma" value="S" />Sim
				<input type="radio" name="asma" value="N" />Não								
			</td>
		</tr>
		<tr>	
			<td align="right">Cardíaco</td>
				<td><input type="radio" name="cardiaco" value="S" />Sim
				<input type="radio" name="cardiaco" value="N" />Não								
			</td>
		</tr>		
		<tr>
			<td colspan=2 align="right">				
				<input type="submit" name="btn" value="Próximo" />				
			</td>
		</tr>
	</table>
</form>	
</fieldset>
<c:import url="cabecalho.jsp"/>

</body>
</html>