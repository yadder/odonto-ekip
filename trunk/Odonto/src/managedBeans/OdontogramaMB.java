package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import modelo.Odontograma;
import persistencia.DaoOdontograma;
import persistencia.DaoOdontogramaImp;

public class OdontogramaMB {

	private DaoOdontograma dao = new DaoOdontogramaImp();
	private Odontograma odontograma;
	private ListDataModel odontogramas; 
	
	public OdontogramaMB(){
		odontograma = new Odontograma();
		odontogramas = resgatarOdontogramas();
	}
	
	private ListDataModel resgatarOdontogramas(){
		return new ListDataModel(dao.pesquisarTodosOdontograma());
	}
	
	public Integer getSizeOdontogramas(){
		return this.odontogramas.getRowCount();
	}
	
	public ListDataModel getOdontogramas(){
		return this.odontogramas;
	}
	
	public String adicionarOdontograma(){
		this.limparOdontograma();
		return null;
	}
	
	public String alterarOdontograma(){
		return null;
	}
	
	public String salvarOdontograma(){
		if(odontograma.getCodigoOdontograma() == 0){
			dao.cadastrarOdontograma(odontograma);
		}else{
			dao.alterarOdontograma(odontograma);
		}
		odontogramas = resgatarOdontogramas();
		this.mostraMensagem(odontograma.getCodigoOdontograma() + " foi salvo!");
		odontograma = new Odontograma();
		return null;
	}
	
	public String excluirOdontograma(){
		this.mostraMensagem(odontograma.getCodigoOdontograma() + " foi excluído!");
		dao.excluirOdontograma(odontograma);
		odontograma = new Odontograma();
		odontogramas = resgatarOdontogramas();
		return null;
	}
	
	public String cancelarCadastroOdontograma(){
		return null;
	}
	
	private void limparOdontograma(){
		odontograma = new Odontograma();
	}
	
	public void mostraMensagem(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));
	}
	
	public Odontograma getOdontograma(){
		return odontograma;
	}
	
	public void setOdontograma(Odontograma odontograma){
		this.odontograma = odontograma;
	}	
}