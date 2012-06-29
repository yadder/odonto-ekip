package teste;

import javax.servlet.RequestDispatcher;

import modelo.Fornecedor;
import persistencia.DaoFornecedor;
import persistencia.DaoFornecedorImp;

public class TesteFornecedor {

	public static void main(String[] args) {
		System.out.println("1------------------------------Testando a classe fornecedor (Pesquisa)");
		String nomeFornecedor = "proteses ltda";
		Fornecedor fornecedor = new Fornecedor(nomeFornecedor);
		DaoFornecedor dao = new DaoFornecedorImp();
		fornecedor = dao.pesquisarFornecedorPorNome(nomeFornecedor);
		if (fornecedor != null){
			System.out.println("Fornecedor encontrado.");
			System.out.println(fornecedor);
		}else{
			System.out.println("Fornecedor não encontrado.");
		}
	}

}
