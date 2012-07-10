package persistencia;

import java.util.List;

import modelo.Acesso;

public interface DaoAcesso {

	boolean cadastrarAcesso(Acesso acesso);
	
	boolean alterarAcesso(Acesso acesso);
	
	boolean excluirAcesso(Acesso acesso);
	
	Acesso pesquisarAcessoPorNome(String nome);
	
	List<Acesso> pesquisarTodosAcesso();
}
