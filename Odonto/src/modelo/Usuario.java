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
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Dentista dentista;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Paciente paciente;

    public Usuario() {
    }

    public Usuario(long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Usuario(long codigoUsuario, String nomeUsuario, String loginUsuario, String senhaUsuario, String perfilUsuario, String cpfUsuario, String sexoUsuario) {
        this.codigoUsuario = codigoUsuario;
        this.nomeUsuario = nomeUsuario;
        this.loginUsuario = loginUsuario;
        this.senhaUsuario = senhaUsuario;
        this.perfilUsuario = perfilUsuario;
        this.cpfUsuario = cpfUsuario;
        this.sexoUsuario = sexoUsuario;
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

    @Override
    public String toString() {
        return "odonto.Usuario[ codigoUsuario=" + codigoUsuario + " ]";
    }
    
}