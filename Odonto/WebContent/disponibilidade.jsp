<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Disponibilidade</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
</head>
<body>
<f:view>
	<h:form id="formDisponibilidadeCad" styleClass="">
		<h:messages />
		<h:panelGrid border="1" columns="2">
			<f:facet name="header">
				<h:outputText value="Cadastro de Disponibilidade" /> 
			</f:facet>
			
			<h:outputLabel for="diaSemanaDisponibilidade" value="Dia da Semana Disponibilidade:" />
			<h:inputText id="diaSemanaDisponibilidade" value="#{disponibilidadeMB.disponibilidade.diaSemana}"  />
			<h:outputLabel for="horaInicioDisponibilidade" value="Hora Inicio Disponibilidade:" />
			<h:inputText id="horaInicioDisponibilidade" value="#{disponibilidadeMB.disponibilidade.horaInicio}" />
			<h:outputLabel for="horaFimDisponibilidade" value="Hora Fim Disponibilidade:" />
			<h:inputText id="horaFimDisponibilidade" value="#{disponibilidadeMB.disponibilidade.horaFim}"  />
					
			<f:facet name="footer">
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{disponibilidadeMB.salvarDisponibilidade}" />
					<h:commandButton value="Cancelar" action="#{disponibilidadeMB.cancelarCadastroDisponibilidade}" immediate="true" />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
		<br />
	<h:form id="formDisponibilidadeOther">
		<!-- Tabela de Disponibilidade cadastrados --> 
		<h:dataTable  var="vDisponibilidade" value="#{disponibilidadeMB.disponibilidades}" border="1" cellpadding="1" cellspacing="1" rendered="#{disponibilidadesMB.sizedisponibilidades > 0}">
			<f:facet name="header">
				<h:outputText value="Disponibilidades Cadastrados" />
			</f:facet>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Codigo" />
				</f:facet>
				<h:outputText value="#{vdisponibilidade.telefonedisponibilidade}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Nome" />
				</f:facet>
				<h:outputText value="#{vdisponibilidade.disponibilidade}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Alterar" />
				</f:facet>
				<h:commandLink action="#{disponibilidadeMB.alterarDisponibilidade}">
					<h:outputText value="Alterar" />
					<f:setPropertyActionListener value="#{vdisponibilidade}" target="#{disponibilidadeMB.disponibilidade}"/>
				</h:commandLink>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Excluir" />
				</f:facet>
				<h:commandLink action="#{disponibilidadeMB.excluirDisponibilidade}">
					<h:outputText value="Excluir" />
					<f:setPropertyActionListener value="#{vdisponibilidade}" target="#{disponibilidadeMB.disponibilidade}"/>
				</h:commandLink>
			</h:column>
		<f:facet name="footer">
			<h:outputText value="Total:  #{disponibilidadeMB.sizeDisponibilidades}" />
		</f:facet>
		</h:dataTable>
	</h:form>
</f:view>
</body>
</html>