<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Odontograma</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
</head>
<body>
<f:view>
	<h:form id="formOdontogramaCad" styleClass="">
		<h:messages />
		<h:panelGrid border="1" columns="2">
			<f:facet name="header">
				<h:outputText value="Cadastro de Odontograma" /> 
			
			</f:facet>
			
			<h:outputLabel for="codigoDentista" value="Código Dentista:" />
			<h:inputText id="codigoDentista" value="#{odontogramaMB.odontograma.codigoDentista}" required="true" />
			<h:outputLabel for="codigoPaciente" value="Código Paciente:" />
			<h:inputText id="codigoPaciente" value="#{odontogramaMB.odontograma.codigoPaciente}" required="true" />
			<h:outputLabel for="valorOdontograma" value="Valor Odontograma:" />
			<h:inputText id="valorOdontograma" value="#{odontogramaMB.odontograma.valorOdontograma}" required="true" />
			<h:outputLabel for="dataOdontograma" value="Data Odontograma:" />
			<h:inputText id="dataOdontograma" value="#{odontogramaMB.odontograma.dataOdontograma}" required="true" />
			<h:outputLabel for="statusOdontograma" value="Status Odontograma:" />
			<h:inputText id="statusOdontograma" value="#{odontogramaMB.odontograma.statusOdontograma}" required="true" />
													
			<f:facet name="footer">
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{odontogramaMB.salvarOdontograma}" />
					<h:commandButton value="Cancelar" action="#{odontogramaMB.cancelarCadastroOdontograma}" immediate="true" />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
		<br />
		<h:form id="formOdontogramaOther">
		<!-- Tabela de odontogramas cadastrados --> 
		<h:dataTable  var="vodontograma" value="#{odontogramaMB.odontogramas}" border="1" cellpadding="1" cellspacing="1" rendered="#{odontogramaMB.sizeOdontogramas > 0}">
			<f:facet name="header">
				<h:outputText value="Odontogramas cadastrados" />
			</f:facet>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Codigo" />
				</f:facet>
				<h:outputText value="#{vodontograma.codigoOdontograma}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Nome" />
				</f:facet>
				<h:outputText value="#{vodontograma.nomeOdontograma}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Alterar" />
				</f:facet>
				<h:commandLink action="#{odontogramaMB.alterarOdontograma}">
					<h:outputText value="Alterar" />
					<f:setPropertyActionListener value="#{vodontograma}" target="#{odontogramaMB.odontograma}"/>
				</h:commandLink>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Excluir" />
				</f:facet>
				<h:commandLink action="#{odontogramaMB.excluirOdontograma}">
					<h:outputText value="Excluir" />
					<f:setPropertyActionListener value="#{vodontograma}" target="#{odontogramaMB.odontograma}"/>
				</h:commandLink>
			</h:column>
		<f:facet name="footer">
			<h:outputText value="Total:  #{odontogramaMB.sizeOdontogramas}" />
		</f:facet>
		</h:dataTable>
	</h:form>
</f:view>
</body>
</html>