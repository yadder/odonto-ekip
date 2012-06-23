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

public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String mensagem = null;

	public ServletUsuario() {
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
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);
			
		}else if (btn.equals("Cadastrar")){
				ConfiguraAtributo ca = new ConfiguraAtributo();
				String nome = (String) request.getParameter("nomeUsuario");
				String rg = (String) request.getParameter("rgUsuario");
				String cpf = (String) request.getParameter("cpfUsuario");
				String dtnasc = (String) request.getParameter("dtNascUsuario");
				String sexo = (String) request.getParameter("sexoUsuario");
				String perfil = (String) request.getParameter("perfilUsuario");
				System.out.println("SEXO: "+sexo+" PERFIL: "+ perfil);
				String senha = null;
				Usuario usuario = new Usuario(nome, senha, perfil, rg, cpf, sexo, ca.dataStringParaDataSql(dtnasc));
				objetoSessao.setAttribute("usuario", usuario);
				if (validaCampos(nome, rg, cpf, dtnasc, sexo, perfil)){
					// gerar uma string com 6 caracteres para colocar na senha
					senha = cpf;
					
					usuario = new Usuario(nome, senha, perfil, rg, cpf, sexo, ca.dataStringParaDataSql(dtnasc));
					DaoUsuario dao = new DaoUsuarioImp();
					dao.cadastrarUsuario(usuario);
					mensagem = "Usu�rio cadastrado com sucesso!";
					objetoSessao.removeAttribute("usuario");
					objetoSessao.removeAttribute("data");
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("usuario.jsp");
					disp.forward(request, response);
				}else{
					request.setAttribute("msg", mensagem);
					String data = ca.dataSqlParaDataString(usuario.getDataNascimentoUsuario());
					objetoSessao.setAttribute("data", data);
					RequestDispatcher disp = request.getRequestDispatcher("usuario.jsp");
					disp.forward(request, response);
				}
		}else if (btn.equals("Pesquisar")){
			String nome = (String) request.getParameter("nomeUsuario");
			Usuario usuario = new Usuario(nome);
			DaoUsuario dao = new DaoUsuarioImp();
			usuario = dao.pesquisarUsuarioPorNome(nome);
			if (usuario != null){
				mensagem = "Usu�rio encontrado.";
				request.setAttribute("msg", mensagem);
				objetoSessao.setAttribute("usuario", usuario);
				RequestDispatcher disp = request.getRequestDispatcher("usuario_alterar.jsp");
				disp.forward(request, response);
			}else{
				mensagem = "Usu�rio n�o encontrado.";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("usuario.jsp");
				disp.forward(request, response);
			}
		}else if(btn.equals("Excluir")){
				Usuario usuario = new Usuario();
				usuario = (Usuario)objetoSessao.getAttribute("usuario");
				DaoUsuario dao = new DaoUsuarioImp();
				boolean result = dao.excluirUsuario(usuario);
				if (result){
					mensagem = "Usu�rio exclu�do com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("usuario");
					RequestDispatcher disp = request.getRequestDispatcher("usuario.jsp");
					disp.forward(request, response);
				}else{
					mensagem = "Ocorreu algum erro ao excluir o usu�rio.";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("usuario.jsp");
					disp.forward(request, response);
				}
		}else if(btn.equals("Alterar")){
			String nome = (String) request.getParameter("nomeUsuario");
			String rg = (String) request.getParameter("rgUsuario");
			String cpf = (String) request.getParameter("cpfUsuario");
			String dtnasc = request.getParameter("dtNascUsuario");
			String sexo = (String) request.getParameter("sexoUsuario");
			String perfil = (String) request.getParameter("perfilUsuario");
			if (validaCampos(nome, rg, cpf, dtnasc, sexo, perfil)){
				Usuario usuario = new Usuario();
				usuario = (Usuario)objetoSessao.getAttribute("usuario");
				usuario.setNomeUsuario((String)request.getParameter("nomeUsuario"));								
				DaoUsuario dao = new DaoUsuarioImp();
				boolean result = dao.alterarUsuario(usuario);
				if (result){
					mensagem = "Usu�rio alterado com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("usuario");
					RequestDispatcher disp = request.getRequestDispatcher("usuario.jsp");
					disp.forward(request, response);
				}else{
					mensagem = "Ocorreu algum erro ao excluir o usu�rio.";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("usuario.jsp");
					disp.forward(request, response);
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("usuario_alterar.jsp");
				disp.forward(request, response);
			}
			
		}
	}

	public boolean validaCampos(String nome, String rg, String cpf, String dtnasc, String sexo, String perfil) {
		boolean result = false;
		if ((nome == null) || (nome.length() < 5)) {
			mensagem = "Preencha o nome do usu�rio corretamente. O nome deve ter pelo menos 5 caracteres";
		}else if ((rg == null) || (rg.length() < 5)) {
			mensagem = "Preencha o RG do usu�rio corretamente.";
		}else if ((cpf == null) || (cpf.length() < 11)) {
			mensagem = "Preencha o CPF do usu�rio corretamente.";
		}else if ((dtnasc == null) || (dtnasc.equals(""))) {
			mensagem = "Preencha a data de nascimento do usu�rio corretamente.";
		}else if ((sexo == null) || (sexo.equals(""))) {
			mensagem = "Preencha o sexo do usu�rio corretamente.";
		}else if ((perfil == null) || (perfil.equals(""))) {
			mensagem = "Preencha o perfil do usu�rio corretamente.";
		}else {
			result = true;
		}
		return result;
	}

}
