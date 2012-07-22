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
import modelo.Procedimento;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import persistencia.DaoConsulta;
import persistencia.DaoConvenio;
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
		
		}else if (btn.equals("Gerar por Convenio")){						
				try{	
					Convenio convenio= new Convenio();
					convenio.setNomeConvenio((String)request.getParameter("convenio"));
					DaoConvenio daoConvenio= new DaoConvenio();
					convenio= daoConvenio.pesquisarConvenioPorNome(convenio);
					
					DaoProcedimento daoProcedimento= new DaoProcedimento();
					List<Procedimento> listaProcedimento=daoProcedimento.pesquisarProcedimentoPorConvenio(convenio);
					
					if(!listaProcedimento.isEmpty()){
						JRBeanCollectionDataSource jr = new JRBeanCollectionDataSource(listaProcedimento);					
						JasperFillManager.fillReportToFile("C:\\TCC\\trunk\\Odonto\\WebContent\\WEB-INF\\relatorio\\procedimento.jasper", new HashMap(), jr);					
						JasperViewer.viewReport("C:\\TCC\\trunk\\Odonto\\WebContent\\WEB-INF\\relatorio\\procedimento.jrprint", false, false);
						jr=null;
						ca.sendRedirect(request, response, null, null, "relatorioCosultaStatusPorData.jsp");
					}else{
						ca.sendRedirect(request, response, null, "Nenhum convênio encontrado", "relatorioCosultaStatusPorData.jsp");
					}
					 
				}catch (Exception e) {
					e.printStackTrace();
					
				}
		}else if (btn.equals("Gerar Consultas por Status Data")){						
			try{	
				Consulta consulta = new Consulta();
				DaoConsulta daoConsulta= new DaoConsulta();
				List<Consulta> listaConsulta= new ArrayList<Consulta>();
				
				if(!listaConsulta.isEmpty()){
				
					listaConsulta= daoConsulta.pesquisarTodosConsultaStatusDataIniDataFim(ca.dataStringParaDataSql((String)request.getParameter("dataConsultaInicio")), ca.dataStringParaDataSql((String)request.getParameter("dataConsultaFim")), (String)request.getParameter("statusConsulta"));
					JRBeanCollectionDataSource jr = new JRBeanCollectionDataSource(listaConsulta); 
					JasperFillManager.fillReportToFile("C:\\TCC\\trunk\\Odonto\\WebContent\\WEB-INF\\relatorio\\consultaStatusPorData.jasper", new HashMap(), jr);
					JasperViewer.viewReport("C:\\TCC\\trunk\\Odonto\\WebContent\\WEB-INF\\relatorio\\consultaStatusPorData.jrprint", false, false);
				}else{
					ca.sendRedirect(request, response, null, "Nenhuma consulta encontrada", "relatorioCosultaStatusPorData.jsp");
				}					                                    
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}	
	
	
	}

}
