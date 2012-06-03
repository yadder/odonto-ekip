<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de telefoneFornecedor</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
</head>
<body>
<f:view>
	<h:form id="formTelefoneFornecedorCad" styleClass="">
		<h:messages />
		<h:panelGrid border="1" columns="2">
			<f:facet name="header">
				<h:outputText value="Cadastro de TelefoneFornecedor" />
			</f:facet>
			
			<h:outputLabel for="dddTelefoneFornecedor" value="Ddd telefoneFornecedor:" />
			<h:inputText id="dddTelefoneFornecedor" value="#{telefoneFornecedorMB.telefoneFornecedor.dddTelefoneFornecedor}" />
			
			<h:outputLabel for="telefoneTelefoneFornecedor" value="Telefone telefoneFornecedor:" />
			<h:inputText id="telefoneTelefoneFornecedor" value="#{telefoneFornecedorMB.telefoneFornecedor.telefoneTelefoneFornecedor}"  />
			<f:facet name="footer">
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{telefoneFornecedorMB.salvarTelefoneFornecedor}" />
					<h:commandButton value="Cancelar" action="#{telefoneFornecedorMB.cancelarCadastroTelefoneFornecedor}" immediate="true" />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
		<br />
	<h:form id="formTelefoneFornecedorOther">
		<!-- Tabela de TelefoneFornecedor cadastrados --> 
		<h:dataTable  var="vtelefoneFornecedor" value="#{telefoneFornecedorMB.telefoneFornecedores}" border="1" cellpadding="1" cellspacing="1" rendered="#{telefoneFornecedoresMB.sizeTelefoneFornecedores > 0}">
			<f:facet name="header">
				<h:outputText value="TelefoneFornecedores cadastrados" />
			</f:facet>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Codigo" />
				</f:facet>
				<h:outputText value="#{vtelefoneFornecedor.telefoneTelefoneFornecedor}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Nome" />
				</f:facet>
				<h:outputText value="#{vtelefoneFornecedor.telefoneFornecedor}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Alterar" />
				</f:facet>
				<h:commandLink action="#{telefoneFornecedorMB.alterarTelefoneFornecedor}">
					<h:outputText value="Alterar" />
					<f:setPropertyActionListener value="#{vtelefoneFornecedor}" target="#{telefoneFornecedorMB.telefoneFornecedor}"/>
				</h:commandLink>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Excluir" />
				</f:facet>
				<h:commandLink action="#{telefoneFornecedorMB.excluirTelefoneFornecedor}">
					<h:outputText value="Excluir" />
					<f:setPropertyActionListener value="#{vtelefoneFornecedor}" target="#{telefoneFornecedorMB.telefoneFornecedor}"/>
				</h:commandLink>
			</h:column>
		<f:facet name="footer">
			<h:outputText value="Total:  #{telefoneFornecedorMB.sizeTelefoneFornecedor}" />
		</f:facet>
		</h:dataTable>
	</h:form>
</f:view>
</body>
</html>