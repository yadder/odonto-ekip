package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Dentista;
import modelo.Paciente;
import modelo.Prescricao;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import persistencia.DaoPrescricao;

public class ServletPrescricao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletPrescricao() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String btn = (String)request.getParameter("btn");
		HttpSession objetoSessao = request.getSession();
		ConfiguraAtributo ca = new ConfiguraAtributo();
		ProcurarObjeto po = new ProcurarObjeto();
		
		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("paciente");
			ca.sendRedirect(request, response, null, null, "principal.jsp");
		}else if(btn.equals("Pesquisar paciente")){
			Paciente paciente = new Paciente();
			paciente = po.getPaciente((String)request.getParameter("nomePaciente"));
			if (paciente!=null){
				objetoSessao.setAttribute("paciente", paciente);
				ca.sendRedirect(request, response, "Paciente encontrado(a).", null, "prescricao.jsp");
			}else{
				ca.sendRedirect(request, response, null, "Paciente não encontrado(a).", "pesquisar_paciente_prescricao.jsp");
			}
		}else if(btn.equals("Cadastrar")){
			if ((String)request.getParameter("observacao")!=null && !((String)request.getParameter("observacao")).equals("")){
				DaoPrescricao daoPrescricao = new DaoPrescricao();
				Prescricao prescricao = new Prescricao();
				prescricao.setObservacao((String)request.getParameter("observacao"));
				prescricao.setDentista((Dentista)objetoSessao.getAttribute("usuarioLogado"));
				prescricao.setPaciente((Paciente)objetoSessao.getAttribute("paciente"));
				prescricao.setTipoPrescricao((String)request.getParameter("tipoPrescricao"));
				try{
					daoPrescricao.cadastrarPrescricao(prescricao);
					ca.sendRedirect(request, response, null, null, "ServletPrescricao?btn=Imprimir");
					
				}catch (Exception e) {
					ca.sendRedirect(request, response, null, "Erro ao gravar a prescrição. "+e.getMessage(), "prescricao.jsp");
				}
			}else{
				ca.sendRedirect(request, response, null, "Preencha o campo prescrição.", "prescricao.jsp");
			}
			
		}else if (btn.equals("Imprimir")){						
			try{	
				Prescricao prescricao = new Prescricao();
				List<Prescricao>listaPrescricao=new ArrayList<Prescricao>();				
				DaoPrescricao daoPrescricao= new DaoPrescricao();
				prescricao=daoPrescricao.pesquisarPrescricaoPorId();				
				listaPrescricao.add(prescricao);				
				
				if(!listaPrescricao.isEmpty()){			
					JRBeanCollectionDataSource jr = new JRBeanCollectionDataSource(listaPrescricao); 
					JasperFillManager.fillReportToFile("C:\\TCC\\trunk\\Odonto\\WebContent\\WEB-INF\\relatorio\\relatorioPrescricao.jasper", new HashMap(), jr);
					JasperViewer.viewReport("C:\\TCC\\trunk\\Odonto\\WebContent\\WEB-INF\\relatorio\\relatorioPrescricao.jrprint", false, false);
					jr=null;					
					ca.sendRedirect(request, response, "Prescrição cadastrada com sucesso!", null, "principal.jsp");
				}else{
					ca.sendRedirect(request, response, "Prescrição cadastrada", null, "principal.jsp");
				}					
			}catch (Exception e) {
				ca.sendRedirect(request, response, null, "Erro ao gerar o relatório. "+e.getMessage(), "prescricao.jsp");
			}
			
			
			
			
			
		}
		
	}

}
