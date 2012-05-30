package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import modelo.Consulta;
import persistencia.DaoConsulta;
import persistencia.DaoConsultaImp;

public class ConsultaMB {

	private DaoConsulta dao = new DaoConsultaImp();
	private Consulta consulta;
	private ListDataModel consultas; 
	
	public ConsultaMB(){
		consulta = new Consulta();
		consultas = resgatarConsultas();
	}
	
	private ListDataModel resgatarConsultas(){
		return new ListDataModel(dao.pesquisarTodosConsulta());
	}
	
	public Integer getSizeConsultas(){
		return this.consultas.getRowCount();
	}
	
	public ListDataModel getConsultas(){
		return this.consultas;
	}
	
	public String adicionarConsulta(){
		this.limparConsulta();
		return null;
	}
	
	public String alterarConsulta(){
		return null;
	}
	
	public String salvarConsulta(){
		if(consulta.getCodigoConsulta() == 0){
			dao.cadastrarConsulta(consulta);
		}else{
			dao.alterarConsulta(consulta);
		}
		consultas = resgatarConsultas();
		this.mostraMensagem(consulta.getCodigoConsulta() + " foi salvo!");
		consulta = new Consulta();
		return null;
	}
	
	public String excluirConsulta(){
		this.mostraMensagem(consulta.getCodigoConsulta() + " foi excluído!");
		dao.excluirConsulta(consulta);
		consulta = new Consulta();
		consultas = resgatarConsultas();
		return null;
	}
	
	public String cancelarCadastroConsulta(){
		return null;
	}
	
	private void limparConsulta(){
		consulta = new Consulta();
	}
	
	public void mostraMensagem(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));
	}
	
	public Consulta getConsulta(){
		return consulta;
	}
	
	public void setConsulta(Consulta consulta){
		this.consulta = consulta;
	}	
}