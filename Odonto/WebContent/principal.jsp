<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema OdontoEkip - Principal</title>
</head>
<body>
<f:view>
	<h:form>
	<h:commandLink value="Cadastro de fornecedor" action="gotoFornecedor" /> <br/><br/>
	<h:commandLink value="Inquérito odontológico" action="gotoInqueritoOdontologico" /><br/><br/>
	
	<hr/>
	testadas e validadas <br/>
	<h:commandLink value="Cadastro de face" action="gotoFace" /><br/><br/>
	<h:commandLink value="Cadastro de elemento" action="gotoElemento" /><br/><br/>
	<h:commandLink value="Cadastro de convenio" action="gotoConvenio" /><br/><br/>
	<h:commandLink value="Realizar pagamento" action="gotoPagamento" /><br/><br/>
	
	</h:form>
</f:view>
</body>
</html>