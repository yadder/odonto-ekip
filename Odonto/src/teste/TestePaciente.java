package teste;

import modelo.Paciente;
import persistencia.DaoPaciente;
import persistencia.DaoPacienteImp;
import util.ConfiguraAtributo;

public class TestePaciente {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean result = false;
		Paciente paciente = null;
		DaoPaciente daoPaciente = new DaoPacienteImp();
		ConfiguraAtributo ca = new ConfiguraAtributo();
				
		System.out.println("1------------------------------Testando a classe paciente (Cadastro)");
		paciente = new Paciente("JOSUE", "12345", "DENTISTA", "12345", "939.939.939-19","M",ca.dataStringParaDataSql("15/03/1970"),"222999", "logradouro","10","lt 1 qd 2","bairro","rio de janeiro","RJ","20.000-000","21","2222-2222","22","3333-3333",);
		daoPaciente.cadastrarPaciente(paciente);
		System.out.println("Paciente "+paciente.getNomeUsuario()+" cadastrado!");
/*		
		System.out.println("1------------------------------Testando a classe paciente (Pesquisa)");
		paciente = new Paciente("Michelle Silva");
		paciente = daoPaciente.pesquisarPacientePorNome("Michelle Silva");
		if (paciente != null){
			System.out.println("Paciente "+paciente.getNomeUsuario()+" encontrado!");
		}else{
			System.out.println("Paciente não encontrado");
		}
		
		System.out.println("1------------------------------Testando a classe paciente (Alteracao)");
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
