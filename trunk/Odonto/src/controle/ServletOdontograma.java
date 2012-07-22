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
	
		String btn = (String)request.getParameter("btn");
		HttpSession objetoSessao = request.getSession();	
		Odontograma odontograma = new Odontograma();
		
		if(btn.equals("Pesquisar Paciente")){
			if (validaNome(((String)request.getParameter("nomePaciente")))){
				Paciente paciente = new Paciente();
				paciente = po.getPaciente((String)request.getParameter("nomePaciente"));
				if (paciente != null){
					//pesquisar se paciente ja tem odontograma em andamento
					if (po.getOdontogramaEmAndamento(paciente) != null){
						ca.sendRedirect(request, response, null, "Este paciente já tem um odontograma em andamento.", "pesquisar_paciente.jsp");
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
					ca.sendRedirect(request, response, null, "Paciente não encontrado.", "pesquisar_paciente.jsp");					
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
						ca.sendRedirect(request, response, "Odontograma excluído com sucesso!", null, "principal.jsp");
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
			//getProcedimento do convênio do paciente
			List<Procedimento> listaProcedimento = po.getListaProcedimentosPorConvenio((Convenio)objetoSessao.getAttribute("convenioPaciente"));
			objetoSessao.setAttribute("listaProcedimento", listaProcedimento);
			//getFaces
			List<Face> listaFace = po.getListaFaces();
			objetoSessao.setAttribute("listaFace", listaFace);
			ca.sendRedirect(request, response, null, null, "selecionar_procedimento.jsp");
		}else if(btn.equals("Voltar")){
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
					ca.sendRedirect(request, response, null, "Este convênio não tem procedimentos cadastrados.", "novo_odontograma.jsp");
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
					ca.sendRedirect(request, response, null, "Odontograma não encontrado.", "principal.jsp");
				}
			}catch(Exception e){
				ca.sendRedirect(request, response, null, "Erro ao buscar os procedimentos deste odontograma." +e.getMessage(), "novo_odontograma.jsp");
			}
		}
		
		else if(btn.equals("Gravar odontograma")){
			odontograma = (Odontograma)objetoSessao.getAttribute("odontograma");
			DaoOdontograma daoOdontograma = new DaoOdontograma();
			
			// mudar o status para "em andamento"
			odontograma.setStatusOdontograma("EM ANDAMENTO");
			
			// calcular o valor do odontograma
			DaoOdontogramaProcedimento daoOdontogramaProcedimento = new DaoOdontogramaProcedimento();
			List<OdontogramaProcedimento> listaTratamento = new ArrayList<OdontogramaProcedimento>();
			try{
				listaTratamento = daoOdontogramaProcedimento.pesquisarOdontogramaProcedimentoPorOdontograma(odontograma);
				double valor = 0.;
				for (OdontogramaProcedimento o : listaTratamento) {
					valor = valor + o.getProcedimento().getValorProcedimento();
				}
				odontograma.setValorOdontograma(valor);
			}catch (Exception e) {
				ca.sendRedirect(request, response, null, "Erro ao calcular valor do odontograma. "+e.getMessage(), "novo_odontograma.jsp");
			}			
						
			// gravar odontograma
			try{
				daoOdontograma.alterarOdontograma(odontograma);
				objetoSessao.removeAttribute("listaFace");
				objetoSessao.removeAttribute("pacienteNovoOdontograma");
				objetoSessao.removeAttribute("listaProcedimento");
				objetoSessao.removeAttribute("convenioPaciente");
				objetoSessao.removeAttribute("odontograma");
				objetoSessao.removeAttribute("elemento");
				objetoSessao.removeAttribute("dentista");
				ca.sendRedirect(request, response, "Odontograma gravado com sucesso!", null, "principal.jsp");
			}catch (Exception e) {
				ca.sendRedirect(request, response, null, "Erro ao gravar odontograma. "+e.getMessage(), "novo_odontograma.jsp");
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
