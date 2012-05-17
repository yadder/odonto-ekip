package modelo_hibernate;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Windows
 */
@Entity
@Table(name = "tb_procedimento", catalog = "odonto", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"descricao_procedimento"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procedimento.findAll", query = "SELECT p FROM Procedimento p"),
    @NamedQuery(name = "Procedimento.findByCodigoProcedimento", query = "SELECT p FROM Procedimento p WHERE p.codigoProcedimento = :codigoProcedimento"),
    @NamedQuery(name = "Procedimento.findByDescricaoProcedimento", query = "SELECT p FROM Procedimento p WHERE p.descricaoProcedimento = :descricaoProcedimento"),
    @NamedQuery(name = "Procedimento.findByValorProcedimento", query = "SELECT p FROM Procedimento p WHERE p.valorProcedimento = :valorProcedimento")})
public class Procedimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_procedimento", nullable = false)
    private Integer codigoProcedimento;
    @Basic(optional = false)
    @Column(name = "descricao_procedimento", nullable = false, length = 50)
    private String descricaoProcedimento;
    @Basic(optional = false)
    @Column(name = "valor_procedimento", nullable = false)
    private double valorProcedimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoProcedimento")
    private List<OdontogramaProcedimento> odontogramaProcedimentoList;
    @JoinColumn(name = "codigo_convenio", referencedColumnName = "codigo_convenio", nullable = false)
    @ManyToOne(optional = false)
    private Convenio codigoConvenio;

    public Procedimento() {
    }

    public Procedimento(Integer codigoProcedimento) {
        this.codigoProcedimento = codigoProcedimento;
    }

    public Procedimento(Integer codigoProcedimento, String descricaoProcedimento, double valorProcedimento) {
        this.codigoProcedimento = codigoProcedimento;
        this.descricaoProcedimento = descricaoProcedimento;
        this.valorProcedimento = valorProcedimento;
    }

    public Integer getCodigoProcedimento() {
        return codigoProcedimento;
    }

    public void setCodigoProcedimento(Integer codigoProcedimento) {
        this.codigoProcedimento = codigoProcedimento;
    }

    public String getDescricaoProcedimento() {
        return descricaoProcedimento;
    }

    public void setDescricaoProcedimento(String descricaoProcedimento) {
        this.descricaoProcedimento = descricaoProcedimento;
    }

    public double getValorProcedimento() {
        return valorProcedimento;
    }

    public void setValorProcedimento(double valorProcedimento) {
        this.valorProcedimento = valorProcedimento;
    }

    @XmlTransient
    public List<OdontogramaProcedimento> getOdontogramaProcedimentoList() {
        return odontogramaProcedimentoList;
    }

    public void setOdontogramaProcedimentoList(List<OdontogramaProcedimento> odontogramaProcedimentoList) {
        this.odontogramaProcedimentoList = odontogramaProcedimentoList;
    }

    public Convenio getCodigoConvenio() {
        return codigoConvenio;
    }

    public void setCodigoConvenio(Convenio codigoConvenio) {
        this.codigoConvenio = codigoConvenio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoProcedimento != null ? codigoProcedimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procedimento)) {
            return false;
        }
        Procedimento other = (Procedimento) object;
        if ((this.codigoProcedimento == null && other.codigoProcedimento != null) || (this.codigoProcedimento != null && !this.codigoProcedimento.equals(other.codigoProcedimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "odonto.Procedimento[ codigoProcedimento=" + codigoProcedimento + " ]";
    }
    
}
