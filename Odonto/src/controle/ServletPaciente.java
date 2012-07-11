package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Convenio;
import modelo.Paciente;
import persistencia.DaoConvenio;
import persistencia.DaoPaciente;
import util.ConfiguraAtributo;

public class ServletPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String mensagem = null;
	
    public ServletPaciente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
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
				String nomeUsuario = (String) request.getParameter("nomePaciente");
				String rgUsuario = (String) request.getParameter("rgPaciente");
				String cpfUsuario = (String) request.getParameter("cpfPaciente");
				String dtNascUsuario = (String) request.getParameter("dtNascPaciente");
				String sexoUsuario = (String) request.getParameter("sexoPaciente");
				String perfilUsuario = "PACIENTE";
				String senhaUsuario = "12345";
				String responsavelPAciente = (String) request.getParameter("responsavelPaciente");
				String logradouroPaciente =  (String) request.getParameter("logradouroPaciente");
				String numeroLogradouroPaciente =  (String) request.getParameter("numeroLogradouroPaciente");
				String complementoLogradouroPaciente =  (String) request.getParameter("complementoLogradouroPaciente");
				String bairroPaciente =  (String) request.getParameter("bairroPaciente");
				String cidadePaciente =  (String) request.getParameter("cidadePaciente");
				String estadoPaciente =  (String) request.getParameter("estadoPaciente");
				String cepPaciente =  (String) request.getParameter("cepPaciente");
				String ddd1Paciente =  (String) request.getParameter("ddd1Paciente");
				String telefone1Paciente =  (String) request.getParameter("telefone1Paciente");
				String ddd2Paciente =  (String) request.getParameter("ddd2Paciente");
				String telefone2Paciente =  (String) request.getParameter("telefone2Paciente");
				String stringConvenio = (String) request.getParameter("convenio");
				
				Convenio convenio = new Convenio();
				DaoConvenio daoConvenio = new DaoConvenio();
				convenio = daoConvenio.pesquisarConvenioPorNome(stringConvenio);
				
				Paciente paciente = new Paciente(nomeUsuario, senhaUsuario, perfilUsuario, rgUsuario, cpfUsuario, sexoUsuario, ca.dataStringParaDataSql(dtNascUsuario), responsavelPAciente, logradouroPaciente,numeroLogradouroPaciente, complementoLogradouroPaciente, bairroPaciente, cidadePaciente, estadoPaciente, cepPaciente, ddd1Paciente, telefone1Paciente, ddd2Paciente, telefone2Paciente, convenio);
				objetoSessao.setAttribute("paciente", paciente);
				if (validaCampos(nomeUsuario, rgUsuario, cpfUsuario, dtNascUsuario, sexoUsuario, stringConvenio)){
					// gerar uma string com 6 caracteres para colocar na senha
					paciente = new Paciente(nomeUsuario, senhaUsuario, perfilUsuario, rgUsuario, cpfUsuario, sexoUsuario, ca.dataStringParaDataSql(dtNascUsuario), responsavelPAciente, logradouroPaciente,numeroLogradouroPaciente, complementoLogradouroPaciente, bairroPaciente, cidadePaciente, estadoPaciente, cepPaciente, ddd1Paciente, telefone1Paciente, ddd2Paciente, telefone2Paciente, convenio);
					DaoPaciente daoPaciente = new DaoPaciente();
					daoPaciente.cadastrarPaciente(paciente);
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
			String nomeUsuario = (String) request.getParameter("nomePaciente");
			Paciente paciente = new Paciente(nomeUsuario);
			DaoPaciente daoPaciente = new DaoPaciente();
			paciente = daoPaciente.pesquisarPacientePorNome(nomeUsuario);
			if (paciente != null){
				ConfiguraAtributo ca = new ConfiguraAtributo();
				mensagem = "Paciente encontrado.";
				request.setAttribute("msg", mensagem);
				objetoSessao.setAttribute("data", ca.dataSqlParaDataString(paciente.getDataNascimentoUsuario()));
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
				DaoPaciente daoPaciente = new DaoPaciente();
				boolean result = daoPaciente.excluirPaciente(paciente);
				if (result){
					mensagem = "Paciente excluído com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("paciente");
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
			String nomeUsuario = (String) request.getParameter("nomePaciente");
			String rgUsuario = (String) request.getParameter("rgPaciente");
			String cpfUsuario = (String) request.getParameter("cpfPaciente");
			String dtNascUsuario = (String) request.getParameter("dtNascPaciente");
			String sexoUsuario = (String) request.getParameter("sexoPaciente");
			String responsavelPaciente = (String) request.getParameter("responsavelPaciente");
			String logradouroPaciente =  (String) request.getParameter("logradouroPaciente");
			String numeroLogradouroPaciente =  (String) request.getParameter("numeroLogradouroPaciente");
			String complementoLogradouroPaciente =  (String) request.getParameter("complementoLogradouroPaciente");
			String bairroPaciente =  (String) request.getParameter("bairroPaciente");
			String cidadePaciente =  (String) request.getParameter("cidadePaciente");
			String estadoPaciente =  (String) request.getParameter("estadoPaciente");
			String cepPaciente =  (String) request.getParameter("cepPaciente");
			String ddd1Paciente =  (String) request.getParameter("ddd1Paciente");
			String telefone1Paciente =  (String) request.getParameter("telefone1Paciente");
			String ddd2Paciente =  (String) request.getParameter("ddd2Paciente");
			String telefone2Paciente =  (String) request.getParameter("telefone2Paciente");
			String stringConvenio = (String) request.getParameter("convenio");
			
			Convenio convenio = new Convenio();
			DaoConvenio daoConvenio = new DaoConvenio();
			convenio = daoConvenio.pesquisarConvenioPorNome(stringConvenio);
			
			
			if (validaCampos(nomeUsuario, rgUsuario, cpfUsuario, dtNascUsuario, sexoUsuario, stringConvenio)){
				Paciente paciente = new Paciente();
				paciente = (Paciente)objetoSessao.getAttribute("paciente");
				paciente.setNomeUsuario(nomeUsuario);
				paciente.setRgUsuario(rgUsuario);
				paciente.setCpfUsuario(cpfUsuario);
				paciente.setDataNascimentoUsuario(ca.dataStringParaDataSql(dtNascUsuario));
				paciente.setSexoUsuario(sexoUsuario);	
				paciente.setResponsavelPaciente(responsavelPaciente);
				paciente.setLogradouroPaciente(logradouroPaciente);
				paciente.setNumeroLogradouroPaciente(numeroLogradouroPaciente);
				paciente.setComplementoLogradouroPaciente(complementoLogradouroPaciente);
				paciente.setBairroPaciente(bairroPaciente);
				paciente.setCidadePaciente(cidadePaciente);
				paciente.setEstadoPaciente(estadoPaciente);
				paciente.setCepPaciente(cepPaciente);
				paciente.setDdd1Paciente(ddd1Paciente);
				paciente.setTelefone1Paciente(telefone1Paciente);
				paciente.setDdd2Paciente(ddd2Paciente);
				paciente.setTelefone2Paciente(telefone2Paciente);
				paciente.setConvenio(convenio);
				DaoPaciente daoPaciente = new DaoPaciente();
				boolean result = daoPaciente.alterarPaciente(paciente);
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

	public boolean validaCampos(String nome, String rg, String cpf, String dtnasc, String sexo, String convenio) {
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
		}else if ((convenio == null) || (convenio.equals(""))) {
			mensagem = "Preencha o sexo do paciente corretamente.";
		}else {
			result = true;
		}
		return result;
	}

}
