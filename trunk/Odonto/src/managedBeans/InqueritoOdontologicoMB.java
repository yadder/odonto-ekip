package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import modelo.InqueritoOdontologico;
import persistencia.DaoInqueritoOdontologico;
import persistencia.DaoInqueritoOdontologicoImp;

public class InqueritoOdontologicoMB {

	private DaoInqueritoOdontologico dao = new DaoInqueritoOdontologicoImp();
	private InqueritoOdontologico inqueritoOdontologico;
	private ListDataModel inqueritoOdontologicos; 
	
	public InqueritoOdontologicoMB(){
		inqueritoOdontologico = new InqueritoOdontologico();
		inqueritoOdontologicos = resgatarInqueritoOdontologicos();
	}
	
	private ListDataModel resgatarInqueritoOdontologicos(){
		return new ListDataModel(dao.pesquisarTodosInqueritoOdontologico());
	}
	
	public Integer getSizeInqueritoOdontologicos(){
		return this.inqueritoOdontologicos.getRowCount();
	}
	
	public ListDataModel getInqueritoOdontologicos(){
		return this.inqueritoOdontologicos;
	}
	
	public String adicionarInqueritoOdontologico(){
		this.limparInqueritoOdontologico();
		return null;
	}
	
	public String alterarInqueritoOdontologico(){
		return null;
	}
	
	public String salvarInqueritoOdontologico(){
		if(inqueritoOdontologico.getCodigoInqueritoOdontologico() == 0){
			dao.cadastrarInqueritoOdontologico(inqueritoOdontologico);
		}else{
			dao.alterarInqueritoOdontologico(inqueritoOdontologico);
		}
		inqueritoOdontologicos = resgatarInqueritoOdontologicos();
		this.mostraMensagem(inqueritoOdontologico.getCodigoInqueritoOdontologico()+ " foi salvo!");
		inqueritoOdontologico = new InqueritoOdontologico();
		return null;
	}
	
	public String excluirInqueritoOdontologico(){
		this.mostraMensagem(inqueritoOdontologico.getCodigoInqueritoOdontologico() + " foi excluído!");
		dao.excluirInqueritoOdontologico(inqueritoOdontologico);
		inqueritoOdontologico = new InqueritoOdontologico();
		inqueritoOdontologicos = resgatarInqueritoOdontologicos();
		return null;
	}
	
	public String cancelarCadastroInqueritoOdontologico(){
		return null;
	}
	
	private void limparInqueritoOdontologico(){
		inqueritoOdontologico = new InqueritoOdontologico();
	}
	
	public void mostraMensagem(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));
	}
	
	public InqueritoOdontologico getInqueritoOdontologico(){
		return inqueritoOdontologico;
	}
	
	public void setInqueritoOdontologico(InqueritoOdontologico inqueritoOdontologico){
		this.inqueritoOdontologico = inqueritoOdontologico;
	}	
}