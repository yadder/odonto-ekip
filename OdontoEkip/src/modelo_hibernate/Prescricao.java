package modelo_hibernate;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Windows
 */
@Entity
@Table(name = "tb_prescricao", catalog = "odonto", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prescricao.findAll", query = "SELECT p FROM Prescricao p"),
    @NamedQuery(name = "Prescricao.findByCodigoPrescricao", query = "SELECT p FROM Prescricao p WHERE p.codigoPrescricao = :codigoPrescricao"),
    @NamedQuery(name = "Prescricao.findByObservacao", query = "SELECT p FROM Prescricao p WHERE p.observacao = :observacao")})
public class Prescricao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_prescricao", nullable = false)
    private Integer codigoPrescricao;
    @Basic(optional = false)
    @Column(name = "observacao", nullable = false, length = 255)
    private String observacao;
    @JoinColumn(name = "codigo_odontograma", referencedColumnName = "codigo_odontograma", nullable = false)
    @ManyToOne(optional = false)
    private Odontograma codigoOdontograma;
    @JoinColumn(name = "codigo_dentista", referencedColumnName = "codigo_dentista", nullable = false)
    @ManyToOne(optional = false)
    private Dentista codigoDentista;

    public Prescricao() {
    }

    public Prescricao(Integer codigoPrescricao) {
        this.codigoPrescricao = codigoPrescricao;
    }

    public Prescricao(Integer codigoPrescricao, String observacao) {
        this.codigoPrescricao = codigoPrescricao;
        this.observacao = observacao;
    }

    public Integer getCodigoPrescricao() {
        return codigoPrescricao;
    }

    public void setCodigoPrescricao(Integer codigoPrescricao) {
        this.codigoPrescricao = codigoPrescricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Odontograma getCodigoOdontograma() {
        return codigoOdontograma;
    }

    public void setCodigoOdontograma(Odontograma codigoOdontograma) {
        this.codigoOdontograma = codigoOdontograma;
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
        hash += (codigoPrescricao != null ? codigoPrescricao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prescricao)) {
            return false;
        }
        Prescricao other = (Prescricao) object;
        if ((this.codigoPrescricao == null && other.codigoPrescricao != null) || (this.codigoPrescricao != null && !this.codigoPrescricao.equals(other.codigoPrescricao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "odonto.Prescricao[ codigoPrescricao=" + codigoPrescricao + " ]";
    }
    
}
