package teste;

import javax.servlet.http.HttpSession;

import modelo.Usuario;
import persistencia.DaoUsuario;
import persistencia.DaoUsuario;

public class TesteLogin {

	public static void main(String[] args) {
		String cpf = "123.451.234-51";
		String senha = "12345";
		
		Usuario usuarioLogado = new Usuario(cpf, senha);
		DaoUsuario dao = new DaoUsuario();
		usuarioLogado = dao.pesquisarUsuarioPorCpf(cpf);
		if (usuarioLogado!= null){
			System.out.println("Nome: "+usuarioLogado.getNomeUsuario()+", Senha: "+usuarioLogado.getSenhaUsuario());
		}else{
			System.out.println("Usuario não encontrado");
		}
	}
}
