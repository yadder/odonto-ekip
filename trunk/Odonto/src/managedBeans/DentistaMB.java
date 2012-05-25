package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import modelo.Dentista;
import persistencia.DaoDentista;
import persistencia.DaoDentistaImp;

public class DentistaMB {

	private DaoDentista dao = new DaoDentistaImp();
	private Dentista dentista;
	private ListDataModel dentistas; 
	
	public DentistaMB(){
		dentista = new Dentista();
		dentistas = resgatarDentistas();
	}
	
	private ListDataModel resgatarDentistas(){
		return new ListDataModel(dao.pesquisarTodosDentista());
	}
	
	public Integer getSizeDentistas(){
		return this.dentistas.getRowCount();
	}
	
	public ListDataModel getDentistas(){
		return this.dentistas;
	}
	
	public String adicionarDentista(){
		this.limparDentista();
		return null;
	}
	
	public String alterarDentista(){
		return null;
	}
	
	public String salvarDentista(){
		if(dentista.getCodigoDentista() == 0){
			dao.cadastrarDentista(dentista);
		}else{
			dao.alterarDentista(dentista);
		}
		dentistas = resgatarDentistas();
		this.mostraMensagem(dentista.getCroDentista() + " foi salvo!");
		dentista = new Dentista();
		return null;
	}
	
	public String excluirDentista(){
		this.mostraMensagem(dentista.getCroDentista() + " foi excluído!");
		dao.excluirDentista(dentista);
		dentista = new Dentista();
		dentistas = resgatarDentistas();
		return null;
	}
	
	public String cancelarCadastroDentista(){
		return null;
	}
	
	private void limparDentista(){
		dentista = new Dentista();
	}
	
	public void mostraMensagem(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));
	}
	
	public Dentista getDentista(){
		return dentista;
	}
	
	public void setDentista(Dentista dentista){
		this.dentista = dentista;
	}	
}