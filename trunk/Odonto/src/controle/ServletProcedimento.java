package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Procedimento;
import persistencia.DaoProcedimento;
import util.ConfiguraAtributo;

public class ServletProcedimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String mensagem = null;
	
    public ServletProcedimento() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request,response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String btn = (String)request.getParameter("btn");
		HttpSession objetoSessao = request.getSession();
		Procedimento procedimento = new Procedimento();

		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("procedimento");
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);
		}else if (btn.equals("Cadastrar")){
			procedimento = preencheObjeto(request, response);
			if (validaCampos(procedimento)){				
				try{
					DaoProcedimento dao = new DaoProcedimento();
					dao.cadastrarProcedimento(procedimento);
					mensagem = "Procedimento cadastrado com sucesso!";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("procedimento.jsp");
					disp.forward(request, response);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("procedimento.jsp");
				disp.forward(request, response);
			}
		}else if (btn.equals("Pesquisar")){
			procedimento = preencheObjeto(request, response);
			if (!procedimento.getDescricaoProcedimento().equals("")){
				try{
					DaoProcedimento dao = new DaoProcedimento();
					procedimento = dao.pesquisarProcedimentoPorDescricao(procedimento);
					if (procedimento != null){
						mensagem = "Procedimento encontrado.";
						request.setAttribute("msg", mensagem);
						objetoSessao.setAttribute("procedimento", procedimento);
						RequestDispatcher disp = request.getRequestDispatcher("procedimento_alterar.jsp");
						disp.forward(request, response);
					}else{
						mensagem = "Procedimento não encontrado.";
						request.setAttribute("msg", mensagem);
						RequestDispatcher disp = request.getRequestDispatcher("procedimento.jsp");
						disp.forward(request, response);
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("procedimento.jsp");
				disp.forward(request, response);
			}
		}else if(btn.equals("Excluir")){
			try{
				procedimento = (Procedimento)objetoSessao.getAttribute("procedimento");
				DaoProcedimento dao = new DaoProcedimento();
				dao.excluirProcedimento(procedimento);
				mensagem = "Procedimento excluído com sucesso.";
				request.setAttribute("msg", mensagem);
				objetoSessao.removeAttribute("procedimento");
				RequestDispatcher disp = request.getRequestDispatcher("procedimento.jsp");
				disp.forward(request, response);
			}catch (Exception e) {
				mensagem = "Ocorreu algum erro ao excluir o procedimento.";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("procedimento.jsp");
				disp.forward(request, response);
				e.printStackTrace();
			}
		}else if(btn.equals("Alterar")){
			procedimento = preencheObjeto(request, response);
			procedimento.setIdProcedimento(((Procedimento)objetoSessao.getAttribute("procedimento")).getIdProcedimento());
			if (validaCampos(procedimento)){	
				try{					
					DaoProcedimento dao = new DaoProcedimento();
					dao.alterarProcedimento(procedimento);
					mensagem = "Procedimento alterado com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("procedimento");
					RequestDispatcher disp = request.getRequestDispatcher("procedimento.jsp");
					disp.forward(request, response);
				}catch (Exception e) {
					mensagem = "Ocorreu algum erro ao alterar o procedimento.";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("procedimento.jsp");
					disp.forward(request, response);
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("procedimento_alterar.jsp");
				disp.forward(request, response);
			}
		}	
	}
	
	public Procedimento preencheObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Procedimento procedimento = new Procedimento();
		ConfiguraAtributo ca = new ConfiguraAtributo();
		procedimento.setDescricaoProcedimento((String)request.getParameter("descricaoProcedimento"));
		procedimento.setCodigoProcedimento((String)request.getParameter("codigoProcedimento"));
		if (!((String) request.getParameter("valorProcedimento")).equals("")){
			procedimento.setValorProcedimento(ca.validaValores((String)request.getParameter("valorProcedimento")));
		}
		return procedimento;		
	}
		
	public boolean validaCampos(Procedimento procedimento){
		boolean result = false;
		procedimento.setDescricaoProcedimento(procedimento.getDescricaoProcedimento().trim()); // retira espaços
		procedimento.setCodigoProcedimento(procedimento.getCodigoProcedimento().trim());
		if ((procedimento.getCodigoProcedimento() == null) || (procedimento.getCodigoProcedimento().equals(""))){
			mensagem = "Preencha o código do procedimento corretamente.";
		}else if ((procedimento.getDescricaoProcedimento() == null) || (procedimento.getDescricaoProcedimento().equals(""))){
			mensagem = "Preencha a descriçao do procedimento corretamente.";
		}else if (procedimento.getValorProcedimento() == 0){
			mensagem = "Preencha o valor do procedimento corretamente.";
		}
		else{
			result = true;
		}
		return result;
	}
		
	public boolean validaCampos(String descricaoProcedimento, String valorProcedimento){
		boolean result = false;
		if ((descricaoProcedimento == null) || (descricaoProcedimento.equals("") || (descricaoProcedimento.length()<3))){
			mensagem = "Preencha o nome do procedimento corretamente.";
		}else if ((valorProcedimento == null) || (valorProcedimento.equals(""))){
			mensagem = "Preencha o valor do procedimento corretamente.";
		}else{
			result = true;
		}
		return result;
	}

}
