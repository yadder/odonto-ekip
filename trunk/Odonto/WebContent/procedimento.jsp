<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de procedimento</title>
</head>
<body>
<div class="header">
	<h3>${msg}</h3>
</div>
<form name="formProcedimento" method="post" action="ServletProcedimento">
	<table>
	
		<tr>
			<td align="right">Convênio:</td>
			<td>
				<select name="convenio">
					<option  value="${convenio.nomeConvenio}"></option>  
	            </select>
			</td>
		</tr>
		
		<tr>
			<td align="right">Código procedimento:</td>
			<td><input type="text" name="codigoProcedimento" value="${procedimento.codigoProcedimento}" size="20" maxlength="2" />
		</tr>	
	
	
		<tr>
			<td align="right">Procedimento:</td>
			<td><input type="text" name="nomeProcedimento" value="${procedimento.nomeProcedimento}" size="20" maxlength="2" />
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