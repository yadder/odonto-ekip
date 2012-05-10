<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Usuários</title>
</head>
<body>
<div id="content">

<form name="formCadastroUsuario" action="ServletUsuario" method="post">
	<fieldset id="fieldsetCadastroUsuario">
	<legend><span>Cadastro de Usuários</span></legend>
	
	<ol>
		<li>
			<label for="NomeUsuario" title="Nome do Usuário">Nome<span></span></label>
			<input type="text" name="nomeUsuario" size="50" maxlength="50" />
		</li>		
		<li>
			<label for="LoginUsuario" title="Login do Usuário">Login<span></span></label>
			<input type="text" name="loginUsuario"size="20" maxlength="20" />
		</li>
		<li>
			<label for="SenhaUsuario" title="Senha do Usuário">Senha<span></span></label>
			<input type="password" name="senhaUsuario"size="20" maxlength="20" />
		</li>
		<li>
			<label for="DataNascimentoUsuario" title="Data Nascimento do Usuário">Data Nascimento<span></span></label>
			<input type="text" name="dataNascimentoUsuario"size="10" maxlength="10" />
		</li>
		<li>
			<label for="SexoUsuario" title="Sexo do Usuário">Sexo<span></span></label>			
				<select name="sexoUsuario">
					  <option value=""></option>						  		
					  <option value="M">MASCULINO</option>
					  <option value="F">FEMININO</option>	                  	                   
	            </select>
	            
		</li>				
		<li>
			<label for="CpfUsuario" title="CPF do usuário">CPF<span></span></label>
			<input type="text" name="cpfUsuario"size="14" maxlength="14" />
		</li>	
		<li>
			<label for="RgUsuario" title="RG do usuário">RG<span></span></label>
			<input type="text" name="rgUsuario"size="20" maxlength="20" />
		</li>	
		<li>
		<label for="PerfilUsuario" title="Perfil do Usuário">Perfil<span></span></label>			
				<select name="perfilUsuario">
					  <option  value=""></option>						  		
					  <option  value="ADMINISTRADOR">ADMINISTRADOR</option>
					  <option  value="DENTISTA">DENTISTA</option>  
	                  <option  value="PACIENTE">PACIENTE</option>
	                  <option  value="RECEPCIONISTA">RECEPCIONISTA</option>	                   
	            </select>
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