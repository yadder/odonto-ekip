<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Fornecedor</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
</head>
<body>nomeVendedor
<f:view>
<rich:panel>
	<h:form id="formFornecedorCad" styleClass="">
		<h:messages />
		<h:panelGrid border="1" columns="2">
			<f:facet name="header">
				<h:outputText value="Cadastro de Fornecedor" />
			</f:facet>		
			
			<h:outputLabel for="nomeFornecedor" value="Nome Fornecedor:" />
			<h:inputText id="nomeFornecedor" value="#{fornecedorMB.fornecedor.nomeFornecedor}" required="true" maxlength="2"/>
			<h:outputLabel for="nomeVendedorr" value="Nome Vendedor:" />
			<h:inputText id="nomeVendedorr" value="#{fornecedorMB.fornecedor.nomeVendedor}" required="true" maxlength="2"/>
			<h:outputLabel for="emailVendedor" value="Email Vendedor:" />
			<h:inputText id="emailVendedor" value="#{fornecedorMB.fornecedor.emailVendedor}" required="true" maxlength="2"/>
			<h:outputLabel for="siteFornecedor" value="Site Fornecedor:" />
			<h:inputText id="siteFornecedor" value="#{fornecedorMB.fornecedor.siteFornecedor}" required="true" maxlength="2"/>
			<h:outputLabel for="cnpjFornecedor" value="Cnpj Fornecedor:" />
			<h:inputText id="cnpjFornecedor" value="#{fornecedorMB.fornecedor.cnpjFornecedor}" required="true" maxlength="2"/>
			<h:outputLabel for="logradouroFornecedor" value="Logradouro Fornecedor:" />
			<h:inputText id="logradouroFornecedor" value="#{fornecedorMB.fornecedor.logradouroFornecedor}" required="true" maxlength="2"/>
			<h:outputLabel for="numeroLogradouroFornecedor" value="Numero Logradouro Fornecedor:" />
			<h:inputText id="numeroLogradouroFornecedor" value="#{fornecedorMB.fornecedor.numeroLogradouroFornecedor}" required="true" maxlength="2"/>
			<h:outputLabel for="complementoLogradouroFornecedor" value="Complemento Logradouro Fornecedor:" />
			<h:inputText id="complementoLogradouroFornecedor" value="#{fornecedorMB.fornecedor.complementoLogradouroFornecedor}" required="true" maxlength="2"/>
			<h:outputLabel for="bairroFornecedor" value="Bairro Fornecedor:" />
			<h:inputText id="bairroFornecedor" value="#{fornecedorMB.fornecedor.bairroFornecedor}" required="true" maxlength="2"/>
			<h:outputLabel for="cidadeFornecedor" value="Cidade Fornecedor:" />
			<h:inputText id="bairroFornecedorcidadeFornecedor" value="#{fornecedorMB.fornecedor.cidadeFornecedor}" required="true" maxlength="2"/>
			<h:outputLabel for="estadoFornecedor" value="Estado Fornecedor:" />
			<h:inputText id="estadoFornecedor" value="#{fornecedorMB.fornecedor.estadoFornecedor}" required="true" maxlength="2"/>
			<h:outputLabel for="cepFornecedor" value="Cep Fornecedor:" />
			<h:inputText id="estadoFornecedocepFornecedorr" value="#{fornecedorMB.fornecedor.cepFornecedor}" required="true" maxlength="2"/>
			
			
			<f:facet name="footer">
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{fornecedorMB.salvarFornecedor}" />
					<h:commandButton value="Cancelar" action="#{fornecedorMB.cancelarCadastroFornecedor}" immediate="true" />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
		<br />
	<h:form id="formFornecedorOther">
		<!-- Tabela de fornecedors cadastrados --> 
		<h:dataTable  var="vfornecedor" value="#{fornecedorMB.fornecedors}" border="1" cellpadding="1" cellspacing="1" rendered="#{fornecedorMB.sizeFornecedors > 0}">
			<f:facet name="header">
				<h:outputText value="Fornecedors cadastrados" />
			</f:facet>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Codigo" />
				</f:facet>
				<h:outputText value="#{vfornecedor.codigoFornecedor}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Nome" />
				</f:facet>
				<h:outputText value="#{vfornecedor.nomeFornecedor}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Alterar" />
				</f:facet>
				<h:commandLink action="#{fornecedorMB.alterarFornecedor}">
					<h:outputText value="Alterar" />
					<f:setPropertyActionListener value="#{vfornecedor}" target="#{fornecedorMB.fornecedor}"/>
				</h:commandLink>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Excluir" />
				</f:facet>
				<h:commandLink action="#{fornecedorMB.excluirFornecedor}">
					<h:outputText value="Excluir" />
					<f:setPropertyActionListener value="#{vfornecedor}" target="#{fornecedorMB.fornecedor}"/>
				</h:commandLink>
			</h:column>
		<f:facet name="footer">
			<h:outputText value="Total:  #{fornecedorMB.sizeFornecedors}" />
		</f:facet>
		</h:dataTable>
	</h:form>
</rich:panel>
</f:view>
</body>
</html>