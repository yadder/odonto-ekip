<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Paciente</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
</head>
<body>
<f:view>
<rich:panel>
	<h:form id="formPacienteCad" styleClass="">
		<h:messages />
		<h:panelGrid border="1" columns="2">
			<f:facet name="header">
				<h:outputText value="Cadastro de Paciente" />
			</f:facet>		
			
			<h:outputLabel for="convenioPaciente" value="Convênio:" />			
			<h:selectOneMenu value="#{convenioMB.convenios}">
				<f:selectItem itemValue=""/>
				<f:selectItem itemValue=""/>
				<f:selectItem itemValue=""/>					
			</h:selectOneMenu>			
			
			<h:outputLabel for="responsavelPaciente" value="Responsavel Paciente:" />
			<h:inputText id="responsavelPaciene" value="#{pacienteMB.paciente.responsavelPaciente}"  maxlength="50"/>
			
			<h:outputLabel for="logradouroPaciente" value="Logradouro: " />
			<h:inputText id="logradouroPaciente" value="#{pacienteMB.paciente.logradouroPaciente}" required="true" maxlength="100"/>
			
			<h:outputLabel for="numeroLogradouroPaciente" value="Numero Logradouro:" />
			<h:inputText id="numeroLogradouroPaciente" value="#{pacienteMB.paciente.numeroLogradouroPaciente}" required="true" maxlength="5"/>
			
			<h:outputLabel for="complementoLogradouroPaciente" value="Complemento:" />
			<h:inputText id="complementoLogradouroPaciente" value="#{pacienteMB.paciente.complementoLogradouroPaciente}" required="true" maxlength="50"/>
			
			<h:outputLabel for="bairroPaciente" value="Bairro:" />
			<h:inputText id="bairroPaciente" value="#{pacienteMB.paciente.bairroPaciente}" required="true" maxlength="30"/>
			
			<h:outputLabel for="cidadePaciente" value="Cidade:" />
			<h:inputText id="cidadePaciente" value="#{pacienteMB.paciente.cidadePaciente}" required="true" maxlength="30"/>
			
			<h:outputLabel for="estadoPaciente" value="Estado:" />			
			<h:selectOneMenu value="#{pacienteMB.paciente.estadoPaciente}">
				<f:selectItem itemValue="AC"/>
				<f:selectItem itemValue="AL"/>
				<f:selectItem itemValue="AM"/>
				<f:selectItem itemValue="AP"/>
				<f:selectItem itemValue="BA"/>
				<f:selectItem itemValue="DF"/>
				<f:selectItem itemValue="ES"/>
				<f:selectItem itemValue="GO"/>
				<f:selectItem itemValue="MA"/>
				<f:selectItem itemValue="MG"/>
				<f:selectItem itemValue="MS"/>
				<f:selectItem itemValue="MT"/>
				<f:selectItem itemValue="PA"/>
				<f:selectItem itemValue="PB"/>
				<f:selectItem itemValue="PE"/>
				<f:selectItem itemValue="PI"/>
				<f:selectItem itemValue="PR"/>
				<f:selectItem itemValue="RJ"/>
				<f:selectItem itemValue="RN"/>
				<f:selectItem itemValue="RO"/>
				<f:selectItem itemValue="RR"/>
				<f:selectItem itemValue="RS"/>
				<f:selectItem itemValue="SC"/>
				<f:selectItem itemValue="SE"/>
				<f:selectItem itemValue="SP"/>
				<f:selectItem itemValue="TO"/>			
			</h:selectOneMenu>
			
			<h:outputLabel for="cepPaciente" value="Cep:" />
			<h:inputText id="cepPaciente" value="#{pacienteMB.paciente.cepPaciente}"  maxlength="9"/>
						
			<f:facet name="footer">
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{pacienteMB.salvarPaciente}" />
					<h:commandButton value="Cancelar" action="#{pacienteMB.cancelarCadastroPaciente}" immediate="true" />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
		<br />
	<h:form id="formPacienteOther">
		<!-- Tabela de pacientes cadastrados --> 
		<h:dataTable  var="vpaciente" value="#{pacienteMB.pacientes}" border="1" cellpadding="1" cellspacing="1" rendered="#{pacienteMB.sizePacientes > 0}">
			<f:facet name="header">
				<h:outputText value="Pacientes cadastrados" />
			</f:facet>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Codigo" />
				</f:facet>
				<h:outputText value="#{vpaciente.codigoPaciente}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Nome" />
				</f:facet>
				<h:outputText value="#{vpaciente.nomePaciente}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Alterar" />
				</f:facet>
				<h:commandLink action="#{pacienteMB.alterarPaciente}">
					<h:outputText value="Alterar" />
					<f:setPropertyActionListener value="#{vpaciente}" target="#{pacienteMB.paciente}"/>
				</h:commandLink>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Excluir" />
				</f:facet>
				<h:commandLink action="#{pacienteMB.excluirPaciente}">
					<h:outputText value="Excluir" />
					<f:setPropertyActionListener value="#{vpaciente}" target="#{pacienteMB.paciente}"/>
				</h:commandLink>
			</h:column>
		<f:facet name="footer">
			<h:outputText value="Total:  #{pacienteMB.sizePacientes}" />
		</f:facet>
		</h:dataTable>
	</h:form>
</rich:panel>
</f:view>
</body>
</html>