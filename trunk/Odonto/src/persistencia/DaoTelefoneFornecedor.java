package persistencia;

import java.util.List;

import modelo.TelefoneFornecedor;

public interface DaoTelefoneFornecedor {

	boolean cadastrarTelefoneFornecedor(TelefoneFornecedor telefoneFornecedor);
	
	boolean alterarTelefoneFornecedor(TelefoneFornecedor telefoneFornecedor);
	
	boolean excluirTelefoneFornecedor(TelefoneFornecedor telefoneFornecedor);
	
	TelefoneFornecedor pesquisarTelefoneFornecedor(TelefoneFornecedor telefoneFornecedor);
	
	List<TelefoneFornecedor> pesquisarTodosTelefoneFornecedor();
}
