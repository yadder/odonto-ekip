package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Consulta;
import modelo.Dentista;
import modelo.Paciente;
import persistencia.DaoConsulta;
import persistencia.DaoDentista;
import persistencia.DaoPaciente;
import util.ConfiguraAtributo;

public class ServletConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String mensagem = null;

	public ServletConsulta() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String btn = (String)request.getParameter("btn");
		HttpSession objetoSessao = request.getSession();
		Consulta consulta = new Consulta();
		
		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("consulta");
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);
			
		}else if(btn.equals("Agendar Consulta")){
			consulta = preencheObjeto(request, response);
			objetoSessao.setAttribute("consulta", consulta);
			if (validaCampos(consulta)){				
				try{
					DaoConsulta daoConsulta = new DaoConsulta();
					daoConsulta.cadastrarConsulta(consulta);
					mensagem = "Consulta agendada com sucesso!";
					objetoSessao.removeAttribute("consulta");
					request.setAttribute("msg", mensagem);
					request.setAttribute("msgE", null);
					RequestDispatcher disp = request.getRequestDispatcher("agendar_consulta.jsp");
					disp.forward(request, response);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				request.setAttribute("msg", null);
				request.setAttribute("msgE", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("agendar_consulta.jsp");
				disp.forward(request, response);
			}
		}
	}
	
	public Consulta preencheObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Consulta consulta = new Consulta();
		try{
			ConfiguraAtributo ca = new ConfiguraAtributo();
			Paciente paciente = new Paciente();
			DaoPaciente daoPaciente = new DaoPaciente();
			paciente.setNomeUsuario((String)request.getParameter("paciente"));
			paciente = daoPaciente.pesquisarPacientePorNome(paciente);
			if (paciente!=null){
				consulta.setPaciente(paciente);
			}
			Dentista dentista = new Dentista();
			DaoDentista daoDentista = new DaoDentista();
			dentista.setNomeUsuario((String)request.getParameter("dentista"));
			dentista = daoDentista.pesquisarDentistaPorNome(dentista);
			if (dentista!=null){
				consulta.setDentista(dentista);
			}
			if((String)request.getParameter("dataConsulta")!=null){
				consulta.setDataConsulta(ca.dataStringParaDataSql((String)request.getParameter("dataConsulta")));
				System.out.println();
			}
			consulta.setHoraConsulta((String)request.getParameter("horaConsulta"));
			consulta.setStatusConsulta("AGENDADA");
			return consulta;
		}catch (Exception e) {
			mensagem = "Erro ao preencher o objeto consulta";
			e.printStackTrace();
		}
		return consulta;		
	}
		
	public boolean validaCampos(Consulta consulta){
		boolean result = false;
		if ((consulta.getDataConsulta() == null) || (consulta.getDataConsulta().equals(""))){
			mensagem = "Preencha a data da consulta.";
		}else if((consulta.getHoraConsulta() == null) || (consulta.getHoraConsulta().equals(""))){
			mensagem = "Preencha o horário da consulta.";
		} 
		else{
			result = true;
		}
		return result;
	}

}
