<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Elemento</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
</head>
<body>
<f:view>
<rich:panel>
	<h:form id="formElementoCad" styleClass="">
		<h:messages />
		<h:panelGrid border="1" columns="2">
			<f:facet name="header">
				<h:outputText value="Cadastro de Elemento" />
			</f:facet>		
			
			<h:outputLabel for="nomeElemento" value="Nome elemento:" />
			<h:inputText id="nomeElemento" value="#{elementoMB.elemento.nomeElemento}" required="true" maxlength="2"/>
			
			<f:facet name="footer">
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{elementoMB.salvarElemento}" />
					<h:commandButton value="Cancelar" action="#{elementoMB.cancelarCadastroElemento}" immediate="true" />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
		<br />
	<h:form id="formElementoOther">
		<!-- Tabela de elementos cadastrados --> 
		<h:dataTable  var="velemento" value="#{elementoMB.elementos}" border="1" cellpadding="1" cellspacing="1" rendered="#{elementoMB.sizeElementos > 0}">
			<f:facet name="header">
				<h:outputText value="Elementos cadastrados" />
			</f:facet>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Codigo" />
				</f:facet>
				<h:outputText value="#{velemento.codigoElemento}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Nome" />
				</f:facet>
				<h:outputText value="#{velemento.nomeElemento}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Alterar" />
				</f:facet>
				<h:commandLink action="#{elementoMB.alterarElemento}">
					<h:outputText value="Alterar" />
					<f:setPropertyActionListener value="#{velemento}" target="#{elementoMB.elemento}"/>
				</h:commandLink>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Excluir" />
				</f:facet>
				<h:commandLink action="#{elementoMB.excluirElemento}">
					<h:outputText value="Excluir" />
					<f:setPropertyActionListener value="#{velemento}" target="#{elementoMB.elemento}"/>
				</h:commandLink>
			</h:column>
		<f:facet name="footer">
			<h:outputText value="Total:  #{elementoMB.sizeElementos}" />
		</f:facet>
		</h:dataTable>
	</h:form>
</rich:panel>
</f:view>
</body>
</html>