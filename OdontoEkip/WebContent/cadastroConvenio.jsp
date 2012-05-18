<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j" %>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich" %>

<f:view>
	<h:form id="form1">
	  <h:panelGrid columns="2">
		<h:outputLabel value="Código convênio: " for="codigoConvenio" />
		<h:inputText id="codigoConvenio" value="#{ManagerBean.convenio.codigoConvenio}" size="10" />
		
		<h:outputLabel value="Nome convênio: " for="nomeConvenio" />
		<h:inputText id="nomeConvenio" value="#{ManagerBean.convenio.nomeConvenio}" size="30" />
		
		<h:commandButton value="Gravar" action="#{ManagerBean.gravar}" />
		<h:commandButton value="Pesquisar" action="#{ManagerBean.pesquisar}" />
		
	  </h:panelGrid>	
	</h:form>
	<h:messages />
</f:view>
