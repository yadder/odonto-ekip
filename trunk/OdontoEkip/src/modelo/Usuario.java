package modelo;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="usuario")
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer codigoUsuario;
	
	@Column(name="nomeUsuario", length=50, nullable=false)
	private String nomeUsuario;
	
	@Column(name="loginUsuario", length=50, nullable=false)
	private String loginUsuario;
	
	@Column(name="senhaUsuario",length=50, nullable=false)
	private String senhaUsuario;
	
	@Column(name="perfilUsuario",length=50, nullable=false)
	private String perfilUsuario;
	
	@Column(name="rgUsuario", length=30)
	private String rgUsuario;
	
	@Column(name="cpfUsuario", length=11)
	private String cpfUsuario;
	
	@Column(name="dataNascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(name="sexoUsuario", columnDefinition="enum ('m','f')",nullable=false)
	private String sexoUsuario;
	
	@Column(name="tipoUsuario", columnDefinition="enum ('admin','comum')",nullable=false)
	private String tipoUsuario;
	

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

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
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
