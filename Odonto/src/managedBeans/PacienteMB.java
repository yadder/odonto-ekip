package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import modelo.Paciente;
import persistencia.DaoPaciente;
import persistencia.DaoPacienteImp;

public class PacienteMB {

	private DaoPaciente dao = new DaoPacienteImp();
	private Paciente paciente;
	private ListDataModel pacientes; 
	
	public PacienteMB(){
		paciente = new Paciente();
		pacientes = resgatarPacientes();
	}
	
	private ListDataModel resgatarPacientes(){
		return new ListDataModel(dao.pesquisarTodosPaciente());
	}
	
	public Integer getSizePacientes(){
		return this.pacientes.getRowCount();
	}
	
	public ListDataModel getPacientes(){
		return this.pacientes;
	}
	
	public String adicionarPaciente(){
		this.limparPaciente();
		return null;
	}
	
	public String alterarPaciente(){
		return null;
	}
	
	public String salvarPaciente(){
		if(paciente.getCodigoUsuario() == 0){
			dao.cadastrarPaciente(paciente);
		}else{
			dao.alterarPaciente(paciente);
		}
		pacientes = resgatarPacientes();
		this.mostraMensagem(paciente.getCodigoUsuario() + " foi salvo!");
		paciente = new Paciente();
		return null;
	}
	
	public String excluirPaciente(){
		this.mostraMensagem(paciente.getCodigoUsuario() + " foi excluído!");
		dao.excluirPaciente(paciente);
		paciente = new Paciente();
		pacientes = resgatarPacientes();
		return null;
	}
	
	public String cancelarCadastroPaciente(){
		return null;
	}
	
	private void limparPaciente(){
		paciente = new Paciente();
	}
	
	public void mostraMensagem(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));
	}
	
	public Paciente getPaciente(){
		return paciente;
	}
	
	public void setPaciente(Paciente paciente){
		this.paciente = paciente;
	}	
}