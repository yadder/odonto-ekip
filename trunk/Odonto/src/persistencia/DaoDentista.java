package persistencia;

import java.util.List;

import modelo.Dentista;

public interface DaoDentista {

	boolean cadastrarDentista(Dentista dentista);
	
	boolean alterarDentista(Dentista dentista);
	
	boolean excluirDentista(Dentista dentista);
	
	Dentista pesquisarDentistaPorNome(String nome);
	
	List<Dentista> pesquisarTodosDentista();
}
