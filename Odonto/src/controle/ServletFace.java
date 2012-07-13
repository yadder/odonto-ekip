package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Face;
import persistencia.DaoFace;

public class ServletFace extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String mensagem = null;   
    public ServletFace() {
    }
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String btn = (String)request.getParameter("btn");
		HttpSession objetoSessao = request.getSession();
		Face face = new Face();
		
		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("face");
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);
		}else if (btn.equals("Cadastrar")){
			face = preencheObjeto(request, response);
			if (validaCampos(face)){				
				try{
					DaoFace dao = new DaoFace();
					dao.cadastrarFace(face);
					mensagem = "Face cadastrada com sucesso!";
					request.setAttribute("msg", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("face.jsp");
					disp.forward(request, response);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("face.jsp");
				disp.forward(request, response);
			}
		}else if (btn.equals("Pesquisar")){
			face = preencheObjeto(request, response);
			if (validaCampos(face)){
				try{
					DaoFace dao = new DaoFace();
					face = dao.pesquisarFacePorNome(face);
					if (face != null){
						mensagem = "Face encontrada.";
						request.setAttribute("msg", mensagem);
						objetoSessao.setAttribute("face", face);
						RequestDispatcher disp = request.getRequestDispatcher("face_alterar.jsp");
						disp.forward(request, response);
					}else{
						mensagem = "Face não encontrada.";
						request.setAttribute("msg", mensagem);
						RequestDispatcher disp = request.getRequestDispatcher("face.jsp");
						disp.forward(request, response);
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("face.jsp");
				disp.forward(request, response);
			}
		}else if(btn.equals("Excluir")){
			try{
				face = (Face)objetoSessao.getAttribute("face");
				DaoFace dao = new DaoFace();
				dao.excluirFace(face);
				mensagem = "Face excluída com sucesso.";
				request.setAttribute("msg", mensagem);
				objetoSessao.removeAttribute("face");
				RequestDispatcher disp = request.getRequestDispatcher("face.jsp");
				disp.forward(request, response);
			}catch (Exception e) {
				mensagem = "Ocorreu algum erro ao excluir a face.";
				request.setAttribute("msg", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("face.jsp");
				disp.forward(request, response);
				e.printStackTrace();
			}
		}else if(btn.equals("Alterar")){
			face = preencheObjeto(request, response);
			face.setIdFace(((Face)objetoSessao.getAttribute("face")).getIdFace());
			if (validaCampos(face)){	
				try{					
					DaoFace dao = new DaoFace();
					dao.alterarFace(face);
					mensagem = "Face alterada com sucesso.";
					request.setAttribute("msg", mensagem);
					objetoSessao.removeAttribute("face");
					RequestDispatcher disp = request.getRequestDispatcher("face.jsp");
					disp.forward(request, response);
				}catch (Exception e) {
					mensagem = "Ocorreu algum erro ao alterar a face.";
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

	public Face preencheObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Face face = new Face();
		face.setNomeFace((String)request.getParameter("nomeFace"));
		return face;		
	}
		
	public boolean validaCampos(Face face){
		boolean result = false;
		face.setNomeFace(face.getNomeFace().trim()); // retira espaços
		if ((face.getNomeFace() == null) || (face.getNomeFace().equals(""))){
			mensagem = "Preencha o nome da face corretamente.";
		}else{
			result = true;
		}
		return result;
	}

}
