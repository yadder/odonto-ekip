package persistencia;

import java.util.List;

import modelo.Usuario;

public interface DaoUsuario {

	boolean cadastrarUsuario(Usuario usuario);
	
	boolean alterarUsuario(Usuario usuario);
	
	boolean excluirUsuario(Usuario usuario);
	
	Usuario pesquisarUsuario(Usuario usuario);
	
	Usuario pesquisarUsuarioPorNome(String nome);
	
	Usuario pesquisarUsuarioPorLogin(String login);
	
	List<Usuario> pesquisarTodosUsuario();
}
