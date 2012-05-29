package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import modelo.Disponibilidade;
import persistencia.DaoDisponibilidade;
import persistencia.DaoDisponibilidadeImp;

public class DisponibilidadeMB {

	private DaoDisponibilidade dao = new DaoDisponibilidadeImp();
	private Disponibilidade disponibilidade;
	private ListDataModel disponibilidades; 
	
	public DisponibilidadeMB(){
		disponibilidade = new Disponibilidade();
		disponibilidades = resgatarDisponibilidades();
	}
	
	private ListDataModel resgatarDisponibilidades(){
		return new ListDataModel(dao.pesquisarTodosDisponibilidade());
	}
	
	public Integer getSizeDisponibilidades(){
		return this.disponibilidades.getRowCount();
	}
	
	public ListDataModel getDisponibilidades(){
		return this.disponibilidades;
	}
	
	public String adicionarDisponibilidade(){
		this.limparDisponibilidade();
		return null;
	}
	
	public String alterarDisponibilidade(){
		return null;
	}
	
	public String salvarDisponibilidade(){
		if(disponibilidade.getCodigoDisponibilidade() == 0){
			dao.cadastrarDisponibilidade(disponibilidade);
		}else{
			dao.alterarDisponibilidade(disponibilidade);
		}
		disponibilidades = resgatarDisponibilidades();
		this.mostraMensagem(disponibilidade.getCodigoDentista() + " foi salvo!");
		disponibilidade = new Disponibilidade();
		return null;
	}
	
	public String excluirDisponibilidade(){
		this.mostraMensagem(disponibilidade.getCodigoDisponibilidade() + " foi excluído!");
		dao.excluirDisponibilidade(disponibilidade);
		disponibilidade = new Disponibilidade();
		disponibilidades = resgatarDisponibilidades();
		return null;
	}
	
	public String cancelarCadastroDisponibilidade(){
		return null;
	}
	
	private void limparDisponibilidade(){
		disponibilidade = new Disponibilidade();
	}
	
	public void mostraMensagem(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));
	}
	
	public Disponibilidade getDisponibilidade(){
		return disponibilidade;
	}
	
	public void setDisponibilidade(Disponibilidade disponibilidade){
		this.disponibilidade = disponibilidade;
	}	
}