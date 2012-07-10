package teste;

import modelo.Acesso;
import persistencia.DaoAcesso;
import persistencia.DaoAcessoImp;

public class TesteAcesso {

	public static void main(String[] args) {
		boolean result = false;
		Acesso acesso = null;
		DaoAcesso daoAcesso = new DaoAcessoImp();
		/*
		System.out.println("1------------------------------Testando a classe acesso (Cadastro)");
		acesso = new Acesso("TelaElemento");
		daoAcesso.cadastrarAcesso(acesso);
		System.out.println("Acesso "+acesso.getDescricaoAcesso()+" cadastrado!");
		*/
			
		System.out.println("1------------------------------Testando a classe acesso (Pesquisa)");
		acesso = new Acesso();
		acesso = daoAcesso.pesquisarAcessoPorNome("TelaFace");
		if (acesso != null){
			System.out.println("Acesso "+acesso.getDescricaoAcesso()+" encontrado!");
		}else{
			System.out.println("Acesso n�o encontrado");
		}
		
		/*
		System.out.println("1------------------------------Testando a classe acesso (Alteracao)");
		if (acesso != null){
			acesso.setDescricaoAcesso("TelaFace");
			result = daoAcesso.alterarAcesso(acesso);
			if (result){
				System.out.println("Acesso alterado para: "+acesso.getDescricaoAcesso());
			}else{
				System.out.println("Erro na altera��o");
			}
		}else{
			System.out.println("O objeto acesso esta null");
		}
		*/
		
		System.out.println("1------------------------------Testando a classe acesso (Exclusao)");
		result = daoAcesso.excluirAcesso(acesso);
		if (result){
			System.out.println("Acesso exclu�do");
		}else{
			System.out.println("Erro na exclus�o");
		}
		
	}

}
