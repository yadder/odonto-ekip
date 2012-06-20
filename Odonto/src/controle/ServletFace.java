package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistencia.DaoFace;
import persistencia.DaoFaceImp;

import modelo.Face;

public class ServletFace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletFace() {
        super();
    }
    String mensagem = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String btn = (String)request.getParameter("btn");
		HttpSession objetoSessao = request.getSession();

		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("face");
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);
			
		}else if (btn.equals("Cadastrar")){
			String nome = (String) request.getParameter("nomeFace");
			if (validaCampos(nome)){				
				Face face = new Face(nome);
				DaoFace dao = new DaoFaceImp();
				dao.cadastrarFace(face);
				mensagem = "Face cadastrada com sucesso!";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("face.jsp");
				disp.forward(request, response);
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("face.jsp");
				disp.forward(request, response);
			}
		}else if (btn.equals("Pesquisar")){
			
			String nome = (String) request.getParameter("nomeFace");
			Face face = new Face(nome);
			DaoFace dao = new DaoFaceImp();
			face = dao.pesquisarFacePorNome(nome);
			if (face != null){
				mensagem = "Face encontrada.";
				request.setAttribute("msg", mensagem);
				objetoSessao.setAttribute("face", face);
				RequestDispatcher disp = request.getRequestDispatcher("face_alterar.jsp");
				disp.forward(request, response);
			}else{
				mensagem = "Face não encontrada.";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("face_alterar.jsp");
				disp.forward(request, response);
			}
		}else if(btn.equals("Excluir")){

				Face face = new Face();
				face = (Face)objetoSessao.getAttribute("face");
				DaoFace dao = new DaoFaceImp();
				boolean result = dao.excluirFace(face);
				if (result){
					mensagem = "Face excluída com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("face");
					RequestDispatcher disp = request.getRequestDispatcher("face.jsp");
					disp.forward(request, response);
				}else{
					mensagem = "Ocorreu algum erro ao excluir a face.";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("face.jsp");
					disp.forward(request, response);
				}
		}else if(btn.equals("Alterar")){
			String nome = (String) request.getParameter("nomeFace");
			if (validaCampos(nome)){	
				Face face = new Face();
				face = (Face)objetoSessao.getAttribute("face");
				face.setNomeFace((String)request.getParameter("nomeFace"));								
				DaoFace dao = new DaoFaceImp();
				boolean result = dao.alterarFace(face);
				if (result){
					mensagem = "Face alterada com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("face");
					RequestDispatcher disp = request.getRequestDispatcher("face.jsp");
					disp.forward(request, response);
				}else{
					mensagem = "Ocorreu algum erro ao excluir a face.";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("face.jsp");
					disp.forward(request, response);
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("face_alterar.jsp");
				disp.forward(request, response);
			}
		}
	
	}
	
	public boolean validaCampos(String nome){
		boolean result = false;
		if ((nome == null) || (nome.length()<3)){
			mensagem = "Preencha o nome da face corretamente.";
		}else{
			result = true;
		}
		return result;
	}

}
