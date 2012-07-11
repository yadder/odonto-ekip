package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("dentista");
			objetoSessao.removeAttribute("data");
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);
			
		}else if (btn.equals("Cadastrar")){
				ConfiguraAtributo ca = new ConfiguraAtributo();
				String nome = (String) request.getParameter("nomeDentista");
				String rg = (String) request.getParameter("rgDentista");
				String cpf = (String) request.getParameter("cpfDentista");
				String dtnasc = (String) request.getParameter("dtNascDentista");
				String sexo = (String) request.getParameter("sexoDentista");
				String cro = (String) request.getParameter("croDentista");
				String perfil = "DENTISTA";
				String senha = null;
				Dentista dentista = new Dentista(nome, senha, perfil, rg, cpf, sexo, ca.dataStringParaDataSql(dtnasc), cro);
				objetoSessao.setAttribute("dentista", dentista);
				if (validaCampos(nome, rg, cpf, dtnasc, sexo, cro)){
					// gerar uma string com 6 caracteres para colocar na senha
					senha = "12345";					
					dentista = new Dentista(nome, senha, perfil, rg, cpf, sexo, ca.dataStringParaDataSql(dtnasc), cro);
					DaoDentista dao = new DaoDentista();
					dao.cadastrarDentista(dentista);
					mensagem = "Dentista cadastrada com sucesso!";
					objetoSessao.removeAttribute("dentista");
					objetoSessao.removeAttribute("data");
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("dentista.jsp");
					disp.forward(request, response);
				}else{
					request.setAttribute("msg", mensagem);
					String data = ca.dataSqlParaDataString(dentista.getDataNascimentoUsuario());
					objetoSessao.setAttribute("data", data);
					RequestDispatcher disp = request.getRequestDispatcher("dentista.jsp");
					disp.forward(request, response);
				}
		}else if (btn.equals("Pesquisar")){
			String nome = (String) request.getParameter("nomeDentista");
			Dentista dentista = new Dentista(nome);
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

	public boolean validaCampos(String nome, String rg, String cpf, String dtnasc, String sexo, String cro) {
		boolean result = false;
		if ((nome == null) || (nome.length() < 5)) {
			mensagem = "Preencha o nome da dentista corretamente. O nome deve ter pelo menos 5 caracteres";
		}else if ((rg == null) || (rg.length() < 5)) {
			mensagem = "Preencha o RG da dentista corretamente.";
		}else if ((cpf == null) || (cpf.length() < 11)) {
			mensagem = "Preencha o CPF da dentista corretamente.";
		}else if ((dtnasc == null) || (dtnasc.equals(""))) {
			mensagem = "Preencha a data de nascimento da dentista corretamente.";
		}else if ((sexo == null) || (sexo.equals(""))) {
			mensagem = "Preencha o sexo da dentista corretamente.";
		}else if ((cro == null) || (cro.equals(""))) {
			mensagem = "Preencha o CRO da dentista corretamente.";
		}else {
			result = true;
		}
		return result;
	}

}
