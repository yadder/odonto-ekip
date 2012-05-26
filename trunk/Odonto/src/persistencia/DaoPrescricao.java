package persistencia;

import java.util.List;

import modelo.Prescricao;

public interface DaoPrescricao {

	boolean cadastrarPrescricao(Prescricao prescricao);
	
	boolean alterarPrescricao(Prescricao prescricao);
	
	boolean excluirPrescricao(Prescricao prescricao);
	
	Prescricao pesquisarPrescricao(Prescricao prescricao);
	
	List<Prescricao> pesquisarTodosPrescricao();
}
