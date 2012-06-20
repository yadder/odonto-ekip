package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Elemento;
import persistencia.DaoElemento;
import persistencia.DaoElementoImp;

public class ServletElemento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String mensagem = null;  
    public ServletElemento() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String btn = (String)request.getParameter("btn");
		HttpSession objetoSessao = request.getSession();

		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("elemento");
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);
			
		}else if (btn.equals("Cadastrar")){
			String nome = (String) request.getParameter("nomeElemento");
			if (validaCampos(nome)){
				Elemento elemento = new Elemento(nome);
				DaoElemento dao = new DaoElementoImp();
				dao.cadastrarElemento(elemento);
				mensagem = "Elemento cadastrado com sucesso!";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("elemento.jsp");
				disp.forward(request, response);
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("elemento.jsp");
				disp.forward(request, response);
			}
		}else if (btn.equals("Pesquisar")){
			
			String nome = (String) request.getParameter("nomeElemento");
			Elemento elemento = new Elemento(nome);
			DaoElemento dao = new DaoElementoImp();
			elemento = dao.pesquisarElementoPorNome(nome);
			if (elemento != null){
				mensagem = "Elemento encontrado.";
				request.setAttribute("msg", mensagem);
				objetoSessao.setAttribute("elemento", elemento);
				RequestDispatcher disp = request.getRequestDispatcher("elemento_alterar.jsp");
				disp.forward(request, response);
			}else{
				mensagem = "Elemento não encontrado.";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("elemento.jsp");
				disp.forward(request, response);
			}
		}else if(btn.equals("Excluir")){

				Elemento elemento = new Elemento();
				elemento = (Elemento)objetoSessao.getAttribute("elemento");
				DaoElemento dao = new DaoElementoImp();
				boolean result = dao.excluirElemento(elemento);
				if (result){
					mensagem = "Elemento excluído com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("elemento");
					RequestDispatcher disp = request.getRequestDispatcher("elemento.jsp");
					disp.forward(request, response);
				}else{
					mensagem = "Ocorreu algum erro ao excluir o elemento.";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("elemento.jsp");
					disp.forward(request, response);
				}
		}else if(btn.equals("Alterar")){
			String nome = (String) request.getParameter("nomeElemento");
			if (validaCampos(nome)){
				Elemento elemento = new Elemento();
				elemento = (Elemento)objetoSessao.getAttribute("elemento");
				elemento.setNomeElemento((String)request.getParameter("nomeElemento"));								
				DaoElemento dao = new DaoElementoImp();
				boolean result = dao.alterarElemento(elemento);
				if (result){
					mensagem = "Elemento alterado com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("elemento");
					RequestDispatcher disp = request.getRequestDispatcher("elemento.jsp");
					disp.forward(request, response);
				}else{
					mensagem = "Ocorreu algum erro ao excluir o elemento.";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("elemento.jsp");
					disp.forward(request, response);
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("elemento_alterar.jsp");
				disp.forward(request, response);
			}
		}
	}
	
	public boolean validaCampos(String nome){
		boolean result = false;
		if ((nome == null) || (nome.length() !=2)){
			mensagem = "Preencha o nome do elemento corretamente.";
		}else{
			result = true;
		}
		return result;
	}

}
