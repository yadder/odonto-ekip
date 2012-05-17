package modelo_hibernate;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Windows
 */
@Entity
@Table(name = "tb_odontograma", catalog = "odonto", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Odontograma.findAll", query = "SELECT o FROM Odontograma o"),
    @NamedQuery(name = "Odontograma.findByCodigoOdontograma", query = "SELECT o FROM Odontograma o WHERE o.codigoOdontograma = :codigoOdontograma"),
    @NamedQuery(name = "Odontograma.findByValorOdontograma", query = "SELECT o FROM Odontograma o WHERE o.valorOdontograma = :valorOdontograma"),
    @NamedQuery(name = "Odontograma.findByDataOdontograma", query = "SELECT o FROM Odontograma o WHERE o.dataOdontograma = :dataOdontograma"),
    @NamedQuery(name = "Odontograma.findByStatusOdontograma", query = "SELECT o FROM Odontograma o WHERE o.statusOdontograma = :statusOdontograma")})
public class Odontograma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_odontograma", nullable = false)
    private Integer codigoOdontograma;
    @Basic(optional = false)
    @Column(name = "valor_odontograma", nullable = false)
    private double valorOdontograma;
    @Basic(optional = false)
    @Column(name = "data_odontograma", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataOdontograma;
    @Basic(optional = false)
    @Column(name = "status_odontograma", nullable = false, length = 20)
    private String statusOdontograma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoOdontograma")
    private List<OdontogramaProcedimento> odontogramaProcedimentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoOdontograma")
    private List<Prescricao> prescricaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoOdontograma")
    private List<Pagamento> pagamentoList;
    @JoinColumn(name = "codigo_dentista", referencedColumnName = "codigo_dentista", nullable = false)
    @ManyToOne(optional = false)
    private Dentista codigoDentista;
    @JoinColumn(name = "codigo_paciente", referencedColumnName = "codigo_paciente", nullable = false)
    @ManyToOne(optional = false)
    private Paciente codigoPaciente;

    public Odontograma() {
    }

    public Odontograma(Integer codigoOdontograma) {
        this.codigoOdontograma = codigoOdontograma;
    }

    public Odontograma(Integer codigoOdontograma, double valorOdontograma, Date dataOdontograma, String statusOdontograma) {
        this.codigoOdontograma = codigoOdontograma;
        this.valorOdontograma = valorOdontograma;
        this.dataOdontograma = dataOdontograma;
        this.statusOdontograma = statusOdontograma;
    }

    public Integer getCodigoOdontograma() {
        return codigoOdontograma;
    }

    public void setCodigoOdontograma(Integer codigoOdontograma) {
        this.codigoOdontograma = codigoOdontograma;
    }

    public double getValorOdontograma() {
        return valorOdontograma;
    }

    public void setValorOdontograma(double valorOdontograma) {
        this.valorOdontograma = valorOdontograma;
    }

    public Date getDataOdontograma() {
        return dataOdontograma;
    }

    public void setDataOdontograma(Date dataOdontograma) {
        this.dataOdontograma = dataOdontograma;
    }

    public String getStatusOdontograma() {
        return statusOdontograma;
    }

    public void setStatusOdontograma(String statusOdontograma) {
        this.statusOdontograma = statusOdontograma;
    }

    @XmlTransient
    public List<OdontogramaProcedimento> getOdontogramaProcedimentoList() {
        return odontogramaProcedimentoList;
    }

    public void setOdontogramaProcedimentoList(List<OdontogramaProcedimento> odontogramaProcedimentoList) {
        this.odontogramaProcedimentoList = odontogramaProcedimentoList;
    }

    @XmlTransient
    public List<Prescricao> getPrescricaoList() {
        return prescricaoList;
    }

    public void setPrescricaoList(List<Prescricao> prescricaoList) {
        this.prescricaoList = prescricaoList;
    }

    @XmlTransient
    public List<Pagamento> getPagamentoList() {
        return pagamentoList;
    }

    public void setPagamentoList(List<Pagamento> pagamentoList) {
        this.pagamentoList = pagamentoList;
    }

    public Dentista getCodigoDentista() {
        return codigoDentista;
    }

    public void setCodigoDentista(Dentista codigoDentista) {
        this.codigoDentista = codigoDentista;
    }

    public Paciente getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(Paciente codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoOdontograma != null ? codigoOdontograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Odontograma)) {
            return false;
        }
        Odontograma other = (Odontograma) object;
        if ((this.codigoOdontograma == null && other.codigoOdontograma != null) || (this.codigoOdontograma != null && !this.codigoOdontograma.equals(other.codigoOdontograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "odonto.Odontograma[ codigoOdontograma=" + codigoOdontograma + " ]";
    }
    
}
