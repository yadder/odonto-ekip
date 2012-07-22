package controle;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Dentista;
import persistencia.DaoDentista;

public class ServletPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletPrincipal() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession objetoSessao = request.getSession();
		String acao = (String)request.getParameter("acao");		
		ConfiguraAtributo ca = new ConfiguraAtributo();
		try{
			if (acao.equals("logout")){
				objetoSessao.removeAttribute("usuarioLogado");
				objetoSessao.invalidate();
				ca.sendRedirect(request, response, "A sessão foi finalizada!", null, "login.jsp");
			}else if (acao.equals("agendar_consulta")){
				DaoDentista daoDentista = new DaoDentista();
				List<Dentista> listaDentista = daoDentista.pesquisarTodosDentista();
				objetoSessao.setAttribute("listaDentista", listaDentista);
				ca.sendRedirect(request, response, null, "Os campos com (*) são obrigatórios.", "agendar_consulta.jsp");
			}else if (acao.equals("home")){
				
				StringBuffer perdidosNaSessao = new StringBuffer();
				for(Enumeration<?> e = objetoSessao.getAttributeNames(); e.hasMoreElements();){
					perdidosNaSessao.append(e.nextElement() + "\n");
				}
				objetoSessao.setAttribute("perdidosNaSessao", perdidosNaSessao);
				ca.sendRedirect(request, response, null, null, "principal.jsp");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}



