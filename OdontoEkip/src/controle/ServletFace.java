package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo_hibernate.Face;
import persistencia.DaoFace;

public class ServletFace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletFace() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String botao = request.getParameter("botao");
		String nomeFace = (String)request.getParameter("nomeFace");
		
		if (botao.toString().equals("Sair")){
			response.sendRedirect("principal.jsp");
		}
		else{
			if (nomeFace.equals("") || (nomeFace == null)){
				request.setAttribute("msg","Preencha o nome da face!");
				request.getRequestDispatcher("cadastroFace.jsp").forward(request,response);
			}
			else{
				if (botao.toString().equals("Gravar")){		
					try{
						Face f = new Face(
							null,
							(String)request.getParameter("nomeFace")
						);
						DaoFace daoFace = new DaoFace();
						try {
							daoFace.gravar(f);
							request.setAttribute("msg","Face cadastrada com sucesso!");
							request.getRequestDispatcher("cadastroFace.jsp").forward(request,response);
						} catch (Exception e) {
							request.setAttribute("msg","Erro ao cadastrar! "+ e.getMessage());
							request.getRequestDispatcher("cadastroFace.jsp").forward(request,response);
						}
					}catch(Exception e){
						request.setAttribute("msg","Erro ao cadastrar! "+ e.getMessage());
						request.getRequestDispatcher("cadastroFace.jsp").forward(request,response);
					}
				}
				
				if (botao.toString().equals("Cancelar")){
					response.sendRedirect("cadastroFace.jsp");
				}
				
				if (botao.toString().equals("Excluir")){
					Face f = new Face();
					f.setNomeFace(nomeFace);
					try{
						DaoFace daoFace = new DaoFace();
						daoFace.excluir(f);
						request.setAttribute("msg","Face excluída com sucesso!");
						request.getRequestDispatcher("cadastroFace.jsp").forward(request,response);
					}catch(Exception e){
						request.setAttribute("msg","Erro ao excluir! "+ e.getMessage());
						request.getRequestDispatcher("cadastroFace.jsp").forward(request,response);
					}
				}
				
				if (botao.toString().equals("Pesquisar")){
					Face f = new Face();
					f.setNomeFace(nomeFace);
					try{
						DaoFace daof = new DaoFace();
						f = daof.consultar(f);
						if (f != null){
							request.setAttribute("msg","Encontrei:"+f.getCodigoFace()+" "+f.getNomeFace());
							request.getRequestDispatcher("cadastroFace.jsp").forward(request,response);
						}
						else{
							request.setAttribute("msg","Face não encontrada!");
							request.getRequestDispatcher("cadastroFace.jsp").forward(request,response);
							f = new Face();  // pois no IF perdeu a referencia do objeto face
						}
					}
					catch (Exception ex){
						ex.printStackTrace();
					}
				}
				
			}
		}
		
	}

}
