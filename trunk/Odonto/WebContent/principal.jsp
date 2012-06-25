<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema OdontoEkip - Principal</title>
</head>
<body>
<div class="header">
	<font size="2">${msg} Usuário: ${usuarioLogado.nomeUsuario}
	</font>
	<form name="logout" action="ServletPrincipal" method="post">
		<input type="submit" value="Logout" />
	</form>

<ul class="menu">
  <li><a href="#" title="Inicial">Inicial</a></li>
  <li><a href="#" title="Sobre">Sobre</a></li>
  <li><a href="#" title="Servi&ccedil;os">Servi&ccedil;os</a>
    
      <ul>
            <li><a href="#" title="Web design">Web Design</a>
            
                <ul>
                    <li><a href="#" title="CSS">CSS</a></li>
                    <li><a href="#" title="XHTML">XHTML</a></li>                                        </ul>
                
         </li>
            
            <li><a href="#" title="Web master">Web Master</a></li>
            <li><a href="#" title="SEO">SEO</a></li>
            <li><a href="#" title="Design gr&aacute;fico">Design Gr&aacute;fico</a>
            </li> 
        </ul>
        
    </li>
  <li><a href="#" title="Porftolio">Portfolio</a></li>
  <li  class="border0"><a href="#" title="Contato">Contato</a></li>
</ul>


</div>
	<a href="fornecedor.jsp">Cadastro de fornecedor</a> <br/><br/>
	<a href="inqueritoOdontologico.jsp">Inquérito odontológico</a><br/><br/>
	
	<a href="convenio.jsp">Cadastro de convênio</a><br/><br/>
	<a href="pagamento.jsp">Efetuar pagamento</a><br/><br/>
	
	<hr/>
	testadas e validadas <br/>
	<a href="face.jsp">Cadastro de face</a><br/>
	<a href="elemento.jsp">Cadastro de elemento</a><br/>
	<a href="usuario.jsp">Cadastro de usuário</a><br/>

</body>
</html>