package modelo_hibernate;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Windows
 */
@Entity
@Table(name = "tb_telefone_fornecedor", catalog = "odonto", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"telefone_fornecedor"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelefoneFornecedor.findAll", query = "SELECT t FROM TelefoneFornecedor t"),
    @NamedQuery(name = "TelefoneFornecedor.findByCodigoTelefone", query = "SELECT t FROM TelefoneFornecedor t WHERE t.codigoTelefone = :codigoTelefone"),
    @NamedQuery(name = "TelefoneFornecedor.findByDddTelefoneFornecedor", query = "SELECT t FROM TelefoneFornecedor t WHERE t.dddTelefoneFornecedor = :dddTelefoneFornecedor"),
    @NamedQuery(name = "TelefoneFornecedor.findByTelefoneFornecedor", query = "SELECT t FROM TelefoneFornecedor t WHERE t.telefoneFornecedor = :telefoneFornecedor")})
public class TelefoneFornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_telefone", nullable = false)
    private Integer codigoTelefone;
    @Basic(optional = false)
    @Column(name = "ddd_telefone_fornecedor", nullable = false, length = 2)
    private String dddTelefoneFornecedor;
    @Basic(optional = false)
    @Column(name = "telefone_fornecedor", nullable = false, length = 9)
    private String telefoneFornecedor;
    @JoinColumn(name = "codigo_fornecedor", referencedColumnName = "codigo_fornecedor", nullable = false)
    @ManyToOne(optional = false)
    private Fornecedor codigoFornecedor;

    public TelefoneFornecedor() {
    }

    public TelefoneFornecedor(Integer codigoTelefone) {
        this.codigoTelefone = codigoTelefone;
    }

    public TelefoneFornecedor(Integer codigoTelefone, String dddTelefoneFornecedor, String telefoneFornecedor) {
        this.codigoTelefone = codigoTelefone;
        this.dddTelefoneFornecedor = dddTelefoneFornecedor;
        this.telefoneFornecedor = telefoneFornecedor;
    }

    public Integer getCodigoTelefone() {
        return codigoTelefone;
    }

    public void setCodigoTelefone(Integer codigoTelefone) {
        this.codigoTelefone = codigoTelefone;
    }

    public String getDddTelefoneFornecedor() {
        return dddTelefoneFornecedor;
    }

    public void setDddTelefoneFornecedor(String dddTelefoneFornecedor) {
        this.dddTelefoneFornecedor = dddTelefoneFornecedor;
    }

    public String getTelefoneFornecedor() {
        return telefoneFornecedor;
    }

    public void setTelefoneFornecedor(String telefoneFornecedor) {
        this.telefoneFornecedor = telefoneFornecedor;
    }

    public Fornecedor getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public void setCodigoFornecedor(Fornecedor codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTelefone != null ? codigoTelefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefoneFornecedor)) {
            return false;
        }
        TelefoneFornecedor other = (TelefoneFornecedor) object;
        if ((this.codigoTelefone == null && other.codigoTelefone != null) || (this.codigoTelefone != null && !this.codigoTelefone.equals(other.codigoTelefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "odonto.TelefoneFornecedor[ codigoTelefone=" + codigoTelefone + " ]";
    }
    
}
