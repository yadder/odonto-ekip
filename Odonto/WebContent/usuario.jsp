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
	<h:form id="formUsuarioCad" styleClass="">
		<h:messages />
		<h:panelGrid border="1" columns="2">
			<f:facet name="header">
				<h:outputText value="Cadastro de Usuario" /> 
			</f:facet>
			
			<h:outputLabel for="nomeUsuario" value="Nome:" />
			<h:inputText id="nomeUsuario" value="#{UsuarioMB.Usuario.nomeUsuario}" required="true" />
			<h:outputLabel for="loginUsuario" value="Login:" />
			<h:inputText id="loginUsuario" value="#{UsuarioMB.Usuario.loginUsuario}" required="true" />
			<h:outputLabel for="senhaUsuario" value="Senha:" />
			<h:inputText id="senhaUsuario" value="#{UsuarioMB.Usuario.senhaUsuario}" required="true" />
			<h:outputLabel for="perfilUsuario" value="Perfil:" />			
			<h:selectOneMenu value="#{UsuarioMB.Usuario.perfilUsuario}">
				<f:selectItem itemValue="ADMINISTRADOR"/>
				<f:selectItem itemValue="DENTISTA"/>
				<f:selectItem itemValue="PACIENTE"/>
				<f:selectItem itemValue="RECEPCIONISTA"/>			
			</h:selectOneMenu>			
			<h:outputLabel for="rgUsuario" value="RG:" />
			<h:inputText id="rgUsuario" value="#{UsuarioMB.Usuario.rgUsuario}" required="true" />
			<h:outputLabel for="cpfUsuario" value="CPF:" />
			<h:inputText id="cpfUsuario" value="#{UsuarioMB.Usuario.cpfUsuario}" required="true" />
			<h:outputLabel for="dataNascimentoUsuario" value="Data Nascimento:" />
			<h:inputText id="dataNascimentoUsuario" value="#{UsuarioMB.Usuario.dataNascimentoUsuario}" required="true" />
			<h:outputLabel for="sexoUsuario" value="Sexo:" />
			<h:selectOneMenu value="#{UsuarioMB.Usuario.sexoUsuario}">
				<f:selectItem itemValue="MASCULINO"/>
				<f:selectItem itemValue="FEMININO"/>			
			</h:selectOneMenu>
											
			<f:facet name="footer">
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{UsuarioMB.salvarUsuario}" />
					<h:commandButton value="Cancelar" action="#{UsuarioMB.cancelarCadastroUsuario}" immediate="true" />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
		<br />
	<h:form id="formUsuarioOther">
		<!-- Tabela de Usuario cadastrados --> 
		<h:dataTable  var="vUsuario" value="#{UsuarioMB.Usuarioes}" border="1" cellpadding="1" cellspacing="1" rendered="#{UsuarioesMB.sizeUsuarios > 0}">
			<f:facet name="header">
				<h:outputText value="Usuarios cadastrados" />
			</f:facet>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Codigo" />
				</f:facet>
				<h:outputText value="#{vUsuario.telefoneUsuario}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Nome" />
				</f:facet>
				<h:outputText value="#{vUsuario.Usuario}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Alterar" />
				</f:facet>
				<h:commandLink action="#{UsuarioMB.alterarUsuario}">
					<h:outputText value="Alterar" />
					<f:setPropertyActionListener value="#{vUsuario}" target="#{UsuarioMB.Usuario}"/>
				</h:commandLink>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Excluir" />
				</f:facet>
				<h:commandLink action="#{UsuarioMB.excluirUsuario}">
					<h:outputText value="Excluir" />
					<f:setPropertyActionListener value="#{vUsuario}" target="#{UsuarioMB.Usuario}"/>
				</h:commandLink>
			</h:column>
		<f:facet name="footer">
			<h:outputText value="Total:  #{UsuarioMB.sizeUsuario}" />
		</f:facet>
		</h:dataTable>
	</h:form>
</f:view>
</body>
</html>