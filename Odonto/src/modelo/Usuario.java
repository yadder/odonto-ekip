package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "tb_usuario")
@Inheritance(strategy=InheritanceType.JOINED) 
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_usuario", nullable = false)
    private long codigoUsuario;
    @Column(name = "nome_usuario", nullable = false, length = 50)
    private String nomeUsuario;
    @Column(name = "login_usuario", nullable = false, length = 20)
    private String loginUsuario;
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

    public Usuario(String login, String senha) {
        this.loginUsuario = login;
        this.senhaUsuario = senha;
    }

    public long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(long codigoUsuario) {
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

    @Override
    public String toString() {
        return 
        		" Nome: " +getNomeUsuario()+
        		" Login: " +getLoginUsuario()+
        		" Senha: " +getSenhaUsuario();
    }
    
}
