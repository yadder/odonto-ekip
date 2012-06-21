package controle;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;
import persistencia.DaoUsuario;
import persistencia.DaoUsuarioImp;

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
			try{
			String nome = (String) request.getParameter("nomeUsuario");
			String login = (String) request.getParameter("loginUsuario");
			String senha = (String) request.getParameter("senhaUsuario");
			String rg = (String) request.getParameter("rgUsuario");
			String cpf = (String) request.getParameter("cpfUsuario");
			DateFormat formatter = new SimpleDateFormat("MM/dd/yy");  
			Date dtnasc = (Date)formatter.parse(request.getParameter("dtNascUsuario"));
			String sexo = (String) request.getParameter("sexoUsuario");
			String perfil = (String) request.getParameter("perfilUsuario");
			
			if (validaCampos(nome, login, senha, rg, cpf, dtnasc, sexo, perfil)){
				Usuario usuario = new Usuario(nome, login, senha, perfil, rg, cpf, dtnasc, sexo);
				DaoUsuario dao = new DaoUsuarioImp();
				dao.cadastrarUsuario(usuario);
				mensagem = "Usuário cadastrado com sucesso!";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("usuario.jsp");
				disp.forward(request, response);
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("usuario.jsp");
				disp.forward(request, response);
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if (btn.equals("Pesquisar")){
			String nome = (String) request.getParameter("nomeUsuario");
			Usuario usuario = new Usuario(nome);
			DaoUsuario dao = new DaoUsuarioImp();
			usuario = dao.pesquisarUsuarioPorNome(nome);
			if (usuario != null){
				mensagem = "Usuário encontrado.";
				request.setAttribute("msg", mensagem);
				objetoSessao.setAttribute("usuario", usuario);
				RequestDispatcher disp = request.getRequestDispatcher("usuario_alterar.jsp");
				disp.forward(request, response);
			}else{
				mensagem = "Usuário não encontrado.";
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
					mensagem = "Usuário excluído com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("usuario");
					RequestDispatcher disp = request.getRequestDispatcher("usuario.jsp");
					disp.forward(request, response);
				}else{
					mensagem = "Ocorreu algum erro ao excluir o usuário.";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("usuario.jsp");
					disp.forward(request, response);
				}
		}else if(btn.equals("Alterar")){
			try{
			String nome = (String) request.getParameter("nomeUsuario");
			String login = (String) request.getParameter("loginUsuario");
			String senha = (String) request.getParameter("senhaUsuario");
			String rg = (String) request.getParameter("rgUsuario");
			String cpf = (String) request.getParameter("cpfUsuario");
			DateFormat formatter = new SimpleDateFormat("MM/dd/yy");  
			Date dtnasc = (Date)formatter.parse(request.getParameter("dtNascUsuario"));
			String sexo = (String) request.getParameter("sexoUsuario");
			String perfil = (String) request.getParameter("perfilUsuario");
			if (validaCampos(nome, login, senha, rg, cpf, dtnasc, sexo, perfil)){
				Usuario usuario = new Usuario();
				usuario = (Usuario)objetoSessao.getAttribute("usuario");
				usuario.setNomeUsuario((String)request.getParameter("nomeUsuario"));								
				DaoUsuario dao = new DaoUsuarioImp();
				boolean result = dao.alterarUsuario(usuario);
				if (result){
					mensagem = "Usuário alterado com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("usuario");
					RequestDispatcher disp = request.getRequestDispatcher("usuario.jsp");
					disp.forward(request, response);
				}else{
					mensagem = "Ocorreu algum erro ao excluir o usuário.";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("usuario.jsp");
					disp.forward(request, response);
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("usuario_alterar.jsp");
				disp.forward(request, response);
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public boolean validaCampos(String nome, String login, String senha,
			String rg, String cpf, Date dtnasc, String sexo, String perfil) {
		boolean result = false;
		if ((nome == null) || (nome.length() < 5)) {
			mensagem = "Preencha o nome do usuário corretamente.";
		} else {
			result = true;
		}
		return result;
	}

}
