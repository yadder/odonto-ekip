package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Convenio;
import persistencia.DaoConvenio;

public class ServletConvenio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String mensagem = null;

    public ServletConvenio() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String btn = (String)request.getParameter("btn");
		HttpSession objetoSessao = request.getSession();

		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("convenio");
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);
			
		}else if (btn.equals("Cadastrar")){
			String nome = (String) request.getParameter("nomeConvenio");
			if (validaCampos(nome)){				
				Convenio convenio = new Convenio(nome);
				DaoConvenio dao = new DaoConvenio();
				dao.cadastrarConvenio(convenio);
				mensagem = "Convênio cadastrado com sucesso!";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("convenio.jsp");
				disp.forward(request, response);
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("convenio.jsp");
				disp.forward(request, response);
			}
		}else if (btn.equals("Pesquisar")){
			
			String nome = (String) request.getParameter("nomeConvenio");
			Convenio convenio = new Convenio(nome);
			DaoConvenio dao = new DaoConvenio();
			convenio = dao.pesquisarConvenioPorNome(nome);
			if (convenio != null){
				mensagem = "Convênio encontrado.";
				request.setAttribute("msg", mensagem);
				objetoSessao.setAttribute("convenio", convenio);
				RequestDispatcher disp = request.getRequestDispatcher("convenio_alterar.jsp");
				disp.forward(request, response);
			}else{
				mensagem = "Convênio não encontrado.";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("convenio.jsp");
				disp.forward(request, response);
			}
		}else if(btn.equals("Excluir")){

				Convenio convenio = new Convenio();
				convenio = (Convenio)objetoSessao.getAttribute("convenio");
				DaoConvenio dao = new DaoConvenio();
				boolean result = dao.excluirConvenio(convenio);
				if (result){
					mensagem = "Convênio excluído com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("convenio");
					RequestDispatcher disp = request.getRequestDispatcher("convenio.jsp");
					disp.forward(request, response);
				}else{
					mensagem = "Ocorreu algum erro ao excluir o convênio.";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("convenio.jsp");
					disp.forward(request, response);
				}
		}else if(btn.equals("Alterar")){
			String nome = (String) request.getParameter("nomeConvenio");
			if (validaCampos(nome)){	
				Convenio convenio = new Convenio();
				convenio = (Convenio)objetoSessao.getAttribute("convenio");
				convenio.setNomeConvenio((String)request.getParameter("nomeConvenio"));								
				DaoConvenio dao = new DaoConvenio();
				boolean result = dao.alterarConvenio(convenio);
				if (result){
					mensagem = "Convênio alterado com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("convenio");
					RequestDispatcher disp = request.getRequestDispatcher("convenio.jsp");
					disp.forward(request, response);
				}else{
					mensagem = "Ocorreu algum erro ao alterar o convênio.";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("convenio.jsp");
					disp.forward(request, response);
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("convenio_alterar.jsp");
				disp.forward(request, response);
			}
		}
	
	}
	
	public boolean validaCampos(String nome){
		boolean result = false;
		if ((nome == null) || (nome.equals(""))){
			mensagem = "Preencha o nome do convenio corretamente.";
		}else{
			result = true;
		}
		return result;
	}
}
