package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import persistencia.DaoUsuario;

public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletLogin() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("login").equals("") || request.getParameter("senha").equals("")){
			request.setAttribute("msg","Login ou senha inválido");
			response.sendRedirect("login.jsp");
			System.out.println("Login ou senha em branco");
		}
		try{
    		Usuario usuario = new Usuario();
    		usuario.setLoginUsuario((String)request.getParameter("login"));
    		DaoUsuario daoUsuario = new DaoUsuario();
    		//usuario = daoUsuario.consultarUsuario(usuario);
    		if (usuario != null){
        		if (usuario.getSenhaUsuario().equals((String)request.getParameter("senha"))){
        			request.setAttribute("msg","Seja bem vindo, "+usuario.getNomeUsuario());
        			response.sendRedirect("principal.jsp");
        			System.out.println("Seja bem vindo");
        		}else{
        			request.setAttribute("msg","Login ou senha inválido");
        			response.sendRedirect("login.jsp");
        			System.out.println("Senha inválido");
        		}
    		}else{
    			request.setAttribute("msg","Login não existe");
    			response.sendRedirect("login.jsp");
    			System.out.println("Login não existe");
    		}
    	}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
