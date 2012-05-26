package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "tb_odontograma")
public class Odontograma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_odontograma", nullable = false)
    private long codigoOdontograma;
    @Column(name = "valor_odontograma", nullable = false)
    private double valorOdontograma;
    @Column(name = "data_odontograma", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataOdontograma;
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

    public Odontograma(long codigoOdontograma) {
        this.codigoOdontograma = codigoOdontograma;
    }

    public Odontograma(long codigoOdontograma, double valorOdontograma, Date dataOdontograma, String statusOdontograma) {
        this.codigoOdontograma = codigoOdontograma;
        this.valorOdontograma = valorOdontograma;
        this.dataOdontograma = dataOdontograma;
        this.statusOdontograma = statusOdontograma;
    }

    public long getCodigoOdontograma() {
        return codigoOdontograma;
    }

    public void setCodigoOdontograma(long codigoOdontograma) {
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
    public String toString() {
        return "odonto.Odontograma[ codigoOdontograma=" + codigoOdontograma + " ]";
    }
    
}
