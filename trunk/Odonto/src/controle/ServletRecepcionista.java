package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;
import persistencia.DaoUsuario;
import persistencia.DaoUsuarioImp;
import util.ConfiguraAtributo;

public class ServletRecepcionista extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String mensagem = null;

	public ServletRecepcionista() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn = (String)request.getParameter("btn");
		HttpSession objetoSessao = request.getSession();

		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("usuario");
			objetoSessao.removeAttribute("data");
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);
			
		}else if (btn.equals("Cadastrar")){
				ConfiguraAtributo ca = new ConfiguraAtributo();
				String nome = (String) request.getParameter("nomeUsuario");
				String rg = (String) request.getParameter("rgUsuario");
				String cpf = (String) request.getParameter("cpfUsuario");
				String dtnasc = (String) request.getParameter("dtNascUsuario");
				String sexo = (String) request.getParameter("sexoUsuario");
				String perfil = "RECEPCIONISTA";
				String senha = null;
				Usuario usuario = new Usuario(nome, senha, perfil, rg, cpf, sexo, ca.dataStringParaDataSql(dtnasc));
				objetoSessao.setAttribute("usuario", usuario);
				if (validaCampos(nome, rg, cpf, dtnasc, sexo)){
					// gerar uma string com 6 caracteres para colocar na senha
					senha = "12345";					
					usuario = new Usuario(nome, senha, perfil, rg, cpf, sexo, ca.dataStringParaDataSql(dtnasc));
					DaoUsuario dao = new DaoUsuarioImp();
					dao.cadastrarUsuario(usuario);
					mensagem = "Recepcionista cadastrada com sucesso!";
					objetoSessao.removeAttribute("usuario");
					objetoSessao.removeAttribute("data");
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("recepcionista.jsp");
					disp.forward(request, response);
				}else{
					request.setAttribute("msg", mensagem);
					String data = ca.dataSqlParaDataString(usuario.getDataNascimentoUsuario());
					objetoSessao.setAttribute("data", data);
					RequestDispatcher disp = request.getRequestDispatcher("recepcionista.jsp");
					disp.forward(request, response);
				}
		}else if (btn.equals("Pesquisar")){
			String nome = (String) request.getParameter("nomeUsuario");
			Usuario usuario = new Usuario(nome);
			DaoUsuario dao = new DaoUsuarioImp();
			usuario = dao.pesquisarUsuarioPorNome(nome);
			if (usuario != null){
				ConfiguraAtributo ca = new ConfiguraAtributo();
				mensagem = "Recepcionista encontrada.";
				request.setAttribute("msg", mensagem);
				objetoSessao.setAttribute("data", ca.dataSqlParaDataString(usuario.getDataNascimentoUsuario()));
				System.out.println(usuario);
				objetoSessao.setAttribute("usuario", usuario);
				RequestDispatcher disp = request.getRequestDispatcher("recepcionista_alterar.jsp");
				disp.forward(request, response);
			}else{
				mensagem = "Recepcionista não encontrada.";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("recepcionista.jsp");
				disp.forward(request, response);
			}
		}else if(btn.equals("Excluir")){
				Usuario usuario = new Usuario();
				usuario = (Usuario)objetoSessao.getAttribute("usuario");
				DaoUsuario dao = new DaoUsuarioImp();
				boolean result = dao.excluirUsuario(usuario);
				if (result){
					mensagem = "Recepcionista excluída com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("usuario");
					objetoSessao.removeAttribute("data");
					RequestDispatcher disp = request.getRequestDispatcher("recepcionista.jsp");
					disp.forward(request, response);
				}else{
					mensagem = "Ocorreu algum erro ao excluir a recepcionista.";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("recepcionista.jsp");
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
				Usuario usuario = new Usuario();
				usuario = (Usuario)objetoSessao.getAttribute("usuario");
				usuario.setNomeUsuario(nome);
				usuario.setRgUsuario(rg);
				usuario.setCpfUsuario(cpf);
				usuario.setDataNascimentoUsuario(ca.dataStringParaDataSql(dtnasc));
				usuario.setSexoUsuario(sexo);				
				DaoUsuario dao = new DaoUsuarioImp();
				boolean result = dao.alterarUsuario(usuario);
				if (result){
					mensagem = "Recepcionista alterada com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("usuario");
					objetoSessao.removeAttribute("data");
					RequestDispatcher disp = request.getRequestDispatcher("recepcionista.jsp");
					disp.forward(request, response);
				}else{
					mensagem = "Ocorreu algum erro ao alterar a recepcionista.";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("recepcionista.jsp");
					disp.forward(request, response);
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("recepcionista_alterar.jsp");
				disp.forward(request, response);
			}
			
		}
	}

	public boolean validaCampos(String nome, String rg, String cpf, String dtnasc, String sexo) {
		boolean result = false;
		if ((nome == null) || (nome.length() < 5)) {
			mensagem = "Preencha o nome da recepcionista corretamente. O nome deve ter pelo menos 5 caracteres";
		}else if ((rg == null) || (rg.length() < 5)) {
			mensagem = "Preencha o RG da recepcionista corretamente.";
		}else if ((cpf == null) || (cpf.length() < 11)) {
			mensagem = "Preencha o CPF da recepcionista corretamente.";
		}else if ((dtnasc == null) || (dtnasc.equals(""))) {
			mensagem = "Preencha a data de nascimento da recepcionista corretamente.";
		}else if ((sexo == null) || (sexo.equals(""))) {
			mensagem = "Preencha o sexo da recepcionista corretamente.";
		}else {
			result = true;
		}
		return result;
	}

}
