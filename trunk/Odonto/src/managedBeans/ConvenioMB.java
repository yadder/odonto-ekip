package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import modelo.Convenio;
import persistencia.DaoConvenio;
import persistencia.DaoConvenioImp;

public class ConvenioMB {

	private DaoConvenio dao = new DaoConvenioImp();
	private Convenio convenio;
	private ListDataModel convenios; 
	
	public ConvenioMB(){
		convenio = new Convenio();
		convenios = resgatarConvenios();
	}
	
	private ListDataModel resgatarConvenios(){
		return new ListDataModel(dao.pesquisarTodosConvenio());
	}
	
	public Integer getSizeConvenios(){
		return this.convenios.getRowCount();
	}
	
	public ListDataModel getConvenios(){
		return this.convenios;
	}
	
	public String adicionarConvenio(){
		this.limparConvenio();
		return null;
	}
	
	public String alterarConvenio(){
		return null;
	}
	
	public String salvarConvenio(){
		if(convenio.getCodigoConvenio() == 0){
			dao.cadastrarConvenio(convenio);
		}else{
			dao.alterarConvenio(convenio);
		}
		convenios = resgatarConvenios();
		this.mostraMensagem(convenio.getNomeConvenio() + " foi salvo!");
		convenio = new Convenio();
		return null;
	}
	
	public String excluirConvenio(){
		this.mostraMensagem(convenio.getNomeConvenio() + " foi excluído!");
		dao.excluirConvenio(convenio);
		convenio = new Convenio();
		convenios = resgatarConvenios();
		return null;
	}
	
	public String cancelarCadastroConvenio(){
		return null;
	}
	
	private void limparConvenio(){
		convenio = new Convenio();
	}
	
	public void mostraMensagem(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));
	}
	
	public Convenio getConvenio(){
		return convenio;
	}
	
	public void setConvenio(Convenio convenio){
		this.convenio = convenio;
	}	
}