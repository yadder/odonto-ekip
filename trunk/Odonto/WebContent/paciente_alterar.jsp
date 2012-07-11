<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="modelo.Convenio" %>
<%@ page import="persistencia.DaoConvenio,persistencia.DaoConvenio" %>
<%@ page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alteração de paciente</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<script type="text/javascript" src="arquivos/scriptValidation.js"></script>
</head>
<body>
<div id="msg">
	<h3 class="information">${msg}</h3>
</div>
<form name="formPaciente" method="post" action="ServletPaciente">
	<table>
		<tr>
			<td align="right">Nome:</td>
			<td><input type="text" name="nomePaciente" value="${paciente.nomeUsuario}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Rg:</td>
			<td><input type="text" name="rgPaciente" value="${paciente.rgUsuario}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Cpf:</td>
			<td><input type="text" name="cpfPaciente" value="${paciente.cpfUsuario}" size="20" maxlength="14" OnKeyPress="formatar(this, '###.###.###-##')" /></td>
		</tr>
		<tr>
			<td align="right">Data nasc.:</td>
			<td><input type="text" name="dtNascPaciente" value="${data}" size="20" maxlength="10" OnKeyPress="formatar(this, '##/##/####')" /></td>
		</tr>
		<tr>
			<td align="right">Sexo:</td>
			<td>
				<input type="radio" name="sexoPaciente" value="M" />Masculino
				<input type="radio" name="sexoPaciente" value="F" />Feminino
			</td>
		</tr>
		<tr>
			<td align="right">Responsável:</td>
			<td><input type="text" name="responsavelPaciente" value="${paciente.responsavelPaciente}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Logradouro:</td>
			<td><input type="text" name="logradouroPaciente" value="${paciente.logradouroPaciente}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Número:</td>
			<td><input type="text" name="numeroLogradouroPaciente" value="${paciente.numeroLogradouroPaciente}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Complemento:</td>
			<td><input type="text" name="complementoLogradouroPaciente" value="${paciente.complementoLogradouroPaciente}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Bairro:</td>
			<td><input type="text" name="bairroPaciente" value="${paciente.bairroPaciente}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Cidade:</td>
			<td><input type="text" name="cidadePaciente" value="${paciente.cidadePaciente}" size="20" /></td>
		</tr>
		<tr>
			<td align="right">Estado:</td>
			<td>
				<select name="estadoPaciente">
					<option  value="${paciente.estadoPaciente}">AC</option>  
	                <option  value="${paciente.estadoPaciente}">AL</option>  
	                <option  value="${paciente.estadoPaciente}">AM</option>  
	                <option  value="${paciente.estadoPaciente}">AP</option>  
	                <option  value="${paciente.estadoPaciente}">BA</option>  
	                <option  value="${paciente.estadoPaciente}">DF</option>  
	                <option  value="${paciente.estadoPaciente}">ES</option>  
	                <option  value="${paciente.estadoPaciente}">GO</option>  
	                <option  value="${paciente.estadoPaciente}">MA</option>  
	                <option  value="${paciente.estadoPaciente}">MG</option>  
	                <option  value="${paciente.estadoPaciente}">MS</option>  
	                <option  value="${paciente.estadoPaciente}">MT</option>  
	                <option  value="${paciente.estadoPaciente}">PA</option>  
	                <option  value="${paciente.estadoPaciente}">PB</option>  
	                <option  value="${paciente.estadoPaciente}">PE</option>  
	                <option  value="${paciente.estadoPaciente}">PI</option>  
	                <option  value="${paciente.estadoPaciente}">PR</option>  
	                <option  value="RJ" selected="selected">RJ</option>  
	                <option  value="${paciente.estadoPaciente}">RN</option>  
	                <option  value="${paciente.estadoPaciente}">RO</option>  
	                <option  value="${paciente.estadoPaciente}">RR</option>  
	                <option  value="${paciente.estadoPaciente}">RS</option>  
	                <option  value="${paciente.estadoPaciente}">SC</option>  
	                <option  value="${paciente.estadoPaciente}">SE</option>  
	                <option  value="${paciente.estadoPaciente}">SP</option>  
	                <option  value="${paciente.estadoPaciente}">TO</option>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right">Cep:</td>
			<td><input type="text" name="cepPaciente" value="${paciente.cepPaciente}" size="20" maxlength="10" OnKeyPress="formatar(this, '##.###-###')"/></td>
		</tr>
		<tr>
			<td align="right">DDD:</td>
			<td><input type="text" name="ddd1Paciente" value="${paciente.ddd1Paciente}" size="20" maxlength="2"/></td>
		</tr>
		<tr>
			<td align="right">Telefone1:</td>
			<td><input type="text" name="telefone1Paciente" value="${paciente.telefone1Paciente}" size="20" maxlength="9" OnKeyPress="formatar(this, '####-####')" /></td>
		</tr>
		<tr>
			<td align="right">DDD:</td>
			<td><input type="text" name="ddd2Paciente" value="${paciente.ddd2Paciente}" size="20" maxlength="2"/></td>
		</tr>
		<tr>
			<td align="right">Telefone2:</td>
			<td><input type="text" name="telefone2Paciente" value="${paciente.telefone2Paciente}" size="20" maxlength="9" OnKeyPress="formatar(this, '####-####')"/></td>
		</tr>
		<tr>
			<td align="right">Convênio:</td>
			<td><select name="convenio">
				<%
					DaoConvenio daoConvenio = new DaoConvenio();
							List<Convenio> convenios = daoConvenio.pesquisarTodosConvenio();
							for(Convenio convenio : convenios){
				%>
				<option value="<%=convenio.getNomeConvenio() %>"><%=convenio.getNomeConvenio() %></option>
				<%} %>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan=2 align="center">
				<input type="button" name="btn" value="Excluir" onclick="javascript:confirmarExclusao('ServletPaciente?btn=Excluir');"/>
				<input type="submit" name="btn" value="Alterar" />
				<input type="submit" name="btn" value="Voltar" />
			</td>
		</tr>
	</table>
</form>	
</body>
</html>