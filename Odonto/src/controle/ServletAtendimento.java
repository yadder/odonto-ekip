package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Odontograma;
import modelo.OdontogramaProcedimento;
import modelo.Paciente;
import persistencia.DaoOdontograma;
import persistencia.DaoOdontogramaProcedimento;

public class ServletAtendimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAtendimento() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn = (String)request.getParameter("btn");
		HttpSession objetoSessao = request.getSession();
		ProcurarObjeto po = new ProcurarObjeto();
		ConfiguraAtributo ca = new ConfiguraAtributo();
		
		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("listaTratamento");
			objetoSessao.removeAttribute("odontograma");
			ca.sendRedirect(request, response, null, null, "principal.jsp");
			
		}else if(btn.equals("Pesquisar paciente para atendimento")){
			if (((String)request.getParameter("nomePaciente"))!=null){
				Paciente paciente = new Paciente();
				paciente = po.getPaciente((String)request.getParameter("nomePaciente"));
				if (paciente != null){
					//pesquisar se paciente ja tem odontograma em andamento
					Odontograma odontograma = new Odontograma();
					odontograma = po.getOdontogramaEmAndamento(paciente);
					if (odontograma == null){
						ca.sendRedirect(request, response, null, "Este paciente n�o tem um odontograma em andamento.", "pesquisar_paciente_atendimento.jsp");
					}else{
						try{
							objetoSessao.setAttribute("odontograma", odontograma);
							//carregar a lista de procedimentos
							DaoOdontogramaProcedimento daoOdontogramaProcedimento = new DaoOdontogramaProcedimento();
							List<OdontogramaProcedimento> listaTratamento = new ArrayList<OdontogramaProcedimento>();
							listaTratamento = daoOdontogramaProcedimento.pesquisarOdontogramaProcedimentoPorOdontograma(odontograma);
							if (listaTratamento.isEmpty()){
								ca.sendRedirect(request, response, null, "N�o existem procedimentos pendentes para este odontograma.", "pesquisar_paciente_atendimento.jsp");
							}else{
								objetoSessao.removeAttribute("listaTratamento");
								objetoSessao.setAttribute("listaTratamento", listaTratamento);
								ca.sendRedirect(request, response, null, null, "lista_odontograma_atendimento.jsp");
							}
						}catch(Exception e){
							ca.sendRedirect(request, response, null, "Erro ao buscar os procedimentos deste odontograma." +e.getMessage(), "pesquisar_paciente_atendimento.jsp");
						}
					}
				}else{
					ca.sendRedirect(request, response, null, "Paciente n�o encontrado.", "pesquisar_paciente_atendimento.jsp");					
				}
			}else{
				ca.sendRedirect(request, response, null, "Preencha o nome do paciente", "pesquisar_paciente_atendimento.jsp");
			}	
		}else if(btn.equals("Realizado")){
			long idOdontogramaProcedimento = Long.parseLong((String)request.getParameter("index"));
			OdontogramaProcedimento odontogramaProcedimento = new OdontogramaProcedimento();
			odontogramaProcedimento = po.getOdontogramaProcedimentoPorId(idOdontogramaProcedimento);
			if (odontogramaProcedimento!=null){
				//se autorizacao = Aprovado  RN
				if(odontogramaProcedimento.getStatusAutorizacao().equals("APROVADO")){
					if (odontogramaProcedimento.getStatusProcedimento().equals("PENDENTE")){
						odontogramaProcedimento.setStatusProcedimento("REALIZADO");
						odontogramaProcedimento.setDataExecucaoProcedimento(new Date());
						DaoOdontogramaProcedimento daoOdontogramaProcedimento = new DaoOdontogramaProcedimento();
						try{							
							daoOdontogramaProcedimento.alterarOdontogramaProcedimento(odontogramaProcedimento);
							objetoSessao.removeAttribute("listaTratamento");
							List<OdontogramaProcedimento> listaTratamento = new ArrayList<OdontogramaProcedimento>();
							Odontograma odontograma = new Odontograma();
							odontograma = (Odontograma)objetoSessao.getAttribute("odontograma");
							daoOdontogramaProcedimento = new DaoOdontogramaProcedimento();
							listaTratamento = daoOdontogramaProcedimento.pesquisarOdontogramaProcedimentoPorOdontograma(odontograma);
							objetoSessao.setAttribute("listaTratamento", listaTratamento);
							ca.sendRedirect(request, response, "Procedimento conclu�do com sucesso!", null, "lista_odontograma_atendimento.jsp");
						}catch(Exception e){
							ca.sendRedirect(request, response, null, "Erro ao gravar odontogramaProcedimento"+e.getMessage(), "lista_odontograma_atendimento.jsp");
							e.printStackTrace();
						}	
			/*			Odontograma odontograma = new Odontograma();
						odontograma = (Odontograma)objetoSessao.getAttribute("odontograma");
						daoOdontogramaProcedimento = new DaoOdontogramaProcedimento();						
						//verificar se existir procedimentos a serem feitos no odontograma
						if (getTratamentoPendente(odontograma)){
							try{
								List<OdontogramaProcedimento> listaTratamento = new ArrayList<OdontogramaProcedimento>();
								listaTratamento = daoOdontogramaProcedimento.pesquisarOdontogramaProcedimentoPorOdontograma(odontograma);
								objetoSessao.setAttribute("listaTratamento", listaTratamento);
								ca.sendRedirect(request, response, "Procedimento conclu�do com sucesso!", null, "lista_odontograma_atendimento.jsp");
							}catch(Exception e){
								e.printStackTrace();
							}							
						}else{  //nao existe mais procedimentos pendentes no odontograma
							finalizarAtendimentoOdontograma(odontograma);
							ca.sendRedirect(request, response, "Tratamento conclu�do!", null, "principal.jsp");
						}					
			*/				
					}else{
						ca.sendRedirect(request, response, null, "Este procedimento j� foi realizado ou cancelado pelo plano.", "lista_odontograma_atendimento.jsp");
					}	
				}else{
					ca.sendRedirect(request, response, null, "Este procedimento ainda n�o foi aprovado pelo conv�nio.", "lista_odontograma_atendimento.jsp");
				}
			}else{
				ca.sendRedirect(request, response, null, "Erro ao buscar o odontogramaProcedimento.", "lista_odontograma_atendimento.jsp");
			}	
		}else if(btn.equals("Finalizar tratamento")){
			Odontograma odontograma = new Odontograma();
			odontograma = (Odontograma)objetoSessao.getAttribute("odontograma");
			if (getTratamentoPendente(odontograma)){
				ca.sendRedirect(request, response, null, "Conclua todos os procedimentos antes de finalizar o tratamento.", "lista_odontograma_atendimento.jsp");
			}else{
				finalizarAtendimentoOdontograma(odontograma);
				ca.sendRedirect(request, response, "Tratamento conclu�do!", null, "ServletAtendimento?btn=Voltar");								
			}
			
		}
	}
	
	public boolean getTratamentoPendente(Odontograma odontograma){
		ProcurarObjeto po = new ProcurarObjeto();
		List<OdontogramaProcedimento> listaTratamento = new ArrayList<OdontogramaProcedimento>();
		listaTratamento = po.getOdontogramaProcedimentoPendentePorOdontograma(odontograma);
		if (!(listaTratamento == null)){
			return true;
		}else{
			return false;
		}
	}
		
	public void finalizarAtendimentoOdontograma(Odontograma odontograma){
		DaoOdontograma daoOdontograma = new DaoOdontograma();
		odontograma.setStatusOdontograma("FINALIZADO");
		odontograma.setDataFimOdontograma(new Date());								
		try{
			daoOdontograma.alterarOdontograma(odontograma);
			
		}catch(Exception e){
			e.printStackTrace();
		}							
	}


}
