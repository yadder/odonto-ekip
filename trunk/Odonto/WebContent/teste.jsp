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
</html>   


