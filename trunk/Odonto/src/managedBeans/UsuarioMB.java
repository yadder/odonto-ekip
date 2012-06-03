package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import modelo.Dentista;
import modelo.Paciente;
import modelo.Usuario;
import persistencia.DaoDentista;
import persistencia.DaoDentistaImp;
import persistencia.DaoPaciente;
import persistencia.DaoPacienteImp;
import persistencia.DaoUsuario;
import persistencia.DaoUsuarioImp;

public class UsuarioMB {

	private DaoUsuario daoUsuario = new DaoUsuarioImp();
	private DaoDentista daoDentista = new DaoDentistaImp();
	private DaoPaciente daoPaciente = new DaoPacienteImp();
	private Usuario usuario;
	private Dentista dentista;
	private Paciente paciente;
	private ListDataModel usuarios;
	private ListDataModel dentistas;
	private ListDataModel pacientes;
	 
	
	public UsuarioMB(){
		usuario = new Usuario();
		dentista = new Dentista();
		paciente = new Paciente();
		usuarios = resgatarUsuarios();		
	}
	
	private ListDataModel resgatarUsuarios(){
		return new ListDataModel(daoUsuario.pesquisarTodosUsuario());
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
	
	public boolean validarCampos(){
		Boolean result = false;
		if ((usuario.getNomeUsuario().equals(""))||(usuario.getNomeUsuario()==null)||(usuario.getNomeUsuario().length()<3)){
			this.mostraMensagem("Erro: Nome de usuário inválido");
			return result;
		}else if ((usuario.getLoginUsuario().equals(""))||(usuario.getLoginUsuario()==null)||(usuario.getLoginUsuario().length()<3)){
			this.mostraMensagem("Erro: Login do usuário inválido");
			return result;
		}else if ((usuario.getSenhaUsuario().equals(""))||(usuario.getSenhaUsuario()==null)||(usuario.getSenhaUsuario().length()<3)){
			this.mostraMensagem("Erro: Senha do usuário inválido");
			return result;
		}else if ((usuario.getRgUsuario().equals(""))||(usuario.getRgUsuario()==null)||(usuario.getRgUsuario().length()<3)){
			this.mostraMensagem("Erro: RG do usuário inválido");
			return result;
		}else if ((usuario.getCpfUsuario().equals(""))||(usuario.getCpfUsuario()==null)||(usuario.getCpfUsuario().length()<3)){
			this.mostraMensagem("Erro: CPF do usuário inválido");
			return result;
		}else if ((usuario.getDataNascimentoUsuario().equals(""))||(usuario.getDataNascimentoUsuario()==null)){
			this.mostraMensagem("Erro: Data de nascimento do usuário inválido");
			return result;
		}else if ((usuario.getSexoUsuario().equals(""))||(usuario.getSexoUsuario()==null)||(usuario.getSexoUsuario().length()<3)){
			this.mostraMensagem("Erro: Sexo do usuário inválido");
			return result;
		}else if ((usuario.getPerfilUsuario().equals(""))||(usuario.getPerfilUsuario()==null)||(usuario.getPerfilUsuario().length()<3)){
			this.mostraMensagem("Erro: Perfil de usuário inválido");
			return result;
		}else{
			result = true;
		}
		return result;
	}
	public String salvarUsuario(){
		if ((validarCampos()) && (usuario.getCodigoUsuario() == 0)){
			daoUsuario.cadastrarUsuario(usuario);
		}else{
			daoUsuario.alterarUsuario(usuario);
		}
		usuarios = resgatarUsuarios();
		this.mostraMensagem(usuario.getCodigoUsuario() + " foi salvo!");
		usuario = new Usuario();
		return null;
	}
	
	public String excluirUsuario(){
		this.mostraMensagem(usuario.getCodigoUsuario() + " foi excluído!");
		daoUsuario.excluirUsuario(usuario);
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

	public DaoUsuario getDaoUsuario() {
		return daoUsuario;
	}

	public void setDaoUsuario(DaoUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	public DaoDentista getDaoDentista() {
		return daoDentista;
	}

	public void setDaoDentista(DaoDentista daoDentista) {
		this.daoDentista = daoDentista;
	}

	public DaoPaciente getDaoPaciente() {
		return daoPaciente;
	}

	public void setDaoPaciente(DaoPaciente daoPaciente) {
		this.daoPaciente = daoPaciente;
	}

	public Dentista getDentista() {
		return dentista;
	}

	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public ListDataModel getDentistas() {
		return dentistas;
	}

	public void setDentistas(ListDataModel dentistas) {
		this.dentistas = dentistas;
	}

	public ListDataModel getPacientes() {
		return pacientes;
	}

	public void setPacientes(ListDataModel pacientes) {
		this.pacientes = pacientes;
	}

	public void setUsuarios(ListDataModel usuarios) {
		this.usuarios = usuarios;
	}	
	
	
}