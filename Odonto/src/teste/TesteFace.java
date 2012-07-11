package teste;

import modelo.Face;
import persistencia.DaoFace;
import persistencia.DaoFace;

public class TesteFace {


	public static void main(String[] args) {
		boolean result = false;
		Face face = null;
		DaoFace daoFace = new DaoFace();
		
		System.out.println("1------------------------------Testando a classe face (Cadastro)");
		face = new Face("MESIAL");
		daoFace.cadastrarFace(face);
		System.out.println("Face "+face.getNomeFace()+" cadastrado!");
		
		System.out.println("1------------------------------Testando a classe face (Pesquisa)");
		face = new Face("MESIAL");
		face = daoFace.pesquisarFacePorNome("MESIAL");
		if (face != null){
			System.out.println("Face "+face.getNomeFace()+" encontrado!");
		}else{
			System.out.println("Face n�o encontrado");
		}
		
		System.out.println("1------------------------------Testando a classe face (Alteracao)");
		face.setNomeFace("UNIMED");
		result = daoFace.alterarFace(face);
		if (result){
			System.out.println("Face alterado para: "+face.getNomeFace());
		}else{
			System.out.println("Erro na altera��o");
		}
		
		System.out.println("1------------------------------Testando a classe face (Exclusao)");
		result = daoFace.excluirFace(face);
		if (result){
			System.out.println("Face exclu�do");
		}else{
			System.out.println("Erro na exclus�o");
		}
	}

}
