package persistencia;

import java.util.List;

import modelo.Elemento;

public interface DaoElemento {

	boolean cadastrarElemento(Elemento elemento);
	
	boolean alterarElemento(Elemento elemento);
	
	boolean excluirElemento(Elemento elemento);
	
	Elemento pesquisarElementoPorNome(String nome);
	
	List<Elemento> pesquisarTodosElemento();
}
