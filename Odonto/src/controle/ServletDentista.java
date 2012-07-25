package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.exception.ConstraintViolationException;

import modelo.Dentista;
import persistencia.DaoDentista;

public class ServletDentista extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String mensagem = null;
	
    public ServletDentista() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn = (String)request.getParameter("btn");
		HttpSession objetoSessao = request.getSession();
		Dentista dentista = new Dentista();
		ConfiguraAtributo ca = new ConfiguraAtributo();

		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("dentista");
			objetoSessao.removeAttribute("data");
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);			
		}else if (btn.equals("Cadastrar")){
				dentista = preencheObjeto(request, response);
				objetoSessao.setAttribute("dentista",dentista);
				if (validaCampos(dentista)){
					DaoDentista dao = new DaoDentista();
					try{						
						dao.cadastrarDentista(dentista);
						mensagem = "Dentista cadastrado(a) com sucesso!";
						request.setAttribute("msg", mensagem);
						objetoSessao.removeAttribute("dentista");
						RequestDispatcher disp = request.getRequestDispatcher("dentista.jsp");
						disp.forward(request, response);
					}catch(ConstraintViolationException cve){
						dao.doRollBack();
						ca.sendRedirect(request, response, null, "Erro: Já existe um dentista com este CPF ou CRO cadastrado.", "dentista.jsp");
					}catch (Exception e) {
						e.printStackTrace();
					}
				}else{
					request.setAttribute("msg", mensagem);
					String data = ca.dataSqlParaDataString(dentista.getDataNascimentoUsuario());
					objetoSessao.setAttribute("data", data);
					RequestDispatcher disp = request.getRequestDispatcher("dentista.jsp");
					disp.forward(request, response);
				}
		}else if (btn.equals("Pesquisar")){
			dentista = preencheObjeto(request, response);
			if (!dentista.getNomeUsuario().equals("")){
				try{
					DaoDentista daoDentista = new DaoDentista();
					dentista = daoDentista.pesquisarDentistaPorNome(dentista);
					if (dentista != null){
						mensagem = "Dentista encontrado(a).";
						request.setAttribute("msg", mensagem);
						objetoSessao.setAttribute("dentista", dentista);
						objetoSessao.setAttribute("data", ca.dataSqlParaDataString(dentista.getDataNascimentoUsuario()));
						RequestDispatcher disp = request.getRequestDispatcher("dentista_alterar.jsp");
						disp.forward(request, response);
					}else{
						mensagem = "Dentista não encontrado(a).";
						request.setAttribute("msg", mensagem);
						RequestDispatcher disp = request.getRequestDispatcher("dentista.jsp");
						disp.forward(request, response);
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("dentista.jsp");
				disp.forward(request, response);
			}
		}else if(btn.equals("Excluir")){
			try{
				dentista = (Dentista)objetoSessao.getAttribute("dentista");
				DaoDentista daoDentista = new DaoDentista();
				daoDentista.excluirDentista(dentista);
				mensagem = "Dentista excluído(a) com sucesso.";
				request.setAttribute("msg", mensagem);
				objetoSessao.removeAttribute("dentista");
				objetoSessao.removeAttribute("data");
				RequestDispatcher disp = request.getRequestDispatcher("dentista.jsp");
				disp.forward(request, response);
			}catch (Exception e) {
				mensagem = "Ocorreu algum erro ao excluir o dentista(a).";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("dentista.jsp");
				disp.forward(request, response);
				e.printStackTrace();
			}
		}else if(btn.equals("Alterar")){
			dentista = preencheObjeto(request, response);
			dentista.setIdUsuario(((Dentista)objetoSessao.getAttribute("dentista")).getIdUsuario());
			if (validaCampos(dentista)){	
				DaoDentista daoDentista = new DaoDentista();
				try{										
					daoDentista.alterarDentista(dentista);
					mensagem = "Dentista alterado(a) com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("dentista");
					objetoSessao.removeAttribute("data");
					RequestDispatcher disp = request.getRequestDispatcher("dentista.jsp");
					disp.forward(request, response);
				}catch(ConstraintViolationException cve){
					daoDentista.doRollBack();
					ca.sendRedirect(request, response, null, "Erro: Já existe um dentista com este CPF ou CRO cadastrado.", "dentista_alterar.jsp");
				}catch (Exception e) {
					mensagem = "Ocorreu algum erro ao alterar o(a) dentista.";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("dentista.jsp");
					disp.forward(request, response);
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("dentista_alterar.jsp");
				disp.forward(request, response);
			}
		}
	}

	public Dentista preencheObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dentista dentista = new Dentista();
		ConfiguraAtributo ca = new ConfiguraAtributo();
		dentista.setNomeUsuario((String) request.getParameter("nomeDentista"));
		dentista.setSenhaUsuario(ca.gerarSenha());
		dentista.setPerfilUsuario("DENTISTA");
		dentista.setRgUsuario((String) request.getParameter("rgDentista"));
		dentista.setCpfUsuario((String) request.getParameter("cpfDentista"));
		dentista.setDataNascimentoUsuario(ca.dataStringParaDataSql((String) request.getParameter("dtNascDentista")));
		dentista.setSexoUsuario((String) request.getParameter("sexoDentista"));
		dentista.setCroDentista((String) request.getParameter("croDentista"));
		return dentista;		
	}
	
	public boolean validaCampos(Dentista dentista) {
		// retira espaços
		dentista.setNomeUsuario(dentista.getNomeUsuario().trim()); 
		dentista.setRgUsuario(dentista.getRgUsuario().trim()); 
		dentista.setCpfUsuario(dentista.getCpfUsuario().trim()); 
		dentista.setSexoUsuario(dentista.getSexoUsuario().trim()); 
		dentista.setCroDentista(dentista.getCroDentista().trim()); 
		
		boolean result = false;
		if ((dentista.getNomeUsuario() == null) || (dentista.getNomeUsuario().length() < 5)) {
			mensagem = "Preencha o nome do(a) dentista corretamente. O nome deve ter pelo menos 5 caracteres";
		}else if ((dentista.getRgUsuario() == null) || (dentista.getRgUsuario().length() < 5)) {
			mensagem = "Preencha o RG da dentista corretamente.";
		}else if ((dentista.getCpfUsuario() == null) || (dentista.getCpfUsuario().length() < 11)) {
			mensagem = "Preencha o CPF da dentista corretamente.";
		}else if ((dentista.getDataNascimentoUsuario() == null) || (dentista.getDataNascimentoUsuario().equals(""))) {
			mensagem = "Preencha a data de nascimento da dentista corretamente.";
		}else if ((dentista.getSexoUsuario() == null) || (dentista.getSexoUsuario().equals(""))) {
			mensagem = "Preencha o sexo da dentista corretamente.";
		}else if ((dentista.getCroDentista() == null) || (dentista.getCroDentista().equals(""))) {
			mensagem = "Preencha o CRO da dentista corretamente.";
		}else {
			result = true;
		}
		return result;
	}
	
	public boolean validaNome(Dentista dentista){
		boolean result = false;
		dentista.setNomeUsuario(dentista.getNomeUsuario().trim());
		if ((dentista.getNomeUsuario() == null) || (dentista.getNomeUsuario().length() < 5)) {
			mensagem = "Preencha o nome do(a) dentista corretamente. O nome deve ter pelo menos 5 caracteres";
		}else{
			result = true;
		}
		return result;
	}

}
