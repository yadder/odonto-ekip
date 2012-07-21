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
		Paciente paciente = new Paciente();
		ConfiguraAtributo ca = new ConfiguraAtributo();
		
		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("paciente");
			objetoSessao.removeAttribute("data");
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);
			
		}else if (btn.equals("Cadastrar")){
			paciente = preencheObjeto(request, response);
			objetoSessao.setAttribute("paciente",paciente);
			if (validaCampos(paciente)){
				try{
					DaoPaciente dao = new DaoPaciente();
					dao.cadastrarPaciente(paciente);
					mensagem = "Paciente cadastrado(a) com sucesso!";
					objetoSessao.removeAttribute("paciente");
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("paciente.jsp");
					disp.forward(request, response);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				request.setAttribute("msg", mensagem);
				String data = ca.dataSqlParaDataString(paciente.getDataNascimentoUsuario());
				objetoSessao.setAttribute("data", data);
				RequestDispatcher disp = request.getRequestDispatcher("paciente.jsp");
				disp.forward(request, response);
			}
		}else if (btn.equals("Pesquisar")){
			paciente = preencheObjeto(request, response);
			if (paciente.getNomeUsuario()!=null){
				try{
					DaoPaciente daoPaciente = new DaoPaciente();
					paciente = daoPaciente.pesquisarPacientePorNome(paciente);
					if (paciente != null){
						mensagem = "Paciente encontrado(a).";
						request.setAttribute("msg", mensagem);
						objetoSessao.setAttribute("paciente", paciente);
						objetoSessao.setAttribute("data", ca.dataSqlParaDataString(paciente.getDataNascimentoUsuario()));
						RequestDispatcher disp = request.getRequestDispatcher("paciente_alterar.jsp");
						disp.forward(request, response);
					}else{
						mensagem = "Paciente não encontrado(a).";
						request.setAttribute("msg", mensagem);
						RequestDispatcher disp = request.getRequestDispatcher("paciente.jsp");
						disp.forward(request, response);
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("paciente.jsp");
				disp.forward(request, response);
			}
		}else if(btn.equals("Excluir")){
			try{
				paciente = (Paciente)objetoSessao.getAttribute("paciente");
				DaoPaciente daoPaciente = new DaoPaciente();
				daoPaciente.excluirPaciente(paciente);
				mensagem = "Paciente excluído(a) com sucesso.";
				request.setAttribute("msg", mensagem);
				objetoSessao.removeAttribute("paciente");
				RequestDispatcher disp = request.getRequestDispatcher("paciente.jsp");
				disp.forward(request, response);
			}catch (Exception e) {
				mensagem = "Ocorreu algum erro ao excluir o paciente(a).";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("paciente.jsp");
				disp.forward(request, response);
				e.printStackTrace();
			}
		}else if(btn.equals("Alterar")){
			paciente = preencheObjeto(request, response);
			paciente.setIdUsuario(((Paciente)objetoSessao.getAttribute("paciente")).getIdUsuario());
			objetoSessao.setAttribute("paciente", paciente);
			if (validaCampos(paciente)){	
				try{					
					DaoPaciente daoPaciente = new DaoPaciente();
					daoPaciente.alterarPaciente(paciente);
					mensagem = "Paciente alterado(a) com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("paciente");
					objetoSessao.removeAttribute("data");
					RequestDispatcher disp = request.getRequestDispatcher("paciente.jsp");
					disp.forward(request, response);
				}catch (Exception e) {
					mensagem = "Ocorreu algum erro ao alterar o(a) paciente.";
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

	public Paciente preencheObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Paciente paciente = new Paciente();
		ConfiguraAtributo ca = new ConfiguraAtributo();
		paciente.setNomeUsuario((String) request.getParameter("nomePaciente"));
		paciente.setSenhaUsuario(ca.gerarSenha());
		paciente.setPerfilUsuario("PACIENTE");
		paciente.setRgUsuario((String) request.getParameter("rgPaciente"));
		paciente.setCpfUsuario((String) request.getParameter("cpfPaciente"));
		if (!((String) request.getParameter("dtNascPaciente")).equals("")){
			paciente.setDataNascimentoUsuario(ca.dataStringParaDataSql((String) request.getParameter("dtNascPaciente")));
		}			
		paciente.setSexoUsuario((String) request.getParameter("sexoPaciente"));
		paciente.setResponsavelPaciente((String) request.getParameter("responsavelPaciente"));
		paciente.setLogradouroPaciente((String) request.getParameter("logradouroPaciente"));
		paciente.setNumeroLogradouroPaciente((String) request.getParameter("numeroLogradouroPaciente"));
		paciente.setComplementoLogradouroPaciente((String) request.getParameter("complementoLogradouroPaciente"));
		paciente.setBairroPaciente((String) request.getParameter("bairroPaciente"));
		paciente.setCidadePaciente((String) request.getParameter("cidadePaciente"));
		paciente.setEstadoPaciente((String) request.getParameter("estadoPaciente"));
		paciente.setCepPaciente((String) request.getParameter("cepPaciente"));
		paciente.setDdd1Paciente((String) request.getParameter("ddd1Paciente"));
		paciente.setTelefone1Paciente((String) request.getParameter("telefone1Paciente"));
		paciente.setDdd2Paciente((String) request.getParameter("ddd2Paciente"));
		paciente.setTelefone2Paciente((String) request.getParameter("telefone2Paciente"));
		if (!((String) request.getParameter("convenio")).equals("")){
			paciente.setConvenio(getConvenio((String) request.getParameter("convenio")));
		}			
		return paciente;		
	}
	
	public Convenio getConvenio(String nomeConvenio){
		try{
			DaoConvenio daoConvenio = new DaoConvenio();
			Convenio convenio = new Convenio();
			convenio.setNomeConvenio(nomeConvenio);
			convenio = daoConvenio.pesquisarConvenioPorNome(convenio);
			return convenio;
		}catch (Exception e) {
			mensagem = "Erro ao buscar convênio.";
			e.printStackTrace();
			return null;
		}		
	}
	public boolean validaCampos(Paciente paciente) {
		// retira espaços
		paciente.setNomeUsuario(paciente.getNomeUsuario().trim()); 
		paciente.setRgUsuario(paciente.getRgUsuario().trim()); 
		paciente.setCpfUsuario(paciente.getCpfUsuario().trim()); 
		paciente.setResponsavelPaciente(paciente.getResponsavelPaciente().trim());
		paciente.setLogradouroPaciente(paciente.getLogradouroPaciente().trim());
		paciente.setNumeroLogradouroPaciente(paciente.getLogradouroPaciente().trim());
		paciente.setComplementoLogradouroPaciente(paciente.getComplementoLogradouroPaciente().trim());
		paciente.setBairroPaciente(paciente.getBairroPaciente().trim());
		paciente.setCidadePaciente(paciente.getCidadePaciente().trim());
		paciente.setEstadoPaciente(paciente.getEstadoPaciente().trim());
		paciente.setCepPaciente(paciente.getCepPaciente().trim());
		paciente.setDdd1Paciente(paciente.getDdd1Paciente().trim());
		paciente.setTelefone1Paciente(paciente.getTelefone1Paciente().trim());
		
		boolean result = false;
		if ((paciente.getNomeUsuario() == null) || (paciente.getNomeUsuario().length() < 5)) {
			mensagem = "Preencha o nome do(a) paciente corretamente. O nome deve ter pelo menos 5 caracteres";
		}else if ((paciente.getRgUsuario() == null) || (paciente.getRgUsuario().length() < 5)) {
			mensagem = "Preencha o RG do(a) paciente corretamente.";
		}else if ((paciente.getCpfUsuario() == null) || (paciente.getCpfUsuario().length() < 14)) {
			mensagem = "Preencha o CPF do(a) paciente corretamente.";
		}else if ((paciente.getDataNascimentoUsuario() == null) || (paciente.getDataNascimentoUsuario().equals(""))) {
			mensagem = "Preencha a data de nascimento do(a) paciente corretamente.";
		}else if ((paciente.getSexoUsuario() == null) || (paciente.getSexoUsuario().equals(""))) {
			mensagem = "Preencha o sexo do(a) paciente corretamente.";
		}else if ((paciente.getDdd1Paciente() == null) || (paciente.getDdd1Paciente().equals("")) ||(paciente.getDdd1Paciente().length()<2)) {
			mensagem = "Preencha o DDD do(a) paciente corretamente.";
		}else if ((paciente.getTelefone1Paciente() == null) || (paciente.getTelefone1Paciente().equals("")) || (paciente.getTelefone1Paciente().length()<9)) {
			mensagem = "Preencha o telefone1 do(a) paciente corretamente.";
		}else if ((paciente.getConvenio()==null)){
			mensagem = "Preencha o convênio do paciente.";
		}
		
		// outros campos do paciente
		
		
		else {
			result = true;
		}
		return result;
	}
	
	public boolean validaNome(Paciente paciente){
		boolean result = false;
		paciente.setNomeUsuario(paciente.getNomeUsuario().trim());
		if ((paciente.getNomeUsuario() == null) || (paciente.getNomeUsuario().length() < 5)) {
			mensagem = "Preencha o nome do(a) paciente corretamente. O nome deve ter pelo menos 5 caracteres";
		}else{
			result = true;
		}
		return result;
	}
}
