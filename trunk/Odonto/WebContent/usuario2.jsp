<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Usuario</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
</head>
<body>
<f:view>
	<h:form id="formUsuarioCad">
		<h:messages />
		<h:panelGrid border="1" columns="2">
			<f:facet name="header">
				<h:outputText value="Cadastro de Usuario" /> 
			</f:facet>
			
			<h:outputLabel for="nomeUsuario" value="Nome:" />
			<h:inputText id="nomeUsuario" value="#{usuarioMB.usuario.nomeUsuario}"  />
			
			<h:outputLabel for="loginUsuario" value="Login:" />
			<h:inputText id="loginUsuario" value="#{usuarioMB.usuario.loginUsuario}"  />
			
			<h:outputLabel for="senhaUsuario" value="Senha:" />
			<h:inputText id="senhaUsuario" value="#{usuarioMB.usuario.senhaUsuario}"  />
			
			<h:outputLabel for="rgUsuario" value="RG:" />
			<h:inputText id="rgUsuario" value="#{usuarioMB.usuario.rgUsuario}"  />
			
			<h:outputLabel for="cpfUsuario" value="CPF:" />
			<h:inputText id="cpfUsuario" value="#{usuarioMB.usuario.cpfUsuario}"  />
			
			<h:outputLabel for="dataNascimentoUsuario" value="Data Nascimento:" />
			<rich:calendar id="dataNascimentoUsuario" value="#{usuarioMB.usuario.dataNascimentoUsuario}" datePattern="dd/MM/yyyy" />			

			<h:outputLabel for="sexoUsuario" value="Sexo:" />
			<h:selectOneMenu value="#{usuarioMB.usuario.sexoUsuario}">
				<f:selectItem itemValue="MASCULINO"/>
				<f:selectItem itemValue="FEMININO"/>			
			</h:selectOneMenu>	
			
			<h:selectoneradio id="tipoDePessoa" value="${myBean.tipoDePessoa}">  
    <f:selectitem itemvalue="PESSOA_FISICA" itemlabel="Pessoa Física"></f:selectitem>  
    <f:selectitem itemvalue="PESSOA_JURIDICA" itemlabel="Pessoa Jurídica"></f:selectitem>  
    <a4j:support ajaxsingle="true" rerender="blocoDeInformacoesExtras"></a4j:support>  
</h:selectoneradio>  
			
			<h:outputLabel for="perfilUsuario" value="Perfil:" />			
			<h:selectOneMenu value="#{usuarioMB.usuario.perfilUsuario}" onselect="">
				<f:selectItem itemValue="DENTISTA"/>
				<f:selectItem itemValue="PACIENTE"/>
				<f:selectItem itemValue="RECEPCIONISTA"/>	
				<a4j:support event="onselect" rerender="sePerfilDentista" />  		
			</h:selectOneMenu>
			
			<!-- Se o cadastro for de DENTISTA -->
			 
			<h:outputLabel for="croDentista" value="CRO:" />
			<h:inputText id="sePerfilDentista" value="#{usuarioMB.dentista.croDentista}"  maxlength="30" />
			
							
			<!-- Se o cadastro for de PACIENTE -->							
			<h:outputLabel for="responsavelPaciente" value="Responsavel Paciente:" rendered="#{usuarioMB.usuario.perfilUsuario eq 'PACIENTE' }"/>
			<h:inputText id="responsavelPaciene" value="#{usuarioMB.paciente.responsavelPaciente}"  maxlength="50" rendered="#{usuarioMB.usuario.perfilUsuario eq 'PACIENTE' }"/>
			
			<h:outputLabel for="logradouroPaciente" value="Logradouro: " rendered="#{usuarioMB.usuario.perfilUsuario eq 'PACIENTE' }" />
			<h:inputText id="logradouroPaciente" value="#{usuarioMB.paciente.logradouroPaciente}"  maxlength="100" rendered="#{usuarioMB.usuario.perfilUsuario eq 'PACIENTE' }"/>
			
			<h:outputLabel for="numeroLogradouroPaciente" value="Numero Logradouro:" rendered="#{usuarioMB.usuario.perfilUsuario eq 'PACIENTE' }" />
			<h:inputText id="numeroLogradouroPaciente" value="#{usuarioMB.paciente.numeroLogradouroPaciente}"  maxlength="5" rendered="#{usuarioMB.usuario.perfilUsuario eq 'PACIENTE' }"/>
			
			<h:outputLabel for="complementoLogradouroPaciente" value="Complemento:" rendered="#{usuarioMB.usuario.perfilUsuario eq 'PACIENTE' }" />
			<h:inputText id="complementoLogradouroPaciente" value="#{usuarioMB.paciente.complementoLogradouroPaciente}"  maxlength="50" rendered="#{usuarioMB.usuario.perfilUsuario eq 'PACIENTE' }"/>
			
			<h:outputLabel for="bairroPaciente" value="Bairro:" rendered="#{usuarioMB.usuario.perfilUsuario eq 'PACIENTE' }" />
			<h:inputText id="bairroPaciente" value="#{usuarioMB.paciente.bairroPaciente}"  maxlength="30" rendered="#{usuarioMB.usuario.perfilUsuario eq 'PACIENTE' }"/>
			
			<h:outputLabel for="cidadePaciente" value="Cidade:" rendered="#{usuarioMB.usuario.perfilUsuario eq 'PACIENTE' }" />
			<h:inputText id="cidadePaciente" value="#{usuarioMB.paciente.cidadePaciente}"  maxlength="30" rendered="#{usuarioMB.usuario.perfilUsuario eq 'PACIENTE' }"/>
			
			<h:outputLabel for="estadoPaciente" value="Estado:" rendered="#{usuarioMB.usuario.perfilUsuario eq 'PACIENTE' }" />			
			<h:selectOneMenu value="#{usuarioMB.paciente.estadoPaciente}" rendered="#{usuarioMB.usuario.perfilUsuario eq 'PACIENTE' }">
				<f:selectItem itemValue="AC"/>				<f:selectItem itemValue="AL"/>				<f:selectItem itemValue="AM"/>
				<f:selectItem itemValue="AP"/>				<f:selectItem itemValue="BA"/>				<f:selectItem itemValue="DF"/>
				<f:selectItem itemValue="ES"/>				<f:selectItem itemValue="GO"/>				<f:selectItem itemValue="MA"/>
				<f:selectItem itemValue="MG"/>				<f:selectItem itemValue="MS"/>				<f:selectItem itemValue="MT"/>
				<f:selectItem itemValue="PA"/>				<f:selectItem itemValue="PB"/>				<f:selectItem itemValue="PE"/>
				<f:selectItem itemValue="PI"/>				<f:selectItem itemValue="PR"/>				<f:selectItem itemValue="RJ"/>
				<f:selectItem itemValue="RN"/>				<f:selectItem itemValue="RO"/>				<f:selectItem itemValue="RR"/>
				<f:selectItem itemValue="RS"/>				<f:selectItem itemValue="SC"/>				<f:selectItem itemValue="SE"/>
				<f:selectItem itemValue="SP"/>				<f:selectItem itemValue="TO"/>			
			</h:selectOneMenu>
			
			<h:outputLabel for="cepPaciente" value="Cep:" rendered="#{usuarioMB.usuario.perfilUsuario eq 'PACIENTE' }" />
			<h:inputText id="cepPaciente" value="#{usuarioMB.paciente.codigoUsuario}"  maxlength="9" rendered="#{usuarioMB.usuario.perfilUsuario eq 'PACIENTE' }"/>
											
			<f:facet name="footer">
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{usuarioMB.salvarUsuario}" />
					<h:commandButton value="Cancelar" action="#{usuarioMB.cancelarCadastroUsuario}" />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
		<br />
	<h:form id="formUsuarioOther">
		<!-- Tabela de Usuario cadastrados --> 
		<h:dataTable  var="vusuario" value="#{usuarioMB.usuarios}" border="1" cellpadding="1" cellspacing="1" rendered="#{usuarioMB.sizeUsuarios > 0}">
			<f:facet name="header">
				<h:outputText value="Usuários cadastrados" />
			</f:facet>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Código" />
				</f:facet>
				<h:outputText value="#{vusuario.codigoUsuario }" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Nome" />
				</f:facet>
				<h:outputText value="#{vusuario.nomeUsuario}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Alterar" />
				</f:facet>
				<h:commandLink action="#{usuarioMB.alterarUsuario}">
					<h:outputText value="Alterar" />
					<f:setPropertyActionListener value="#{vusuario}" target="#{usuarioMB.usuario}"/>
				</h:commandLink>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Excluir" />
				</f:facet>
				<h:commandLink action="#{usuarioMB.excluirUsuario}">
					<h:outputText value="Excluir" />
					<f:setPropertyActionListener value="#{vusuario}" target="#{usuarioMB.usuario}"/>
				</h:commandLink>
			</h:column>
		<f:facet name="footer">
			<h:outputText value="Total:  #{usuarioMB.sizeUsuarios}" />
		</f:facet>
		</h:dataTable>
	</h:form>
</f:view>
</body>
</html>