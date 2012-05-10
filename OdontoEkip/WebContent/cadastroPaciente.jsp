<%@ page isELIgnored ="false" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Pacientes</title>
<script language="javascript">
function formatar(src, mask){
	var i = src.value.length;
	var saida = mask.substring(0,1);
	var texto = mask.substring(i)
	if (texto.substring(0,1) != saida){
	    src.value += texto.substring(0,1);
	}
}
</script>

</head>
<body>
<div id="msg">
${msg}
</div>
<div id="content">

<form name="formCadastroPaciente" action="servletCadastroPaciente" method="post">
	<fieldset id="fieldsetCadastroPaciente">
	<legend><span>Cadastro de Pacientes</span></legend>
	
	<ol>
		<li>
			<label for="TipoConvenio" title="Tipo de Convênio">Tipo de Convênio<span></span></label>			
				<select>
					  <option  value=""></option>						  		
					  <option  value="CONVÊNIO">CONVÊNIO</option>
					  <option  value="PARTICULAR">PARTICULAR</option>	                  	                   
	            </select>
		</li>							
		<li>
			<label for="LogradouroPaciente" title="Logradouro do paciente">Logradouro<span></span></label>
			<input type="text" name="logradouroPaciente" size="50" maxlength="100"/>
		</li>
		<li>
			<label for="NumeroPaciente" title="Numero do paciente">Número<span></span></label>
			<input type="text" name="numeroPaciente"size="10" maxlength="10" />
		</li>
		<li>
			<label for="ComplementoPaciente" title="Complemento do paciente">Complemento<span></span></label>
			<input type="text" name="complementoPaciente" size="50" maxlength="50"/>
		</li>
		<li>
			<label for="BairroPaciente" title="Bairro do paciente">Bairro<span></span></label>
			<input type="text" name="bairroPaciente"size="50" maxlength="50" />
		</li>
		<li>
			<label for="CidadePaciente" title="Cidade do paciente">Cidade<span></span></label>
			<input type="text" name="cidadePaciente"size="50" maxlength="50" />
		</li>
		<li>
			<label for="EstadoPaciente" title="Estado do paciente">Estado<span></span></label>			
				<select>  
	                  <option  value="AC">AC</option>  
	                  <option  value="AL">AL</option>  
	                  <option  value="AM">AM</option>  
	                  <option  value="AP">AP</option>  
	                  <option  value="BA">BA</option>  
	                  <option  value="DF">DF</option>  
	                  <option  value="ES">ES</option>  
	                  <option  value="GO">GO</option>  
	                  <option  value="MA">MA</option>  
	                  <option  value="MG">MG</option>  
	                  <option  value="MS">MS</option>  
	                  <option  value="MT">MT</option>  
	                  <option  value="PA">PA</option>  
	                  <option  value="PB">PB</option>  
	                  <option  value="PE">PE</option>  
	                  <option  value="PI">PI</option>  
	                  <option  value="PR">PR</option>  
	                  <option  value="RJ">RJ</option>  
	                  <option  value="RN">RN</option>  
	                  <option  value="RO">RO</option>  
	                  <option  value="RR">RR</option>  
	                  <option  value="RS">RS</option>  
	                  <option  value="SC">SC</option>  
	                  <option  value="SE">SE</option>  
	                  <option  value="SP">SP</option>  
	                  <option  value="TO">TO</option>  
	               </select>
		</li>
		<li>
			<label for="CepPaciente" title="CEP do paciente">CEP<span></span></label>
			<input type="text" name="cepPaciente" size="9" maxlength="9"/>
		</li>
		<li>
			<label for="DddPaciente" title="DDD do paciente">DDD<span></span></label>
			<input type="text" name="dddPaciente"size="3" maxlength="3" />
		</li>
		<li>
			<label for="TelefonePaciente" title="Telefone do paciente">Telefone<span></span></label>
			<input type="text" name="telefonePaciente"size="9" maxlength="9" />
		</li>
		<li>
			<label for="ResponsavelPaciente" title="Responsável pelo paciente">Responsável<span></span></label>
			<input type="text" name="responsavelPaciente"size="50" maxlength="50"/>
		</li>		
		
	</ol>
	<ol>
		<li>
			<input type="reset" value="Limpar campos" name="botao" />
			<input type="submit" value="Gravar" name="botao" />
			<input type="submit" value="Excluir" name="botao" />
			<input type="submit" value="Pesquisar" name="botao" />
			<input type="submit" value="Sair" name="botao" />
		</li>
	</ol>
	</fieldset>
	
</form>

</div>

</body>
</html>