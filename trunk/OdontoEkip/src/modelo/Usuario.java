package modelo;

public class Usuario {
	
	private Integer codigoUsuario;
	
	private String nomeUsuario;
	
	private String loginUsuario;
	
	private String senhaUsuario;
	
	private String perfilUsuario;

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
	
	public Usuario() {
	
	}

	public Usuario(Integer codigoUsuario, String nomeUsuario,
			String loginUsuario, String senhaUsuario, String perfilUsuario) {
		this.codigoUsuario = codigoUsuario;
		this.nomeUsuario = nomeUsuario;
		this.loginUsuario = loginUsuario;
		this.senhaUsuario = senhaUsuario;
		this.perfilUsuario = perfilUsuario;
	}
	
	
}
