package controle;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
			objetoSessao.removeAttribute("listaConsulta");
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
		}else if (btn.equals("listarconsultas")){
			System.out.println("listarconsultas");
			try{
				DaoConsulta dao = new DaoConsulta();
				List<Consulta> listaConsulta = new ArrayList<Consulta>();
				listaConsulta = dao.pesquisarTodosConsultaAgendada();
				if (listaConsulta!= null){
					System.out.println("A lista nao esta vazia");
					objetoSessao.setAttribute("listaConsulta", listaConsulta);
					RequestDispatcher disp = request.getRequestDispatcher("listar_consultas.jsp");
					disp.forward(request, response);
				}else{
					objetoSessao.removeAttribute("listaConsulta");
					mensagem = "Não existe consultas agendadas.";
					request.setAttribute("msg", null);
					request.setAttribute("msgE", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("cancelar_consulta.jsp");
					disp.forward(request, response);
				}				
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}else if (btn.equals("Pesquisar")){
			if (validaData(((String)request.getParameter("dataConsulta")))){
				ConfiguraAtributo ca = new ConfiguraAtributo();
				Date data = (ca.dataStringParaDataSql((String)request.getParameter("dataConsulta")));
				try{
					DaoConsulta dao = new DaoConsulta();
					List<Consulta> listaConsulta = new ArrayList<Consulta>();
					listaConsulta = dao.pesquisarTodosConsultaData(data);
					if (listaConsulta.size()>0){
						objetoSessao.setAttribute("listaConsulta", listaConsulta);
						request.setAttribute("msg", null);
						request.setAttribute("msgE", null);
						RequestDispatcher disp = request.getRequestDispatcher("listar_consultas.jsp");
						disp.forward(request, response);
					}else{
						objetoSessao.removeAttribute("listaConsulta");
						mensagem = "Nenhuma consulta foi agendada para a data "+ca.dataSqlParaDataString(data);
						request.setAttribute("msg", null);
						request.setAttribute("msgE", mensagem);
						RequestDispatcher disp = request.getRequestDispatcher("cancelar_consulta.jsp");
						disp.forward(request, response);
					}
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}else{
				request.setAttribute("msg", null);
				request.setAttribute("msgE", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("cancelar_consulta.jsp");
				disp.forward(request, response);
			}			
		}else if(btn.equals("Pesquisar Paciente")){
			if (validaNome(((String)request.getParameter("nomePaciente")))){
				Paciente paciente = new Paciente();
				paciente = getPaciente((String)request.getParameter("nomePaciente"));
				if (paciente != null){
					try{
						DaoConsulta daoConsulta = new DaoConsulta();
						List<Consulta> listaConsulta = new ArrayList<Consulta>();
						listaConsulta = daoConsulta.pesquisarConsultaPorPaciente(paciente);
						if (listaConsulta.size()>0){
							objetoSessao.setAttribute("listaConsulta", listaConsulta);
							request.setAttribute("msg", null);
							request.setAttribute("msgE", null);
							RequestDispatcher disp = request.getRequestDispatcher("listar_consultas.jsp");
							disp.forward(request, response);
						}else{
							objetoSessao.removeAttribute("listaConsulta");
							mensagem = "Nenhuma consulta foi agendada para o paciente "+(String)request.getParameter("nomePaciente");
							request.setAttribute("msg", null);
							request.setAttribute("msgE", mensagem);
							RequestDispatcher disp = request.getRequestDispatcher("remarcar_consulta.jsp");
							disp.forward(request, response);
						}
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}else{
					mensagem = "Paciente não encontrado.";
					request.setAttribute("msg", null);
					request.setAttribute("msgE", mensagem);
					RequestDispatcher disp = request.getRequestDispatcher("remarcar_consulta.jsp");
					disp.forward(request, response);
				}
			}else{
				request.setAttribute("msg", null);
				request.setAttribute("msgE", mensagem);
				RequestDispatcher disp = request.getRequestDispatcher("remarcar_consulta.jsp");
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
	
	public boolean validaData(String data){
		boolean result = false;
		if ((data == null) || (data.equals("")) || (data.length()!=10)){
			mensagem = "Preencha a data da consulta corretamente.";
		}else{
			result = true;
		}
		return result;
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
