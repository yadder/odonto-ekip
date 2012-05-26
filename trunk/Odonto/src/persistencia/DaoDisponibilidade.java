package persistencia;

import java.util.List;

import modelo.Disponibilidade;

public interface DaoDisponibilidade {

	boolean cadastrarDisponibilidade(Disponibilidade disponibilidade);
	
	boolean alterarDisponibilidade(Disponibilidade disponibilidade);
	
	boolean excluirDisponibilidade(Disponibilidade disponibilidade);
	
	Disponibilidade pesquisarDisponibilidade(Disponibilidade disponibilidade);
	
	List<Disponibilidade> pesquisarTodosDisponibilidade();
}
