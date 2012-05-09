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
		try{
    		Usuario usuario = new Usuario();
    		usuario.setLoginUsuario(request.getParameter("login"));
    		DaoUsuario daoUsuario = new DaoUsuario();
    		usuario = daoUsuario.consultarUsuario(usuario);
    		if (usuario != null){
        		if (usuario.getSenhaUsuario().equals((String)request.getParameter("senha"))){
        			request.setAttribute("msg","Seja bem vindo, "+usuario.getNomeUsuario());
        			request.getRequestDispatcher("NewFile.jsp").forward(request, response);
        			System.out.println("Achei o login e a senha");
        		}else{
        			request.setAttribute("msg","Login ou senha inválido");
        			request.getRequestDispatcher("NewFile.jsp").forward(request, response);
        			System.out.println("Achei o login e nao achei a senha");
        		}
    		}else{
    			request.setAttribute("msg","Login não existe");
    			request.getRequestDispatcher("NewFile.jsp").forward(request, response);
    			System.out.println("Não achei porra nenhuma");
    		}
    	}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
