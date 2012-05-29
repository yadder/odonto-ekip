package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import modelo.Procedimento;
import persistencia.DaoProcedimento;
import persistencia.DaoProcedimentoImp;

public class ProcedimentoMB {

	private DaoProcedimento dao = new DaoProcedimentoImp();
	private Procedimento procedimento;
	private ListDataModel procedimentos; 
	
	public ProcedimentoMB(){
		procedimento = new Procedimento();
		procedimentos = resgatarProcedimentos();
	}
	
	private ListDataModel resgatarProcedimentos(){
		return new ListDataModel(dao.pesquisarTodosProcedimento());
	}
	
	public Integer getSizeProcedimentos(){
		return this.procedimentos.getRowCount();
	}
	
	public ListDataModel getProcedimentos(){
		return this.procedimentos;
	}
	
	public String adicionarProcedimento(){
		this.limparProcedimento();
		return null;
	}
	
	public String alterarProcedimento(){
		return null;
	}
	
	public String salvarProcedimento(){
		if(procedimento.getCodigoProcedimento() == 0){
			dao.cadastrarProcedimento(procedimento);
		}else{
			dao.alterarProcedimento(procedimento);
		}
		procedimentos = resgatarProcedimentos();
		this.mostraMensagem(procedimento.getCodigoProcedimento() + " foi salvo!");
		procedimento = new Procedimento();
		return null;
	}
	
	public String excluirProcedimento(){
		this.mostraMensagem(procedimento.getCodigoProcedimento() + " foi excluído!");
		dao.excluirProcedimento(procedimento);
		procedimento = new Procedimento();
		procedimentos = resgatarProcedimentos();
		return null;
	}
	
	public String cancelarCadastroProcedimento(){
		return null;
	}
	
	private void limparProcedimento(){
		procedimento = new Procedimento();
	}
	
	public void mostraMensagem(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));
	}
	
	public Procedimento getProcedimento(){
		return procedimento;
	}
	
	public void setProcedimento(Procedimento procedimento){
		this.procedimento = procedimento;
	}	
}