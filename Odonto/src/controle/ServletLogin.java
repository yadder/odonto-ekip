package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;
import persistencia.DaoUsuario;

public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpf = (String)request.getParameter("login");
		String senha = (String)request.getParameter("senha");
		String mensagem = null;
		HttpSession objetoSessao;
		
		Usuario usuarioLogado = new Usuario(cpf, senha);
		DaoUsuario dao = new DaoUsuario();
		usuarioLogado = dao.pesquisarUsuarioPorCpf(cpf);
		
		if ((usuarioLogado != null) && (usuarioLogado.getSenhaUsuario().equals(senha))){
	        // resgata a sessao
			objetoSessao = request.getSession();
			// verifica se o objeto session existe
		    if (objetoSessao == null)
		    { // se nao existe, cria um novo objeto session
		        objetoSessao = request.getSession(true);
		    }  
			// seta o usuarioLogado na sessao
			objetoSessao.setAttribute("usuarioLogado", usuarioLogado);
			mensagem = "Seja bem vindo ";
			request.setAttribute("msgCabecalho", mensagem);
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);
		}else{
			mensagem = "Login ou senha inválido!";
			request.setAttribute("msg", mensagem);
			RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
			disp.forward(request, response);
		}
	}
}
