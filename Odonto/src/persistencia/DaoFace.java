package persistencia;

import java.util.List;

import modelo.Face;

public interface DaoFace {

	boolean cadastrarFace(Face face);
	
	boolean alterarFace(Face face);
	
	boolean excluirFace(Face face);
	
	Face pesquisarFace(Face face);
	
	List<Face> pesquisarTodosFace();
}
