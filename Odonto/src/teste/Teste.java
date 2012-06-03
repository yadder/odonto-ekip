package teste;

import java.util.List;

import modelo.Elemento;
import modelo.Face;
import modelo.Pagamento;
import modelo.Usuario;
import persistencia.DaoElemento;
import persistencia.DaoElementoImp;
import persistencia.DaoFace;
import persistencia.DaoFaceImp;
import persistencia.DaoPagamento;
import persistencia.DaoPagamentoImp;
import persistencia.DaoUsuario;
import persistencia.DaoUsuarioImp;

public class Teste {

	public static void main(String[] args) {
		

		System.out.println("1------------------------------Testando a classe usuario:FIM");
		DaoUsuario daoUsuario = new DaoUsuarioImp();
		Usuario usuario = new Usuario();
		usuario.setNomeUsuario("Bianca");
		
		
		
		
		
		System.out.println("1------------------------------Testando a classe usuario:INICIO");
		//////////////////////////////////////////////
		
		System.out.println("1------------------------------Testando a classe face:INICIO");
		DaoFace df = new DaoFaceImp();
		Face face = new Face();
		face.setNomeFace("direito");
		if(df.cadastrarFace(face)){
			System.out.println("Face cadastrada");
		}else{
			System.out.println("Cadastro da face falhou");
		}
		List<Face> faces = df.pesquisarTodosFace();
		if (faces != null){
			for(Face f : faces){
				System.out.println("Listagem de face: Codigo: "+ f.getCodigoFace() + " Nome: "+ f.getNomeFace());
			}	
		}else{
			System.out.println("Faces vieram NULL da consulta");
		}
		System.out.println("1------------------------------Testando a classe face:FIM");
		//////////////////////////////////////////////
		System.out.println("1------------------------------Testando a classe elemento:INICIO");
		DaoElemento daoElemento = new DaoElementoImp();
		Elemento elemento = new Elemento();
		elemento.setNomeElemento("21");
		if(daoElemento.cadastrarElemento(elemento)){
			System.out.println("Elemento cadastrado");
		}else{
			System.out.println("Cadastro de elemento falhou");
		}
		List<Elemento> elementos = daoElemento.pesquisarTodosElemento();
		if (elementos != null){
			for(Elemento el:elementos){
				System.out.println("Listagem de face: Codigo: "+ el.getCodigoElemento() + " Nome: "+ el.getNomeElemento());
			}
		}
		System.out.println("1------------------------------Testando a classe elemento:FIM");
		
		System.out.println("1------------------------------Testando a classe pagamento:INICIO");
		DaoPagamento daoPagamento = new DaoPagamentoImp();
		Pagamento pagamento = new Pagamento();
		pagamento.setNumeroParcela(10);
		pagamento.setValorParcela(100);
		pagamento.setStatusPagamento("PENDENTE");
		
		
		if(daoPagamento.cadastrarPagamento(pagamento)){
			System.out.println("Pagamento cadastrado");
		}else{
			System.out.println("Cadastro de pagamento falhou");
		}
		List<Pagamento> pagamentos = daoPagamento.pesquisarTodosPagamento();
		if (pagamentos != null){
			for(Pagamento pag:pagamentos){
				System.out.println("Listagem de pagamento: Codigo: "+ pag.getCodigoPagamento() + " N. pacelas: "+ pag.getNumeroParcela()
						+ " Valor parcelas: " + pag.getValorParcela() + " Status: " + pag.getStatusPagamento());
			}
		}
		System.out.println("1------------------------------Testando a classe pagamento:FIM");
			
	
		
	}

}
