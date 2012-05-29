package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import modelo.OdontogramaProcedimento;
import persistencia.DaoOdontogramaProcedimento;
import persistencia.DaoOdontogramaProcedimentoImp;

public class OdontogramaProcedimentoMB {

	private DaoOdontogramaProcedimento dao = new DaoOdontogramaProcedimentoImp();
	private OdontogramaProcedimento odontogramaProcedimento;
	private ListDataModel odontogramaProcedimentos; 
	
	public OdontogramaProcedimentoMB(){
		odontogramaProcedimento = new OdontogramaProcedimento();
		odontogramaProcedimentos = resgatarOdontogramaProcedimentos();
	}
	
	private ListDataModel resgatarOdontogramaProcedimentos(){
		return new ListDataModel(dao.pesquisarTodosOdontogramaProcedimento());
	}
	
	public Integer getSizeOdontogramaProcedimentos(){
		return this.odontogramaProcedimentos.getRowCount();
	}
	
	public ListDataModel getOdontogramaProcedimentos(){
		return this.odontogramaProcedimentos;
	}
	
	public String adicionarOdontogramaProcedimento(){
		this.limparOdontogramaProcedimento();
		return null;
	}
	
	public String alterarOdontogramaProcedimento(){
		return null;
	}
	
	public String salvarOdontogramaProcedimento(){
		if(odontogramaProcedimento.getCodigoOdontogramaProcedimeto() == 0){
			dao.cadastrarOdontogramaProcedimento(odontogramaProcedimento);
		}else{
			dao.alterarOdontogramaProcedimento(odontogramaProcedimento);
		}
		odontogramaProcedimentos = resgatarOdontogramaProcedimentos();
		this.mostraMensagem(odontogramaProcedimento.getCodigoOdontogramaProcedimeto() + " foi salvo!");
		odontogramaProcedimento = new OdontogramaProcedimento();
		return null;
	}
	
	public String excluirOdontogramaProcedimento(){
		this.mostraMensagem(odontogramaProcedimento.getCodigoOdontogramaProcedimeto() + " foi excluído!");
		dao.excluirOdontogramaProcedimento(odontogramaProcedimento);
		odontogramaProcedimento = new OdontogramaProcedimento();
		odontogramaProcedimentos = resgatarOdontogramaProcedimentos();
		return null;
	}
	
	public String cancelarCadastroOdontogramaProcedimento(){
		return null;
	}
	
	private void limparOdontogramaProcedimento(){
		odontogramaProcedimento = new OdontogramaProcedimento();
	}
	
	public void mostraMensagem(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));
	}
	
	public OdontogramaProcedimento getOdontogramaProcedimento(){
		return odontogramaProcedimento;
	}
	
	public void setOdontogramaProcedimento(OdontogramaProcedimento odontogramaProcedimento){
		this.odontogramaProcedimento = odontogramaProcedimento;
	}	
}