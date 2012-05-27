<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Inquerito Odontologico</title>
<link rel="stylesheet" type="text/css" href="arquivos/styleOdontoEkip.css" />
</head>
<body>
<f:view>
<rich:panel>
	<h:form id="formFornecedorCad" styleClass="">
		<h:messages />
		<h:panelGrid border="1" columns="6">
			<f:facet name="header">
				<h:outputText value="Cadastro de Inquerito Odontologico" />
			</f:facet>		
			
			<h:outputLabel for="tratamentoMedico" value="Tratamento Médico ?:" />
			<h:outputLabel for="usandoMedicacao" value="Usano Medicação ?:" />
			<h:outputLabel for="alergia" value="Alergia ?:" />
			<h:outputLabel for="anemia" value="Anemia ?:" />
			<h:outputLabel for="fumante" value="Fumante ?:" />
			<h:outputLabel for="hepatite" value="Hepatite ?:" />
			<h:inputText id="tratamentoMedico" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.tratamentoMedico}" required="true" />
			<h:inputText id="usandoMedicacao" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.usandoMedicacao}" required="true" />
			<h:inputText id="alergia" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.alergia}" required="true" />
			<h:inputText id="anemia" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.anemia}" required="true" />
			<h:inputText id="fumante" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.fumante}" required="true" />
			<h:inputText id="hepatite" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.hepatite}" required="true" />
					
			
			<h:outputLabel for="alcoolista" value="Alcoolista ?:" />
			<h:outputLabel for="sifilis" value="Sifilis ?:" />
			<h:outputLabel for="herpesAfitasfumante" value="Herpes Afitas ?:" />
			<h:outputLabel for="hiv" value="Hiv ?:" />
			<h:outputLabel for="gravidez" value="Gravidez ?:" />
			<h:outputLabel for="tuberculose" value="Tuberculose ?:" />
			<h:inputText id="alcoolista" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.alcoolista}" required="true" />
			<h:inputText id="sifilis" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.sifilis}" required="true" />
			<h:inputText id="herpesAfitasfumante" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.herpesAfitas}" required="true" />
			<h:inputText id="hiv" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.hiv}" required="true" />
			<h:inputText id="gravidez" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.gravidez}" required="true" />
			<h:inputText id="tuberculose" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.tuberculose}" required="true" />
			
			<h:outputLabel for="diabetes" value="Diabetes ?:" />
			<h:outputLabel for="asma" value="Asma ?:" />
			<h:outputLabel for="cardiaco" value="Cardiaco ?:" />
			<h:outputLabel for="dataUltimoAtendimento" value="Data Ultimo Atendimento :" />			
			<h:outputLabel for="concluiTratamento" value="Conclui Tratamento ?:" />
			<h:outputLabel for="experienciaNegativaTratamento" value="Experiencia Negativa Tratamento ?:" />
			<h:inputText id="diabetes" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.diabetes}" required="true" />
			<h:inputText id="asma" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.asma}" required="true" />
			<h:inputText id="cardiaco" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.cardiaco}" required="true" />
			<h:inputText id="dataUltimoAtendimento" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.dataUltimoAtendimento}" required="true" />
			<h:inputText id="concluiTratamento" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.concluiTratamento}" required="true" />
			<h:inputText id="experienciaNegativaTratamento" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.experienciaNegativaTratamento}" required="true" />
			
			<h:outputLabel for="roerUnhas" value="RoerUnhas ?:" />
			<h:outputLabel for="respirarPelaBoca" value="Respirar Pela Boca :" />
			<h:outputLabel for="morderObjetos" value="Morder Objetos ?:" />
			<h:outputLabel for="rangerOsDentes" value="Ranger Os Dentes ?:" />
			<h:outputLabel for="chuparaDedoOuChupeta" value="Chupar Dedo Ou Chupeta ?:" />
			<h:outputLabel for="outros" value="Outros :" />
			<h:inputText id="roerUnhas" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.roerUnhas}" required="true" />
			<h:inputText id="respirarPelaBoca" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.respirarPelaBoca}" required="true" />
			<h:inputText id="morderObjetos" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.morderObjetos}" required="true" />
			<h:inputText id="rangerOsDentes" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.rangerOsDentes}" required="true" />
			<h:inputText id="chuparaDedoOuChupeta" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.chuparaDedoOuChupeta}" required="true" />
			<h:inputText id="outros" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.outros}" required="true" />
			
			<h:outputLabel for="fioFitaDental" value="Fio Fita Dental :" />
			<h:outputLabel for="palito" value="Palito ?:" />
			<h:outputLabel for="unitufoBitufo" value="Unitufo Bitufo ?:" />
			<h:outputLabel for="tipoEscova" value="Tipo Escova ?:" />
			<h:outputLabel for="interDental" value="Inter Dental :" />
			<h:outputLabel for="cremeDental" value="Creme Dental :" />
			<h:inputText id="fioFitaDental" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.fioFitaDental}" required="true" />
			<h:inputText id="palito" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.palito}" required="true" />
			<h:inputText id="unitufoBitufo" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.unitufoBitufo}" required="true" />
			<h:inputText id="tipoEscova" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.tipoEscova}" required="true" />
			<h:inputText id="interDental" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.interDental}" required="true" />
			<h:inputText id="cremeDental" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.cremeDental}" required="true" />
			
			
			<h:outputLabel for="ingereAlimentos EntreRefeicoes" value="Ingere Alimentos Entre Refeicoes :" />
			<h:inputText id="ingereAlimentosEntreRefeicoes" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.ingereAlimentosEntreRefeicoes}" required="true" />
			
			
			<f:facet name="footer">
			
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{InqueritoOdontologicoMB.salvarFornecedor}" />
					<h:commandButton value="Cancelar" action="#{InqueritoOdontologicoMB.cancelarCadastroFornecedor}" immediate="true" />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
		<br />
	<h:form id="formFornecedorOther">
		<!-- Tabela de InqueritoOdontologicos cadastrados --> 
		<h:dataTable  var="vInqueritoOdontologico" value="#{InqueritoOdontologicoMB.InqueritoOdontologicos}" border="1" cellpadding="1" cellspacing="1" rendered="#{InqueritoOdontologicoMB.sizeFornecedors > 0}">
			<f:facet name="header">
				<h:outputText value="Fornecedors cadastrados" />
			</f:facet>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Codigo" />
				</f:facet>
				<h:outputText value="#{vInqueritoOdontologico.codigoFornecedor}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Nome" />
				</f:facet>
				<h:outputText value="#{vInqueritoOdontologico.nomeFornecedor}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Alterar" />
				</f:facet>
				<h:commandLink action="#{InqueritoOdontologicoMB.alterarFornecedor}">
					<h:outputText value="Alterar" />
					<f:setPropertyActionListener value="#{vInqueritoOdontologico}" target="#{InqueritoOdontologicoMB.InqueritoOdontologico}"/>
				</h:commandLink>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Excluir" />
				</f:facet>
				<h:commandLink action="#{InqueritoOdontologicoMB.excluirFornecedor}">
					<h:outputText value="Excluir" />
					<f:setPropertyActionListener value="#{vInqueritoOdontologico}" target="#{InqueritoOdontologicoMB.InqueritoOdontologico}"/>
				</h:commandLink>
			</h:column>
		<f:facet name="footer">
			<h:outputText value="Total:  #{InqueritoOdontologicoMB.sizeFornecedors}" />
		</f:facet>
		</h:dataTable>
	</h:form>
</rich:panel>
</f:view>
</body>
</html>