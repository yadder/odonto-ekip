package controle;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;
import persistencia.DaoUsuario;

public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletUsuario() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String botao = request.getParameter("botao");
		
		if (botao.toString().equals("Gravar")){		
			try{
				DateFormat forma = new SimpleDateFormat("dd/MM/yyyy");    
				java.sql.Date data = new java.sql.Date(forma.parse(request.getParameter("dataNascimentoUsuario")).getTime());
					Usuario u = new Usuario(
						null,
						(String)request.getParameter("nomeUsuario"),
						(String)request.getParameter("loginUsuario"),
						(String)request.getParameter("senhaUsuario"),
						(String)request.getParameter("perfilUsuario"),
						(String)request.getParameter("rgUsuario"),
						(String)request.getParameter("cpfUsuario"),
						data,
						(String)request.getParameter("sexoUsuario")			
					);
				DaoUsuario daoUsuario = new DaoUsuario();
				try {
					daoUsuario.cadastrar(u);
					request.setAttribute("msg","Usuário cadastrado com sucesso!");
					request.getRequestDispatcher("cadastroUsuario.jsp").forward(request,response);
				} catch (Exception e) {
					request.setAttribute("msg","Erro ao cadastrar! "+ e.getMessage());
					request.getRequestDispatcher("cadastroUsuario.jsp").forward(request,response);
				}
			}catch(Exception e){
				request.setAttribute("msg","Erro ao cadastrar! "+ e.getMessage());
				request.getRequestDispatcher("cadastroUsuario.jsp").forward(request,response);
			}
		}
		if (botao.toString().equals("Alterar")){
			try{
				DateFormat forma = new SimpleDateFormat("dd/MM/yyyy");    
				java.sql.Date data = new java.sql.Date(forma.parse(request.getParameter("dataNascimentoUsuario")).getTime());
					Usuario u = new Usuario(
						null,
						(String)request.getParameter("nomeUsuario"),
						(String)request.getParameter("loginUsuario"),
						(String)request.getParameter("senhaUsuario"),
						(String)request.getParameter("perfilUsuario"),
						(String)request.getParameter("rgUsuario"),
						(String)request.getParameter("cpfUsuario"),
						data,
						(String)request.getParameter("sexoUsuario")			
					);
				DaoUsuario daoUsuario = new DaoUsuario();
				try {
					daoUsuario.alterar(u);
					request.setAttribute("msg","Usuário alterado com sucesso!");
					request.getRequestDispatcher("cadastroUsuario.jsp").forward(request,response);
				} catch (Exception e) {
					request.setAttribute("msg","Erro ao alterar! "+ e.getMessage());
					request.getRequestDispatcher("cadastroUsuario.jsp").forward(request,response);
				}
			}catch(Exception e){
				request.setAttribute("msg","Erro ao alterar! "+ e.getMessage());
				request.getRequestDispatcher("cadastroUsuario.jsp").forward(request,response);
			}
		}
		if (botao.toString().equals("Cancelar")){
			response.sendRedirect("cadastroUsuario.jsp");
		}
		if (botao.toString().equals("Excluir")){
			try{
				Usuario u = new Usuario();
				DaoUsuario daoUsuario = new DaoUsuario();
				daoUsuario.excluir(u);
				request.setAttribute("msg","Usuário excluído com sucesso! ");
				request.getRequestDispatcher("cadastroUsuario.jsp").forward(request,response);
			}catch(Exception e){
				request.setAttribute("msg","Erro ao excluir! "+ e.getMessage());
				request.getRequestDispatcher("cadastroUsuario.jsp").forward(request,response);
			}
		}
		if (botao.toString().equals("Pesquisar")){
			request.setAttribute("msg","Apertei pesquisar");
			request.getRequestDispatcher("cadastroUsuario.jsp").forward(request,response);
		}
		if (botao.toString().equals("Sair")){
			response.sendRedirect("principal.jsp");
		}
	}
}
