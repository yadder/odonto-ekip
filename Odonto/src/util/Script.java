package util;

import modelo.Acesso;
import modelo.Convenio;
import modelo.Dentista;
import modelo.Elemento;
import modelo.Face;
import modelo.Paciente;
import modelo.Usuario;
import persistencia.DaoAcesso;
import persistencia.DaoConvenio;
import persistencia.DaoDentista;
import persistencia.DaoElemento;
import persistencia.DaoFace;
import persistencia.DaoPaciente;
import persistencia.DaoUsuario;

public class Script {
	
	public static void main(String[] args) {
		ConfiguraAtributo ca = new ConfiguraAtributo();
		try{
			System.out.println("--- Inserindo convênios");
			Convenio convenio1 = new Convenio("AMIL");
			Convenio convenio2 = new Convenio("UNIMED");
			Convenio convenio3 = new Convenio("BRADESCO");
			Convenio convenio4 = new Convenio("DIX");
			Convenio convenio5 = new Convenio("MEDIAL");
			DaoConvenio daoConvenio = new DaoConvenio();
			daoConvenio.cadastrarConvenio(convenio1);
			daoConvenio.cadastrarConvenio(convenio2);
			daoConvenio.cadastrarConvenio(convenio3);
			daoConvenio.cadastrarConvenio(convenio4);
			daoConvenio.cadastrarConvenio(convenio5);
			System.out.println("--- Convênios cadastrados");
		}catch (Exception e) {
			System.out.println("Erro ao inserir convênios...");
		}
/////////////////////////////////////////////////////
		try{
			System.out.println("--- Inserindo elemento");
			
			DaoElemento daoElemento = new DaoElemento();
			for (int i=11; i<49;i++){
				Elemento elemento = new Elemento(""+i);
				daoElemento.cadastrarElemento(elemento);
			}
			System.out.println("--- Elementos cadastrados");
		}catch (Exception e) {
			System.out.println("Erro ao inserir elemento...");
		}
/////////////////////////////////////////////////////
		try{
			System.out.println("--- Inserindo face");
			DaoFace daoFace = new DaoFace();
			Face face1 = new Face("lingual ou palatina");
			Face face2 = new Face("vestibular");
			Face face3 = new Face("mesial");
			Face face4 = new Face("distal");
			Face face5 = new Face("oclusal ou incisal");
			daoFace.cadastrarFace(face1);
			daoFace.cadastrarFace(face2);
			daoFace.cadastrarFace(face3);
			daoFace.cadastrarFace(face4);
			daoFace.cadastrarFace(face5);
			System.out.println("--- Faces cadastradas");
		}catch (Exception e) {
			System.out.println("Erro ao inserir face...");
		}
/////////////////////////////////////////////////////
		try{
			System.out.println("--- Inserindo acesso");
			DaoAcesso daoAcesso = new DaoAcesso();
			Acesso acesso1 = new Acesso("TelaFornecedor");
			Acesso acesso2 = new Acesso("TelaInqueritoOdontologico");
			Acesso acesso3 = new Acesso("TelaConvenio");
			Acesso acesso4 = new Acesso("TelaPaciente");
			Acesso acesso5 = new Acesso("TelaRecepcionista");
			Acesso acesso6 = new Acesso("TelaProcedimento");
			Acesso acesso7 = new Acesso("TelaFace");
			Acesso acesso8 = new Acesso("TelaConsulta");
			Acesso acesso9 = new Acesso("TelaOdontograma");
			Acesso acesso10 = new Acesso("TelaAcesso");
			Acesso acesso11 = new Acesso("TelaDentista");
			Acesso acesso12 = new Acesso("TelaElemento");
			Acesso acesso13 = new Acesso("TelaPagamento");
			Acesso acesso14 = new Acesso("TelaPrescricao");
			daoAcesso.cadastrarAcesso(acesso1);
			daoAcesso.cadastrarAcesso(acesso2);
			daoAcesso.cadastrarAcesso(acesso3);
			daoAcesso.cadastrarAcesso(acesso4);
			daoAcesso.cadastrarAcesso(acesso5);
			daoAcesso.cadastrarAcesso(acesso6);
			daoAcesso.cadastrarAcesso(acesso7);
			daoAcesso.cadastrarAcesso(acesso8);
			daoAcesso.cadastrarAcesso(acesso9);
			daoAcesso.cadastrarAcesso(acesso10);
			daoAcesso.cadastrarAcesso(acesso11);
			daoAcesso.cadastrarAcesso(acesso12);
			daoAcesso.cadastrarAcesso(acesso13);
			daoAcesso.cadastrarAcesso(acesso14);
			System.out.println("--- Acessos cadastrados");
		}catch (Exception e) {
			System.out.println("Erro ao inserir acessos...");
		}
/////////////////////////////////////////////////////
		try{
			System.out.println("--- Inserindo recepcionista");
			DaoUsuario daoUsuario = new DaoUsuario();
			Usuario usuario = new Usuario();
			usuario.setNomeUsuario("TESTE RECEPCIONISTA");
			usuario.setSenhaUsuario(ca.gerarSenha());
			usuario.setPerfilUsuario("RECEPCIONISTA");
			usuario.setRgUsuario("11111111-7");
			usuario.setCpfUsuario("111.111.111-11");
			usuario.setDataNascimentoUsuario(ca.dataStringParaDataSql("23/12/1980"));
			usuario.setSexoUsuario("F");
			daoUsuario.cadastrarUsuario(usuario);
			System.out.println("--- Recepcionista cadastrados");
		}catch (Exception e) {
			System.out.println("Erro ao inserir recepcionista...");
		}
		
		try{
			System.out.println("--- Inserindo dentista");
			DaoDentista daoDentista = new DaoDentista();
			Dentista dentista = new Dentista();
			dentista.setNomeUsuario("TESTE DENTISTA");
			dentista.setSenhaUsuario(ca.gerarSenha());
			dentista.setPerfilUsuario("DENTISTA");
			dentista.setRgUsuario("22222222-2");
			dentista.setCpfUsuario("222.222.222-22");
			dentista.setDataNascimentoUsuario(ca.dataStringParaDataSql("15/03/1968"));
			dentista.setSexoUsuario("M");
			dentista.setCroDentista("2222222");
			daoDentista.cadastrarDentista(dentista);
			System.out.println("--- Dentista cadastrados");
		}catch (Exception e) {
			System.out.println("Erro ao inserir dentista...");
		}
/////////////////////////////////////////////////////
		try{
			System.out.println("--- Inserindo paciente");
			DaoPaciente daoPaciente = new DaoPaciente();
			Paciente paciente = new Paciente();
			paciente.setNomeUsuario("TESTE PACIENTE");
			paciente.setSenhaUsuario(ca.gerarSenha());
			paciente.setPerfilUsuario("PACIENTE");
			paciente.setRgUsuario("33333333-3");
			paciente.setCpfUsuario("333.333.333-33");
			paciente.setDataNascimentoUsuario(ca.dataStringParaDataSql("10/01/1968"));
			paciente.setSexoUsuario("F");
			paciente.setResponsavelPaciente("");
			paciente.setLogradouroPaciente("AVENIDA BRASIL");
			paciente.setNumeroLogradouroPaciente("5487");
			paciente.setComplementoLogradouroPaciente("");
			paciente.setBairroPaciente("CAJU");
			paciente.setCidadePaciente("RIO DE JANEIRO");
			paciente.setEstadoPaciente("RJ");
			paciente.setCepPaciente("33.333-333");
			paciente.setDdd1Paciente("33");
			paciente.setTelefone1Paciente("3333-3333");
			DaoConvenio daoConvenio = new DaoConvenio();
			Convenio convenio = new Convenio();
			convenio.setNomeConvenio("UNIMED");
			convenio = daoConvenio.pesquisarConvenioPorNome(convenio);
			paciente.setConvenio(convenio);
			daoPaciente.cadastrarPaciente(paciente);
			System.out.println("--- Paciente cadastrados");
		}catch (Exception e) {
			System.out.println("Erro ao inserir paciente...");
		}
/////////////////////////////////////////////////////
	}

}
