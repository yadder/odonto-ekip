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
			System.out.println("Cadastrado com sucesso!");
			response.sendRedirect("principal.jsp");
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar! "+ e.getMessage());
		}
		}catch(Exception e){
			System.out.println("Erro ao cadastrar! "+ e.getMessage());
		}
	}
	

}
