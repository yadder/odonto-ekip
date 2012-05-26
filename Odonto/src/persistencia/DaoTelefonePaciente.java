package persistencia;

import java.util.List;

import modelo.TelefonePaciente;

public interface DaoTelefonePaciente {

	boolean cadastrarTelefonePaciente(TelefonePaciente telefonePaciente);
	
	boolean alterarTelefonePaciente(TelefonePaciente telefonePaciente);
	
	boolean excluirTelefonePaciente(TelefonePaciente telefonePaciente);
	
	TelefonePaciente pesquisarTelefonePaciente(TelefonePaciente telefonePaciente);
	
	List<TelefonePaciente> pesquisarTodosTelefonePaciente();
}
