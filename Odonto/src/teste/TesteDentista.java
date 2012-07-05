package teste;

import modelo.Dentista;
import persistencia.DaoDentista;
import persistencia.DaoDentistaImp;
import util.ConfiguraAtributo;

public class TesteDentista {

	public static void main(String[] args) {
		boolean result = false;
		Dentista dentista = null;
		DaoDentista daoDentista = new DaoDentistaImp();
		ConfiguraAtributo ca = new ConfiguraAtributo();
				
		System.out.println("1------------------------------Testando a classe dentista (Cadastro)");
		dentista = new Dentista("JOSUE", "12345", "DENTISTA", "12345", "939.939.939-19","M",ca.dataStringParaDataSql("15/03/1970"),"222999");
		daoDentista.cadastrarDentista(dentista);
		System.out.println("Dentista "+dentista.getNomeUsuario()+" cadastrado!");
/*		
		System.out.println("1------------------------------Testando a classe dentista (Pesquisa)");
		dentista = new Dentista("Michelle Silva");
		dentista = daoDentista.pesquisarDentistaPorNome("Michelle Silva");
		if (dentista != null){
			System.out.println("Dentista "+dentista.getNomeUsuario()+" encontrado!");
		}else{
			System.out.println("Dentista não encontrado");
		}
		
		System.out.println("1------------------------------Testando a classe dentista (Alteracao)");
		dentista.setCroDentista("000000000");
		result = daoDentista.alterarDentista(dentista);
		if (result){
			System.out.println("CRO do dentista alterado para: "+dentista.getCroDentista());
		}else{
			System.out.println("Erro na alteração");
		}
		
		System.out.println("1------------------------------Testando a classe dentista (Exclusao)");
		result = daoDentista.excluirDentista(dentista);
		if (result){
			System.out.println("Dentista excluído");
		}else{
			System.out.println("Erro na exclusão");
		}
*/
	}
}
