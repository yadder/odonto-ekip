package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import modelo.Elemento;
import persistencia.DaoElemento;
import persistencia.DaoElementoImp;

public class ElementoMB {

	private DaoElemento dao = new DaoElementoImp();
	private Elemento elemento;
	private ListDataModel elementos; 
	
	public ElementoMB(){
		elemento = new Elemento();
		elementos = resgatarElementos();
	}
	
	private ListDataModel resgatarElementos(){
		return new ListDataModel(dao.pesquisarTodosElemento());
	}
	
	public Integer getSizeElementos(){
		return this.elementos.getRowCount();
	}
	
	public ListDataModel getElementos(){
		return this.elementos;
	}
	
	public String adicionarElemento(){
		this.limparElemento();
		return null;
	}
	
	public String alterarElemento(){
		return null;
	}
	
	public String salvarElemento(){
		if ((elemento.getNomeElemento().equals("")) || (elemento.getNomeElemento()==null)||(elemento.getNomeElemento().length()!=2)){
			this.mostraMensagem("Erro: Nome de elemento inválido");
			return null;
		}
		if(elemento.getCodigoElemento() == 0){
			dao.cadastrarElemento(elemento);
		}else{
			dao.alterarElemento(elemento);
		}
		elementos = resgatarElementos();
		this.mostraMensagem(elemento.getNomeElemento() + " foi salvo!");
		elemento = new Elemento();
		return null;
	}
	
	public String excluirElemento(){
		this.mostraMensagem(elemento.getNomeElemento() + " foi excluído!");
		dao.excluirElemento(elemento);
		elemento = new Elemento();
		elementos = resgatarElementos();
		return null;
	}
	
	public String cancelarCadastroElemento(){
		return null;
	}
	
	private void limparElemento(){
		elemento = new Elemento();
	}
	
	public void mostraMensagem(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));
	}
	
	public Elemento getElemento(){
		return elemento;
	}
	
	public void setElemento(Elemento elemento){
		this.elemento = elemento;
	}	
}