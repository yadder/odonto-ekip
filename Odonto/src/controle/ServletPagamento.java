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
			objetoSessao.removeAttribute("paciente");
			objetoSessao.removeAttribute("odontograma");
			objetoSessao.removeAttribute("listaPagamento");
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
				int par = Integer.parseInt((String)request.getParameter("parcelas"));
				double valorParcela = Double.parseDouble((String)request.getParameter("valorParcela"));
				DaoPagamento daoPagamento = new DaoPagamento();
				if (((String)request.getParameter("formaPagamento")).equals("CARTÃO")){
					Date minhaData = new Date();  
					Calendar calendar = Calendar.getInstance();  
					calendar.setTime(minhaData);
					SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
					for (int i = 0; i < par; i++) {
						calendar.add(Calendar.DAY_OF_MONTH,31);// incrementa na data a qtd de dias							
						Pagamento pagamento = new Pagamento();
						pagamento.setNumeroParcela(i+1);							
						pagamento.setValorParcela(valorParcela);
						pagamento.setStatusPagamento("PENDENTE");
						pagamento.setOdontograma((Odontograma)objetoSessao.getAttribute("odontograma"));
						pagamento.setPaciente((Paciente)objetoSessao.getAttribute("paciente"));
						pagamento.setDataVencimento(ca.dataStringParaDataSql(dataFormatada.format(calendar.getTime())));
						pagamento.setDataPagamento(null);							
						try{
							daoPagamento.cadastrarPagamento(pagamento);
							daoPagamento = new DaoPagamento();
						}catch (Exception e) {
							ca.sendRedirect(request, response, null, "Erro ao gravar pagamento.", "gerar_pagamento.jsp");
							e.printStackTrace();
						}
					}
					objetoSessao.removeAttribute("paciente");
					objetoSessao.removeAttribute("odontograma");
					ca.sendRedirect(request, response, "Pagamento no cartão cadastrado com sucesso!", null, "principal.jsp");
				}else if (((String)request.getParameter("formaPagamento")).equals("DINHEIRO")){
					if (valor<=500){
						if (par<=5){
							Date minhaData = new Date();  
							Calendar calendar = Calendar.getInstance();  
							calendar.setTime(minhaData);
							SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
							for (int i = 0; i < par; i++) {
								calendar.add(Calendar.DAY_OF_MONTH,31);// incrementa na data a qtd de dias							
								Pagamento pagamento = new Pagamento();
								pagamento.setNumeroParcela(i+1);							
								pagamento.setValorParcela(valorParcela);
								pagamento.setStatusPagamento("PENDENTE");
								pagamento.setOdontograma((Odontograma)objetoSessao.getAttribute("odontograma"));
								pagamento.setPaciente((Paciente)objetoSessao.getAttribute("paciente"));
								pagamento.setDataVencimento(ca.dataStringParaDataSql(dataFormatada.format(calendar.getTime())));
								pagamento.setDataPagamento(null);							
								try{
									daoPagamento.cadastrarPagamento(pagamento);
								}catch (Exception e) {
									ca.sendRedirect(request, response, null, "Erro ao gravar pagamento.", "gerar_pagamento.jsp");
									e.printStackTrace();
								}
							}
							objetoSessao.removeAttribute("paciente");
							objetoSessao.removeAttribute("odontograma");
							ca.sendRedirect(request, response, "Pagamento em dinheiro cadastrado com sucesso!", null, "principal.jsp");
						}else{
							ca.sendRedirect(request, response, null, "Pagamento em dinheiro só pode ser parcelado em até 5 vezes.", "gerar_pagamento.jsp");
						}
					}else{
						ca.sendRedirect(request, response, null, "Parcelamento em dinheiro só pode ser feito para tratamento inferior a R$ 500,00.", "gerar_pagamento.jsp");
					}	
				}
			}else{
				ca.sendRedirect(request, response, null, "Selecione a quantidade de parcelas.", "gerar_pagamento.jsp");
			}		
		}else if (btn.equals("Pesquisar paciente para efetuar pagamento")){
			if (((String)request.getParameter("nomePaciente"))!=null){
				Paciente paciente = new Paciente();
				paciente = po.getPaciente((String)request.getParameter("nomePaciente"));
				if (paciente != null){
					//pesquisar pagamentos por paciente 
					List<Pagamento> listaPagamento = new ArrayList<Pagamento>();
					listaPagamento = po.getPagamentoPendentePorPaciente(paciente);
					if (listaPagamento == null){
						ca.sendRedirect(request, response, null, "O paciente informado não possui pagamentos pendentes.", "pesquisar_paciente_efetuar_pagamento.jsp");
					}else{
						objetoSessao.setAttribute("listaPagamento", listaPagamento);
						objetoSessao.setAttribute("paciente", paciente);
						ca.sendRedirect(request, response, null, null, "efetuar_pagamento.jsp");
					}					
				}else{
					ca.sendRedirect(request, response, null, "Paciente não encontrado.", "pesquisar_paciente_efetuar_pagamento.jsp");
				}
			}else{
				ca.sendRedirect(request, response, null, "Preencha o nome do paciente.", "pesquisar_paciente_efetuar_pagamento.jsp");
			}
		}else if(btn.equals("Pagar")){
			long index = Long.parseLong((String)request.getParameter("index"));
			DaoPagamento daoPagamento = new DaoPagamento();
			Pagamento pagamento = new Pagamento();
			pagamento = po.getPagamentoPorId(index); 
			if (pagamento!=null){
				pagamento.setStatusPagamento("PAGO");
				pagamento.setDataPagamento(new Date());
				try{
					daoPagamento.alterarPagamento(pagamento);
					Paciente paciente = new Paciente();
					paciente = (Paciente)objetoSessao.getAttribute("paciente");
					List<Pagamento> listaPagamento = new ArrayList<Pagamento>();
					listaPagamento = po.getPagamentoPendentePorPaciente(paciente);
					objetoSessao.setAttribute("listaPagamento", listaPagamento);
					ca.sendRedirect(request, response, "Pagamento realizado com sucesso", null, "efetuar_pagamento.jsp");
				}catch (Exception e) {
					ca.sendRedirect(request, response, null, "Erro ao alterar o status do pagamento", "efetuar_pagamento.jsp");
					e.printStackTrace();
				}
			}else{
				ca.sendRedirect(request, response, null, "Pagamento não encontrado.", "efetuar_pagamento.jsp");
			}
		}else if (btn.equals("listarPagamentosVencidosEmAberto")){
			objetoSessao.removeAttribute("listaPagamento");
			List<Pagamento> listaPagamento = new ArrayList<Pagamento>();
			Date dataSql = new Date();
			String dataString = dataSql.toString();
			listaPagamento = po.getPagamentoPendente(ca.dataStringParaDataSql(dataString));
			if (listaPagamento == null){
				ca.sendRedirect(request, response, null, "Não existe pagamento pendente.", "pagamentos_vencidos_em_aberto.jsp");
			}else{
				objetoSessao.setAttribute("listaPagamento", listaPagamento);
				ca.sendRedirect(request, response, null, null, "pagamentos_vencidos_em_aberto.jsp");
			}
		}
						
	} // post

}
