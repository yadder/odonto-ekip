<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pesquisar pagamento</title>
</head>
<body>
<f:view>
<rich:panel>
	<h:form id="formPesquisaPagamento" styleClass="">
		<h:messages />
		<h:panelGrid border="1" columns="3">
			<f:facet name="header">
				<h:outputText value="Pesquisa de pagamento" />
			</f:facet>		
			<h3>Pesquisar pagamento por nome do paciente ou CPF: </h3>
			<h:outputLabel for="nomePaciente" value="Nome do paciente"/>
			<h:inputText id="nomePaciente" value="#{pacienteMB.paciente.nomeUsuario}" /><br /><br />
			
			<h:outputLabel for="cpfPaciente" value="CPF do paciente"/>
			<h:inputText id="cpfPaciente" value="#{pacienteMB.paciente.cpfUsuario}" /><br /><br />
			
			<f:facet name="footer">
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{pagamentoMB.salvarPagamento}" />
					<h:commandButton value="Sair" action="gotoPrincipal" />
				</h:panelGroup>
			</f:facet>

		</h:panelGrid>			
	</h:form>
</rich:panel>	
</f:view>
</body>
</html>