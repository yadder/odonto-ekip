package persistencia;

import java.util.List;

import modelo.Consulta;

public interface DaoConsulta {

	boolean cadastrarConsulta(Consulta consulta);
	
	boolean alterarConsulta(Consulta consulta);
	
	boolean excluirConsulta(Consulta consulta);
	
	Consulta pesquisarConsulta(Consulta consulta);
	
	List<Consulta> pesquisarTodosConsulta();
}
