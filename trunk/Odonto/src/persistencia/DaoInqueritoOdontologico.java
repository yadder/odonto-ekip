package persistencia;

import java.util.List;

import modelo.InqueritoOdontologico;

public interface DaoInqueritoOdontologico {

	boolean cadastrarInqueritoOdontologico(InqueritoOdontologico inqueritoOdontologico);
	
	boolean alterarInqueritoOdontologico(InqueritoOdontologico inqueritoOdontologico);
	
	boolean excluirInqueritoOdontologico(InqueritoOdontologico inqueritoOdontologico);
	
	InqueritoOdontologico pesquisarInqueritoOdontologico(InqueritoOdontologico inqueritoOdontologico);
	
	List<InqueritoOdontologico> pesquisarTodosInqueritoOdontologico();
}
