package persistencia;

import java.util.List;

import modelo.Odontograma;

public interface DaoOdontograma {

	boolean cadastrarOdontograma(Odontograma odontograma);
	
	boolean alterarOdontograma(Odontograma odontograma);
	
	boolean excluirOdontograma(Odontograma odontograma);
	
	Odontograma pesquisarOdontograma(Odontograma odontograma);
	
	List<Odontograma> pesquisarTodosOdontograma();
}
