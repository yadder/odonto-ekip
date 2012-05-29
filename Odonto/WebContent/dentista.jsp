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
	<h:form id="formDentistaCad" styleClass="">
		<h:messages />
		<h:panelGrid border="1" columns="2">
			<f:facet name="header">
				<h:outputText value="Cadastro de Dentista" />
			</f:facet>		
			
			<h:outputLabel for="croDentista" value="CRO:" />
			<h:inputText id="croDentista" value="#{dentistaMB.dentista.croDentista}" required="true" maxlength="30"/>
			
			<f:facet name="footer">
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{dentistaMB.salvarDentista}" />
					<h:commandButton value="Cancelar" action="#{dentistaMB.cancelarCadastroDentista}" immediate="true" />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
		<br />
	<h:form id="formConvenioOther">
		<!-- Tabela de dentistas cadastrados --> 
		<h:dataTable  var="vdentista" value="#{dentistaMB.dentista}" border="1" cellpadding="1" cellspacing="1" rendered="#{dentistaMB.sizeDentistas > 0}">
			<f:facet name="header">
				<h:outputText value="Dentistas cadastrados" />
			</f:facet>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Codigo" />
				</f:facet>
				<h:outputText value="#{vdentista.codigoDentista}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Nome" />
				</f:facet>
				<h:outputText value="#{vdentista.croDentista}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Alterar" />
				</f:facet>
				<h:commandLink action="#{dentistaMB.alterarDentista}">
					<h:outputText value="Alterar" />
					<f:setPropertyActionListener value="#{vdentista}" target="#{dentistaMB.dentista}"/>
				</h:commandLink>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Excluir" />
				</f:facet>
				<h:commandLink action="#{dentistaMB.excluirDentista}">
					<h:outputText value="Excluir" />
					<f:setPropertyActionListener value="#{vdentista}" target="#{dentistaMB.dentista}"/>
				</h:commandLink>
			</h:column>
		<f:facet name="footer">
			<h:outputText value="Total:  #{dentistaMB.sizeDentistas}" />
		</f:facet>
		</h:dataTable>
	</h:form>
</f:view>
</body>
</html>