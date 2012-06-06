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
			<rich:calendar id="dataConsulta" value="#{consultaMB.consulta.dataConsulta}" datePattern="dd/MM/yyyy" />		
						
						
			
			<h:outputLabel for="statusConsulta" value="Status Consulta:" />							
			<h:selectOneMenu value="#{consultaMB.consulta.statusConsulta}" >
				<f:selectItem itemValue="AGENDADA"/>
				<f:selectItem itemValue="REALIZADA"/>
				<f:selectItem itemValue="REMARCADA"/>							
				<f:selectItem itemValue="CANCELADA"/>			
			</h:selectOneMenu>
			
			
			
						
			<f:facet name="footer">
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{consultaMB.salvarConsulta}" />
					<h:commandButton value="Cancelar" action="#{consultaMB.cancelarCadastroConsulta}" immediate="true" />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
		<br />
	<h:form id="formConsultaOther">
		<!-- Tabela de consultas cadastradas --> 
		<h:dataTable  var="vconsulta" value="#{consultaMB.consultas}" border="1" cellpadding="1" cellspacing="1" rendered="#{consultaMB.sizeConsultas > 0}">
			<f:facet name="header">
				<h:outputText value="Consultas cadastradas" />
			</f:facet>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Codigo" />
				</f:facet>
				<h:outputText value="#{vconsulta.codigoConsulta}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Data" />
				</f:facet>
				<h:outputText value="#{vconsulta.dataConsulta}" />
			</h:column>
				<h:column>
				<f:facet name="header">
					<h:outputText value="Status" />
				</f:facet>
				<h:outputText value="#{vconsulta.statusConsulta}" />
			</h:column>
			
			<h:column>
				<f:facet name="header">
					<h:outputText value="Alterar" />
				</f:facet>
				<h:commandLink action="#{consultaMB.alterarConsulta}">
					<h:outputText value="Alterar" />
					<f:setPropertyActionListener value="#{vconsulta}" target="#{consultaMB.consulta}"/>
				</h:commandLink>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Excluir" />
				</f:facet>
				<h:commandLink action="#{consultaMB.excluirConsulta}">
					<h:outputText value="Excluir" />
					<f:setPropertyActionListener value="#{vconsulta}" target="#{consultaMB.consulta}"/>
				</h:commandLink>
			</h:column>
		<f:facet name="footer">
			<h:outputText value="Total:  #{consultaMB.sizeConsultas}" />
		</f:facet>
		</h:dataTable>
	</h:form>
</rich:panel>
</f:view>
</body>
</html>