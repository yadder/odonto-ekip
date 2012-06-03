<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Pagamento</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
</head>
<body>
<f:view>
<rich:panel>
	<h:form id="formPagamento" styleClass="">
		<h:messages />
		<h:panelGrid border="1" columns="3">
			<f:facet name="header">
				<h:outputText value="Controle de pagamento" />
			</f:facet>		
			
			<h:outputLabel for="codigoPagamento" value="Código pagamento:" />
			<h:inputText id="codigoPagamento" value="#{pagamentoMB.pagamento.codigoPagamento}" />
			
			<h:outputLabel for="numeroParcela" value="Número parcela:" />
			<h:inputText id="numeroParcela" value="#{pagamentoMB.pagamento.numeroParcela}" />
			
			<h:outputLabel for="valorParcela" value="Valor parcela:" />
			<h:inputText id="valorParcela" value="#{pagamentoMB.pagamento.valorParcela}" />
			
			<h:outputLabel for="statusPagmento" value="Status pagamento:" />			
			<h:selectOneMenu value="#{pagamentoMB.pagamento.statusPagamento}">
				<f:selectItem itemValue="PAGO"/>
				<f:selectItem itemValue="PENDENTE"/>							
			</h:selectOneMenu>
					
			<f:facet name="footer">
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{pagamentoMB.salvarPagamento}" />
					<h:commandButton value="Cancelar" action="#{pagamentoMB.cancelarCadastroPagamento}" />
					<h:commandButton value="Sair" action="gotoPrincipal" />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
		<br />
	<h:form id="formPagamentoOther">
		<!-- Tabela de odontogramas cadastrados --> 
		<h:dataTable  var="vpagamento" value="#{pagamentoMB.pagamentos}" border="1" cellpadding="1" cellspacing="1" rendered="#{pagamentoMB.sizePagamentos > 0}">
			<f:facet name="header">
				<h:outputText value="Pagamentos Cadastrados" />
			</f:facet>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Codigo" />
				</f:facet>
				<h:outputText value="#{vpagamento.c}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Nome" />
				</f:facet>
				<h:outputText value="#{vpagamento.nomeOdontograma}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Alterar" />
				</f:facet>
				<h:commandLink action="#{pagamentoMB.alterarPagamento}">
					<h:outputText value="Alterar" />
					<f:setPropertyActionListener value="#{vpagamento}" target="#{pagamentoMB.pagamento}"/>
				</h:commandLink>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Excluir" />
				</f:facet>
				<h:commandLink action="#{pagamentoMB.excluirPagamento}">
					<h:outputText value="Excluir" />
					<f:setPropertyActionListener value="#{vpagamento}" target="#{pagamentoMB.pagamento}"/>
				</h:commandLink>
			</h:column>
		<f:facet name="footer">
			<h:outputText value="Total:  #{pagamentoMB.sizePagamentos}" />
		</f:facet>
		</h:dataTable>
	</h:form>
</rich:panel>
</f:view>
</body>
</html>