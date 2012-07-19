package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Convenio;
import modelo.Dentista;
import modelo.Elemento;
import modelo.Face;
import modelo.Odontograma;
import modelo.OdontogramaProcedimento;
import modelo.Paciente;
import modelo.Procedimento;
import persistencia.DaoDentista;
import persistencia.DaoElemento;
import persistencia.DaoFace;
import persistencia.DaoOdontograma;
import persistencia.DaoOdontogramaProcedimento;
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
		
		if (btn.equals("Cancelar odontograma")){
			//excluir o odontograma caso tenha sido criado
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
		}else if (btn.equals("procedimento")){
			try{
				String dente = request.getParameter("dente");
				System.out.println(dente);
				objetoSessao.setAttribute("elemento", dente);
				//getPaciente
				DaoPaciente daoPaciente = new DaoPaciente();
				Paciente paciente = new Paciente();
				paciente.setNomeUsuario((String)objetoSessao.getAttribute("pacienteNovoOdontograma"));
				paciente = daoPaciente.pesquisarPacientePorNome(paciente);
				System.out.println("Paciente: "+paciente);
				
				//getDentista
				DaoDentista daoDentista = new DaoDentista();
				Dentista dentista = new Dentista();
				dentista = (Dentista)objetoSessao.getAttribute("usuarioLogado");
				dentista = daoDentista.pesquisarDentistaPorNome(dentista);
				System.out.println("Dentista: "+dentista);
				
				//getOdontograma
				DaoOdontograma daoOdontograma = new DaoOdontograma();
				odontograma = new Odontograma();
				if (daoOdontograma.pesquisarOdontogramaPorPaciente(paciente) != null){
					//se paciente ja tiver odontograma
					odontograma = daoOdontograma.pesquisarOdontogramaPorPaciente(paciente);
					System.out.println("Odontograma ja existia...");
				}else{
					System.out.println("Odontograma não existia...");
					//se paciente nao tiver odontograma
					odontograma.setDentista(dentista);
					odontograma.setPaciente(paciente);
					odontograma.setValorOdontograma(0.);
					odontograma.setDataInicioOdontograma(new Date());
					odontograma.setDataFimOdontograma(null);
					odontograma.setStatusOdontograma("INICIADO");
					
					objetoSessao.setAttribute("odontograma", odontograma);
					//gravar odontograma
					daoOdontograma.cadastrarOdontograma(odontograma);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}		
			//gravando odontograma na sessao
			objetoSessao.setAttribute("odontograma", odontograma);
			
			//getProcedimento do convênio do paciente
			List<Procedimento> listaProcedimento = getProcedimentos((Convenio)objetoSessao.getAttribute("convenioPaciente"));
			objetoSessao.setAttribute("listaProcedimento", listaProcedimento);
			
			//getFaces
			List<Face> listaFace = getFaces();
			objetoSessao.setAttribute("listaFace", listaFace);

			RequestDispatcher disp = request.getRequestDispatcher("selecionar_procedimento.jsp");
			disp.forward(request, response);
			
		}else if(btn.equals("Gravar procedimento")){
			System.out.println("Gravando OdontogramaProcedimento");
			try{
				DaoOdontogramaProcedimento daoOdontogramaProcedimento = new DaoOdontogramaProcedimento();
				OdontogramaProcedimento odontogramaProcedimento = new OdontogramaProcedimento();
				odontogramaProcedimento.setStatusAutorizacao("PENDENTE");
				odontogramaProcedimento.setStatusProcedimento("PENDENTE");
				odontogramaProcedimento.setDataExecucaoProcedimento(null);
				
				//getElemento
				Elemento elemento = new Elemento();
				DaoElemento daoElemento = new DaoElemento();
				elemento.setNomeElemento((String)objetoSessao.getAttribute("elemento"));
				elemento = daoElemento.pesquisarElementoPorNome(elemento);
				odontogramaProcedimento.setElemento(elemento);
				
				//getFace
				Face face = new Face();
				DaoFace daoFace = new DaoFace();
				face.setNomeFace((String)request.getParameter("face"));
				face = daoFace.pesquisarFacePorNome(face);
				odontogramaProcedimento.setFace(face);
				
				//getOdontograma
				odontograma = new Odontograma();
				odontograma = (Odontograma)objetoSessao.getAttribute("odontograma");
				odontogramaProcedimento.setOdontograma(odontograma);
				
				//getProcedimento
				Procedimento procedimento = new Procedimento();
				DaoProcedimento daoProcedimento = new DaoProcedimento();
				procedimento.setDescricaoProcedimento((String)request.getParameter("procedimento"));
				procedimento = daoProcedimento.pesquisarProcedimentoPorDescricao(procedimento);
				odontogramaProcedimento.setProcedimento(procedimento);
				System.out.println("Procedimento: "+procedimento);
				
				//gravando odontogramaProcedimento
				daoOdontogramaProcedimento.cadastrarOdontogramaProcedimento(odontogramaProcedimento);
				
				RequestDispatcher disp = request.getRequestDispatcher("ServletOdontograma?btn=Visualizar tratamento");
				disp.forward(request, response);
				
			}catch (Exception e) {
				mensagem = "Erro ao gravar odontogramaProcedimento";
				System.out.println(mensagem);
				e.printStackTrace();
			}
			
		}else if(btn.equals("Visualizar tratamento")){
			try{
				DaoOdontogramaProcedimento daoOdontogramaProcedimento = new DaoOdontogramaProcedimento();
				odontograma = (Odontograma)objetoSessao.getAttribute("odontograma");
				List<OdontogramaProcedimento> listaTratamento = new ArrayList<OdontogramaProcedimento>();
				listaTratamento = daoOdontogramaProcedimento.pesquisarOdontogramaProcedimentoPorOdontograma(odontograma);
				objetoSessao.setAttribute("listaTratamento", listaTratamento);
				RequestDispatcher disp = request.getRequestDispatcher("lista_odontograma.jsp");
				disp.forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
				mensagem = "Erro ao buscar os procedimentos deste odontograma";
				RequestDispatcher disp = request.getRequestDispatcher("novo_odontograma.jsp");
				disp.forward(request, response);
			}
		}else if(btn.equals("Voltar")){
			RequestDispatcher disp = request.getRequestDispatcher("novo_odontograma.jsp");
			disp.forward(request, response);
		}else if(btn.equals("Excluir")){
			try{
				OdontogramaProcedimento odontogramaProcedimento = new OdontogramaProcedimento();
				DaoOdontogramaProcedimento daoOdontogramaProcedimento = new DaoOdontogramaProcedimento();
				long idOdontogramaProcedimento = Long.parseLong((String)request.getParameter("index"));
				System.out.println(idOdontogramaProcedimento);
				odontogramaProcedimento = daoOdontogramaProcedimento.pesquisarOdontogramaProcedimentoPorId(idOdontogramaProcedimento);
				if (odontogramaProcedimento != null){
					daoOdontogramaProcedimento.excluirOdontogramaProcedimento(odontogramaProcedimento);
					RequestDispatcher disp = request.getRequestDispatcher("ServletOdontograma?btn=Visualizar tratamento");
					disp.forward(request, response);
				}
			}catch (Exception e) {
				e.printStackTrace();
				mensagem = "Erro ao remover procedimento.";
			}
		}else if(btn.equals("Gravar odontograma")){
			try{
				//calcular o valor do odontograma
				double valorOdontograma = 0.;
				DaoOdontogramaProcedimento daoOdontogramaProcedimento = new DaoOdontogramaProcedimento();
				odontograma = (Odontograma)objetoSessao.getAttribute("odontograma");
				List<OdontogramaProcedimento> listaTratamento = new ArrayList<OdontogramaProcedimento>();
				listaTratamento = daoOdontogramaProcedimento.pesquisarOdontogramaProcedimentoPorOdontograma(odontograma);
				DaoProcedimento daoProcedimento = new DaoProcedimento();
				Procedimento procedimento = new Procedimento();
				for(OdontogramaProcedimento o : listaTratamento){
					procedimento = daoProcedimento.pesquisarProcedimentoPorId(o.getProcedimento());
					valorOdontograma = valorOdontograma+procedimento.getValorProcedimento(); 
				}				
				DaoOdontograma daoOdontograma = new DaoOdontograma();
				odontograma.setStatusOdontograma("EM ANDAMENTO");
				odontograma.setValorOdontograma(valorOdontograma);
				daoOdontograma.alterarOdontograma(odontograma);
				RequestDispatcher disp = request.getRequestDispatcher("pesquisar_paciente_atendimento.jsp");
				disp.forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
				mensagem = "Erro ao gravar o odontograma.";
			}
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
