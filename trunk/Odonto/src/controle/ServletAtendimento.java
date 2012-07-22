package controle;

import java.io.IOException;
import java.util.ArrayList;
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
						ca.sendRedirect(request, response, null, "Este paciente não tem um odontograma em andamento.", "pesquisar_paciente_atendimento.jsp");
					}else{
						try{
							objetoSessao.setAttribute("odontograma", odontograma);
							//carregar a lista de procedimentos
							DaoOdontogramaProcedimento daoOdontogramaProcedimento = new DaoOdontogramaProcedimento();
							List<OdontogramaProcedimento> listaTratamento = new ArrayList<OdontogramaProcedimento>();
							listaTratamento = daoOdontogramaProcedimento.pesquisarOdontogramaProcedimentoPorOdontograma(odontograma);
							if (listaTratamento.isEmpty()){
								ca.sendRedirect(request, response, null, "Não existem procedimentos pendentes para este odontograma.", "pesquisar_paciente_atendimento.jsp");
							}else{
								objetoSessao.setAttribute("listaTratamento", listaTratamento);
								ca.sendRedirect(request, response, null, null, "lista_odontograma_atendimento.jsp");
							}
						}catch(Exception e){
							ca.sendRedirect(request, response, null, "Erro ao buscar os procedimentos deste odontograma." +e.getMessage(), "pesquisar_paciente_atendimento.jsp");
						}
					}
				}else{
					ca.sendRedirect(request, response, null, "Paciente não encontrado.", "pesquisar_paciente_atendimento.jsp");					
				}
			}else{
				ca.sendRedirect(request, response, null, "Preencha o nome do paciente", "pesquisar_paciente_atendimento.jsp");
			}	
		}else if(btn.equals("Realizado")){
			long idOdontogramaProcedimento = Long.parseLong((String)request.getParameter("index"));
			OdontogramaProcedimento odontogramaProcedimento = new OdontogramaProcedimento();
			odontogramaProcedimento = po.getOdontogramaProcedimentoPorId(idOdontogramaProcedimento);
			if (odontogramaProcedimento!=null){
				//se autorizacao = Aprovado
				if(odontogramaProcedimento.getStatusAutorizacao().equals("APROVADO")){
					if (odontogramaProcedimento.getStatusProcedimento().equals("PENDENTE")){
						odontogramaProcedimento.setStatusProcedimento("REALIZADO");
						try{
							DaoOdontogramaProcedimento daoOdontogramaProcedimento = new DaoOdontogramaProcedimento();
							daoOdontogramaProcedimento.alterarOdontogramaProcedimento(odontogramaProcedimento);
							//verificar se existir procedimentos a serem feitos no odontograma
							
							//carregar a lista de procedimentos
							List<OdontogramaProcedimento> listaTratamento = new ArrayList<OdontogramaProcedimento>();
							listaTratamento = daoOdontogramaProcedimento.pesquisarOdontogramaProcedimentoPorOdontograma((Odontograma)objetoSessao.getAttribute("odontograma"));
							int cont = 0;
							//verificando se existe procedimentos como pendente
							for (OdontogramaProcedimento op : listaTratamento) {
								if (op.getStatusProcedimento().equals("PENDENTE")){
									cont++;
								}
							}
							//se nao existir procedimentos pendentes no odontograma, statusOdontograma = finalizado
							if (cont == 0){
								Odontograma odontograma = new Odontograma();
								odontograma = ((Odontograma)objetoSessao.getAttribute("odontograma"));
								DaoOdontograma daoOdontograma = new DaoOdontograma();
								odontograma.setStatusOdontograma("FINALIZADO");
								daoOdontograma.alterarOdontograma(odontograma);
								ca.sendRedirect(request, response, "Tratamento concluído!", null, "principal.jsp");
							}else{							
								ca.sendRedirect(request, response, "Procedimento realizado com sucesso!", null, "lista_odontograma_atendimento.jsp");
							}
						}catch(Exception e){
							ca.sendRedirect(request, response, null, "Erro ao gravar odontogramaProcedimento", "lista_odontograma_atendimento.jsp");
						}						
					}else{
						ca.sendRedirect(request, response, null, "Este procedimento já foi realizado.", "lista_odontograma_atendimento.jsp");
					}
				}else{
					ca.sendRedirect(request, response, null, "Este procedimento ainda não foi aprovado pelo convênio.", "lista_odontograma_atendimento.jsp");
				}
			}else{
				ca.sendRedirect(request, response, null, "Erro ao buscar o odontogramaProcedimento.", "lista_odontograma_atendimento.jsp");
			}
		}
	}

}
