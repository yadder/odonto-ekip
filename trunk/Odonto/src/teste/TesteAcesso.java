package teste;

import modelo.Acesso;
import persistencia.DaoAcesso;

public class TesteAcesso {

	public static void main(String[] args) {
		boolean result = false;
		try{
		Acesso acesso = null;
		DaoAcesso daoAcesso = new DaoAcesso();
		/*
		System.out.println("1------------------------------Testando a classe acesso (Cadastro)");
		acesso = new Acesso("TelaElemento");
		daoAcesso.cadastrarAcesso(acesso);
		System.out.println("Acesso "+acesso.getDescricaoAcesso()+" cadastrado!");
		*/
			
		System.out.println("1------------------------------Testando a classe acesso (Pesquisa)");
		acesso = new Acesso();
		acesso = daoAcesso.pesquisarAcessoPorNome(acesso);
		if (acesso != null){
			System.out.println("Acesso "+acesso.getDescricaoAcesso()+" encontrado!");
		}else{
			System.out.println("Acesso não encontrado");
		}
		
		/*
		System.out.println("1------------------------------Testando a classe acesso (Alteracao)");
		if (acesso != null){
			acesso.setDescricaoAcesso("TelaFace");
			result = daoAcesso.alterarAcesso(acesso);
			if (result){
				System.out.println("Acesso alterado para: "+acesso.getDescricaoAcesso());
			}else{
				System.out.println("Erro na alteração");
			}
		}else{
			System.out.println("O objeto acesso esta null");
		}
		*/
		
		System.out.println("1------------------------------Testando a classe acesso (Exclusao)");
		daoAcesso.excluirAcesso(acesso);
		if (result){
			System.out.println("Acesso excluído");
		}else{
			System.out.println("Erro na exclusão");
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
