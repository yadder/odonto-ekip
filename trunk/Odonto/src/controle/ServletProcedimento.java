package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Convenio;
import modelo.Procedimento;
import persistencia.DaoConvenio;
import persistencia.DaoProcedimento;

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
		ConfiguraAtributo ca = new ConfiguraAtributo();
		ProcurarObjeto po = new ProcurarObjeto();
		
		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("procedimento");
			ca.sendRedirect(request, response, null, null, "principal.jsp");
		}else if (btn.equals("Cadastrar")){
			procedimento = preencheObjeto(request, response);
			if (validaCampos(procedimento)){				
				try{
					DaoProcedimento dao = new DaoProcedimento();
					dao.cadastrarProcedimento(procedimento);
					ca.sendRedirect(request, response, "Procedimento cadastrado com sucesso!", null, "procedimento.jsp");
				}catch (Exception e) {
					ca.sendRedirect(request, response, null, "Erro ao cadastrar o procedimento.", "procedimento.jsp");
					e.printStackTrace();
				}
			}else{
				ca.sendRedirect(request, response, null, mensagem, "procedimento.jsp");
			}
		}else if (btn.equals("Pesquisar")){
			procedimento = preencheObjeto(request, response);
			Convenio convenio = new Convenio();
			convenio = po.getConvenioPorNome((String)request.getParameter("convenio"));			
			if (procedimento.getDescricaoProcedimento()!=null){
				try{
					procedimento = po.getProcedimentoPorNomeEConvenio(procedimento.getDescricaoProcedimento(), convenio);
					if (procedimento != null){
						objetoSessao.setAttribute("procedimento", procedimento);
						ca.sendRedirect(request, response, "Procedimento encontrado.", null, "procedimento_alterar.jsp");
					}else{
						ca.sendRedirect(request, response, null, "Procedimento não encontrado.", "procedimento.jsp");
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				ca.sendRedirect(request, response, null, mensagem, "procedimento.jsp");
			}
		}else if(btn.equals("Excluir")){
			try{
				procedimento = (Procedimento)objetoSessao.getAttribute("procedimento");
				DaoProcedimento dao = new DaoProcedimento();
				dao.excluirProcedimento(procedimento);
				objetoSessao.removeAttribute("procedimento");
				ca.sendRedirect(request, response, "Procedimento excluído com sucesso.", null, "procedimento.jsp");
			}catch (Exception e) {
				ca.sendRedirect(request, response, null, "Erro ao excluir o procedimento.", "procedimento.jsp");
				e.printStackTrace();
			}
		}else if(btn.equals("Alterar")){
			procedimento = preencheObjeto(request, response);
			procedimento.setIdProcedimento(((Procedimento)objetoSessao.getAttribute("procedimento")).getIdProcedimento());
			if (validaCampos(procedimento)){	
				try{					
					DaoProcedimento dao = new DaoProcedimento();
					dao.alterarProcedimento(procedimento);
					objetoSessao.removeAttribute("procedimento");
					ca.sendRedirect(request, response, "Procedimento alterado com sucesso.", null, "procedimento.jsp");
				}catch (Exception e) {
					ca.sendRedirect(request, response, null, "Erro ao alterar o procedimento.", "procedimento.jsp");
				}
			}else{
				ca.sendRedirect(request, response, null, mensagem, "procedimento_alterar.jsp");
			}
		}	
	}
	
	public Procedimento preencheObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Procedimento procedimento = new Procedimento();
		try{
			ConfiguraAtributo ca = new ConfiguraAtributo();
			DaoConvenio daoConvenio = new DaoConvenio();
			Convenio convenio = new Convenio();
			convenio.setNomeConvenio((String)request.getParameter("convenio"));
			convenio = daoConvenio.pesquisarConvenioPorNome(convenio);
			procedimento.setConvenio(convenio);
			procedimento.setCodigoProcedimento((String)request.getParameter("codigoProcedimento"));
			procedimento.setDescricaoProcedimento((String)request.getParameter("descricaoProcedimento"));
			if (!((String) request.getParameter("valorProcedimento")).equals("")){
				procedimento.setValorProcedimento(ca.validaValores((String)request.getParameter("valorProcedimento")));
			}
			return procedimento;
		}catch(Exception e){
			e.printStackTrace();
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
