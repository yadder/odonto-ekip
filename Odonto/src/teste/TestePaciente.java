package teste;

import modelo.Convenio;
import modelo.Paciente;
import persistencia.DaoConvenio;
import persistencia.DaoConvenio;
import persistencia.DaoPaciente;
import persistencia.DaoPaciente;
import util.ConfiguraAtributo;

public class TestePaciente {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean result = false;
		Paciente paciente = new Paciente();
		DaoPaciente daoPaciente = new DaoPaciente();
		ConfiguraAtributo ca = new ConfiguraAtributo();
		
		Convenio convenio = new Convenio("AMIL");
		DaoConvenio daoConvenio = new DaoConvenio();
		convenio = daoConvenio.pesquisarConvenioPorNome(convenio.getNomeConvenio());
				
		if (convenio != null){
			System.out.println("1------------------------------Testando a classe paciente (Cadastro)");
			paciente = new Paciente("JOSUE", "12345", "DENTISTA", "12345", "939.939.939-19", "M", ca.dataStringParaDataSql("15/03/1970"), 
					"responsavel paciente", "logradouro","10", "lt 1 qd 2", "bairro", "Rio de Janeiro", "RJ", "20.000-000", "21", "2222-2222", 
					"22", "3333-3333", convenio);
			
			result = daoPaciente.cadastrarPaciente(paciente);
			System.out.println("Paciente "+paciente.getNomeUsuario()+" cadastrado!");
		}

		/*		
		System.out.println("1------------------------------Testando a classe paciente (Pesquisa)");
		paciente = daoPaciente.pesquisarPacientePorNome("JOSUE FREITAS");
		if (paciente != null){
			System.out.println("Paciente "+paciente.getNomeUsuario()+" encontrado! O convenio desse paciente �: "+paciente.getConvenio());
		}else{
			System.out.println("Paciente n�o encontrado");
		}
		
/*		System.out.println("1------------------------------Testando a classe paciente (Alteracao)");
		paciente.setCroPaciente("000000000");
		result = daoPaciente.alterarPaciente(paciente);
		if (result){
			System.out.println("CRO do paciente alterado para: "+paciente.getCroPaciente());
		}else{
			System.out.println("Erro na altera��o");
		}
		
		System.out.println("1------------------------------Testando a classe paciente (Exclusao)");
		result = daoPaciente.excluirPaciente(paciente);
		if (result){
			System.out.println("Paciente exclu�do");
		}else{
			System.out.println("Erro na exclus�o");
		}
*/

	}

}
