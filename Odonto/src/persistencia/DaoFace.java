package persistencia;

import java.util.List;

import modelo.Face;

public interface DaoFace {

	boolean cadastrarFace(Face face);
	
	boolean alterarFace(Face face);
	
	boolean excluirFace(Face face);
	
	Face pesquisarFace(Face face);
	
	Face pesquisarFacePorNome(String nome);
	
	List<Face> pesquisarTodosFace();
}

