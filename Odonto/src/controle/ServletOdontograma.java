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

import modelo.Convenio;
import modelo.Dentista;
import modelo.Face;
import modelo.Odontograma;
import modelo.OdontogramaProcedimento;
import modelo.Paciente;
import modelo.Procedimento;
import persistencia.DaoOdontograma;
import persistencia.DaoOdontogramaProcedimento;

public class ServletOdontograma extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String mensagem = null;
	private ConfiguraAtributo ca = new ConfiguraAtributo();
	private ProcurarObjeto po = new ProcurarObjeto();
	
    public ServletOdontograma() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache");  
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
		response.setHeader("Pragma", "no-cache");
		
		String btn = (String)request.getParameter("btn");
		HttpSession objetoSessao = request.getSession();	
		Odontograma odontograma = new Odontograma();
		
		if(btn.equals("Voltar")){
			objetoSessao.removeAttribute("listaPendente");
			ca.sendRedirect(request, response, null, null, "principal.jsp");
		}else if(btn.equals("Voltar ao odontograma")){
			ca.sendRedirect(request, response, null, null, "novo_odontograma.jsp");
		}else if(btn.equals("Pesquisar Paciente")){
			if (validaNome(((String)request.getParameter("nomePaciente")))){
				Paciente paciente = new Paciente();
				paciente = po.getPaciente((String)request.getParameter("nomePaciente"));
				if (paciente != null){
					//pesquisar se paciente ja tem odontograma em andamento
					if (po.getOdontogramaEmAndamento(paciente) != null){
						ca.sendRedirect(request, response, null, "Este paciente j� tem um odontograma em andamento.", "pesquisar_paciente.jsp");
					}else{
						//pesquisa dentista
						Dentista dentista = new Dentista();
						dentista = (Dentista)objetoSessao.getAttribute("usuarioLogado");
						try{
							//criar novo odontograma
							DaoOdontograma daoOdontograma = new DaoOdontograma();
							odontograma = new Odontograma(new Date(), null, "INICIADO", 0., dentista, paciente);
							daoOdontograma.cadastrarOdontograma(odontograma);
							// grava objetos na sessao
							objetoSessao.setAttribute("odontograma", odontograma);
							objetoSessao.setAttribute("dentista", dentista);
							objetoSessao.setAttribute("pacienteNovoOdontograma", paciente.getNomeUsuario());
							objetoSessao.setAttribute("convenioPaciente", paciente.getConvenio());
							ca.sendRedirect(request, response, null, null, "novo_odontograma.jsp");
						}catch(Exception e){
							ca.sendRedirect(request, response, null, "Erro ao criar odontograma", "pesquisar_paciente.jsp");
						}
					}
				}else{
					ca.sendRedirect(request, response, null, "Paciente n�o encontrado.", "pesquisar_paciente.jsp");					
				}
			}else{
				ca.sendRedirect(request, response, null, mensagem, "pesquisar_paciente.jsp");
			}		
		}else if (btn.equals("Cancelar odontograma")){
			try{
				DaoOdontogramaProcedimento daoOdontogramaProcedimento = new DaoOdontogramaProcedimento();
				List<OdontogramaProcedimento> listaTratamento = new ArrayList<OdontogramaProcedimento>();
				odontograma = (Odontograma)objetoSessao.getAttribute("odontograma");
				if (odontograma!=null){
					listaTratamento = daoOdontogramaProcedimento.pesquisarOdontogramaProcedimentoPorOdontograma(odontograma);
					if (listaTratamento.isEmpty()){
						//se odontograma nao tiver procedimentos associados
						DaoOdontograma daoOdontograma = new DaoOdontograma();
						daoOdontograma.excluirOdontograma(odontograma);
						objetoSessao.removeAttribute("odontograma");
						objetoSessao.removeAttribute("dentista");
						objetoSessao.removeAttribute("pacienteNovoOdontograma");
						objetoSessao.removeAttribute("convenioPaciente");
						ca.sendRedirect(request, response, "Odontograma exclu�do com sucesso!", null, "principal.jsp");
					}else{
						ca.sendRedirect(request, response, null, "Exclua os procedimentos antes de excluir o odontograma.", "lista_odontograma.jsp");
					}
				}				
			}catch (Exception e) {
				ca.sendRedirect(request, response, null, "Erro ao buscar procedimentos do odontograma" +e.getMessage(), "pesquisar_paciente.jsp");
			}	
		}else if (btn.equals("procedimento")){
			String dente = request.getParameter("dente");
			objetoSessao.setAttribute("elemento", dente);
			//getProcedimento do conv�nio do paciente
			List<Procedimento> listaProcedimento = po.getListaProcedimentosPorConvenio((Convenio)objetoSessao.getAttribute("convenioPaciente"));
			objetoSessao.setAttribute("listaProcedimento", listaProcedimento);
			//getFaces
			List<Face> listaFace = po.getListaFaces();
			objetoSessao.setAttribute("listaFace", listaFace);
			ca.sendRedirect(request, response, null, null, "selecionar_procedimento.jsp");
		}else if(btn.equals("Cancelar")){
			objetoSessao.removeAttribute("listaTratamento");
			ca.sendRedirect(request, response, null, null, "novo_odontograma.jsp");
		}				
		else if(btn.equals("Gravar procedimento")){
			try{
				DaoOdontogramaProcedimento daoOdontogramaProcedimento = new DaoOdontogramaProcedimento();
				OdontogramaProcedimento odontogramaProcedimento = new OdontogramaProcedimento();
				odontogramaProcedimento.setStatusProcedimento("PENDENTE");
				odontogramaProcedimento.setDataExecucaoProcedimento(null);
				odontogramaProcedimento.setElemento(po.getElemento((String)objetoSessao.getAttribute("elemento")));
				odontogramaProcedimento.setFace(po.getFace((String)request.getParameter("face")));
				if ((po.getProcedimentoPorNomeEConvenio(((String)request.getParameter("procedimento")), (Convenio)objetoSessao.getAttribute("convenioPaciente")))!=null){
					odontogramaProcedimento.setProcedimento(po.getProcedimentoPorNomeEConvenio(((String)request.getParameter("procedimento")), (Convenio)objetoSessao.getAttribute("convenioPaciente")));
					//Se convenio particular entao status autorizacao = aprovado
					if (odontogramaProcedimento.getProcedimento().getConvenio().getNomeConvenio().equals("PARTICULAR")){
						odontogramaProcedimento.setStatusAutorizacao("APROVADO");
					}//senao status autorizacao = pendente
					else{
						odontogramaProcedimento.setStatusAutorizacao("PENDENTE");
					}
				}else{
					ca.sendRedirect(request, response, null, "Este conv�nio n�o tem procedimentos cadastrados.", "novo_odontograma.jsp");
				}
				//getOdontograma
				odontograma = new Odontograma();
				odontograma = (Odontograma)objetoSessao.getAttribute("odontograma");
				odontogramaProcedimento.setOdontograma(odontograma);
				//gravando odontogramaProcedimento
				daoOdontogramaProcedimento.cadastrarOdontogramaProcedimento(odontogramaProcedimento);
				ca.sendRedirect(request, response, "Procedimento cadastrado com sucesso!", null, "ServletOdontograma?btn=Visualizar tratamento");
			}catch (Exception e) {
				ca.sendRedirect(request, response, null, "Erro ao gravar odontogramaProcedimento. "+e.getMessage(), "novo_odontograma.jsp");
			}
			
		}else if(btn.equals("Visualizar tratamento")){
			try{
				DaoOdontogramaProcedimento daoOdontogramaProcedimento = new DaoOdontogramaProcedimento();
				List<OdontogramaProcedimento> listaTratamento = new ArrayList<OdontogramaProcedimento>();
				odontograma = (Odontograma)objetoSessao.getAttribute("odontograma");
				if (odontograma!=null){
					listaTratamento = daoOdontogramaProcedimento.pesquisarOdontogramaProcedimentoPorOdontograma(odontograma);
					objetoSessao.setAttribute("listaTratamento", listaTratamento);
					ca.sendRedirect(request, response, null, null, "lista_odontograma.jsp");
				}else{
					ca.sendRedirect(request, response, null, "Odontograma n�o encontrado.", "principal.jsp");
				}
			}catch(Exception e){
				ca.sendRedirect(request, response, null, "Erro ao buscar os procedimentos deste odontograma." +e.getMessage(), "novo_odontograma.jsp");
			}
		}else if(btn.equals("Excluir")){
			long idOdontogramaProcedimento = Long.parseLong((String)request.getParameter("index"));
			OdontogramaProcedimento odontogramaProcedimento = new OdontogramaProcedimento();
			odontogramaProcedimento = po.getOdontogramaProcedimentoPorId(idOdontogramaProcedimento);
			if (odontogramaProcedimento!=null){
				DaoOdontogramaProcedimento daoOdontogramaProcedimento = new DaoOdontogramaProcedimento();
				try{
					daoOdontogramaProcedimento.excluirOdontogramaProcedimento(odontogramaProcedimento);
					ca.sendRedirect(request, response, null, null, "ServletOdontograma?btn=Visualizar tratamento");
				}catch (Exception e) {
					ca.sendRedirect(request, response, null, "Erro ao excluir o procedimento. "+e.getMessage(), "lista_odontograma.jsp"); 
				}
			}else{
				ca.sendRedirect(request, response, null, "Procedimento n�o encontrado. ", "lista_odontograma.jsp");
			}
		}else if(btn.equals("Gravar odontograma")){
			DaoOdontogramaProcedimento daoOdontogramaProcedimento = new DaoOdontogramaProcedimento();
			DaoOdontograma daoOdontograma = new DaoOdontograma();
			List<OdontogramaProcedimento> listaTratamento = new ArrayList<OdontogramaProcedimento>();
			odontograma = (Odontograma)objetoSessao.getAttribute("odontograma");
			if (odontograma!=null){
				try{
					odontograma.setStatusOdontograma("EM ANDAMENTO");
					listaTratamento = daoOdontogramaProcedimento.pesquisarOdontogramaProcedimentoPorOdontograma(odontograma);
					// calcular o valor do odontograma
					if (!listaTratamento.isEmpty()){
						double valor = 0.;
						for (OdontogramaProcedimento op : listaTratamento) {
							valor = valor + op.getProcedimento().getValorProcedimento();
						}
						odontograma.setValorOdontograma(valor);
						// gravar odontograma			
						daoOdontograma.alterarOdontograma(odontograma);
					}else{
						ca.sendRedirect(request, response, null, "A lista de procedimentos esta vazia. ", "novo_odontograma.jsp");
					}
				}catch (Exception e) {
					ca.sendRedirect(request, response, null, "Erro ao calcular e gravar o valor do odontograma. "+e.getMessage(), "novo_odontograma.jsp");
				}
				objetoSessao.removeAttribute("listaFace");
				objetoSessao.removeAttribute("pacienteNovoOdontograma");
				objetoSessao.removeAttribute("listaProcedimento");
				objetoSessao.removeAttribute("convenioPaciente");
				objetoSessao.removeAttribute("odontograma");
				objetoSessao.removeAttribute("elemento");
				objetoSessao.removeAttribute("dentista");
				ca.sendRedirect(request, response, "Odontograma gravado com sucesso!", null, "principal.jsp");
			}
		}else if (btn.equals("listarProcedimentosPendentes")){
			objetoSessao.removeAttribute("listaPendente");
			List<OdontogramaProcedimento> listaPendente = new ArrayList<OdontogramaProcedimento>();
			listaPendente = po.getOdontogramaProcedimentoPendente();
			if (listaPendente != null){
				objetoSessao.setAttribute("listaPendente", listaPendente);
				ca.sendRedirect(request, response, null, null, "listar_procedimentos_pendentes.jsp");
			}else{
				ca.sendRedirect(request, response, null, "Nenhum procedimento pendente foi encontrado.", "principal.jsp");
			}
		}else if (btn.equals("Autorizado")){
			long id = Long.parseLong((String)request.getParameter("index"));
			OdontogramaProcedimento odontogramaProcedimento = new OdontogramaProcedimento();
			odontogramaProcedimento = po.getOdontogramaProcedimentoPorId(id);
			if (odontogramaProcedimento != null){
				odontogramaProcedimento.setStatusAutorizacao("APROVADO");
				try{
					DaoOdontogramaProcedimento daoOdontogramaProcedimento = new DaoOdontogramaProcedimento();
					daoOdontogramaProcedimento.alterarOdontogramaProcedimento(odontogramaProcedimento);
					ca.sendRedirect(request, response, "Procedimento aprovado.", null, "ServletOdontograma?btn=listarProcedimentosPendentes");
				}catch(Exception e){
					ca.sendRedirect(request, response, null, "Erro ao aprovar procedimento.", "listar_procedimentos_pendentes.jsp");
					e.printStackTrace();
				}
			}
		}else if (btn.equals("Negado")){
			long id = Long.parseLong((String)request.getParameter("index"));
			OdontogramaProcedimento odontogramaProcedimento = new OdontogramaProcedimento();
			odontogramaProcedimento = po.getOdontogramaProcedimentoPorId(id);
			if (odontogramaProcedimento != null){
				odontogramaProcedimento.setStatusAutorizacao("NEGADO");
				try{
					DaoOdontogramaProcedimento daoOdontogramaProcedimento = new DaoOdontogramaProcedimento();
					daoOdontogramaProcedimento.alterarOdontogramaProcedimento(odontogramaProcedimento);
					ca.sendRedirect(request, response, "Procedimento negado.", null, "ServletOdontograma?btn=listarProcedimentosPendentes");
				}catch(Exception e){
					ca.sendRedirect(request, response, null, "Erro ao negar procedimento.", "listar_procedimentos_pendentes.jsp");
					e.printStackTrace();
				}
			}
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
