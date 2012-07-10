package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Convenio;
import modelo.Procedimento;
import persistencia.DaoConvenio;
import persistencia.DaoConvenioImp;
import persistencia.DaoProcedimento;
import persistencia.DaoProcedimentoImp;

public class ServletProcedimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String mensagem = null;
	
    public ServletProcedimento() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String btn = (String)request.getParameter("btn");
		HttpSession objetoSessao = request.getSession();

		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("procedimento");
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);
		}else if (btn.equals("Cadastrar")){
			String descricaoProcedimento = (String) request.getParameter("descricaoProcedimento");
			String valorProcedimento = (String) request.getParameter("valorProcedimento");
			String stringConvenio = (String) request.getParameter("convenio");
			if (validaCampos(descricaoProcedimento, valorProcedimento)){
				DaoConvenio daoConvenio = new DaoConvenioImp();
				Convenio convenio = new Convenio();
				convenio = daoConvenio.pesquisarConvenioPorNome(stringConvenio);
				Procedimento procedimento = new Procedimento(descricaoProcedimento, Double.parseDouble(valorProcedimento), convenio);
				DaoProcedimento daoProcedimento = new DaoProcedimentoImp();
				daoProcedimento.cadastrarProcedimento(procedimento);
				mensagem = "Procedimento cadastrado com sucesso!";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("procedimento.jsp");
				disp.forward(request, response);
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("procedimento.jsp");
				disp.forward(request, response);
			}
		}else if (btn.equals("Pesquisar")){
			
			String descricaoProcedimento = (String) request.getParameter("descricaoProcedimento");
			Procedimento procedimento = new Procedimento(descricaoProcedimento);
			DaoProcedimento daoProcedimento = new DaoProcedimentoImp();
			procedimento = daoProcedimento.pesquisarProcedimentoPorDescricao(descricaoProcedimento);
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
		}else if(btn.equals("Excluir")){

			Procedimento procedimento = new Procedimento();
			procedimento = (Procedimento)objetoSessao.getAttribute("procedimento");
			DaoProcedimento daoProcedimento = new DaoProcedimentoImp();
			boolean result = daoProcedimento.excluirProcedimento(procedimento);
			if (result){
				mensagem = "Procedimento excluído com sucesso.";
				request.setAttribute("msg", mensagem);
				objetoSessao.removeAttribute("procedimento");
				RequestDispatcher disp = request.getRequestDispatcher("procedimento.jsp");
				disp.forward(request, response);
			}else{
				mensagem = "Ocorreu algum erro ao excluir o procedimento.";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("procedimento.jsp");
				disp.forward(request, response);
			}
		}else if(btn.equals("Alterar")){
			String descricaoProcedimento = (String) request.getParameter("descricaoProcedimento");
			String valorProcedimento = (String) request.getParameter("valorProcedimento");
			String stringConvenio = (String) request.getParameter("convenio");
			if (validaCampos(descricaoProcedimento, valorProcedimento)){	
				DaoConvenio daoConvenio = new DaoConvenioImp();
				Convenio convenio = new Convenio();
				convenio = daoConvenio.pesquisarConvenioPorNome(stringConvenio);
				Procedimento procedimento = new Procedimento();
				procedimento = (Procedimento)objetoSessao.getAttribute("procedimento");
				procedimento.setDescricaoProcedimento(descricaoProcedimento);
				procedimento.setValorProcedimento(Double.parseDouble(valorProcedimento));
				procedimento.setConvenio(convenio);
				DaoProcedimento daoProcedimento = new DaoProcedimentoImp();
				boolean result = daoProcedimento.alterarProcedimento(procedimento);
				if (result){
					mensagem = "Procedimento alterado com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("procedimento");
					RequestDispatcher disp = request.getRequestDispatcher("procedimento.jsp");
					disp.forward(request, response);
				}else{
					mensagem = "Ocorreu algum erro ao alterar o procedimento.";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("procedimento_alterar.jsp");
					disp.forward(request, response);
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("procedimento_alterar.jsp");
				disp.forward(request, response);
			}
		}	
			
	
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
