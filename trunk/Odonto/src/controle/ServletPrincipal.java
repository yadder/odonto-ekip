package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String mensagem = null;   
    public ServletPrincipal() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mensagem = "Testei o Ajax";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession objetoSessao = request.getSession();
		objetoSessao.removeAttribute("usuarioLogado");
		objetoSessao.invalidate();
		mensagem = "A sessão foi finalizada!";
		request.setAttribute("msg", mensagem);
		RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
		disp.forward(request, response);	
	}

}
