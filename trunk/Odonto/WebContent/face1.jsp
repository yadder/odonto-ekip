<%@taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style type="text/css">
 .login { width:300px; top:150px; position: absolute;}
 .msgErro { width:300px; position:relative; }
 .camposLogin { width:200px; }
</style>
<f:view>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>LOGIN</title>
 </head>
 <body>
 <a4j:form>
 <rich:panel styleClass="login" style="">
 <f:facet name="header">
 <h:outputText value="Digite o usuário e a senha"/>
 </f:facet>
 <h:panelGrid columns="2">
 <h:outputText value="Usuário:"/><h:inputText value="#{loginBackingBean.usuario.login}" size="30" styleClass="camposLogin"/>
 <h:outputText value="Senha:"/><h:inputSecret value="#{loginBackingBean.usuario.senha}" size="30" styleClass="camposLogin"/>
 </h:panelGrid>
 <a4j:commandButton action="#{loginBackingBean.efetuaLogin}" value="Entrar" reRender="mensagemErro"/>
 </rich:panel>
 </a4j:form>
 <a4j:status>
 <f:facet name="start">
 <h:graphicImage value="#{pageContext.servletContext.contextPath}/imagens/carregando.gif"/>
 </f:facet>
 </a4j:status>
 <rich:panel id="mensagemErro" rendered="#{loginBackingBean.msgErro}" styleClass="msgErro">
 <h:panelGrid columns="2">
 <h:graphicImage  value="#{pageContext.servletContext.contextPath}/imagens/loginErro.png"/>
 <h:outputText value="Erro! Usuário ou Senha inválidos." />
 </h:panelGrid>
 </rich:panel>
 </body>
</f:view>