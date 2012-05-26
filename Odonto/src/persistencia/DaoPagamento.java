package persistencia;

import java.util.List;

import modelo.Pagamento;

public interface DaoPagamento {

	boolean cadastrarPagamento(Pagamento pagamento);
	
	boolean alterarPagamento(Pagamento pagamento);
	
	boolean excluirPagamento(Pagamento pagamento);
	
	Pagamento pesquisarPagamento(Pagamento pagamento);
	
	List<Pagamento> pesquisarTodosPagamento();
}
