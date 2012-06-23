package modelo;

import java.io.Serializable;
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
@Table(name = "tb_usuario")
@Inheritance(strategy=InheritanceType.JOINED) 
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private long idUsuario;
    @Column(name = "nome_usuario", nullable = false, length = 50)
    private String nomeUsuario;
    @Column(name = "senha_usuario", nullable = false, length = 20)
    private String senhaUsuario;
    @Column(name = "perfil_usuario", nullable = false, length = 20)
    private String perfilUsuario;
    @Column(name = "rg_usuario", length = 20)
    private String rgUsuario;
    @Column(name = "cpf_usuario", nullable = false, length = 14)
    private String cpfUsuario;
    @Column(name = "data_nascimento_usuario")
    @Temporal(TemporalType.DATE)
    private Date dataNascimentoUsuario;
    @Column(name = "sexo_usuario", nullable = false, length = 1)
    private String sexoUsuario;

    public Usuario() {
    }

    public Usuario(String cpf, String senha) {
        this.cpfUsuario = cpf;
        this.senhaUsuario = senha;
    }

    public Usuario(String nomeUsuario, String senhaUsuario, String perfilUsuario, String rgUsuario,
			String cpfUsuario, String sexoUsuario, java.sql.Date dataNascimentoUsuario) {
		this.nomeUsuario = nomeUsuario;
		this.senhaUsuario = senhaUsuario;
		this.perfilUsuario = perfilUsuario;
		this.rgUsuario = rgUsuario;
		this.cpfUsuario = cpfUsuario;
		this.sexoUsuario = sexoUsuario;
		this.dataNascimentoUsuario = dataNascimentoUsuario;
	}
    
    
	public Usuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
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

    public Date getDataNascimentoUsuario() {
        return dataNascimentoUsuario;
    }

    public void setDataNascimentoUsuario(Date dataNascimentoUsuario) {
        this.dataNascimentoUsuario = dataNascimentoUsuario;
    }

    public String getSexoUsuario() {
        return sexoUsuario;
    }

    public void setSexoUsuario(String sexoUsuario) {
        this.sexoUsuario = sexoUsuario;
    }

}
