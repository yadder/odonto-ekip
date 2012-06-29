package persistencia;

import java.util.List;

import modelo.Fornecedor;

public interface DaoFornecedor {

	boolean cadastrarFornecedor(Fornecedor fornecedor);
	
	boolean alterarFornecedor(Fornecedor fornecedor);
	
	boolean excluirFornecedor(Fornecedor fornecedor);
	
	Fornecedor pesquisarFornecedor(Fornecedor fornecedor);
	
	Fornecedor pesquisarFornecedorPorNome(String nomeFornecedor);
	
	List<Fornecedor> pesquisarTodosFornecedor();
}
