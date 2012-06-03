<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de telefonePaciente</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
</head>
<body>
<f:view>
	<h:form id="formTelefonePacienteCad" styleClass="">
		<h:messages />
		<h:panelGrid border="1" columns="2">
			<f:facet name="header">
				<h:outputText value="Cadastro de TelefonePaciente" />
			</f:facet>
			
			<h:outputLabel for="dddTelefonePaciente" value="Ddd telefonePaciente:" />
			<h:inputText id="dddTelefonePaciente" value="#{telefonePacienteMB.telefonePaciente.dddTelefonePaciente}"  />
			
			<h:outputLabel for="telefoneTelefonePaciente" value="Telefone telefonePaciente:" />
			<h:inputText id="telefoneTelefonePaciente" value="#{telefonePacienteMB.telefonePaciente.telefoneTelefonePaciente}"  />
			
			<f:facet name="footer">
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{telefonePacienteMB.salvarTelefonePaciente}" />
					<h:commandButton value="Cancelar" action="#{telefonePacienteMB.cancelarCadastroTelefonePaciente}" immediate="true" />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
		<br />
	<h:form id="formTelefonePacienteOther">
		<!-- Tabela de TelefonePaciente cadastrados --> 
		<h:dataTable  var="vtelefonePaciente" value="#{telefonePacienteMB.telefonePacientees}" border="1" cellpadding="1" cellspacing="1" rendered="#{telefonePacienteesMB.sizeTelefonePacientees > 0}">
			<f:facet name="header">
				<h:outputText value="TelefonePacientees cadastrados" />
			</f:facet>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Codigo" />
				</f:facet>
				<h:outputText value="#{vtelefonePaciente.telefoneTelefonePaciente}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Nome" />
				</f:facet>
				<h:outputText value="#{vtelefonePaciente.telefonePaciente}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Alterar" />
				</f:facet>
				<h:commandLink action="#{telefonePacienteMB.alterarTelefonePaciente}">
					<h:outputText value="Alterar" />
					<f:setPropertyActionListener value="#{vtelefonePaciente}" target="#{telefonePacienteMB.telefonePaciente}"/>
				</h:commandLink>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Excluir" />
				</f:facet>
				<h:commandLink action="#{telefonePacienteMB.excluirTelefonePaciente}">
					<h:outputText value="Excluir" />
					<f:setPropertyActionListener value="#{vtelefonePaciente}" target="#{telefonePacienteMB.telefonePaciente}"/>
				</h:commandLink>
			</h:column>
		<f:facet name="footer">
			<h:outputText value="Total:  #{telefonePacienteMB.sizeTelefonePaciente}" />
		</f:facet>
		</h:dataTable>
	</h:form>
</f:view>
</body>
</html>