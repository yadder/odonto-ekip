package persistencia;

import java.util.List;

import modelo.Face;

public interface DaoFace {

	boolean insereFace(Face face);
	
	boolean alteraFace(Face face);
	
	boolean excluiFace(Face face);
	
	Face procurarFace(Face face);
	
	List<Face> procurarTodosFace();
}
