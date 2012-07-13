package controle;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Convenio;
import modelo.Dentista;
import persistencia.DaoDentista;
import util.ConfiguraAtributo;

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
				if (validaCampos(dentista)){
					try{
						DaoDentista dao = new DaoDentista();
						dao.cadastrarDentista(dentista);
						mensagem = "Dentista cadastrada com sucesso!";
						request.setAttribute("msg", mensagem);
						RequestDispatcher disp = request.getRequestDispatcher("dentista.jsp");
						disp.forward(request, response);
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
			if (validaNome(dentista)){
				
			}
			
				DaoDentista dao = new DaoDentista();
				dentista = dao.pesquisarDentistaPorNome(nome);
			if (dentista != null){
				ConfiguraAtributo ca = new ConfiguraAtributo();
				mensagem = "Dentista encontrada.";
				request.setAttribute("msg", mensagem);
				objetoSessao.setAttribute("data", ca.dataSqlParaDataString(dentista.getDataNascimentoUsuario()));
				System.out.println(dentista);
				objetoSessao.setAttribute("dentista", dentista);
				RequestDispatcher disp = request.getRequestDispatcher("dentista_alterar.jsp");
				disp.forward(request, response);
			}else{
				mensagem = "Dentista não encontrada.";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("dentista.jsp");
				disp.forward(request, response);
			}
		}else if(btn.equals("Excluir")){
				Dentista dentista = new Dentista();
				dentista = (Dentista)objetoSessao.getAttribute("dentista");
				DaoDentista dao = new DaoDentista();
				boolean result = dao.excluirDentista(dentista);
				if (result){
					mensagem = "Dentista excluída com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("dentista");
					objetoSessao.removeAttribute("data");
					RequestDispatcher disp = request.getRequestDispatcher("dentista.jsp");
					disp.forward(request, response);
				}else{
					mensagem = "Ocorreu algum erro ao excluir a dentista.";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("dentista.jsp");
					disp.forward(request, response);
				}
		}else if(btn.equals("Alterar")){
			ConfiguraAtributo ca = new ConfiguraAtributo();
			String nome = (String) request.getParameter("nomeDentista");
			String rg = (String) request.getParameter("rgDentista");
			String cpf = (String) request.getParameter("cpfDentista");
			String dtnasc = (String) request.getParameter("dtNascDentista");
			String sexo = (String) request.getParameter("sexoDentista");
			String cro = (String) request.getParameter("croDentista");
			if (validaCampos(nome, rg, cpf, dtnasc, sexo, cro)){
				Dentista dentista = new Dentista();
				dentista = (Dentista)objetoSessao.getAttribute("dentista");
				dentista.setNomeUsuario(nome);
				dentista.setRgUsuario(rg);
				dentista.setCpfUsuario(cpf);
				dentista.setDataNascimentoUsuario(ca.dataStringParaDataSql(dtnasc));
				dentista.setSexoUsuario(sexo);		
				dentista.setCroDentista(cro);
				DaoDentista dao = new DaoDentista();
				boolean result = dao.alterarDentista(dentista);
				if (result){
					mensagem = "Dentista alterada com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("dentista");
					objetoSessao.removeAttribute("data");
					RequestDispatcher disp = request.getRequestDispatcher("dentista.jsp");
					disp.forward(request, response);
				}else{
					mensagem = "Ocorreu algum erro ao alterar a dentista.";
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
