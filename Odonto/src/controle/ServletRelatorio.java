package controle;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Convenio;
import modelo.Procedimento;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
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
		Convenio convenio= new Convenio();
		
		if (btn.equals("Voltar")){
			objetoSessao.removeAttribute("convenio");
			RequestDispatcher disp = request.getRequestDispatcher("principal.jsp");
			disp.forward(request, response);
		
		}else if (btn.equals("Gerar por Convenio")){						
				try{					
					convenio.setNomeConvenio((String)request.getParameter("convenio"));
					DaoConvenio daoConvenio= new DaoConvenio();
					convenio= daoConvenio.pesquisarConvenioPorNome(convenio);
					
					DaoProcedimento daoProcedimento= new DaoProcedimento();
					List<Procedimento> listaProcedimento=daoProcedimento.pesquisarProcedimentoPorConvenio(convenio);
					
					System.out.println(listaProcedimento);
					// passo 1 -> preparar a lista para ser enviada para o relatorio
					JRBeanCollectionDataSource jr = new JRBeanCollectionDataSource(listaProcedimento);
					
					// passo 2 -> preencher o arquivo relatorio.jasper com as informacoes preparadas da lista
					JasperFillManager.fillReportToFile("C:\\TCC\\trunk\\Odonto\\WebContent\\WEB-INF\\relatorio\\procedimento.jasper", new HashMap(), jr);
					// o arquivo Relatorio.jasper preenchido é o relatório.jrprint				
					
					// passo 3 -> mostrar o arquivo relatorio.jrprint
					JasperViewer.viewReport("C:\\TCC\\trunk\\Odonto\\WebContent\\WEB-INF\\relatorio\\procedimento.jrprint", false, false);
					                                     //1ºfalse -> Se o arquivo está em XML
														 //2ºfalse -> Se o sistema deve ser fechado quando o relatorio for fechado
					
				}catch (Exception e) {
					e.printStackTrace();
				}
		}	
	
	
	}

}
