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
		Acesso acesso = new Acesso();

		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("acesso");
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);
		}else if (btn.equals("Cadastrar")){
			acesso = preencheObjeto(request, response);
			if (validaCampos(acesso)){				
				try{
					DaoAcesso daoAcesso = new DaoAcesso();
					daoAcesso.cadastrarAcesso(acesso);
					mensagem = "Acesso cadastrado com sucesso!";
					request.setAttribute("msg", mensagem);
					request.setAttribute("msgE", null);
					RequestDispatcher disp = request.getRequestDispatcher("acesso.jsp");
					disp.forward(request, response);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				request.setAttribute("msg", null);
				request.setAttribute("msgE", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("acesso.jsp");
				disp.forward(request, response);
			}
		}else if (btn.equals("Pesquisar")){
			acesso = preencheObjeto(request, response);
			if (acesso.getDescricaoAcesso()!=null){
				try{
					DaoAcesso daoAcesso = new DaoAcesso();
					acesso = daoAcesso.pesquisarAcessoPorNome(acesso);
					if (acesso != null){
						mensagem = "Acesso encontrado.";
						request.setAttribute("msg", mensagem);
						request.setAttribute("msgE", null);
						objetoSessao.setAttribute("acesso", acesso);
						RequestDispatcher disp = request.getRequestDispatcher("acesso_alterar.jsp");
						disp.forward(request, response);
					}else{
						mensagem = "Acesso não encontrado.";
						request.setAttribute("msg", null);
						request.setAttribute("msgE", mensagem);
						RequestDispatcher disp = request.getRequestDispatcher("acesso.jsp");
						disp.forward(request, response);
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				request.setAttribute("msg", null);
				request.setAttribute("msgE", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("acesso.jsp");
				disp.forward(request, response);
			}
		}else if(btn.equals("Excluir")){
			try{
				acesso = (Acesso)objetoSessao.getAttribute("acesso");
				DaoAcesso daoAcesso = new DaoAcesso();
				daoAcesso.excluirAcesso(acesso);
				mensagem = "Acesso excluído com sucesso.";
				request.setAttribute("msg", mensagem);
				request.setAttribute("msgE", null);
				objetoSessao.removeAttribute("acesso");
				RequestDispatcher disp = request.getRequestDispatcher("acesso.jsp");
				disp.forward(request, response);
			}catch (Exception e) {
				mensagem = "Ocorreu algum erro ao excluir o acesso.";
				request.setAttribute("msg", null);
				request.setAttribute("msgE", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("acesso.jsp");
				disp.forward(request, response);
				e.printStackTrace();
			}
		}else if(btn.equals("Alterar")){
			acesso = preencheObjeto(request, response);
			acesso.setIdAcesso(((Acesso)objetoSessao.getAttribute("acesso")).getIdAcesso());
			if (validaCampos(acesso)){	
				try{					
					DaoAcesso daoAcesso = new DaoAcesso();
					daoAcesso.alterarAcesso(acesso);
					mensagem = "Acesso alterado com sucesso.";
					request.setAttribute("msgE", null);
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("acesso");
					objetoSessao.removeAttribute("data");
					RequestDispatcher disp = request.getRequestDispatcher("acesso.jsp");
					disp.forward(request, response);
				}catch (Exception e) {
					mensagem = "Ocorreu algum erro ao alterar o acesso.";
					request.setAttribute("msg", null);
					request.setAttribute("msgE", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("acesso.jsp");
					disp.forward(request, response);
				}
			}else{
				request.setAttribute("msg", null);
				request.setAttribute("msgE", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("acesso_alterar.jsp");
				disp.forward(request, response);
			}	
		}
	}
	
	public Acesso preencheObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Acesso acesso = new Acesso();
		acesso.setDescricaoAcesso((String)request.getParameter("descricaoAcesso"));
		return acesso;		
	}
		
	public boolean validaCampos(Acesso acesso){
		boolean result = false;
		acesso.setDescricaoAcesso(acesso.getDescricaoAcesso().trim()); // retira espaços
		if ((acesso.getDescricaoAcesso() == null) || (acesso.getDescricaoAcesso().equals(""))){
			mensagem = "Preencha o nome do acesso corretamente.";
		}else{
			result = true;
		}
		return result;
	}
}
