package teste;

import controle.ConfiguraAtributo;
import modelo.Convenio;
import modelo.Paciente;
import persistencia.DaoConvenio;
import persistencia.DaoPaciente;

public class TestePaciente {

	public static void main(String[] args) {
		try{
			Paciente paciente = new Paciente();
			DaoPaciente daoPaciente = new DaoPaciente();
			ConfiguraAtributo ca = new ConfiguraAtributo();
			Convenio convenio = new Convenio("Amil");
			DaoConvenio daoConvenio = new DaoConvenio();
			convenio = daoConvenio.pesquisarConvenioPorNome(convenio);
					
			if (convenio != null){
				System.out.println("1------------------------------Testando a classe paciente (Cadastro)");
				paciente = new Paciente("JOSUE", "12345", "DENTISTA", "12345", "123.451.234-51", "M", ca.dataStringParaDataSql("15/03/1970"), 
						"responsavel paciente", "logradouro","10", "lt 1 qd 2", "bairro", "Rio de Janeiro", "RJ", "20.000-000", "21", "2222-2222", 
						"22", "3333-3333", convenio);
				
				daoPaciente.cadastrarPaciente(paciente);
				System.out.println("Paciente "+paciente.getNomeUsuario()+" cadastrado!");
			}
		}catch (Exception e) {
			// TODO: handle exception
		}

		/*		
		System.out.println("1------------------------------Testando a classe paciente (Pesquisa)");
		paciente = daoPaciente.pesquisarPacientePorNome("JOSUE FREITAS");
		if (paciente != null){
			System.out.println("Paciente "+paciente.getNomeUsuario()+" encontrado! O convenio desse paciente é: "+paciente.getConvenio());
		}else{
			System.out.println("Paciente não encontrado");
		}
		
/*		System.out.println("1------------------------------Testando a classe paciente (Alteracao)");
		paciente.setCroPaciente("000000000");
		result = daoPaciente.alterarPaciente(paciente);
		if (result){
			System.out.println("CRO do paciente alterado para: "+paciente.getCroPaciente());
		}else{
			System.out.println("Erro na alteração");
		}
		
		System.out.println("1------------------------------Testando a classe paciente (Exclusao)");
		result = daoPaciente.excluirPaciente(paciente);
		if (result){
			System.out.println("Paciente excluído");
		}else{
			System.out.println("Erro na exclusão");
		}
*/

	}

}
