package persistencia;

import java.util.List;

import modelo.Procedimento;

public interface DaoProcedimento {

	boolean cadastrarProcedimento(Procedimento procedimento);
	
	boolean alterarProcedimento(Procedimento procedimento);
	
	boolean excluirProcedimento(Procedimento procedimento);
	
	Procedimento pesquisarProcedimentoPorDescricao(String nome);
	
	List<Procedimento> pesquisarTodosProcedimento();
}
