package controle;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Consulta;
import modelo.Dentista;
import modelo.Paciente;
import persistencia.DaoConsulta;

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
		ConfiguraAtributo ca = new ConfiguraAtributo();
		ProcurarObjeto po = new ProcurarObjeto();
		
		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("consulta");
			objetoSessao.removeAttribute("paciente");
			objetoSessao.removeAttribute("listaConsulta");
			objetoSessao.removeAttribute("listaDentista");
			objetoSessao.removeAttribute("dentista");
			objetoSessao.removeAttribute("idConsulta");
			ca.sendRedirect(request, response, null, null, "principal.jsp");
		}else if(btn.equals("Pesquisar Paciente")){
			if (validaNome(((String)request.getParameter("nomePaciente")))){
				Paciente paciente = new Paciente();
				paciente = po.getPaciente((String)request.getParameter("nomePaciente"));
				if (paciente != null){
					objetoSessao.setAttribute("paciente", paciente);
					ca.sendRedirect(request, response, null, null, "ServletConsulta?btn=preencheCombo");
				}else{
					ca.sendRedirect(request, response, null, "Paciente não encontrado.", "pesquisar_paciente_agendar_consulta.jsp");
				}
			}else{
				ca.sendRedirect(request, response, null, mensagem, "pesquisar_paciente_agendar_consulta.jsp");
			}
		}else if(btn.equals("Agendar Consulta")){
			consulta = preencheObjeto(request, response);
			objetoSessao.setAttribute("consulta", consulta);
			if (validaCampos(consulta)){				
				try{
					consulta.setPaciente((Paciente)objetoSessao.getAttribute("paciente"));
					DaoConsulta daoConsulta = new DaoConsulta();
					daoConsulta.cadastrarConsulta(consulta);
					objetoSessao.removeAttribute("consulta");
					objetoSessao.removeAttribute("paciente");
					ca.sendRedirect(request, response, "Consulta agendada com sucesso!", null, "principal.jsp");
				}catch (Exception e) {
					ca.sendRedirect(request, response, null, "Erro ao agendar consulta. "+e.getMessage(), "agendar_consulta.jsp");
				}
			}else{
				ca.sendRedirect(request, response, null, mensagem, "agendar_consulta.jsp");
			}
		}else if (btn.equals("listarconsultas")){
			try{
				DaoConsulta dao = new DaoConsulta();
				List<Consulta> listaConsulta = new ArrayList<Consulta>();
				listaConsulta = dao.pesquisarTodosConsultaAgendada();
				if (listaConsulta!= null){
					objetoSessao.setAttribute("listaConsulta", listaConsulta);
					ca.sendRedirect(request, response, null, null, "listar_consultas.jsp");
				}else{
					objetoSessao.removeAttribute("listaConsulta");
					ca.sendRedirect(request, response, null, "Não existe consultas agendadas.", "listar_consultas.jsp");
				}				
			}catch(Exception ex){
				ca.sendRedirect(request, response, null, "Erro ao buscar consultas agendadas. "+ex.getMessage(), "listar_consultas.jsp");
			}
		}else if (btn.equals("preencheCombo")){
			try{
				List<Dentista> listaDentista = new ArrayList<Dentista>();
				listaDentista = po.getListaDentista();
				if (listaDentista!= null){
					objetoSessao.setAttribute("listaDentista", listaDentista);
					ca.sendRedirect(request, response, null, null, "agendar_consulta.jsp");
				}else{
					objetoSessao.removeAttribute("listaDentista");
					ca.sendRedirect(request, response, null, "Nenhum dentista encontrado.", "agendar_consulta.jsp");
				}				
			}catch(Exception ex){
				ca.sendRedirect(request, response, null, "Erro ao buscar dentistas. "+ex.getMessage(), "agendar_consulta.jsp");
			}
		}else if (btn.equals("Pesquisar")){
			if (validaData(((String)request.getParameter("dataConsulta")))){
				Date data = (ca.dataStringParaDataSql((String)request.getParameter("dataConsulta")));
				try{
					DaoConsulta dao = new DaoConsulta();
					List<Consulta> listaConsulta = new ArrayList<Consulta>();
					listaConsulta = dao.pesquisarTodosConsultaData(data);
					if (listaConsulta.size()>0){
						objetoSessao.setAttribute("listaConsulta", listaConsulta);
						ca.sendRedirect(request, response, null, null, "listar_consultas.jsp");
					}else{
						objetoSessao.removeAttribute("listaConsulta");
						ca.sendRedirect(request, response, null, "Nenhuma consulta foi agendada para a data "+ca.dataSqlParaDataString(data), "pesquisar_consulta_por_data.jsp");
					}
				}catch(Exception ex){
					ca.sendRedirect(request, response, null, "Erro ao buscar consultas. "+ex.getMessage(), "principal.jsp");
				}
			}else{
				ca.sendRedirect(request, response, null, mensagem, "pesquisar_consulta_por_data.jsp");
			}			
		}else if (btn.equals("Pesquisar por paciente")){
			if (validaNome(((String)request.getParameter("nomePaciente")))){
				try{
					DaoConsulta dao = new DaoConsulta();
					Paciente paciente = new Paciente();
					paciente = po.getPaciente((String)request.getParameter("nomePaciente"));
					if (paciente!=null){
						List<Consulta> listaConsulta = new ArrayList<Consulta>();
						listaConsulta = dao.pesquisarConsultaPorPaciente(paciente);
						if (listaConsulta.size()>0){
							objetoSessao.setAttribute("listaConsulta", listaConsulta);
							ca.sendRedirect(request, response, null, null, "listar_consultas.jsp");
						}else{
							objetoSessao.removeAttribute("listaConsulta");
							ca.sendRedirect(request, response, null, "Nenhuma consulta foi agendada para o paciente "+paciente.getNomeUsuario(), "pesquisar_consulta_por_nome.jsp");
						}
					}else{
						ca.sendRedirect(request, response, null, "Paciente não encontrado", "pesquisar_consulta_por_nome.jsp");
					}
				}catch(Exception ex){
					ca.sendRedirect(request, response, null, "Erro ao buscar consultas. "+ex.getMessage(), "principal.jsp");
				}
			}else{
				ca.sendRedirect(request, response, null, mensagem, "pesquisar_consulta_por_nome.jsp");
			}			
		}else if (btn.equals("Cancelar")){
			long idConsulta = Long.parseLong((String)request.getParameter("id"));
			//pesquisar consulta
			consulta = po.getConsultaPorId(idConsulta);
			if (consulta!=null){
				try{
					DaoConsulta daoConsulta = new DaoConsulta();
					//verificar RN de 24 horas
					consulta.setStatusConsulta("CANCELADA");
					daoConsulta.alterarConsulta(consulta);
					ca.sendRedirect(request, response, "Consulta cancelada com sucesso!", null, "ServletConsulta?btn=listarconsultas");
				}catch (Exception e) {
					ca.sendRedirect(request, response, null, "Erro ao cancelar consulta. "+e.getMessage(),"listar_consultas.jsp");
				}
			}else{
				ca.sendRedirect(request, response, null, "Consulta não encontrada.", "listar_consultas.jsp");
			}			
		}else if (btn.equals("Remarcar")){
			long idConsulta = Long.parseLong((String)request.getParameter("id"));
			consulta = po.getConsultaPorId(idConsulta);
			if (consulta!=null){
				Paciente paciente = new Paciente();
				Dentista dentista = new Dentista();
				paciente = po.getPacientePorId(consulta.getPaciente().getIdUsuario());
				dentista = po.getDentistaPorId(consulta.getDentista().getIdUsuario());				
				objetoSessao.setAttribute("paciente", paciente);
				objetoSessao.setAttribute("dentista", dentista);
				objetoSessao.setAttribute("idConsulta", idConsulta);
				ca.sendRedirect(request, response, "Informe a nova data ou hora da consulta", null, "remarcar_consulta.jsp");
			}else{
				ca.sendRedirect(request, response, null, "Consulta não encontrada.", "listar_consultas.jsp");
			}
		}else if (btn.equals("Remarcar consulta")){		
			long idConsulta = Long.parseLong((objetoSessao.getAttribute("idConsulta")).toString());
			consulta = po.getConsultaPorId(idConsulta);
			if (consulta!=null){
				//remarcar consulta
				try{
					if (validaData((String)request.getParameter("dataConsulta"))){
						consulta.setDataConsulta(ca.dataStringParaDataSql((String)request.getParameter("dataConsulta")));
					}else{
						ca.sendRedirect(request, response, null, mensagem, "remarcar_consulta.jsp");
					}
					consulta.setHoraConsulta((String)request.getParameter("horaConsulta"));
					DaoConsulta daoConsulta = new DaoConsulta();
					daoConsulta.alterarConsulta(consulta);
					ca.sendRedirect(request, response, "Consulta remarcada com sucesso!", null, "ServletConsulta?btn=listarconsultas");
				}catch (Exception e) {
					ca.sendRedirect(request, response, null, "Erro ao remarcar a consulta. "+e.getMessage(),"remarcar_consultas.jsp");
				}	
			}else{
				ca.sendRedirect(request, response, null, "Consulta não encontrada.", "listar_consultas.jsp");
			}
		}
	}
	
	public Consulta preencheObjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Consulta consulta = new Consulta();
		ProcurarObjeto po = new ProcurarObjeto();
		ConfiguraAtributo ca = new ConfiguraAtributo();
		try{
			Dentista dentista = new Dentista();
			dentista = po.getDentista((String)request.getParameter("dentista"));
			if (dentista!=null){
				consulta.setDentista(dentista);
			}else{
				mensagem = "Erro ao gravar o dentista.";
			}

			if((String)request.getParameter("dataConsulta")!=null){
				consulta.setDataConsulta(ca.dataStringParaDataSql((String)request.getParameter("dataConsulta")));
			}else{
				mensagem = "Erro ao gravar a data da consulta.";
			}
			consulta.setHoraConsulta((String)request.getParameter("horaConsulta"));
			consulta.setStatusConsulta("AGENDADA");
			return consulta;
		}catch (Exception e) {
			mensagem = "Erro ao preencher o objeto consulta";
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
