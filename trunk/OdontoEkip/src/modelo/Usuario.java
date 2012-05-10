package modelo;
import java.util.Date;

public class Usuario {
	private Integer codigoUsuario;
	private String nomeUsuario;
	private String loginUsuario;
	private String senhaUsuario;
	private String perfilUsuario;
	private String rgUsuario;
	private String cpfUsuario;
	private Date dataNascimento;
	private String sexoUsuario;

	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Integer codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(String perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}
	
	public String getRgUsuario() {
		return rgUsuario;
	}

	public void setRgUsuario(String rgUsuario) {
		this.rgUsuario = rgUsuario;
	}

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexoUsurio() {
		return sexoUsuario;
	}

	public void setSexoUsurio(String sexoUsurio) {
		this.sexoUsuario = sexoUsurio;
	}	

	public Usuario() {
	
	}
	
	public Usuario(Integer codigoUsuario, String nomeUsuario,
			String loginUsuario, String senhaUsuario, String perfilUsuario,
			String rgUsuario, String cpfUsuario, Date dataNascimento,
			String sexoUsuario) {
		this.codigoUsuario = codigoUsuario;
		this.nomeUsuario = nomeUsuario;
		this.loginUsuario = loginUsuario;
		this.senhaUsuario = senhaUsuario;
		this.perfilUsuario = perfilUsuario;
		this.rgUsuario = rgUsuario;
		this.cpfUsuario = cpfUsuario;
		this.dataNascimento = dataNascimento;
		this.sexoUsuario = sexoUsuario;
	}

	public Usuario(String loginUsuario){
		this.loginUsuario = loginUsuario;
	}

	
}
