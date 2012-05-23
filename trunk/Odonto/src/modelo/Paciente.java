package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "tb_paciente")
@PrimaryKeyJoinColumn(name="codigoUsuario")
public class Paciente extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "responsavel_paciente", length = 50)
    private String responsavelPaciente;
    @Column(name = "logradouro_paciente", length = 100)
    private String logradouroPaciente;
    @Column(name = "numero_logradouro_paciente")
    private Integer numeroLogradouroPaciente;
    @Column(name = "complemento_logradouro_paciente", length = 50)
    private String complementoLogradouroPaciente;
    @Column(name = "bairro_paciente", length = 30)
    private String bairroPaciente;
    @Column(name = "cidade_paciente", length = 30)
    private String cidadePaciente;
    @Column(name = "estado_paciente", length = 30)
    private String estadoPaciente;
    @Column(name = "cep_paciente", length = 10)
    private String cepPaciente;
    @Column(name = "codigo_paciente", nullable = false)
    private Integer codigoPaciente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoPaciente")
    private List<TelefonePaciente> telefonePacienteList;
    @JoinColumn(name = "codigo_paciente", referencedColumnName = "codigo_usuario", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "codigo_convenio", referencedColumnName = "codigo_convenio", nullable = false)
    @ManyToOne(optional = false)
    private Convenio codigoConvenio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoPaciente")
    private List<Odontograma> odontogramaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoPaciente")
    private List<InqueritoOdontologico> inqueritoOdontologicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoPaciente")
    private List<Consulta> consultaList;

    public Paciente() {
    }

    public Paciente(Integer codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public String getResponsavelPaciente() {
        return responsavelPaciente;
    }

    public void setResponsavelPaciente(String responsavelPaciente) {
        this.responsavelPaciente = responsavelPaciente;
    }

    public String getLogradouroPaciente() {
        return logradouroPaciente;
    }

    public void setLogradouroPaciente(String logradouroPaciente) {
        this.logradouroPaciente = logradouroPaciente;
    }

    public Integer getNumeroLogradouroPaciente() {
        return numeroLogradouroPaciente;
    }

    public void setNumeroLogradouroPaciente(Integer numeroLogradouroPaciente) {
        this.numeroLogradouroPaciente = numeroLogradouroPaciente;
    }

    public String getComplementoLogradouroPaciente() {
        return complementoLogradouroPaciente;
    }

    public void setComplementoLogradouroPaciente(String complementoLogradouroPaciente) {
        this.complementoLogradouroPaciente = complementoLogradouroPaciente;
    }

    public String getBairroPaciente() {
        return bairroPaciente;
    }

    public void setBairroPaciente(String bairroPaciente) {
        this.bairroPaciente = bairroPaciente;
    }

    public String getCidadePaciente() {
        return cidadePaciente;
    }

    public void setCidadePaciente(String cidadePaciente) {
        this.cidadePaciente = cidadePaciente;
    }

    public String getEstadoPaciente() {
        return estadoPaciente;
    }

    public void setEstadoPaciente(String estadoPaciente) {
        this.estadoPaciente = estadoPaciente;
    }

    public String getCepPaciente() {
        return cepPaciente;
    }

    public void setCepPaciente(String cepPaciente) {
        this.cepPaciente = cepPaciente;
    }

    public Integer getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(Integer codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    @XmlTransient
    public List<TelefonePaciente> getTelefonePacienteList() {
        return telefonePacienteList;
    }

    public void setTelefonePacienteList(List<TelefonePaciente> telefonePacienteList) {
        this.telefonePacienteList = telefonePacienteList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Convenio getCodigoConvenio() {
        return codigoConvenio;
    }

    public void setCodigoConvenio(Convenio codigoConvenio) {
        this.codigoConvenio = codigoConvenio;
    }

    @XmlTransient
    public List<Odontograma> getOdontogramaList() {
        return odontogramaList;
    }

    public void setOdontogramaList(List<Odontograma> odontogramaList) {
        this.odontogramaList = odontogramaList;
    }

    @XmlTransient
    public List<InqueritoOdontologico> getInqueritoOdontologicoList() {
        return inqueritoOdontologicoList;
    }

    public void setInqueritoOdontologicoList(List<InqueritoOdontologico> inqueritoOdontologicoList) {
        this.inqueritoOdontologicoList = inqueritoOdontologicoList;
    }

    @XmlTransient
    public List<Consulta> getConsultaList() {
        return consultaList;
    }

    public void setConsultaList(List<Consulta> consultaList) {
        this.consultaList = consultaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPaciente != null ? codigoPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.codigoPaciente == null && other.codigoPaciente != null) || (this.codigoPaciente != null && !this.codigoPaciente.equals(other.codigoPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "odonto.Paciente[ codigoPaciente=" + codigoPaciente + " ]";
    }
    
}
