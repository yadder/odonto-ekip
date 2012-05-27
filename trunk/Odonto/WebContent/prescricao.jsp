<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="func" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Prescricao</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
</head>
<body>
<f:view>
	<h:form id="formPrescricaoCad" styleClass="">
		<h:messages />
		<h:panelGrid border="1" columns="2">
			<f:facet name="header">
				<h:outputText value="Cadastro de Prescricao" />
			</f:facet>		
			
			<h:outputLabel for="observacaoPrescricao" value="Observação Prescricao:" />
			<h:inputText id="observacaoPrescricao" value="#{prescricaoMB.prescricao.observacaoPrescricao}" required="true" />
			
			<f:facet name="footer">
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{prescricaoMB.salvarPrescricao}" />
					<h:commandButton value="Cancelar" action="#{prescricaoMB.cancelarCadastroPrescricao}" immediate="true" />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
		<br />
	<h:form id="formConvenioOther">
		<!-- Tabela de prescricaos cadastrados --> 
		<h:dataTable  var="vprescricao" value="#{prescricaoMB.prescricaoa}" border="1" cellpadding="1" cellspacing="1" rendered="#{prescricaoMB.sizePrescricaos > 0}">
			<f:facet name="header">
				<h:outputText value="Prescricaos cadastrados" />
			</f:facet>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Codigo" />
				</f:facet>
				<h:outputText value="#{vprescricao.codigoPrescricao}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Nome" />
				</f:facet>
				<h:outputText value="#{vprescricao.croPrescricao}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Alterar" />
				</f:facet>
				<h:commandLink action="#{prescricaoMB.alterarPrescricao}">
					<h:outputText value="Alterar" />
					<f:setPropertyActionListener value="#{vprescricao}" target="#{denistaMB.prescricao}"/>
				</h:commandLink>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Excluir" />
				</f:facet>
				<h:commandLink action="#{prescricaoMB.excluirPrescricao}">
					<h:outputText value="Excluir" />
					<f:setPropertyActionListener value="#{vprescricao}" target="#{deintistaMB.prescricao}"/>
				</h:commandLink>
			</h:column>
		<f:facet name="footer">
			<h:outputText value="Total:  #{prescricaoMB.sizePrescricao}" />
		</f:facet>
		</h:dataTable>
	</h:form>
</f:view>
</body>
</html>