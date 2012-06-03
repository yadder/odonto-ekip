package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import modelo.Paciente;
import modelo.Pagamento;
import persistencia.DaoPagamento;
import persistencia.DaoPagamentoImp;

public class PagamentoMB {

	private DaoPagamento dao = new DaoPagamentoImp();
	private Pagamento pagamento;
	private ListDataModel pagamentos; 
	
	public PagamentoMB(){
		pagamento = new Pagamento();
		pagamentos = resgatarPagamentos();
	}
	
	private ListDataModel resgatarPagamentos(){
		return new ListDataModel(dao.pesquisarTodosPagamento());
	}
	
	private ListDataModel resgatarPagamentosPaciente(Paciente paciente){
		return new ListDataModel(dao.pesquisarPagamentoPaciente(paciente));
	}
	
	public Integer getSizePagamentos(){
		return this.pagamentos.getRowCount();
	}
	
	public ListDataModel getPagamentos(){
		return this.pagamentos;
	}
	
	public String adicionarPagamento(){
		this.limparPagamento();
		return null;
	}
	
	public String alterarPagamento(){
		return null;
	}
	
	public String salvarPagamento(){
		if(pagamento.getCodigoPagamento() == 0){
			dao.cadastrarPagamento(pagamento);
		}else{
			dao.alterarPagamento(pagamento);
		}
		pagamentos = resgatarPagamentos();
		this.mostraMensagem(pagamento.getCodigoPagamento() + " foi salvo!");
		pagamento = new Pagamento();
		return null;
	}
	
	public String excluirPagamento(){
		this.mostraMensagem(pagamento.getCodigoPagamento() + " foi excluído!");
		dao.excluirPagamento(pagamento);
		pagamento = new Pagamento();
		pagamentos = resgatarPagamentos();
		return null;
	}
	
	public String cancelarCadastroPagamento(){
		return null;
	}
	
	private void limparPagamento(){
		pagamento = new Pagamento();
	}
	
	public void mostraMensagem(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));
	}
	
	public Pagamento getPagamento(){
		return pagamento;
	}
	
	public void setPagamento(Pagamento pagamento){
		this.pagamento = pagamento;
	}
	
}