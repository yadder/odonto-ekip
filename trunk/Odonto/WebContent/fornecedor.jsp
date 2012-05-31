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
<body>
<f:view>
<rich:panel>
	<h:form id="formFornecedorCad" styleClass="">
		<h:messages />
		<h:panelGrid border="1" columns="2">
			<f:facet name="header">
				<h:outputText value="Cadastro de Fornecedor" />
			</f:facet>		
			
			<h:outputLabel for="nomeFornecedor" value="Nome:" />
			<h:inputText id="nomeFornecedor" value="#{fornecedorMB.fornecedor.nomeFornecedor}" required="true" maxlength="50"/>			
			
			<h:outputLabel for="cnpjFornecedor" value="CNPJ:"/>
			<h:inputText id="cnpjFornecedor" value="#{fornecedorMB.fornecedor.cnpjFornecedor}" required="true" maxlength="18"/>
			
			<h:outputLabel for="logradouroFornecedor" value="Logradouro Fornecedor:" />
			<h:inputText id="logradouroFornecedor" value="#{fornecedorMB.fornecedor.logradouroFornecedor}" required="true" maxlength="100"/>
			
			<h:outputLabel for="numeroLogradouroFornecedor" value="Numero Logradouro:" />
			<h:inputText id="numeroLogradouroFornecedor" value="#{fornecedorMB.fornecedor.numeroLogradouroFornecedor}" required="true" maxlength="4"/>
			
			<h:outputLabel for="complementoLogradouroFornecedor" value="Complemento Logradouro:" />
			<h:inputText id="complementoLogradouroFornecedor" value="#{fornecedorMB.fornecedor.complementoLogradouroFornecedor}" required="true" maxlength="50"/>
			
			<h:outputLabel for="bairroFornecedor" value="Bairro:" />
			<h:inputText id="bairroFornecedor" value="#{fornecedorMB.fornecedor.bairroFornecedor}" required="true" maxlength="30"/>
			
			<h:outputLabel for="estadoFornecedor" value="Estado:" />			
			<h:selectOneMenu value="#{fornecedorMB.fornecedor.estadoFornecedor}">
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
			
			<h:outputLabel for="cidadeFornecedor" value="Cidade:" />
			<h:inputText id="cidadeFornecedor" value="#{fornecedorMB.fornecedor.cidadeFornecedor}" required="true" maxlength="30"/>			
			
			<h:outputLabel for="cepFornecedor" value="Cep:" />
			<h:inputText id="cepFornecedor" value="#{fornecedorMB.fornecedor.cepFornecedor}" required="true" maxlength="9"/>
			
			<h:outputLabel for="nomeVendedor" value="Nome Vendedor:" />
			<h:inputText id="nomeVendedor" value="#{fornecedorMB.fornecedor.nomeVendedor}" required="true" maxlength="50"/>
			
			<h:outputLabel for="emailVendedor" value="Email Vendedor:" />
			<h:inputText id="emailVendedor" value="#{fornecedorMB.fornecedor.emailVendedor}" required="true" maxlength="50"/>
			
			<h:outputLabel for="siteFornecedor" value="Site:" />
			<h:inputText id="siteFornecedor" value="#{fornecedorMB.fornecedor.siteFornecedor}" required="true" maxlength="50"/>
			
			<f:facet name="footer">
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{fornecedorMB.salvarFornecedor}" />
					<h:commandButton value="Cancelar" action="#{fornecedorMB.cancelarCadastroFornecedor}" immediate="true" />
					<h:commandButton value="Sair" action="gotoPrincipal"></h:commandButton>
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