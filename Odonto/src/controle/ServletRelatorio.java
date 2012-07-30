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

import modelo.Consulta;
import modelo.Convenio;
import modelo.Odontograma;
import modelo.Pagamento;
import modelo.Procedimento;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import persistencia.DaoConsulta;
import persistencia.DaoConvenio;
import persistencia.DaoOdontograma;
import persistencia.DaoPagamento;
import persistencia.DaoProcedimento;

public class ServletRelatorio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletRelatorio() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String btn = (String)request.getParameter("btn");
		HttpSession objetoSessao = request.getSession();
		ConfiguraAtributo ca= new ConfiguraAtributo(); 
		
		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("convenio");
			ca.sendRedirect(request, response, null, null, "principal.jsp");
		
		}else if (btn.equals("Gerar relatório de procedimentos")){						
				try{	
					Convenio convenio= new Convenio();
					convenio.setNomeConvenio((String)request.getParameter("convenio"));
					DaoConvenio daoConvenio= new DaoConvenio();
					convenio= daoConvenio.pesquisarConvenioPorNome(convenio);
					
					DaoProcedimento daoProcedimento= new DaoProcedimento();
					List<Procedimento> listaProcedimento=daoProcedimento.pesquisarProcedimentoPorConvenio(convenio);
					
					if(!listaProcedimento.isEmpty()){
						JRBeanCollectionDataSource jr = new JRBeanCollectionDataSource(listaProcedimento);					
						JasperFillManager.fillReportToFile("C:\\TCC\\trunk\\Odonto\\WebContent\\WEB-INF\\relatorio\\relatorioProcedimento.jasper", new HashMap(), jr);					
						JasperViewer.viewReport("C:\\TCC\\trunk\\Odonto\\WebContent\\WEB-INF\\relatorio\\relatorioProcedimento.jrprint", false, false);
						jr=null;
						ca.sendRedirect(request, response, null, null, "relatorioProcedimento.jsp");
					}else{
						ca.sendRedirect(request, response, null, "Nenhum procedimento encontrado", "relatorioProcedimento.jsp");
					}
					 
				}catch (Exception e) {
					e.printStackTrace();
					
				}
		}else if (btn.equals("Gerar relatório de Consultas")){						
			try{	
				DaoConsulta daoConsulta= new DaoConsulta();
				List<Consulta> listaConsulta= new ArrayList<Consulta>();
				listaConsulta= daoConsulta.pesquisarTodosConsultaStatusDataIniDataFim(
						ca.dataStringParaDataSql((String)request.getParameter("dataConsultaInicio")), 
						ca.dataStringParaDataSql((String)request.getParameter("dataConsultaFim")), 
						(String)request.getParameter("statusConsulta"));
				
				if(!listaConsulta.isEmpty()){			
					JRBeanCollectionDataSource jr = new JRBeanCollectionDataSource(listaConsulta); 
					JasperFillManager.fillReportToFile("C:\\TCC\\trunk\\Odonto\\WebContent\\WEB-INF\\relatorio\\relatorioConsulta.jasper", new HashMap(), jr);
					JasperViewer.viewReport("C:\\TCC\\trunk\\Odonto\\WebContent\\WEB-INF\\relatorio\\relatorioConsulta.jrprint", false, false);
					jr=null;
					ca.sendRedirect(request, response, null, null, "relatorioConsulta.jsp");
				}else{
					ca.sendRedirect(request, response, null, "Nenhuma consulta encontrada", "relatorioConsulta.jsp");
				}					                                    
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		}else if (btn.equals("Gerar relatório de Odontogramas")){						
			try{	
				DaoOdontograma daoOdontograma= new DaoOdontograma();
				List<Odontograma> listaOdontograma= new ArrayList<Odontograma>();
				listaOdontograma= daoOdontograma.pesquisarTodosOdontogramaFinalizadoDataIniDataFim(
						ca.dataStringParaDataSql((String)request.getParameter("dataInicio")), 
						ca.dataStringParaDataSql((String)request.getParameter("dataFim"))); 
						
				
				if(!listaOdontograma.isEmpty()){			
					JRBeanCollectionDataSource jr = new JRBeanCollectionDataSource(listaOdontograma); 
					JasperFillManager.fillReportToFile("C:\\TCC\\trunk\\Odonto\\WebContent\\WEB-INF\\relatorio\\relatorioOdontograma.jasper", new HashMap(), jr);
					JasperViewer.viewReport("C:\\TCC\\trunk\\Odonto\\WebContent\\WEB-INF\\relatorio\\relatorioOdontograma.jrprint", false, false);
					jr=null;
					ca.sendRedirect(request, response, null, null, "relatorioOdontograma.jsp");
				}else{
					ca.sendRedirect(request, response, null, "Nenhum odontograma encontrado", "relatorioOdontograma.jsp");
				}					                                    
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}else if (btn.equals("Gerar relatório de Pagamentos")){						
			try{	
				DaoPagamento daoPagamento= new DaoPagamento();
				List<Pagamento> listaPagamento= new ArrayList<Pagamento>();
				listaPagamento= daoPagamento.pesquisarTodosPagamentoStatusDataIniDataFim(
						ca.dataStringParaDataSql((String)request.getParameter("dataInicio")), 
						ca.dataStringParaDataSql((String)request.getParameter("dataFim")), 
						(String)request.getParameter("statusPagamento"));
				
				if(!listaPagamento.isEmpty()){			
					JRBeanCollectionDataSource jr = new JRBeanCollectionDataSource(listaPagamento); 
					JasperFillManager.fillReportToFile("C:\\TCC\\trunk\\Odonto\\WebContent\\WEB-INF\\relatorio\\relatorioPagamento.jasper", new HashMap(), jr);
					JasperViewer.viewReport("C:\\TCC\\trunk\\Odonto\\WebContent\\WEB-INF\\relatorio\\relatorioPagamento.jrprint", false, false);
					jr=null;
					ca.sendRedirect(request, response, null, null, "relatorioPagamento.jsp");
				}else{
					ca.sendRedirect(request, response, null, "Nenhum pagamento encontrado", "relatorioPagamento.jsp");
				}					                                    
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		}	
	
	
	}
	
}

