package teste;

import modelo.Convenio;
import persistencia.DaoConvenio;
import persistencia.DaoConvenioImp;

public class TesteConvenio {

	public static void main(String[] args) {
		boolean result = false;
		Convenio convenio = null;
		DaoConvenio daoConvenio = new DaoConvenioImp();
		
		System.out.println("1------------------------------Testando a classe convenio (Cadastro)");
		convenio = new Convenio("Amil");
		daoConvenio.cadastrarConvenio(convenio);
		System.out.println("Convenio "+convenio.getNomeConvenio()+" cadastrado!");
		
		System.out.println("1------------------------------Testando a classe convenio (Pesquisa)");
		convenio = new Convenio("Amil");
		convenio = daoConvenio.pesquisarConvenioPorNome("Amil");
		if (convenio != null){
			System.out.println("Convenio "+convenio.getNomeConvenio()+" encontrado!");
		}else{
			System.out.println("Convenio não encontrado");
		}
		
		System.out.println("1------------------------------Testando a classe convenio (Alteracao)");
		convenio.setNomeConvenio("Unimed");
		result = daoConvenio.alterarConvenio(convenio);
		if (result){
			System.out.println("Convenio alterado para: "+convenio.getNomeConvenio());
		}else{
			System.out.println("Erro na alteração");
		}
		
		System.out.println("1------------------------------Testando a classe convenio (Exclusao)");
		result = daoConvenio.excluirConvenio(convenio);
		if (result){
			System.out.println("Convenio excluído");
		}else{
			System.out.println("Erro na exclusão");
		}
	}

}
