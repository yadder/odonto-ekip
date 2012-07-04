package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Paciente;
import modelo.Usuario;
import persistencia.DaoPaciente;
import persistencia.DaoPacienteImp;
import persistencia.DaoUsuario;
import persistencia.DaoUsuarioImp;
import util.ConfiguraAtributo;

public class ServletPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String mensagem = null;
	
    public ServletPaciente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String btn = (String)request.getParameter("btn");
		HttpSession objetoSessao = request.getSession();

		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("paciente");
			objetoSessao.removeAttribute("data");
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);
			
		}else if (btn.equals("Cadastrar")){
				ConfiguraAtributo ca = new ConfiguraAtributo();
				String nomeUsuario = (String) request.getParameter("nomeUsuario");
				String rgUsuario = (String) request.getParameter("rgUsuario");
				String cpfUsuario = (String) request.getParameter("cpfUsuario");
				String dtdtNascUsuarionasc = (String) request.getParameter("dtNascUsuario");
				String sexoUsuario = (String) request.getParameter("sexoUsuario");
				String perfilUsuario = "PACIENTE";
				String responsavelPAciente = 
				String logradouroPaciente = 
				String complementoLogradouroPaciente = 
				String bairroPaciente = 
				String cidadePaciente = 
				String estadoPaciente = 
				String cepPaciente = 
				
				
				Paciente paciente = new Paciente(nomeUsuario, senhaUsuario, perfilUsuario, rgUsuario, cpfUsuario, sexoUsuario, ca.dataStringParaDataSql(dtdtNascUsuarionasc));
				objetoSessao.setAttribute("paciente", paciente);
				if (validaCampos(nome, rg, cpf, dtnasc, sexo)){
					// gerar uma string com 6 caracteres para colocar na senha
					senha = "12345";					
					paciente = new Paciente(nome, senha, perfil, rg, cpf, sexo, ca.dataStringParaDataSql(dtnasc));
					DaoPaciente dao = new DaoPacienteImp();
					dao.cadastrarPaciente(paciente);
					mensagem = "Paciente cadastrado com sucesso!";
					objetoSessao.removeAttribute("paciente");
					objetoSessao.removeAttribute("data");
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("paciente.jsp");
					disp.forward(request, response);
				}else{
					request.setAttribute("msg", mensagem);
					String data = ca.dataSqlParaDataString(paciente.getDataNascimentoUsuario());
					objetoSessao.setAttribute("data", data);
					RequestDispatcher disp = request.getRequestDispatcher("paciente.jsp");
					disp.forward(request, response);
				}
		}else if (btn.equals("Pesquisar")){
			String nome = (String) request.getParameter("nomeUsuario");
			Paciente paciente = new Paciente(nome);
			DaoUsuario dao = new DaoUsuarioImp();
			paciente = dao.pesquisarPacientePorNome(nome);
			if (paciente != null){
				ConfiguraAtributo ca = new ConfiguraAtributo();
				mensagem = "Paciente encontrado.";
				request.setAttribute("msg", mensagem);
				objetoSessao.setAttribute("data", ca.dataSqlParaDataString(paciente.getDataNascimentoUsuario()));
				System.out.println(paciente);
				objetoSessao.setAttribute("paciente", paciente);
				RequestDispatcher disp = request.getRequestDispatcher("paciente_alterar.jsp");
				disp.forward(request, response);
			}else{
				mensagem = "Paciente não encontrado.";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("paciente.jsp");
				disp.forward(request, response);
			}
		}else if(btn.equals("Excluir")){
				Paciente paciente = new Paciente();
				paciente = (Paciente)objetoSessao.getAttribute("paciente");
				DaoPaciente dao = new DaoPacienteImp();
				boolean result = dao.excluirPaciente(paciente);
				if (result){
					mensagem = "Paciente excluído com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("usuario");
					objetoSessao.removeAttribute("data");
					RequestDispatcher disp = request.getRequestDispatcher("paciente.jsp");
					disp.forward(request, response);
				}else{
					mensagem = "Ocorreu algum erro ao excluir o paciente.";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("paciente.jsp");
					disp.forward(request, response);
				}
		}else if(btn.equals("Alterar")){
			ConfiguraAtributo ca = new ConfiguraAtributo();
			String nome = (String) request.getParameter("nomeUsuario");
			String rg = (String) request.getParameter("rgUsuario");
			String cpf = (String) request.getParameter("cpfUsuario");
			String dtnasc = (String) request.getParameter("dtNascUsuario");
			String sexo = (String) request.getParameter("sexoUsuario");
			if (validaCampos(nome, rg, cpf, dtnasc, sexo)){
				Paciente paciente = new Paciente();
				paciente = (Usuario)objetoSessao.getAttribute("usuario");
				paciente.setNomeUsuario(nome);
				paciente.setRgUsuario(rg);
				paciente.setCpfUsuario(cpf);
				paciente.setDataNascimentoUsuario(ca.dataStringParaDataSql(dtnasc));
				paciente.setSexoUsuario(sexo);				
				DaoPaciente dao = new DaoPacienteImp();
				boolean result = dao.alterarUsuario(paciente);
				if (result){
					mensagem = "Paciente alterado com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("paciente");
					objetoSessao.removeAttribute("data");
					RequestDispatcher disp = request.getRequestDispatcher("paciente.jsp");
					disp.forward(request, response);
				}else{
					mensagem = "Ocorreu algum erro ao alterar o paciente.";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("paciente.jsp");
					disp.forward(request, response);
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("paciente_alterar.jsp");
				disp.forward(request, response);
			}
			
		}
	}

	public boolean validaCampos(String nome, String rg, String cpf, String dtnasc, String sexo) {
		boolean result = false;
		if ((nome == null) || (nome.length() < 5)) {
			mensagem = "Preencha o nome do paciente corretamente. O nome deve ter pelo menos 5 caracteres";
		}else if ((rg == null) || (rg.length() < 5)) {
			mensagem = "Preencha o RG do paciente corretamente.";
		}else if ((cpf == null) || (cpf.length() < 11)) {
			mensagem = "Preencha o CPF do paciente corretamente.";
		}else if ((dtnasc == null) || (dtnasc.equals(""))) {
			mensagem = "Preencha a data de nascimento do paciente corretamente.";
		}else if ((sexo == null) || (sexo.equals(""))) {
			mensagem = "Preencha o sexo do paciente corretamente.";
		}else {
			result = true;
		}
		return result;
	}

}
