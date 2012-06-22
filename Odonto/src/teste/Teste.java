package teste;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import modelo.Usuario;
import persistencia.DaoUsuario;
import persistencia.DaoUsuarioImp;

public class Teste {

	public static void main(String[] args) {
		
/*
		System.out.println("1------------------------------Testando a classe face (pesquisa por nome: INICIO");
		//busca por nome
		Face face= new Face("distal");
		DaoFace daoFace = new DaoFaceImp();
		face = daoFace.pesquisarFacePorNome("face1");
		if (face != null){
			System.out.println("Face encontrada: codigo: "+ face.getCodigoFace() + " Nome: "+ face.getNomeFace());
		}else{
			System.out.println("ERRO: Face veio NULL da consulta");
		}
		//alteracao
		face.setNomeFace("face12345");
		boolean result = daoFace.alterarFace(face);
		if (result){
			System.out.println("Alterado com sucesso");
		}else{
			System.out.println("ERRO: Não alterado");
		}
/*		//exclusao
		boolean result = daoFace.excluirFace(face);
		if (result){
			System.out.println("Excluído com sucesso");
		}else{
			System.out.println("ERRO: Não excluído");
		}
		//////////////////////////////////////////////
		
		*/
		
		try{
			System.out.println("--- CADASTRO DE USUARIO ---");
			Usuario usuario = new Usuario();
			usuario.setNomeUsuario("JOSUE");
			usuario.setSenhaUsuario("JOSUE");
			usuario.setPerfilUsuario("PACIENTE");
			usuario.setRgUsuario("123456");
			usuario.setCpfUsuario("JOSUE");
			
			// PARA GRAVAR NO BANCO
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
	        java.util.Date dataUtil = df.parse("19/12/1982");  
	        // converter de java.util.Date para java.sql.Date  
	        java.sql.Date dataJDBC = new java.sql.Date(dataUtil.getTime());  
			usuario.setDataNascimentoUsuario(dataJDBC);
			usuario.setSexoUsuario("M");
			//////////////////////////////
			DaoUsuario daoUsuario = new DaoUsuarioImp();
			daoUsuario.cadastrarUsuario(usuario);
			System.out.println("USUARIO CADASTRADO COM SUCESSO");
			
			usuario = null;
			usuario = daoUsuario.pesquisarUsuarioPorCpf("JOSUE");
			if (usuario != null){
				System.out.println("DATA NASC USUARIO: "+usuario.getDataNascimentoUsuario());
				//trazendo do banco
				SimpleDateFormat iso = new SimpleDateFormat("dd/MM/yyyy");  
		        String dataISO = iso.format(usuario.getDataNascimentoUsuario());  
				System.out.println("DATA FORMATADA: "+dataISO);
		        /////////////////////
			}
		}catch(Exception ex_cad_usuario){
			ex_cad_usuario.printStackTrace();
		}
		//////////////////////////////////////////////
		
		
		/*usuario = daoUsuario.pesquisarUsuarioPorLogin("josue");
		if (usuario != null){
			System.out.println("Usuario encontrado: Login: "+ usuario.getLoginUsuario() + " Senha: "+ usuario.getSenhaUsuario());
		}else{
			System.out.println("Usuario veio NULL da consulta");
		}
		
		
		//////////////////////////////////////////////
		
/*		
		
		
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
			
	
*/		
	}

}
