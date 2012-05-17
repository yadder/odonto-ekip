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
@Table(name = "tb_fornecedor", catalog = "odonto", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cnpj_fornecedor"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.findByCodigoFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.codigoFornecedor = :codigoFornecedor"),
    @NamedQuery(name = "Fornecedor.findBySiteFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.siteFornecedor = :siteFornecedor"),
    @NamedQuery(name = "Fornecedor.findByCnpjFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.cnpjFornecedor = :cnpjFornecedor"),
    @NamedQuery(name = "Fornecedor.findByNomeFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.nomeFornecedor = :nomeFornecedor"),
    @NamedQuery(name = "Fornecedor.findByNomeVendedor", query = "SELECT f FROM Fornecedor f WHERE f.nomeVendedor = :nomeVendedor"),
    @NamedQuery(name = "Fornecedor.findByEmailVendedor", query = "SELECT f FROM Fornecedor f WHERE f.emailVendedor = :emailVendedor"),
    @NamedQuery(name = "Fornecedor.findByLogradouroFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.logradouroFornecedor = :logradouroFornecedor"),
    @NamedQuery(name = "Fornecedor.findByNumeroLogradouroFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.numeroLogradouroFornecedor = :numeroLogradouroFornecedor"),
    @NamedQuery(name = "Fornecedor.findByComplementoLogradouroFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.complementoLogradouroFornecedor = :complementoLogradouroFornecedor"),
    @NamedQuery(name = "Fornecedor.findByBairroFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.bairroFornecedor = :bairroFornecedor"),
    @NamedQuery(name = "Fornecedor.findByCidadeFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.cidadeFornecedor = :cidadeFornecedor"),
    @NamedQuery(name = "Fornecedor.findByEstadoFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.estadoFornecedor = :estadoFornecedor"),
    @NamedQuery(name = "Fornecedor.findByCepFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.cepFornecedor = :cepFornecedor")})
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_fornecedor", nullable = false)
    private Integer codigoFornecedor;
    @Column(name = "site_fornecedor", length = 50)
    private String siteFornecedor;
    @Basic(optional = false)
    @Column(name = "cnpj_fornecedor", nullable = false, length = 18)
    private String cnpjFornecedor;
    @Basic(optional = false)
    @Column(name = "nome_fornecedor", nullable = false, length = 50)
    private String nomeFornecedor;
    @Basic(optional = false)
    @Column(name = "nome_vendedor", nullable = false, length = 50)
    private String nomeVendedor;
    @Basic(optional = false)
    @Column(name = "email_vendedor", nullable = false, length = 50)
    private String emailVendedor;
    @Column(name = "logradouro_fornecedor", length = 100)
    private String logradouroFornecedor;
    @Column(name = "numero_logradouro_fornecedor")
    private Integer numeroLogradouroFornecedor;
    @Column(name = "complemento_logradouro_fornecedor", length = 50)
    private String complementoLogradouroFornecedor;
    @Column(name = "bairro_fornecedor", length = 30)
    private String bairroFornecedor;
    @Column(name = "cidade_fornecedor", length = 30)
    private String cidadeFornecedor;
    @Column(name = "estado_fornecedor", length = 30)
    private String estadoFornecedor;
    @Column(name = "cep_fornecedor", length = 10)
    private String cepFornecedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoFornecedor")
    private List<TelefoneFornecedor> telefoneFornecedorList;

    public Fornecedor() {
    }

    public Fornecedor(Integer codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    public Fornecedor(Integer codigoFornecedor, String cnpjFornecedor, String nomeFornecedor, String nomeVendedor, String emailVendedor) {
        this.codigoFornecedor = codigoFornecedor;
        this.cnpjFornecedor = cnpjFornecedor;
        this.nomeFornecedor = nomeFornecedor;
        this.nomeVendedor = nomeVendedor;
        this.emailVendedor = emailVendedor;
    }

    public Integer getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public void setCodigoFornecedor(Integer codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    public String getSiteFornecedor() {
        return siteFornecedor;
    }

    public void setSiteFornecedor(String siteFornecedor) {
        this.siteFornecedor = siteFornecedor;
    }

    public String getCnpjFornecedor() {
        return cnpjFornecedor;
    }

    public void setCnpjFornecedor(String cnpjFornecedor) {
        this.cnpjFornecedor = cnpjFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public String getEmailVendedor() {
        return emailVendedor;
    }

    public void setEmailVendedor(String emailVendedor) {
        this.emailVendedor = emailVendedor;
    }

    public String getLogradouroFornecedor() {
        return logradouroFornecedor;
    }

    public void setLogradouroFornecedor(String logradouroFornecedor) {
        this.logradouroFornecedor = logradouroFornecedor;
    }

    public Integer getNumeroLogradouroFornecedor() {
        return numeroLogradouroFornecedor;
    }

    public void setNumeroLogradouroFornecedor(Integer numeroLogradouroFornecedor) {
        this.numeroLogradouroFornecedor = numeroLogradouroFornecedor;
    }

    public String getComplementoLogradouroFornecedor() {
        return complementoLogradouroFornecedor;
    }

    public void setComplementoLogradouroFornecedor(String complementoLogradouroFornecedor) {
        this.complementoLogradouroFornecedor = complementoLogradouroFornecedor;
    }

    public String getBairroFornecedor() {
        return bairroFornecedor;
    }

    public void setBairroFornecedor(String bairroFornecedor) {
        this.bairroFornecedor = bairroFornecedor;
    }

    public String getCidadeFornecedor() {
        return cidadeFornecedor;
    }

    public void setCidadeFornecedor(String cidadeFornecedor) {
        this.cidadeFornecedor = cidadeFornecedor;
    }

    public String getEstadoFornecedor() {
        return estadoFornecedor;
    }

    public void setEstadoFornecedor(String estadoFornecedor) {
        this.estadoFornecedor = estadoFornecedor;
    }

    public String getCepFornecedor() {
        return cepFornecedor;
    }

    public void setCepFornecedor(String cepFornecedor) {
        this.cepFornecedor = cepFornecedor;
    }

    @XmlTransient
    public List<TelefoneFornecedor> getTelefoneFornecedorList() {
        return telefoneFornecedorList;
    }

    public void setTelefoneFornecedorList(List<TelefoneFornecedor> telefoneFornecedorList) {
        this.telefoneFornecedorList = telefoneFornecedorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoFornecedor != null ? codigoFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.codigoFornecedor == null && other.codigoFornecedor != null) || (this.codigoFornecedor != null && !this.codigoFornecedor.equals(other.codigoFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "odonto.Fornecedor[ codigoFornecedor=" + codigoFornecedor + " ]";
    }
    
}
