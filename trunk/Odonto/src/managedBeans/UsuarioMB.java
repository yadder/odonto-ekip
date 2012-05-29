package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import modelo.Usuario;
import persistencia.DaoUsuario;
import persistencia.DaoUsuarioImp;

public class UsuarioMB {

	private DaoUsuario dao = new DaoUsuarioImp();
	private Usuario usuario;
	private ListDataModel usuarios; 
	
	public UsuarioMB(){
		usuario = new Usuario();
		usuarios = resgatarUsuarios();
	}
	
	private ListDataModel resgatarUsuarios(){
		return new ListDataModel(dao.pesquisarTodosUsuario());
	}
	
	public Integer getSizeUsuarios(){
		return this.usuarios.getRowCount();
	}
	
	public ListDataModel getUsuarios(){
		return this.usuarios;
	}
	
	public String adicionarUsuario(){
		this.limparUsuario();
		return null;
	}
	
	public String alterarUsuario(){
		return null;
	}
	
	public String salvarUsuario(){
		if(usuario.getCodigoUsuario() == 0){
			dao.cadastrarUsuario(usuario);
		}else{
			dao.alterarUsuario(usuario);
		}
		usuarios = resgatarUsuarios();
		this.mostraMensagem(usuario.getCodigoUsuario() + " foi salvo!");
		usuario = new Usuario();
		return null;
	}
	
	public String excluirUsuario(){
		this.mostraMensagem(usuario.getCodigoUsuario() + " foi excluído!");
		dao.excluirUsuario(usuario);
		usuario = new Usuario();
		usuarios = resgatarUsuarios();
		return null;
	}
	
	public String cancelarCadastroUsuario(){
		return null;
	}
	
	private void limparUsuario(){
		usuario = new Usuario();
	}
	
	public void mostraMensagem(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem));
	}
	
	public Usuario getUsuario(){
		return usuario;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}	
}