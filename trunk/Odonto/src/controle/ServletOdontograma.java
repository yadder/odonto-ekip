package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Convenio;
import modelo.Face;
import modelo.Odontograma;
import modelo.Paciente;
import modelo.Procedimento;
import persistencia.DaoFace;
import persistencia.DaoPaciente;
import persistencia.DaoProcedimento;

public class ServletOdontograma extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String mensagem = null;
	
	
    public ServletOdontograma() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String btn = (String)request.getParameter("btn");
		HttpSession objetoSessao = request.getSession();	
		Odontograma odontograma = new Odontograma();
		
		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("odontograma");
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);
		}else if(btn.equals("Pesquisar Paciente")){
			if (validaNome(((String)request.getParameter("nomePaciente")))){
				Paciente paciente = new Paciente();
				paciente = getPaciente((String)request.getParameter("nomePaciente"));
				if (paciente != null){
					//paciente encontrado
					// verificar se paciente ja tem odontograma aberto.
					objetoSessao.setAttribute("pacienteNovoOdontograma", paciente.getNomeUsuario());
					objetoSessao.setAttribute("convenioPaciente", paciente.getConvenio());
					request.setAttribute("msg", null);
					request.setAttribute("msgE", null);
					RequestDispatcher disp = request.getRequestDispatcher("novo_odontograma.jsp");
					disp.forward(request, response);
				}else{
					mensagem = "Paciente não encontrado.";
					request.setAttribute("msg", null);
					request.setAttribute("msgE", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("pesquisar_paciente.jsp");
					disp.forward(request, response);
				}
			}else{
				request.setAttribute("msg", null);
				request.setAttribute("msgE", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("pesquisar_paciente.jsp");
				disp.forward(request, response);
			}		
		}else if(btn.equals("Cancelar")){
			RequestDispatcher disp = request.getRequestDispatcher("novo_odontograma.jsp");
			disp.forward(request, response);
		}else if (btn.equals("Gravar procedimento")){
			
		}else if (btn.equals("18")){
			List<Procedimento> listaProcedimento = getProcedimentos((Convenio)objetoSessao.getAttribute("convenioPaciente"));
			objetoSessao.setAttribute("listaProcedimento", listaProcedimento);
			
			List<Face> listaFace = getFaces();
			objetoSessao.setAttribute("listaFace", listaFace);
			
			RequestDispatcher disp = request.getRequestDispatcher("selecionar_procedimento.jsp");
			disp.forward(request, response);
			
		}
		
		
		
		
		
	}
	
	public List<Face> getFaces(){
		try{
			List<Face> listaFace = new ArrayList<Face>();
			DaoFace daoFace = new DaoFace();
			listaFace = daoFace.pesquisarTodosFace();
			return listaFace;
		}catch (Exception e) {
			mensagem = "Erro ao buscar faces.";
			e.printStackTrace();
			return null;
		}
	}
	public List<Procedimento> getProcedimentos(Convenio convenio){
		try{
			List<Procedimento> listaProcedimento = new ArrayList<Procedimento>();
			DaoProcedimento daoProcedimento = new DaoProcedimento();
			if (convenio!=null){
				listaProcedimento = daoProcedimento.pesquisarProcedimentoPorConvenio(convenio);
			}else{
				mensagem = "Convenio não encontrado.";
			}
			return listaProcedimento;				
		}catch (Exception e) {
			mensagem = "Erro ao buscar procedimentos.";
			e.printStackTrace();
			return null;
		}		
	}
	
	public Paciente getPaciente(String nome){
		try{
			Paciente paciente = new Paciente();
			paciente.setNomeUsuario(nome);
			DaoPaciente daoPaciente = new DaoPaciente();
			paciente = daoPaciente.pesquisarPacientePorNome(paciente);
			return paciente;
		}catch(Exception ex){
			mensagem = "Erro ao pesquisar paciente.";
			ex.printStackTrace();
			return null;
		}
	}
	
	public boolean validaNome(String nome){
		boolean result = false;
		if ((nome == null) || (nome.equals("") || (nome.length()<5))){
			mensagem = "Preencha o nome do paciente corretamente.";
		}else{
			result = true;
		}
		return result;
	}

}
