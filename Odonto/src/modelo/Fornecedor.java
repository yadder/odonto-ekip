package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_fornecedor")
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fornecedor", nullable = false)
    private long idFornecedor;
    @Column(name = "site_fornecedor", length = 50)
    private String siteFornecedor;
    @Column(name = "cnpj_fornecedor", nullable = false, length = 18)
    private String cnpjFornecedor;
    @Column(name = "nome_fornecedor", nullable = false, length = 50)
    private String nomeFornecedor;
    @Column(name = "nome_vendedor", nullable = false, length = 50)
    private String nomeVendedor;
    @Column(name = "email_vendedor", nullable = false, length = 50)
    private String emailVendedor;
    @Column(name = "logradouro_fornecedor", length = 100)
    private String logradouroFornecedor;
    @Column(name = "numero_logradouro_fornecedor")
    private String numeroLogradouroFornecedor;
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
    @Column(name = "ddd1_fornecedor", length = 2)
    private String ddd1Fornecedor;
    @Column(name = "telefone1_fornecedor", length = 9)
    private String telefone1Fornecedor;
    @Column(name = "ddd2_fornecedor", length = 2)
    private String ddd2Fornecedor;
    @Column(name = "telefone2_fornecedor", length = 9)
    private String telefone2Fornecedor;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "idFornecedor")
    private List<TelefoneFornecedor> telefoneFornecedorList;
*/
    public Fornecedor() {
    }

    public Fornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public Fornecedor(String nomeFornecedor, String nomeVendedor,
			String emailVendedor, String siteFornecedor, String cnpjFornecedor,
			String logradouroFornecedor, String numeroLogradouroFornecedor,
			String complementoLogradouroFornecedor, String bairroFornecedor,
			String cidadeFornecedor, String estadoFornecedor,
			String cepFornecedor, String ddd1Fornecedor,
			String telefone1Fornecedor, String ddd2Fornecedor,
			String telefone2Fornecedor) {
		this.nomeFornecedor = nomeFornecedor;
		this.nomeVendedor = nomeVendedor;
		this.emailVendedor = emailVendedor;
		this.siteFornecedor = siteFornecedor;
		this.cnpjFornecedor = cnpjFornecedor;
		this.logradouroFornecedor = logradouroFornecedor;
		this.numeroLogradouroFornecedor = numeroLogradouroFornecedor;
		this.complementoLogradouroFornecedor = complementoLogradouroFornecedor;
		this.bairroFornecedor = bairroFornecedor;
		this.cidadeFornecedor = cidadeFornecedor;
		this.estadoFornecedor = estadoFornecedor;
		this.cepFornecedor = cepFornecedor;
		this.ddd1Fornecedor = ddd1Fornecedor;
		this.telefone1Fornecedor = telefone1Fornecedor;
		this.ddd2Fornecedor = ddd2Fornecedor;
		this.telefone2Fornecedor = telefone2Fornecedor;
	}

	public long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
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

    public String getNumeroLogradouroFornecedor() {
        return numeroLogradouroFornecedor;
    }

    public void setNumeroLogradouroFornecedor(String numeroLogradouroFornecedor) {
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

 /*   @XmlTransient
    public List<TelefoneFornecedor> getTelefoneFornecedorList() {
        return telefoneFornecedorList;
    }

    public void setTelefoneFornecedorList(List<TelefoneFornecedor> telefoneFornecedorList) {
        this.telefoneFornecedorList = telefoneFornecedorList;
    }
*/
	public String getDdd1Fornecedor() {
		return ddd1Fornecedor;
	}

	public void setDdd1Fornecedor(String ddd1Fornecedor) {
		this.ddd1Fornecedor = ddd1Fornecedor;
	}

	public String getTelefone1Fornecedor() {
		return telefone1Fornecedor;
	}

	public void setTelefone1Fornecedor(String telefone1Fornecedor) {
		this.telefone1Fornecedor = telefone1Fornecedor;
	}

	public String getDdd2Fornecedor() {
		return ddd2Fornecedor;
	}

	public void setDdd2Fornecedor(String ddd2Fornecedor) {
		this.ddd2Fornecedor = ddd2Fornecedor;
	}

	public String getTelefone2Fornecedor() {
		return telefone2Fornecedor;
	}

	public void setTelefone2Fornecedor(String telefone2Fornecedor) {
		this.telefone2Fornecedor = telefone2Fornecedor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setIdFornecedor(long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	@Override
	public String toString() {
		return "Fornecedor [idFornecedor=" + idFornecedor + ", siteFornecedor="
				+ siteFornecedor + ", cnpjFornecedor=" + cnpjFornecedor
				+ ", nomeFornecedor=" + nomeFornecedor + ", nomeVendedor="
				+ nomeVendedor + ", emailVendedor=" + emailVendedor
				+ ", logradouroFornecedor=" + logradouroFornecedor
				+ ", numeroLogradouroFornecedor=" + numeroLogradouroFornecedor
				+ ", complementoLogradouroFornecedor="
				+ complementoLogradouroFornecedor + ", bairroFornecedor="
				+ bairroFornecedor + ", cidadeFornecedor=" + cidadeFornecedor
				+ ", estadoFornecedor=" + estadoFornecedor + ", cepFornecedor="
				+ cepFornecedor + ", ddd1Fornecedor=" + ddd1Fornecedor
				+ ", telefone1Fornecedor=" + telefone1Fornecedor
				+ ", ddd2Fornecedor=" + ddd2Fornecedor
				+ ", telefone2Fornecedor=" + telefone2Fornecedor + "]";
	}
    
	
    
   
}
