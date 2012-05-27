<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Procedimento</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
</head>
<body>
<f:view>
<rich:panel>
	<h:form id="formProcedimentoCad" styleClass="">
		<h:messages />
		<h:panelGrid border="1" columns="2">
			<f:facet name="header">
				<h:outputText value="Cadastro de Procedimento" />
			</f:facet>		
			
			<h:outputLabel for="descricaoProcedimento" value="Descricao Procedimento:" />
			<h:outputLabel for="valorProcedimento" value="Valor Procedimento:" />
			<h:inputText id="descricaoProcedimento" value="#{procedimentoMB.procedimento.descricaoProcedimento}" required="true" />
			<h:inputText id="valorProcedimento" value="#{procedimentoMB.procedimento.valorProcedimento}" required="true" />
			
			<f:facet name="footer">
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{procedimentoMB.salvarProcedimento}" />
					<h:commandButton value="Cancelar" action="#{procedimentoMB.cancelarCadastroProcedimento}" immediate="true" />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
		<br />
	<h:form id="formProcedimentoOther">
		<!-- Tabela de procedimentos cadastrados --> 
		<h:dataTable  var="vprocedimento" value="#{procedimentoMB.procedimentos}" border="1" cellpadding="1" cellspacing="1" rendered="#{procedimentoMB.sizeProcedimentos > 0}">
			<f:facet name="header">
				<h:outputText value="Procedimentos cadastrados" />
			</f:facet>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Codigo" />
				</f:facet>
				<h:outputText value="#{vprocedimento.codigoProcedimento}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Nome" />
				</f:facet>
				<h:outputText value="#{vprocedimento.nomeProcedimento}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Alterar" />
				</f:facet>
				<h:commandLink action="#{procedimentoMB.alterarProcedimento}">
					<h:outputText value="Alterar" />
					<f:setPropertyActionListener value="#{vprocedimento}" target="#{procedimentoMB.procedimento}"/>
				</h:commandLink>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Excluir" />
				</f:facet>
				<h:commandLink action="#{procedimentoMB.excluirProcedimento}">
					<h:outputText value="Excluir" />
					<f:setPropertyActionListener value="#{vprocedimento}" target="#{procedimentoMB.procedimento}"/>
				</h:commandLink>
			</h:column>
		<f:facet name="footer">
			<h:outputText value="Total:  #{procedimentoMB.sizeProcedimentos}" />
		</f:facet>
		</h:dataTable>
	</h:form>
</rich:panel>
</f:view>
</body>
</html>