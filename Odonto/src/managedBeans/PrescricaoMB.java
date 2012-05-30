package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import modelo.Dentista;
import modelo.Odontograma;
import modelo.Prescricao;
import persistencia.DaoPrescricao;
import persistencia.DaoPrescricaoImp;

public class PrescricaoMB {

	private DaoPrescricao dao = new DaoPrescricaoImp();
	private Prescricao prescricao;
	private ListDataModel prescricoes; 
	private Dentista dentista;
	private Odontograma odontograma;
	
	public PrescricaoMB(){
		prescricao = new Prescricao();
		prescricoes = resgatarPrescricoes();
		dentista = new Dentista();
		odontograma = new Odontograma();
	}
	
	private ListDataModel resgatarPrescricoes(){
		return new ListDataModel(dao.pesquisarTodosPrescricao());
	}
	
	public Integer getSizePrescricoes(){
		return this.prescricoes.getRowCount();
	}
	
	public ListDataModel getPrescricoes(){
		return this.prescricoes;
	}
	
	public String adicionarPrescricao(){
		this.limparPrescricao();
		return null;
	}
	
	public String alterarPrescricao(){
		return null;
	}
	
	public String salvarPrescricao(){
		if(prescricao.getCodigoPrescricao() == 0){
			dao.cadastrarPrescricao(prescricao);
		}else{
			dao.alterarPrescricao(prescricao);
		}
		prescricoes = resgatarPrescricoes();
		this.mostraMensagem(prescricao.getCodigoPrescricao() + " foi salvo!");
		prescricao = new Prescricao();
		return null;
	}
	
	public String excluirPrescricao(){
		this.mostraMensagem(prescricao.getCodigoPrescricao() + " foi excluído!");
		dao.excluirPrescricao(prescricao);
		prescricao = new Prescricao();
		prescricoes = resgatarPrescricoes();
		return null;
	}
	
	public String cancelarCadastroPrescricao(){
		return null;
	}
	
	private void limparPrescricao(){
		prescricao = new Prescricao();
	}
	
	public void mostraMensagem(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));
	}
	
	public Prescricao getPrescricao(){
		return prescricao;
	}
	
	public void setPrescricao(Prescricao prescricao){
		this.prescricao = prescricao;
	}	
}