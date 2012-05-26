package persistencia;

import java.util.List;

import modelo.OdontogramaProcedimento;

public interface DaoOdontogramaProcedimento {

	boolean cadastrarOdontogramaProcedimento(OdontogramaProcedimento odontogramaProcedimento);
	
	boolean alterarOdontogramaProcedimento(OdontogramaProcedimento odontogramaProcedimento);
	
	boolean excluirOdontogramaProcedimento(OdontogramaProcedimento odontogramaProcedimento);
	
	OdontogramaProcedimento pesquisarOdontogramaProcedimento(OdontogramaProcedimento odontogramaProcedimento);
	
	List<OdontogramaProcedimento> pesquisarTodosOdontogramaProcedimento();
}
