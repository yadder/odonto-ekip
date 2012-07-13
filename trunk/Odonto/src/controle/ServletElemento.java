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

public class ServletElemento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String mensagem = null;  
    public ServletElemento() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String btn = (String)request.getParameter("btn");
		HttpSession objetoSessao = request.getSession();
		Elemento elemento = new Elemento();

		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("elemento");
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);
			
		}else if (btn.equals("Cadastrar")){
			elemento = preencheObjeto(request, response);
			if (validaCampos(elemento)){				
				try{
					DaoElemento dao = new DaoElemento();
					dao.cadastrarElemento(elemento);
					mensagem = "Fornecedor cadastrado com sucesso!";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("elemento.jsp");
					disp.forward(request, response);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("elemento.jsp");
				disp.forward(request, response);
			}
		}else if (btn.equals("Pesquisar")){
			elemento = preencheObjeto(request, response);
			if (validaCampos(elemento)){
				try{
					DaoElemento dao = new DaoElemento();
					elemento = dao.pesquisarElementoPorNome(elemento);
					if (elemento != null){
						mensagem = "Fornecedor encontrado.";
						request.setAttribute("msg", mensagem);
						objetoSessao.setAttribute("elemento", elemento);
						RequestDispatcher disp = request.getRequestDispatcher("elemento_alterar.jsp");
						disp.forward(request, response);
					}else{
						mensagem = "Fornecedor não encontrado.";
						request.setAttribute("msg", mensagem);
						RequestDispatcher disp = request.getRequestDispatcher("elemento.jsp");
						disp.forward(request, response);
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(btn.equals("Excluir")){
			try{
				elemento = (Elemento)objetoSessao.getAttribute("elemento");
				DaoElemento dao = new DaoElemento();
				dao.excluirElemento(elemento);
				mensagem = "Fornecedor excluído com sucesso.";
				request.setAttribute("msg", mensagem);
				objetoSessao.removeAttribute("elemento");
				RequestDispatcher disp = request.getRequestDispatcher("elemento.jsp");
				disp.forward(request, response);
			}catch (Exception e) {
				mensagem = "Ocorreu algum erro ao excluir o fornecedor.";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("elemento.jsp");
				disp.forward(request, response);
				e.printStackTrace();
			}
		}else if(btn.equals("Alterar")){
			elemento = preencheObjeto(request, response);
			elemento.setIdElemento(((Elemento)objetoSessao.getAttribute("elemento")).getIdElemento());
			if (validaCampos(elemento)){	
				try{					
					DaoElemento dao = new DaoElemento();
					dao.alterarElemento(elemento);
					mensagem = "Fornecedor alterado com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("elemento");
					RequestDispatcher disp = request.getRequestDispatcher("elemento.jsp");
					disp.forward(request, response);
				}catch (Exception e) {
					mensagem = "Ocorreu algum erro ao alterar o fornecedor.";
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
	
	public Elemento preencheObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Elemento elemento = new Elemento();
		elemento.setNomeElemento((String)request.getParameter("nomeElemento"));
		return elemento;		
	}
		
	public boolean validaCampos(Elemento elemento){
		boolean result = false;
		elemento.setNomeElemento(elemento.getNomeElemento().trim()); // retira espaços
		if ((elemento.getNomeElemento() == null) || (elemento.getNomeElemento().equals(""))){
			mensagem = "Preencha o nome do elemento corretamente.";
		}else{
			result = true;
		}
		return result;
	}
}
