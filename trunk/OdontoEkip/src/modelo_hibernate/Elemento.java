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
@Table(name = "tb_elemento", catalog = "odonto", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nome_elemento"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Elemento.findAll", query = "SELECT e FROM Elemento e"),
    @NamedQuery(name = "Elemento.findByCodigoElemento", query = "SELECT e FROM Elemento e WHERE e.codigoElemento = :codigoElemento"),
    @NamedQuery(name = "Elemento.findByNomeElemento", query = "SELECT e FROM Elemento e WHERE e.nomeElemento = :nomeElemento")})
public class Elemento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_elemento", nullable = false)
    private Integer codigoElemento;
    @Basic(optional = false)
    @Column(name = "nome_elemento", nullable = false, length = 2)
    private String nomeElemento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoElemento")
    private List<OdontogramaProcedimento> odontogramaProcedimentoList;

    public Elemento() {
    }

    public Elemento(Integer codigoElemento) {
        this.codigoElemento = codigoElemento;
    }

    public Elemento(Integer codigoElemento, String nomeElemento) {
        this.codigoElemento = codigoElemento;
        this.nomeElemento = nomeElemento;
    }

    public Integer getCodigoElemento() {
        return codigoElemento;
    }

    public void setCodigoElemento(Integer codigoElemento) {
        this.codigoElemento = codigoElemento;
    }

    public String getNomeElemento() {
        return nomeElemento;
    }

    public void setNomeElemento(String nomeElemento) {
        this.nomeElemento = nomeElemento;
    }

    @XmlTransient
    public List<OdontogramaProcedimento> getOdontogramaProcedimentoList() {
        return odontogramaProcedimentoList;
    }

    public void setOdontogramaProcedimentoList(List<OdontogramaProcedimento> odontogramaProcedimentoList) {
        this.odontogramaProcedimentoList = odontogramaProcedimentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoElemento != null ? codigoElemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Elemento)) {
            return false;
        }
        Elemento other = (Elemento) object;
        if ((this.codigoElemento == null && other.codigoElemento != null) || (this.codigoElemento != null && !this.codigoElemento.equals(other.codigoElemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "odonto.Elemento[ codigoElemento=" + codigoElemento + " ]";
    }
    
}
