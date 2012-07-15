package teste;

import modelo.Fornecedor;
import persistencia.DaoFornecedor;

public class TesteFornecedor {

	public static void main(String[] args) {
		try{
		System.out.println("1------------------------------Testando a classe fornecedor (Pesquisa)");
		String nomeFornecedor = "proteses ltda";
		Fornecedor fornecedor = new Fornecedor(nomeFornecedor);
		DaoFornecedor dao = new DaoFornecedor();
		fornecedor = dao.pesquisarFornecedorPorNome(fornecedor);
		if (fornecedor != null){
			System.out.println("Fornecedor encontrado.");
			System.out.println(fornecedor);
		}else{
			System.out.println("Fornecedor não encontrado.");
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
