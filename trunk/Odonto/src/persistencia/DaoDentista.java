package persistencia;

import java.util.List;

import modelo.Dentista;

public interface DaoDentista {

	boolean cadastrarDentista(Dentista dentista);
	
	boolean alterarDentista(Dentista dentista);
	
	boolean excluirDentista(Dentista dentista);
	
	List<Dentista> pesquisarTodosDentista();
}
