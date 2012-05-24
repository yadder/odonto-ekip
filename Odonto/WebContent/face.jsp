<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de face</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
</head>
<body>
<f:view>
<rich:panel>
	<h:form id="formFaceCad" styleClass="">
		<h:messages />
		<h:panelGrid border="1" columns="2">
			<f:facet name="header">
				<h:outputText value="Cadastro de Face" />
			</f:facet>
			
			<h:outputLabel for="nomeFace" value="Nome face:" />
			<h:inputText id="nomeFace" value="#{faceMB.face.nomeFace}" required="true" />
			
			<f:facet name="footer">
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{faceMB.salvarFace}" />
					<h:commandButton value="Cancelar" action="#{faceMB.cancelarCadastroFace}" immediate="true" />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
		<br />
	<h:form id="formFaceOther">
		<!-- Tabela de faces cadastradas --> 
		<h:dataTable  var="vface" value="#{faceMB.faces}" border="1" cellpadding="1" cellspacing="1" rendered="#{faceMB.sizeFaces > 0}">
			<f:facet name="header">
				<h:outputText value="Faces cadastradas" />
			</f:facet>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Codigo" />
				</f:facet>
				<h:outputText value="#{vface.codigoFace}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Nome" />
				</f:facet>
				<h:outputText value="#{vface.nomeFace}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Alterar" />
				</f:facet>
				<h:commandLink action="#{faceMB.alterarFace}">
					<h:outputText value="Alterar" />
					<f:setPropertyActionListener value="#{vface}" target="#{faceMB.face}"/>
				</h:commandLink>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Excluir" />
				</f:facet>
				<h:commandLink action="#{faceMB.excluirFace}">
					<h:outputText value="Excluir" />
					<f:setPropertyActionListener value="#{vface}" target="#{faceMB.face}"/>
				</h:commandLink>
			</h:column>
		<f:facet name="footer">
			<h:outputText value="Total:  #{faceMB.sizeFaces}" />
		</f:facet>
		</h:dataTable>
	</h:form>
</rich:panel>
</f:view>
</body>
</html>