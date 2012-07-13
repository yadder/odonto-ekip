package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Acesso;
import persistencia.DaoAcesso;

public class ServletAcesso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String mensagem = null;
	
    public ServletAcesso() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String btn = (String)request.getParameter("btn");
		HttpSession objetoSessao = request.getSession();

		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("acesso");
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);
		}else if (btn.equals("Cadastrar")){
			String descricaoAcesso = (String) request.getParameter("descricaoAcesso");
			if (validaCampos(descricaoAcesso)){				
				try{
					Acesso acesso = new Acesso(descricaoAcesso);
					DaoAcesso daoAcesso = new DaoAcesso();
					daoAcesso.cadastrarAcesso(acesso);
					mensagem = "Acesso cadastrado com sucesso!";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("acesso.jsp");
					disp.forward(request, response);
				}catch (Exception e) {
					mensagem = "Ocorreu algum erro ao excluir o acesso.";
					request.setAttribute("msg", mensagem);
					e.printStackTrace();
					RequestDispatcher disp = request.getRequestDispatcher("acesso.jsp");
					disp.forward(request, response);					
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("acesso.jsp");
				disp.forward(request, response);
			}
		}else if (btn.equals("Pesquisar")){
			String descricaoAcesso = (String) request.getParameter("descricaoAcesso");
			try{
				Acesso acesso = new Acesso(descricaoAcesso);
				DaoAcesso daoAcesso = new DaoAcesso();
				acesso = daoAcesso.pesquisarAcessoPorNome(descricaoAcesso);
				if (acesso != null){
					mensagem = "Acesso encontrado.";
					request.setAttribute("msg", mensagem);
					objetoSessao.setAttribute("acesso", acesso);
					RequestDispatcher disp = request.getRequestDispatcher("acesso_alterar.jsp");
					disp.forward(request, response);
				}else{
					mensagem = "Acesso não encontrado.";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("acesso.jsp");
					disp.forward(request, response);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else if(btn.equals("Excluir")){
			try{
				Acesso acesso = new Acesso();
				acesso = (Acesso)objetoSessao.getAttribute("acesso");
				DaoAcesso daoAcesso = new DaoAcesso();
				daoAcesso.excluirAcesso(acesso);
				mensagem = "Acesso excluído com sucesso.";
				request.setAttribute("msg", mensagem);
				objetoSessao.removeAttribute("acesso");
				RequestDispatcher disp = request.getRequestDispatcher("acesso.jsp");
				disp.forward(request, response);
			}catch (Exception e) {
				mensagem = "Ocorreu algum erro ao excluir o acesso.";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("acesso.jsp");
				disp.forward(request, response);
			}
		}else if(btn.equals("Alterar")){
			String descricaoAcesso = (String) request.getParameter("descricaoAcesso");
			if (validaCampos(descricaoAcesso)){	
				try{
					Acesso acesso = new Acesso();
					acesso = (Acesso)objetoSessao.getAttribute("acesso");
					acesso.setDescricaoAcesso((String)request.getParameter("descricaoAcesso"));								
					DaoAcesso daoAcesso = new DaoAcesso();
					daoAcesso.alterarAcesso(acesso);
					mensagem = "Acesso alterado com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("acesso");
					RequestDispatcher disp = request.getRequestDispatcher("acesso.jsp");
					disp.forward(request, response);
				}catch (Exception e) {
					mensagem = "Ocorreu algum erro ao alterar o acesso.";
					request.setAttribute("msg", mensagem);
					e.printStackTrace();
					RequestDispatcher disp = request.getRequestDispatcher("acesso.jsp");
					disp.forward(request, response);
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("acesso_alterar.jsp");
				disp.forward(request, response);
			}
		}
	
	}
	
	public boolean validaCampos(String descricaoAcesso){
		boolean result = false;
		if ((descricaoAcesso == null) || (descricaoAcesso.equals(""))){
			mensagem = "Preencha o nome do acesso corretamente.";
		}else{
			result = true;
		}
		return result;
	}
}
