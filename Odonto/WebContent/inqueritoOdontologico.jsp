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
			
			<h:outputLabel for="tratamentoMedico" value="Em tratamento médico?" />
			<h:selectOneRadio id="tratamentoMedico" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.tratamentoMedico}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>	
			
		   	<h:outputLabel for="usandoMedicacao" value="Usando medicação?" />
			<h:selectOneRadio id="usandoMedicacao" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.usandoMedicacao}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>		   
		   				
			<h:outputLabel for="alergia" value="Possui alergia?" />
			<h:selectOneRadio id="alergia" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.alergia}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>				
			
			<h:outputLabel for="anemia" value="Possui anemia?" />
			<h:selectOneRadio id="anemia" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.anemia}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="hepatite" value="Possui hepatite?" />
			<h:selectOneRadio id="hepatite" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.hepatite}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="sifilis" value="Possui sifilis?" />
			<h:selectOneRadio id="sifilis" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.sifilis}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="hiv" value="Possui HIV?" />
			<h:selectOneRadio id="hiv" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.hiv}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="tuberculose" value="Tuberculose?" />
			<h:selectOneRadio id="tuberculose" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.tuberculose}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="asma" value="Asma?" />
			<h:selectOneRadio id="asma" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.asma}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>			
			
			<h:outputLabel for="fumante" value="Fumante?" />
			<h:selectOneRadio id="fumante" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.fumante}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>			
			
			<h:outputLabel for="alcoolista" value="Alcoolista?" />
			<h:selectOneRadio id="alcoolista" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.alcoolista}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>			
			
			<h:outputLabel for="herpesAfitas" value="Possui Herpes Afitas?" />
			<h:selectOneRadio id="herpesAfitas" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.herpesAfitas}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>						
			
			<h:outputLabel for="gravidez" value="Gravidez?" />
			<h:selectOneRadio id="gravidez" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.gravidez}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>			
			
			<h:outputLabel for="diabetes" value="Diabetes?" />
			<h:selectOneRadio id="diabetes" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.diabetes}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>			
			
			<h:outputLabel for="cardiaco" value="Cardiaco?" />
			<h:selectOneRadio id="cardiaco" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.cardiaco}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
						
			<h:outputLabel for="dataUltimoAtendimento" value="Data Ultimo Atendimento :" />
			<h:inputText id="dataUltimoAtendimento" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.dataUltimoAtendimento}" required="true" />			
			
			<h:outputLabel for="concluiTratamento" value="Concluiu tratamento?" />
			<h:selectOneRadio id="concluiTratamento" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.concluiTratamento}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>			
			
			<h:outputLabel for="experienciaNegativaTratamento" value="Experiencia Negativa Tratamento ?:" />
			<h:inputText id="experienciaNegativaTratamento" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.experienciaNegativaTratamento}" required="true" />			
			
			<h:outputLabel for="roerUnhas" value="Roer unhas?" />
			<h:selectOneRadio id="roerUnhas" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.roerUnhas}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="respirarPelaBoca" value="Resperar pela boca?" />
			<h:selectOneRadio id="respirarPelaBoca" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.respirarPelaBoca}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="morderObjetos" value="Morder objetos?" />
			<h:selectOneRadio id="morderObjetos" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.morderObjetos}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="rangerOsDentes" value="Ranger os dentes?" />
			<h:selectOneRadio id="rangerOsDentes" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.rangerOsDentes}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="chuparaDedoOuChupeta" value="Chupar dedo ou chupeta?" />
			<h:selectOneRadio id="chuparaDedoOuChupeta" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.chuparaDedoOuChupeta}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>			
			
			<h:outputLabel for="outros" value="Outros :" />
			<h:inputText id="outros" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.outros}" required="true" />			
			
			<h:outputLabel for="fioFitaDental" value="Fio ou fita dental?" />
			<h:selectOneRadio id="fioFitaDental" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.fioFitaDental}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="palito" value="Palito?" />
			<h:selectOneRadio id="palito" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.palito}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="unitufoBitufo" value="Unitufo/Bitufo?" />
			<h:selectOneRadio id="unitufoBitufo" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.unitufoBitufo}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>			
			
			<h:outputLabel for="tipoEscova" value="Tipo escova?" />
			<h:selectOneRadio id="tipoEscova" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.tipoEscova}">
		    	<f:selectItem itemValue="Macia" itemLabel="Macia" />	    
		    	<f:selectItem itemValue="Média" itemLabel="Média" />
			    <f:selectItem itemValue="Dura" itemLabel="Dura" />
			</h:selectOneRadio>
			
			<h:outputLabel for="interDental" value="Interdental?" />
			<h:selectOneRadio id="interDental" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.interDental}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="cremeDental" value="Creme dental?" />
			<h:selectOneRadio id="cremeDental" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.cremeDental}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="ingereAlimentosEntreRefeicoes" value="Ingere alimentos entre refeições?" />
			<h:selectOneRadio id="ingereAlimentosEntreRefeicoes" value="#{InqueritoOdontologicoMB.InqueritoOdontologico.ingereAlimentosEntreRefeicoes}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>			
			
			<f:facet name="footer">
			
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{InqueritoOdontologicoMB.salvarInqueritoOdontologico}" />
					<h:commandButton value="Cancelar" action="#{InqueritoOdontologicoMB.cancelarCadastroInqueritoOdontologico}" immediate="true" />
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
		<br />
	<h:form id="formInqueritoOdontologicoCad">
		<!-- Tabela de InqueritoOdontologicos cadastrados --> 
		<h:dataTable  var="vInqueritoOdontologico" value="#{InqueritoOdontologicoMB.InqueritoOdontologicos}" border="1" cellpadding="1" cellspacing="1" rendered="#{InqueritoOdontologicoMB.SizeInqueritoOdontologicos > 0}">
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
				<h:commandLink action="#{InqueritoOdontologicoMB.alterarInqueritoOdontologico}">
					<h:outputText value="Alterar" />
					<f:setPropertyActionListener value="#{vInqueritoOdontologico}" target="#{InqueritoOdontologicoMB.InqueritoOdontologico}"/>
				</h:commandLink>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Excluir" />
				</f:facet>
				<h:commandLink action="#{InqueritoOdontologicoMB.excluirInqueritoOdontologico}">
					<h:outputText value="Excluir" />
					<f:setPropertyActionListener value="#{vInqueritoOdontologico}" target="#{InqueritoOdontologicoMB.InqueritoOdontologico}"/>
				</h:commandLink>
			</h:column>
		<f:facet name="footer">
			<h:outputText value="Total:  #{InqueritoOdontologicoMB.SizeInqueritoOdontologicos}" />
		</f:facet>
		</h:dataTable>
	</h:form>
</rich:panel>
</f:view>
</body>
</html>