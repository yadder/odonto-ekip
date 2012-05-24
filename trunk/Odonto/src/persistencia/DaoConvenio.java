package persistencia;

import java.util.List;

import modelo.Convenio;

public interface DaoConvenio {

	boolean cadastrarConvenio(Convenio convenio);
	
	boolean alterarConvenio(Convenio convenio);
	
	boolean excluirConvenio(Convenio convenio);
	
	Convenio pesquisarConvenio(Convenio convenio);
	
	List<Convenio> pesquisarTodosConvenio();
}
