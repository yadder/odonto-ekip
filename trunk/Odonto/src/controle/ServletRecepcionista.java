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
import util.ConfiguraAtributo;

public class ServletRecepcionista extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String mensagem = null;

	public ServletRecepcionista() {
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn = (String)request.getParameter("btn");
		HttpSession objetoSessao = request.getSession();
		Usuario usuario = new Usuario();
		ConfiguraAtributo ca = new ConfiguraAtributo();

		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("usuario");
			objetoSessao.removeAttribute("data");
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);
			
		}else if (btn.equals("Cadastrar")){
			usuario = preencheObjeto(request, response);
			if (validaCampos(usuario)){
				try{
					DaoUsuario daoUsuario = new DaoUsuario();
					daoUsuario.cadastrarUsuario(usuario);
					mensagem = "Recepcionista cadastrado(a) com sucesso!";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("recepcionista.jsp");
					disp.forward(request, response);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				request.setAttribute("msg", mensagem);
				String data = ca.dataSqlParaDataString(usuario.getDataNascimentoUsuario());
				objetoSessao.setAttribute("data", data);
				RequestDispatcher disp = request.getRequestDispatcher("recepcionista.jsp");
				disp.forward(request, response);
			}
		}else if (btn.equals("Pesquisar")){
			usuario = preencheObjeto(request, response);
			if (validaCampos(usuario)){
				try{
					DaoUsuario daoUsuario = new DaoUsuario();
					usuario = daoUsuario.pesquisarUsuarioPorNome(usuario);
					if (usuario != null){
						mensagem = "Usuario encontrado(a).";
						request.setAttribute("msg", mensagem);
						objetoSessao.setAttribute("usuario", usuario);
						objetoSessao.setAttribute("data", ca.dataSqlParaDataString(usuario.getDataNascimentoUsuario()));
						RequestDispatcher disp = request.getRequestDispatcher("usuario_alterar.jsp");
						disp.forward(request, response);
					}else{
						mensagem = "Usuario não encontrado(a).";
						request.setAttribute("msg", mensagem);
						RequestDispatcher disp = request.getRequestDispatcher("usuario.jsp");
						disp.forward(request, response);
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else if(btn.equals("Excluir")){
			try{
				usuario = (Usuario)objetoSessao.getAttribute("usuario");
				DaoUsuario daoUsuario = new DaoUsuario();
				daoUsuario.excluirUsuario(usuario);
				mensagem = "Usuario(a) excluído(a) com sucesso.";
				request.setAttribute("msg", mensagem);
				objetoSessao.removeAttribute("usuario");
				RequestDispatcher disp = request.getRequestDispatcher("usuario.jsp");
				disp.forward(request, response);
			}catch (Exception e) {
				mensagem = "Ocorreu algum erro ao excluir o(a) usuario(a).";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("usuario.jsp");
				disp.forward(request, response);
				e.printStackTrace();
			}
		}else if(btn.equals("Alterar")){
			usuario = preencheObjeto(request, response);
			usuario.setIdUsuario(((Usuario)objetoSessao.getAttribute("usuario")).getIdUsuario());
			if (validaCampos(usuario)){	
				try{					
					DaoUsuario daoUsuario = new DaoUsuario();
					daoUsuario.alterarUsuario(usuario);
					mensagem = "Usuario alterado(a) com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("usuario");
					objetoSessao.removeAttribute("data");
					RequestDispatcher disp = request.getRequestDispatcher("usuario.jsp");
					disp.forward(request, response);
				}catch (Exception e) {
					mensagem = "Ocorreu algum erro ao alterar o(a) usuario.";
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

	public Usuario preencheObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		ConfiguraAtributo ca = new ConfiguraAtributo();
		usuario.setNomeUsuario((String) request.getParameter("nomeUsuario"));
		usuario.setSenhaUsuario(ca.gerarSenha());
		usuario.setPerfilUsuario("RECEPCIONISTA");
		usuario.setRgUsuario((String) request.getParameter("rgUsuario"));
		usuario.setCpfUsuario((String) request.getParameter("cpfUsuario"));
		usuario.setDataNascimentoUsuario(ca.dataStringParaDataSql((String) request.getParameter("dtNascUsuario")));
		usuario.setSexoUsuario((String) request.getParameter("sexoUsuario"));
		return usuario;		
	}
	
	public boolean validaCampos(Usuario usuario) {
		// retira espaços
		usuario.setNomeUsuario(usuario.getNomeUsuario().trim()); 
		usuario.setRgUsuario(usuario.getRgUsuario().trim()); 
		usuario.setCpfUsuario(usuario.getCpfUsuario().trim()); 
		usuario.setSexoUsuario(usuario.getSexoUsuario().trim()); 
		
		boolean result = false;
		if ((usuario.getNomeUsuario() == null) || (usuario.getNomeUsuario().length() < 5)) {
			mensagem = "Preencha o nome do(a) usuario corretamente. O nome deve ter pelo menos 5 caracteres";
		}else if ((usuario.getRgUsuario() == null) || (usuario.getRgUsuario().length() < 5)) {
			mensagem = "Preencha o RG da usuario corretamente.";
		}else if ((usuario.getCpfUsuario() == null) || (usuario.getCpfUsuario().length() < 11)) {
			mensagem = "Preencha o CPF da usuario corretamente.";
		}else if ((usuario.getDataNascimentoUsuario() == null) || (usuario.getDataNascimentoUsuario().equals(""))) {
			mensagem = "Preencha a data de nascimento da usuario corretamente.";
		}else if ((usuario.getSexoUsuario() == null) || (usuario.getSexoUsuario().equals(""))) {
			mensagem = "Preencha o sexo da usuario corretamente.";
		}else {
			result = true;
		}
		return result;
	}
	
	public boolean validaNome(Usuario usuario){
		boolean result = false;
		usuario.setNomeUsuario(usuario.getNomeUsuario().trim());
		if ((usuario.getNomeUsuario() == null) || (usuario.getNomeUsuario().length() < 5)) {
			mensagem = "Preencha o nome do(a) usuario corretamente. O nome deve ter pelo menos 5 caracteres";
		}else{
			result = true;
		}
		return result;
	}

}
