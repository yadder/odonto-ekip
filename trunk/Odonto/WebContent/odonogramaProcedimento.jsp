<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Odontograma Procedimentos</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
</head>
<body>
<f:view>
	<h:form id="formOdontogramaProcedimentosCad" styleClass="">
		<h:messages />
		<h:panelGrid border="1" columns="2">
			<f:facet name="header">
				<h:outputText value="Cadastro de Odontograma Procedimentos" /> 
			
			</f:facet>
			
			<h:outputLabel for="codigoProcedimento" value="Código Procedimento:" />
			<h:inputText id="codigoProcedimento" value="#{odontogramaProcedimentoMB.odontogramaProcedimento.codigoOdontogramaProcedimeto}"  />
								
			<h:outputLabel for="statusPagamento" value="Status Pagamento:" />			
			<h:selectOneMenu value="#{odontogramaProcedimentoMB.odontogramaProcedimento.statusPagamento}">
				<f:selectItem itemValue="PAGO"/>
				<f:selectItem itemValue="PENDENTE"/>											
			</h:selectOneMenu>			
			
			<h:outputLabel for="dataPagamento" value="Data Pagamento Odontograma:" />
			<h:inputText id="dataPagamento" value="#{odontogramaProcedimentoMB.odontogramaProcedimento.dataPagamento}"  />
			
			<h:outputLabel for="statusAutorizacao" value="Status Autorização:" />		
			<h:selectOneMenu value="#{odontogramaProcedimentoMB.odontogramaProcedimento.statusAutorizacao}">
				<f:selectItem itemValue="APROVADO"/>
				<f:selectItem itemValue="NÃO APROVADO"/>
				<f:selectItem itemValue="EM ANÁLISE"/>															
			</h:selectOneMenu>
			
													
			<f:facet name="footer">
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{odontogramaProcedimentoMB.salvarOdontogramaProcedimento}" />
					<h:commandButton value="Cancelar" action="#{odontogramaProcedimentoMB.cancelarCadastroOdontogramaProcedimento}" immediate="true" />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
		<br />
		<h:form id="formOdontogramaOther">
		<!-- Tabela de odontogramaProcedimentoss cadastrados --> 
		<h:dataTable  var="vodontogramaProcedimentos" value="#{odontogramaProcedimentoMB.odontogramaProcedimento}" border="1" cellpadding="1" cellspacing="1" rendered="#{odontogramaProcedimentoMB.sizeOdontogramaProcedimentos > 0}">
			<f:facet name="header">
				<h:outputText value="OdontogramasProcedimentos cadastrados" />
			</f:facet>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Codigo" />
				</f:facet>
				<h:outputText value="#{vodontogramaProcedimentos.codigoOdontograma}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Código Procedimento" />
				</f:facet>
				<h:outputText value="#{vodontogramaProcedimentos.codigoOdontogramaProcedimeto}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Alterar" />
				</f:facet>
				<h:commandLink action="#{odontogramaProcedimentoMB.alterarOdontogramaProcedimento}">
					<h:outputText value="Alterar" />
					<f:setPropertyActionListener value="#{vodontogramaProcedimentos}" target="#{odontogramaProcedimentoMB.odontogramaProcedimento}"/>
				</h:commandLink>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Excluir" />
				</f:facet>
				<h:commandLink action="#{odontogramaProcedimentoMB.excluirOdontogramaProcedimento}">
					<h:outputText value="Excluir" />
					<f:setPropertyActionListener value="#{vodontogramaProcedimentos}" target="#{odontogramaProcedimentoMB.odontogramaProcedimento}"/>
				</h:commandLink>
			</h:column>
		<f:facet name="footer">
			<h:outputText value="Total:  #{odontogramaProcedimentoMB.sizeOdontogramaProcedimentos}" />
		</f:facet>
		</h:dataTable>
	</h:form>
</f:view>
</body>
</html>