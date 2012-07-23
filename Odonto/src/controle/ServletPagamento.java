package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Odontograma;
import modelo.Paciente;

public class ServletPagamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletPagamento() {
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
			ca.sendRedirect(request, response, null, null, "principal.jsp");
		}else if(btn.equals("Pesquisar paciente para pagamento")){
			if (((String)request.getParameter("nomePaciente"))!=null){
				Paciente paciente = new Paciente();
				paciente = po.getPaciente((String)request.getParameter("nomePaciente"));
				if (paciente != null){
					//pesquisar se paciente ja tem odontograma em andamento
					Odontograma odontograma = new Odontograma();
					odontograma = po.getOdontogramaEmAndamento(paciente);
					if (odontograma == null){
						ca.sendRedirect(request, response, null, "O paciente informado não possui odontograma em andamento.", "pesquisar_paciente_gerar_pagamento.jsp");
					}else{
						//odontograma é de convenio particular
						if (odontograma.getPaciente().getConvenio().getNomeConvenio().equals("PARTICULAR")){						
							if()
							
							objetoSessao.setAttribute("odontograma", odontograma);
							objetoSessao.setAttribute("paciente", paciente);
							ca.sendRedirect(request, response, "Paciente encontrado!", null, "gerar_pagamento.jsp");
						}else{
							ca.sendRedirect(request, response, null, "O odontograma deste paciente não é particular, logo o pagamento é feito pela operadora do convênio.", "pesquisar_paciente_gerar_pagamento.jsp");
						}
					}					
				}else{
					ca.sendRedirect(request, response, null, "Paciente não encontrado.", "pesquisar_paciente_gerar_pagamento.jsp");
				}
			}else{
				ca.sendRedirect(request, response, null, "Preencha o nome do paciente.", "pesquisar_paciente_gerar_pagamento.jsp");
			}
		}else if(btn.equals("Gerar pagamento")){
			
		}
	
	}

}
