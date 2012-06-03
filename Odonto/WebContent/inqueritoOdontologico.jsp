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
			<h:selectOneRadio id="tratamentoMedico" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.tratamentoMedico}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:selectOneRadio id="myRadio" value="#{myBackingBean.myRadioValue}">
			   <f:selectItem itemValue="0" itemLabel="#{myBackingBean.myRadioPossibleLabel1}"/>   
			   <f:selectItem itemValue="1" itemLabel="#{myBackingBean.myRadioPossibleLabel2}"/>   
			   <f:selectItem itemValue="2" itemLabel="#{myBackingBean.myRadioPossibleLabel3}"/>   
			</h:selectOneRadio>
			
			
			
			
		   	<h:outputLabel for="usandoMedicacao" value="Usando medicação?" />
			<h:selectOneRadio id="usandoMedicacao" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.usandoMedicacao}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>		   
		   				
			<h:outputLabel for="alergia" value="Possui alergia?" />
			<h:selectOneRadio id="alergia" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.alergia}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>				
			
			<h:outputLabel for="anemia" value="Possui anemia?" />
			<h:selectOneRadio id="anemia" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.anemia}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="hepatite" value="Possui hepatite?" />
			<h:selectOneRadio id="hepatite" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.hepatite}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="sifilis" value="Possui sifilis?" />
			<h:selectOneRadio id="sifilis" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.sifilis}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="hiv" value="Possui HIV?" />
			<h:selectOneRadio id="hiv" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.hiv}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="tuberculose" value="Tuberculose?" />
			<h:selectOneRadio id="tuberculose" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.tuberculose}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="asma" value="Asma?" />
			<h:selectOneRadio id="asma" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.asma}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>			
			
			<h:outputLabel for="fumante" value="Fumante?" />
			<h:selectOneRadio id="fumante" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.fumante}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>			
			
			<h:outputLabel for="alcoolista" value="Alcoolista?" />
			<h:selectOneRadio id="alcoolista" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.alcoolista}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>			
			
			<h:outputLabel for="herpesAfitas" value="Possui Herpes Afitas?" />
			<h:selectOneRadio id="herpesAfitas" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.herpesAfta}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>						
			
			<h:outputLabel for="gravidez" value="Gravidez?" />
			<h:selectOneRadio id="gravidez" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.gravidez}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>			
			
			<h:outputLabel for="diabetes" value="Diabetes?" />
			<h:selectOneRadio id="diabetes" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.diabetes}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>			
			
			<h:outputLabel for="cardiaco" value="Cardiaco?" />
			<h:selectOneRadio id="cardiaco" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.cardiaco}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
						
			<h:outputLabel for="dataUltimoAtendimento" value="Data Ultimo Atendimento :" />			
			<rich:calendar id="dataUltimoAtendimento" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.dataUltimoAtendimento}" datePattern="dd/MM/yyyy" />			
			
			<h:outputLabel for="concluiTratamento" value="Concluiu tratamento?" />
			<h:selectOneRadio id="concluiTratamento" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.concluiuTratamento}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>			
			
			<h:outputLabel for="experienciaNegativaTratamento" value="Experiencia Negativa Tratamento ?:" />
			<h:inputText id="experienciaNegativaTratamento" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.experienciaNegativaTratamento}"  />			
			
			<h:outputLabel for="roerUnhas" value="Roer unhas?" />
			<h:selectOneRadio id="roerUnhas" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.roerUnhas}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="respirarPelaBoca" value="Resperar pela boca?" />
			<h:selectOneRadio id="respirarPelaBoca" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.respirarPelaBoca}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="morderObjetos" value="Morder objetos?" />
			<h:selectOneRadio id="morderObjetos" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.morderObjetos}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="rangerOsDentes" value="Ranger os dentes?" />
			<h:selectOneRadio id="rangerOsDentes" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.rangerOsDentes}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="chuparaDedoOuChupeta" value="Chupar dedo ou chupeta?" />
			<h:selectOneRadio id="chuparaDedoOuChupeta" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.chuparDedoChupeta}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>			
			
			<h:outputLabel for="outros" value="Outros :" />
			<h:inputText id="outros" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.outros}"  />			
			
			<h:outputLabel for="fioFitaDental" value="Fio ou fita dental?" />
			<h:selectOneRadio id="fioFitaDental" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.fioFitaDental}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="palito" value="Palito?" />
			<h:selectOneRadio id="palito" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.palito}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="unitufoBitufo" value="Unitufo/Bitufo?" />
			<h:selectOneRadio id="unitufoBitufo" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.unitufoBitufo}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>			
			
			<h:outputLabel for="tipoEscova" value="Tipo escova?" />
			<h:selectOneRadio id="tipoEscova" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.tipoEscova}">
		    	<f:selectItem itemValue="Macia" itemLabel="Macia" />	    
		    	<f:selectItem itemValue="Média" itemLabel="Média" />
			    <f:selectItem itemValue="Dura" itemLabel="Dura" />
			</h:selectOneRadio>
			
			<h:outputLabel for="interDental" value="Interdental?" />
			<h:selectOneRadio id="interDental" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.interdental}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="cremeDental" value="Creme dental?" />
			<h:selectOneRadio id="cremeDental" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.cremeDental}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>
			
			<h:outputLabel for="ingereAlimentosEntreRefeicoes" value="Ingere alimentos entre refeições?" />
			<h:selectOneRadio id="ingereAlimentosEntreRefeicoes" value="#{inqueritoOdontologicoMB.inqueritoOdontologico.ingereAlimentosEntreRefeicoes}">
		    	<f:selectItem itemValue="Sim" itemLabel="Sim" />	    
			    <f:selectItem itemValue="Não" itemLabel="Não" />
			</h:selectOneRadio>			
			
			<f:facet name="footer">
			
				<h:panelGroup>	
					<h:commandButton value="Salvar" action="#{inqueritoOdontologicoMB.salvarInqueritoOdontologico}" />
					<h:commandButton value="Cancelar" action="#{inqueritoOdontologicoMB.cancelarCadastroInqueritoOdontologico}" immediate="true" />
					<h:commandButton value="Sair" action="gotoPrincipal"></h:commandButton>
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>
		<br />
	<h:form id="forminqueritoOdontologicoCad">
		<!-- Tabela de inqueritoOdontologicos cadastrados --> 
		<h:dataTable  var="vinqueritoOdontologico" value="#{inqueritoOdontologicoMB.inqueritoOdontologicos}" border="1" cellpadding="1" cellspacing="1" rendered="#{inqueritoOdontologicoMB.sizeInqueritoOdontologicos > 0}">
			<f:facet name="header">
				<h:outputText value="Fornecedors cadastrados" />
			</f:facet>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Codigo" />
				</f:facet>
				<h:outputText value="#{vinqueritoOdontologico.codigoFornecedor}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Nome" />
				</f:facet>
				<h:outputText value="#{vinqueritoOdontologico.nomeFornecedor}" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Alterar" />
				</f:facet>
				<h:commandLink action="#{inqueritoOdontologicoMB.alterarInqueritoOdontologico}">
					<h:outputText value="Alterar" />
					<f:setPropertyActionListener value="#{vinqueritoOdontologico}" target="#{inqueritoOdontologicoMB.inqueritoOdontologico}"/>
				</h:commandLink>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Excluir" />
				</f:facet>
				<h:commandLink action="#{inqueritoOdontologicoMB.excluirInqueritoOdontologico}">
					<h:outputText value="Excluir" />
					<f:setPropertyActionListener value="#{vinqueritoOdontologico}" target="#{inqueritoOdontologicoMB.inqueritoOdontologico}"/>
				</h:commandLink>
			</h:column>
		<f:facet name="footer">
			<h:outputText value="Total:  #{inqueritoOdontologicoMB.sizeInqueritoOdontologicos}" />
		</f:facet>
		</h:dataTable>
	</h:form>
</rich:panel>
</f:view>
</body>
</html>