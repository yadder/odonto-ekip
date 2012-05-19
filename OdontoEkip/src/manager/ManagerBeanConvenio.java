package manager;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import modelo_hibernate.Convenio;
import persistencia.DaoConvenio;

public class ManagerBeanConvenio {

	private Convenio convenio;

	//declaro a classe
	
	public ManagerBeanConvenio() {
		convenio = new Convenio(); // crio uma instancia para trabalhar com o convenio
		
	}
	// todas as operacoes possuem um metodo dentro do managerBean Ex: cadastrar, consultar...

	public String gravar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		String msg = "";
		DaoConvenio daoc = new DaoConvenio();
		try {
			daoc.gravar(convenio);  // eu gravo o objeto que possui espaço de memoria
			msg = "Dados gravados!";
			convenio = new Convenio();
		} catch (Exception e) {
			msg = "Erro: "+e.getMessage();
		}
		fc.addMessage("form1", new FacesMessage(msg));  // mandando a mensagem para a tela
		return null;  // nao irá para outra pagina
	}
	
	public Convenio pesquisar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		String msg = "";
		DaoConvenio daoc = new DaoConvenio();
		try {
			if ((convenio = daoc.consultar(convenio)) != null ){
				msg = "Convênio encontrado";
				return convenio;
				
			}
			else{
				msg = "Convênio não encontrado";
				convenio = new Convenio();
			}
		} catch (Exception e) {
			msg = "Erro: "+e.getMessage();
			
		}
		return convenio;
	}
	
	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
	
	public void sair(){
		
	}
	
}
