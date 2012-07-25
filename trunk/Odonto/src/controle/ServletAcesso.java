package controle;

import java.io.IOException;
import java.sql.BatchUpdateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Acesso;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.GenericJDBCException;

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
		ConfiguraAtributo ca = new ConfiguraAtributo();
		Acesso acesso = new Acesso();

		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("acesso");
			ca.sendRedirect(request, response, null, null, "principal.jsp");
		}else if (btn.equals("Cadastrar")){
			acesso = preencheObjeto(request, response);
			if (validaCampos(acesso)){				
				try{
					DaoAcesso daoAcesso = new DaoAcesso();
					daoAcesso.cadastrarAcesso(acesso);
					ca.sendRedirect(request, response, "Acesso cadastrado com sucesso!", null, "acesso.jsp");
				}catch(ConstraintViolationException cve){
					ca.sendRedirect(request, response, null, "Erro: Já existe um acesso com essa descrição cadastrado. "+cve.getMessage(), "acesso.jsp");
					cve = null;
				}
				catch (Exception e) {
					ca.sendRedirect(request, response, null, "Erro: "+e.getMessage(), "acesso.jsp");
					e = null;
				}
			}else{
				ca.sendRedirect(request, response, null, mensagem, "acesso.jsp");
			}
		}else if (btn.equals("Pesquisar")){
			acesso = preencheObjeto(request, response);
			if (acesso.getDescricaoAcesso()!=null){
				try{
					DaoAcesso daoAcesso = new DaoAcesso();
					acesso = daoAcesso.pesquisarAcessoPorNome(acesso);
					if (acesso != null){
						objetoSessao.setAttribute("acesso", acesso);
						ca.sendRedirect(request, response, "Acesso encontrado!", null, "acesso_alterar.jsp");
					}else{
						ca.sendRedirect(request, response, null, "Acesso não encontrado", "acesso.jsp");
					}
				}catch (Exception e) {
					ca.sendRedirect(request, response, null, "Ocorreu um erro ao buscar o acesso. "+e.getMessage(),"acesso.jsp");
				}
			}else{
				ca.sendRedirect(request, response, null, mensagem, "acesso.jsp");
			}
		}else if(btn.equals("Excluir")){
			try{
				acesso = (Acesso)objetoSessao.getAttribute("acesso");
				DaoAcesso daoAcesso = new DaoAcesso();
				daoAcesso.excluirAcesso(acesso);
				objetoSessao.removeAttribute("acesso");
				ca.sendRedirect(request, response, "Acesso excluído com sucesso.", null, "acesso.jsp");
			}catch (Exception e) {
				ca.sendRedirect(request, response, null, "Ocorreu algum erro ao excluir o acesso. " + e.getMessage(), "acesso.jsp");
			}
		}else if(btn.equals("Alterar")){
			acesso = preencheObjeto(request, response);
			acesso.setIdAcesso(((Acesso)objetoSessao.getAttribute("acesso")).getIdAcesso());
			if (validaCampos(acesso)){	
				try{					
					DaoAcesso daoAcesso = new DaoAcesso();
					daoAcesso.alterarAcesso(acesso);
					objetoSessao.removeAttribute("acesso");
					ca.sendRedirect(request, response, "Acesso alterado com sucesso.", null, "acesso.jsp");
				}catch(ConstraintViolationException cve){
					ca.sendRedirect(request, response, null, "Erro: Já existe um acesso com essa descrição cadastrado. "+cve.getMessage(), "acesso_alterar.jsp");
					cve = null;
				}catch (BatchUpdateException bue) {
					ca.sendRedirect(request, response, null, "Erro: Já existe um acesso com essa descrição cadastrado. "+bue.getMessage(), "acesso_alterar.jsp");
					bue = null;
				}catch (GenericJDBCException ge){
					ca.sendRedirect(request, response, null, "Erro: Já existe um acesso com essa descrição cadastrado. "+ge.getMessage(), "acesso_alterar.jsp");
					ge = null;
				}
				catch (Exception e) {
					ca.sendRedirect(request, response, null, "Ocorreu algum erro ao alterar o acesso. " + e.getMessage(), "acesso.jsp");
				}
			}else{
				ca.sendRedirect(request, response, null, "Preencha o nome do acesso corretamente.", "acesso_alterar.jsp");
			}	
		}
	}
	
	public Acesso preencheObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Acesso acesso = new Acesso();
		acesso.setDescricaoAcesso((String)request.getParameter("descricaoAcesso"));
		return acesso;		
	}
		
	public boolean validaCampos(Acesso acesso){
		acesso.setDescricaoAcesso(acesso.getDescricaoAcesso().trim()); // retira espaços
		if ((acesso.getDescricaoAcesso() == null) || (acesso.getDescricaoAcesso().equals(""))){
			return false;
		}else{
			return true;
		}
	}
}
