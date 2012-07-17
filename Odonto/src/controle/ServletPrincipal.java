package controle;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Dentista;
import persistencia.DaoDentista;

public class ServletPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String mensagem = null;   

    public ServletPrincipal() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession objetoSessao = request.getSession();
		String acao = (String)request.getParameter("acao");		
		try{
			if (acao.equals("logout")){
				objetoSessao.removeAttribute("usuarioLogado");
				objetoSessao.invalidate();
				mensagem = "A sessão foi finalizada!";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
				disp.forward(request, response);	
			}else if (acao.equals("agendar_consulta")){
				DaoDentista daoDentista = new DaoDentista();
				List<Dentista> listaDentista = daoDentista.pesquisarTodosDentista();
				objetoSessao.setAttribute("listaDentista", listaDentista);
				
				mensagem = "Os campos com (*) são obrigatórios.";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("agendar_consulta.jsp");
				disp.forward(request, response);
			}else if (acao.equals("home")){
				
				StringBuffer perdidosNaSessao = new StringBuffer();
				for(Enumeration e = objetoSessao.getAttributeNames(); e.hasMoreElements();){
					perdidosNaSessao.append(e.nextElement() + "\n");
				}
				objetoSessao.setAttribute("perdidosNaSessao", perdidosNaSessao);
				RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
				disp.forward(request, response);
			}
		}catch (Exception e) {
			
		}
		
	}

}



