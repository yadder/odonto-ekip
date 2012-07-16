<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html> 
<body>   
<!-- cria a  Lista -->  
<jsp:useBean id="lista" class="persistencia.DaoDentista" />
			Selecione o(a) dentista: taglig***
			<select name="dentista">
						<c:forEach var="lis" items="${lista.pesquisarTodosDentista}">
							<option value="${lis.nomeUsuario}">${lis.nomeUsuario}</option>
						</c:forEach>
				</select>
</body>

<table>
<c:forEach items="${sessionScope.listaChamado}" var="colecao">
	<tr id="<c:out value="${colecao.idChamado}"/>" class="font_obj"
		onmouseover="javascript:getOver('<c:out value="${colecao.idChamado}"/>');" onmouseout="javascript:getOut('<c:out value="${colecao.idChamado}"/>');">
	<td><c:out value="${colecao.idChamado}" /></td>
	<td><c:out value="${colecao.assunto}" /></td>
	<td><c:out value="${colecao.status}" /></td>
	<td><a href="srvChamado?comando=Alterar&idChamado=<c:out value="${colecao.idChamado}"/>"><img src="img/editar.png" alt="" title="" border="0" /></a></td>
	<td><a href="srvChamado?comando=Remover&idChamado=<c:out value="${colecao.idChamado}"/>"><img src="img/excluir.png" alt="" title="" border="0" /></a></td>
	</tr>
</c:forEach>
</table>
	<c:if test="${param.msg != null}">
		<div id="div_sucesso" class="div_sucesso"><c:out value="${param.msg}"/><span class="div_fechar" onclick="javascript:trataDiv('div_sucesso');">[x]</span></div>
	</c:if>

</html>   


