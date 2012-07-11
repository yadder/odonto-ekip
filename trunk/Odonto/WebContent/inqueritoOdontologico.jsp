<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inquérito Odontológico</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body>
<div id="msg">
	<h3 class="information">${msg}</h3>
</div>
<form name="formInqueritoOdontologico" method="post" action="ServletInqueritoOdontologico">
	<table>
		
		
		<tr>				
			<td align="center">INQUÉRITO ODONTOLÓGICO:</td>						
		</tr>		
			
		<tr>				
			<td align="left">Data último atendimento:
				<input type="text" name="dtUltimoAtendimento" value="${data}" size="20" maxlength="10" OnKeyPress="formatar(this, '##/##/####')" /><br>
			</td>			
		</tr>			
			
		<tr>				
			<td align="left">Concluiu tratamento?
				<input type="radio" name="tratamento" value="SIM" />Sim
				<input type="radio" name="tratamento" value="NÃO" />Não
			</td>				
		</tr>
		
		<tr>						
			<td align="left">Experiência negativa no tratamento odontológico: Qual?
				<input type="text" name="experienciaNegativa" size="50" maxlength="50" />
			</td>
		</tr>		
		
		<tr>						
			<td align="left">Queixa principal/Motivo da consulta:
				<input type="text" name="queixaMotivoConsulta" size="50" maxlength="50" /><br><br><br>
			</td>
		</tr>
		
		
		
		<tr>
			<td align="center">HÁBITOS</td>
		</tr>
				
		<tr>
			<td><input type="checkbox" name="checkbox" value="roerUnhas"> Roer unhas
				<input type="checkbox" name="checkbox" value="morderObjetos"> Morder objetos
				<input type="checkbox" name="checkbox" value="outros"> Outros
				<input type="checkbox" name="checkbox" value="respirarPelaBoca"> Respirar pela boca
				<input type="checkbox" name="checkbox" value="rangerOsDentes"> Ranger os dentes
				<input type="checkbox" name="checkbox" value="chuparDedoOuChupeta"> Chupar dedo ou chupeta<BR><BR><BR>			
			</td>			
		</tr>
				
				
		<tr>
			<td align="center">HIGIENE BUCAL(utiliza)</td>
		</tr>	
		
		<tr>	
			<td><input type="checkbox" name="checkbox" value="fioFitaDental"> Fio/Fita dental
				<input type="checkbox" name="checkbox" value="unitufoBitufo"> Unitufo/Bitufo
				<input type="checkbox" name="checkbox" value="interdental"> Interdental
				<input type="checkbox" name="checkbox" value="palito"> Palito
				<input type="checkbox" name="checkbox" value="escovaMaciaMediaDura"> Escova macia/média/dura
				<input type="checkbox" name="checkbox" value="cremedental"> Creme dental<BR><BR><BR>			
			</td>			
		</tr>		
		
		
		
		<tr>
			<td align="center">DIETA</td>
		</tr>
		
		<tr>											
			<td align="left"> Ingere alimentos/bebidas entre as refeições?
				<input type="radio" name="ingereAlimentosBebidasRefeicoes" value="NÃO" />Não
				<input type="radio" name="ingereAlimentosBebidasRefeicoes" value="SIM" />Sim				
				<input type="text" name="ingereAlimentosBebidasRefeicoes" size="30" maxlength="30" /><br>
			</td>							
																				
		</tr>
		
		<tr>						
			<td align="left">Tecidos moles:
				<input type="text" name="tecidosMoles" size="30" maxlength="30" /><br><br><br>
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
</body>
</html>