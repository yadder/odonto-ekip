package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Convenio;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.GenericJDBCException;

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
		Convenio convenio = new Convenio();
		ConfiguraAtributo ca = new ConfiguraAtributo();
		
		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("convenio");
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);
		}else if (btn.equals("Cadastrar")){
			convenio = preencheObjeto(request, response);
			if (validaCampos(convenio)){		
				DaoConvenio dao = new DaoConvenio();
				try{					
					dao.cadastrarConvenio(convenio);
					mensagem = "Convênio cadastrado com sucesso!";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("convenio.jsp");
					disp.forward(request, response);
				}catch(ConstraintViolationException cve){
					dao.doRollBack();
					ca.sendRedirect(request, response, null, "Erro: Já existe um convênio com essa descrição cadastrado.", "convenio.jsp");
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("convenio.jsp");
				disp.forward(request, response);
			}
		}else if (btn.equals("Pesquisar")){
			convenio = preencheObjeto(request, response);
			if (validaCampos(convenio)){
				try{
					DaoConvenio dao = new DaoConvenio();
					convenio = dao.pesquisarConvenioPorNome(convenio);
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
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("convenio.jsp");
				disp.forward(request, response);
			}
		}else if(btn.equals("Excluir")){
			try{
				convenio = (Convenio)objetoSessao.getAttribute("convenio");
				DaoConvenio dao = new DaoConvenio();
				dao.excluirConvenio(convenio);
				mensagem = "Convênio excluído com sucesso.";
				request.setAttribute("msg", mensagem);
				objetoSessao.removeAttribute("convenio");
				RequestDispatcher disp = request.getRequestDispatcher("convenio.jsp");
				disp.forward(request, response);
			}catch(ConstraintViolationException h){
				mensagem = "O convênio não pode ser excluído pois está associado a um paciente ou um procedimento.";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("convenio_alterar.jsp");
				disp.forward(request, response);
				h.printStackTrace();
			}catch(GenericJDBCException g){
				mensagem = "O convênio não pode ser excluído pois está associado a um paciente ou um procedimento.";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("convenio_alterar.jsp");
				disp.forward(request, response);
				g.printStackTrace();
			}catch (Exception e) {
				mensagem = "Ocorreu algum erro ao excluir o convênio.";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("convenio_alterar.jsp");
				disp.forward(request, response);
				e.printStackTrace();
			}
		}else if(btn.equals("Alterar")){
			convenio = preencheObjeto(request, response);
			convenio.setIdConvenio(((Convenio)objetoSessao.getAttribute("convenio")).getIdConvenio());
			if (validaCampos(convenio)){	
				DaoConvenio dao = new DaoConvenio();
				try{										
					dao.alterarConvenio(convenio);
					mensagem = "Convênio alterado com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("convenio");
					RequestDispatcher disp = request.getRequestDispatcher("convenio.jsp");
					disp.forward(request, response);
				}catch(ConstraintViolationException cve){
					dao.doRollBack();
					ca.sendRedirect(request, response, null, "Erro: Já existe um convênio com essa descrição cadastrado.", "convenio_alterar.jsp");
				}catch (Exception e) {
					mensagem = "Ocorreu algum erro ao alterar o convênio.";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("convenio_alterar.jsp");
					disp.forward(request, response);
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("convenio_alterar.jsp");
				disp.forward(request, response);
			}
		}
	}

	public Convenio preencheObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Convenio convenio = new Convenio();
		convenio.setNomeConvenio((String)request.getParameter("nomeConvenio"));
		return convenio;		
	}
		
	public boolean validaCampos(Convenio convenio){
		boolean result = false;
		convenio.setNomeConvenio(convenio.getNomeConvenio().trim()); // retira espaços
		if ((convenio.getNomeConvenio() == null) || (convenio.getNomeConvenio().equals(""))){
			mensagem = "Preencha o nome do convenio corretamente.";
		}else{
			result = true;
		}
		return result;
	}
	
}
