package persistencia;

import java.util.List;

import modelo.Paciente;

public interface DaoPaciente {

	boolean cadastrarPaciente(Paciente paciente);
	
	boolean alterarPaciente(Paciente paciente);
	
	boolean excluirPaciente(Paciente paciente);
	
	Paciente pesquisarPaciente(Paciente paciente);
	
	List<Paciente> pesquisarTodosPaciente();
}
