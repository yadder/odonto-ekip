package manager;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import modelo_hibernate.Convenio;
import persistencia.DaoConvenio;

public class ManagerBeanConvenio {

	private Convenio convenio;

	//declaro a classe
	
	public ManagerBeanConvenio() {
		convenio = new Convenio(); // crio uma instancia para trabalhar com o convenio
		
	}
	// todas as operacoes possuem um metodo dentro do managerBean Ex: cadastrar, consultar...

	public void gravar(){
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
	}
	
	public void alterar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		String msg = "";
		DaoConvenio daoc = new DaoConvenio();
		try {
			daoc.alterar(convenio);  // eu gravo o objeto que possui espaço de memoria
			msg = "Dados alterados!";
			convenio = new Convenio();
		} catch (Exception e) {
			msg = "Erro: "+e.getMessage();
		}
		fc.addMessage("form1", new FacesMessage(msg));  // mandando a mensagem para a tela
	}

	public void excluir(){
		FacesContext fc = FacesContext.getCurrentInstance();
		String msg = "";
		DaoConvenio daoc = new DaoConvenio();
		try {
			if (convenio.getCodigoConvenio() != null){
				daoc.excluir(convenio);  // eu gravo o objeto que possui espaço de memoria
				msg = "Dados excluídos!";
			}else{
				msg = "O convênio é null!";
			}
		} catch (HibernateException he){
			msg = "Erro: "+he.getMessage();
		}catch (Exception e) {
			msg = "Erro: "+e.getMessage();
		}
		fc.addMessage("form1", new FacesMessage(msg));  // mandando a mensagem para a tela
	}
	
	public void pesquisar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		String msg = "";
		DaoConvenio daoc = new DaoConvenio();
		try {
			this.convenio = daoc.consultar(convenio);
			if (this.convenio != null )
				msg = "Convênio encontrado";				
			else{
				msg = "Convênio não encontrado";
			}
		} catch (Exception e) {
			msg = "Erro: "+e.getMessage();
		}
		fc.addMessage("form1", new FacesMessage(msg));  // mandando a mensagem para a tela
	}
	
	public Convenio getConvenio() {
		return this.convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
	
	public String gotoPrincipal(){
		return "gotoPrincipal";
	}
}
