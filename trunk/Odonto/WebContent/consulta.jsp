<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de consulta</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
</head>
<body>
<f:view>
<rich:panel>
	<h:form id="formConsultaCad" styleClass="">
		<h:messages />
		<h:panelGrid border="1" columns="2">
			<f:facet name="header">
				<h:outputText value="Cadastro de Consulta" />
			</f:facet>
			
			<h:outputLabel for="dataConsulta" value="Data consulta:" />
			<h:inputText id="dataConsulta" value="#{consultaMB.consulta.dataCconsulta}" required="true" />
			
			<f:facet name="footer">
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{consultaMB.salvarConsulta}" />
					<h:commandButton value="Cancelar" action="#{consultaMB.cancelarCadastroConsulta}" immediate="true" />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
		<br />>
	<h:form id="formConsultaOther">
		<!-- Tabela de consultas cadastradas --> 
		<h:dataTable  var="vconsulta" value="#{consultaMB.consultas}" border="1" cellpadding="1" cellspacing="1" rendered="#{consultaMB.sizeConsultas > 0}">
			<f:consultat name="header">
				<h:outputText value="Consultas cadastradas" />
			</f:consultat>
			<h:column>
				<f:consultat name="header">
					<h:outputText value="Codigo" />
				</f:consultat>
				<h:outputText value="#{vconsulta.codigoConsulta}" />
			</h:column>
			<h:column>
				<f:consultat name="header">
					<h:outputText value="Nome" />
				</f:consultat>
				<h:outputText value="#{vconsulta.nomeConsulta}" />
			</h:column>
			<h:column>
				<f:consultat name="header">
					<h:outputText value="Alterar" />
				</f:consultat>
				<h:commandLink action="#{consultaMB.alterarConsulta}">
					<h:outputText value="Alterar" />
					<f:setPropertyActionListener value="#{vconsulta}" target="#{consultaMB.consulta}"/>
				</h:commandLink>
			</h:column>
			<h:column>
				<f:consultat name="header">
					<h:outputText value="Excluir" />
				</f:consultat>
				<h:commandLink action="#{consultaMB.excluirConsulta}">
					<h:outputText value="Excluir" />
					<f:setPropertyActionListener value="#{vconsulta}" target="#{consultaMB.consulta}"/>
				</h:commandLink>
			</h:column>
		<f:consultat name="footer">
			<h:outputText value="Total:  #{consultaMB.sizeConsultas}" />
		</f:consultat>
		</h:dataTable>
	</h:form>
</rich:panel>
</f:view>
</body>
</html>