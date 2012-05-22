<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
	<h:messages />
	<h:form id="form1">
	  <h:panelGrid columns="2" border="1">
		<h:outputLabel value="Código convênio: " />
		<h:inputText id="codigoConvenio" disabled="true" value="#{ManagerBeanConvenio.convenio.codigoConvenio}" size="10" />
		
		<h:outputLabel value="Nome convênio: " for="nomeConvenio" />
		<h:inputText id="nomeConvenio" value="#{ManagerBeanConvenio.convenio.nomeConvenio}" size="30" />
		</h:panelGrid>
		<br>
		<h:commandButton value="Gravar"    action="#{ManagerBeanConvenio.gravar}" /> 
		<h:commandButton value="Pesquisar" action="#{ManagerBeanConvenio.pesquisar}" />
		<h:commandButton value="Alterar"   action="#{ManagerBeanConvenio.alterar}" />
		<h:commandButton value="Excluir"   action="#{ManagerBeanConvenio.excluir}" />
	  	
	  	<h:commandButton value="Sair" action="#{ManagerBeanConvenio.gotoPrincipal}" />
	</h:form>
</f:view>
