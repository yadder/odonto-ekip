package controle;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Odontograma;
import modelo.Paciente;
import modelo.Pagamento;
import persistencia.DaoPagamento;

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
							//verificar se ja existe pagamento para este odontograma
							List<Pagamento> listaPagamento = new ArrayList<Pagamento>();
							listaPagamento = po.getPagamentoPorOdontograma(odontograma);
							if(listaPagamento == null){
								objetoSessao.setAttribute("odontograma", odontograma);
								objetoSessao.setAttribute("paciente", paciente);
								ca.sendRedirect(request, response, "Paciente encontrado!", null, "gerar_pagamento.jsp");
							}else{
								ca.sendRedirect(request, response, null, "Já existe pagamento gerado para este odontograma.", "pesquisar_paciente_gerar_pagamento.jsp");
							}
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
			String valParcela = (String)request.getParameter("valorParcela");
			if (!valParcela.equals("") && valParcela != null){
				double valor = Double.parseDouble((String)request.getParameter("valorOdontograma"));
				if (((String)request.getParameter("formaPagamento")).equals("DINHEIRO") && valor<500){
					int par = Integer.parseInt((String)request.getParameter("parcelas"));
					if(((String)request.getParameter("formaPagamento")).equals("DINHEIRO") && par<=5){
						DaoPagamento daoPagamento = new DaoPagamento();
						double valorParcela = Double.parseDouble((String)request.getParameter("valorParcela"));
						// dia de hoje)  
						Date minhaData = new Date();  
						Calendar calendar = Calendar.getInstance();  
						calendar.setTime(minhaData);
						SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
						for (int i = 0; i < par; i++) {
							calendar.add(Calendar.DAY_OF_MONTH,30);// incrementa na data a qtd de dias							
							Pagamento pagamento = new Pagamento();
							pagamento.setNumeroParcela(i+1);							
							pagamento.setValorParcela(valorParcela);
							pagamento.setStatusPagamento("PENDENTE");
							pagamento.setOdontograma((Odontograma)objetoSessao.getAttribute("odontograma"));
							pagamento.setDataVencimento(ca.dataStringParaDataSql(dataFormatada.format(calendar.getTime())));
							pagamento.setDataPagamento(null);							
							try{
								daoPagamento.cadastrarPagamento(pagamento);
							}catch (Exception e) {
								ca.sendRedirect(request, response, null, "Erro ao gravar pagamento.", "gerar_pagamento.jsp");
							}
						}
						ca.sendRedirect(request, response, "Pagamento cadastrado com sucesso!", null, "principal.jsp");						
					}else{
						ca.sendRedirect(request, response, null, "Pagamento em dinheiro só pode ser parcelado em até 5 vezes.", "gerar_pagamento.jsp");
					}
				}else{
					ca.sendRedirect(request, response, null, "Parcelamento em dinheiro só pode ser feito para tratamento inferior a R$ 500,00.", "gerar_pagamento.jsp");
				}
			}else{
				ca.sendRedirect(request, response, null, "Selecione a quantidade de parcelas.", "gerar_pagamento.jsp");
			}
		}
	
	}

}
