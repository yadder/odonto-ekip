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
@Table(name = "tb_consulta", catalog = "odonto", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consulta.findAll", query = "SELECT c FROM Consulta c"),
    @NamedQuery(name = "Consulta.findByCodigoConsulta", query = "SELECT c FROM Consulta c WHERE c.codigoConsulta = :codigoConsulta"),
    @NamedQuery(name = "Consulta.findByDataConsulta", query = "SELECT c FROM Consulta c WHERE c.dataConsulta = :dataConsulta"),
    @NamedQuery(name = "Consulta.findByStatusConsulta", query = "SELECT c FROM Consulta c WHERE c.statusConsulta = :statusConsulta")})
public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_consulta", nullable = false)
    private Integer codigoConsulta;
    @Basic(optional = false)
    @Column(name = "data_consulta", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataConsulta;
    @Basic(optional = false)
    @Column(name = "status_consulta", nullable = false, length = 20)
    private String statusConsulta;
    @JoinColumn(name = "codigo_paciente", referencedColumnName = "codigo_paciente", nullable = false)
    @ManyToOne(optional = false)
    private Paciente codigoPaciente;
    @JoinColumn(name = "codigo_dentista", referencedColumnName = "codigo_dentista", nullable = false)
    @ManyToOne(optional = false)
    private Dentista codigoDentista;

    public Consulta() {
    }

    public Consulta(Integer codigoConsulta) {
        this.codigoConsulta = codigoConsulta;
    }

    public Consulta(Integer codigoConsulta, Date dataConsulta, String statusConsulta) {
        this.codigoConsulta = codigoConsulta;
        this.dataConsulta = dataConsulta;
        this.statusConsulta = statusConsulta;
    }

    public Integer getCodigoConsulta() {
        return codigoConsulta;
    }

    public void setCodigoConsulta(Integer codigoConsulta) {
        this.codigoConsulta = codigoConsulta;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(String statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public Paciente getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(Paciente codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public Dentista getCodigoDentista() {
        return codigoDentista;
    }

    public void setCodigoDentista(Dentista codigoDentista) {
        this.codigoDentista = codigoDentista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoConsulta != null ? codigoConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.codigoConsulta == null && other.codigoConsulta != null) || (this.codigoConsulta != null && !this.codigoConsulta.equals(other.codigoConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "odonto.Consulta[ codigoConsulta=" + codigoConsulta + " ]";
    }
    
}
