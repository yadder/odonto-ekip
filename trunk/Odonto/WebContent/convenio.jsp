<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="func" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Convênio</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
</head>
<body>
<f:view>
	<h:form id="formConvenioCad" styleClass="">
		<h:messages />
		<h:panelGrid border="1" columns="2">
			<f:facet name="header">
				<h:outputText value="Cadastro de Convênio" />
			</f:facet>		
			
			<h:outputLabel for="nomeConvenio" value="Nome convênio:" />
			<h:inputText id="nomeConvenio" value="#{convenioMB.convenio.nomeConvenio}" required="true" maxlength="50" />
			
			<f:facet name="footer">
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{convenioMB.salvarConvenio}" />
					<h:commandButton value="Cancelar" action="#{convenioMB.cancelarCadastroConvenio}" immediate="true" />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
		<br />
	<h:form id="formConvenioOther">
		<!-- Tabela de convenios cadastrados --> 
		<h:dataTable  var="vconvenio" value="#{convenioMB.convenios}" border="1" cellpadding="1" cellspacing="1" rendered="#{convenioMB.sizeConvenios > 0}">
			<f:facet name="header">
				<h:outputText value="Convenios cadastrados" />
			</f:facet>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Codigo" />
				</f:facet>
				<h:outputText value="#{vconvenio.codigoConvenio}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Nome" />
				</f:facet>
				<h:outputText value="#{vconvenio.nomeConvenio}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Alterar" />
				</f:facet>
				<h:commandLink action="#{convenioMB.alterarConvenio}">
					<h:outputText value="Alterar" />
					<f:setPropertyActionListener value="#{vconvenio}" target="#{convenioMB.convenio}"/>
				</h:commandLink>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Excluir" />
				</f:facet>
				<h:commandLink action="#{convenioMB.excluirConvenio}">
					<h:outputText value="Excluir" />
					<f:setPropertyActionListener value="#{vconvenio}" target="#{convenioMB.convenio}"/>
				</h:commandLink>
			</h:column>
		<f:facet name="footer">
			<h:outputText value="Total:  #{convenioMB.sizeConvenios}" />
		</f:facet>
		</h:dataTable>
	</h:form>
</f:view>
</body>
</html>