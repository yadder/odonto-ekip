package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Paciente;
import modelo.Pagamento;

public interface DaoPagamento {

	boolean cadastrarPagamento(Pagamento pagamento);
	
	boolean alterarPagamento(Pagamento pagamento);
	
	boolean excluirPagamento(Pagamento pagamento);
	
	List<Pagamento> pesquisarTodosPagamento();
	
	ArrayList<Pagamento> pesquisarPagamentoPaciente(Paciente paciente);
}
