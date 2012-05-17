package modelo_hibernate;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Windows
 */
@Entity
@Table(name = "tb_usuario", catalog = "odonto", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cpf_usuario"}),
    @UniqueConstraint(columnNames = {"login_usuario"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByCodigoUsuario", query = "SELECT u FROM Usuario u WHERE u.codigoUsuario = :codigoUsuario"),
    @NamedQuery(name = "Usuario.findByNomeUsuario", query = "SELECT u FROM Usuario u WHERE u.nomeUsuario = :nomeUsuario"),
    @NamedQuery(name = "Usuario.findByLoginUsuario", query = "SELECT u FROM Usuario u WHERE u.loginUsuario = :loginUsuario"),
    @NamedQuery(name = "Usuario.findBySenhaUsuario", query = "SELECT u FROM Usuario u WHERE u.senhaUsuario = :senhaUsuario"),
    @NamedQuery(name = "Usuario.findByPerfilUsuario", query = "SELECT u FROM Usuario u WHERE u.perfilUsuario = :perfilUsuario"),
    @NamedQuery(name = "Usuario.findByRgUsuario", query = "SELECT u FROM Usuario u WHERE u.rgUsuario = :rgUsuario"),
    @NamedQuery(name = "Usuario.findByCpfUsuario", query = "SELECT u FROM Usuario u WHERE u.cpfUsuario = :cpfUsuario"),
    @NamedQuery(name = "Usuario.findByDataNascimentoUsuario", query = "SELECT u FROM Usuario u WHERE u.dataNascimentoUsuario = :dataNascimentoUsuario"),
    @NamedQuery(name = "Usuario.findBySexoUsuario", query = "SELECT u FROM Usuario u WHERE u.sexoUsuario = :sexoUsuario")})
@Inheritance(strategy=InheritanceType.JOINED) 
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_usuario", nullable = false)
    private Integer codigoUsuario;
    @Basic(optional = false)
    @Column(name = "nome_usuario", nullable = false, length = 50)
    private String nomeUsuario;
    @Basic(optional = false)
    @Column(name = "login_usuario", nullable = false, length = 20)
    private String loginUsuario;
    @Basic(optional = false)
    @Column(name = "senha_usuario", nullable = false, length = 20)
    private String senhaUsuario;
    @Basic(optional = false)
    @Column(name = "perfil_usuario", nullable = false, length = 20)
    private String perfilUsuario;
    @Column(name = "rg_usuario", length = 20)
    private String rgUsuario;
    @Basic(optional = false)
    @Column(name = "cpf_usuario", nullable = false, length = 14)
    private String cpfUsuario;
    @Column(name = "data_nascimento_usuario")
    @Temporal(TemporalType.DATE)
    private Date dataNascimentoUsuario;
    @Basic(optional = false)
    @Column(name = "sexo_usuario", nullable = false, length = 1)
    private String sexoUsuario;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Dentista dentista;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Paciente paciente;

    public Usuario() {
    }

    public Usuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Usuario(Integer codigoUsuario, String nomeUsuario, String loginUsuario, String senhaUsuario, String perfilUsuario, String cpfUsuario, String sexoUsuario) {
        this.codigoUsuario = codigoUsuario;
        this.nomeUsuario = nomeUsuario;
        this.loginUsuario = loginUsuario;
        this.senhaUsuario = senhaUsuario;
        this.perfilUsuario = perfilUsuario;
        this.cpfUsuario = cpfUsuario;
        this.sexoUsuario = sexoUsuario;
    }

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
    public int hashCode() {
        int hash = 0;
        hash += (codigoUsuario != null ? codigoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codigoUsuario == null && other.codigoUsuario != null) || (this.codigoUsuario != null && !this.codigoUsuario.equals(other.codigoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "odonto.Usuario[ codigoUsuario=" + codigoUsuario + " ]";
    }
    
}
