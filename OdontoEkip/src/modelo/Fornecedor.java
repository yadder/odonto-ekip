package modelo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Fornecedor")
public class Fornecedor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codigoFornecedor")
	private Integer codigoFornecedor;
	@Column(name="nomeFornecedor", nullable=false)
	private String nomeFornecedor;
	@Column(name="nomeVendendor", nullable=false)
	private String nomeVendendor;
	@Column(name="emailVendedor", length=100)
	private String emailVendendor;
	@Column(name="siteFornecedor")
	private String siteFornecedor;
	@Column(name="cnpjFornecedor", length=14)
	private String cnpjFornecedor;
	@Column(name="logradouroFornecedor")
	private String logradouroFornecedor;
	@Column(name="numeroFornecedor", length=10)
	private Integer numeroFornecedor;
	@Column(name="complementoFornecedor")
	private String complementoFornecedor;
	@Column(name="bairroFornecedor", length=50)
	private String bairroFornecedor;
	@Column(name="cidadeFornecedor", length=50)
	private String cidadeFornecedor;
	@Column(name="estadoFornecedor", length=50)
	private String estadoFornecedor;
	@Column(name="cepFornecedor", length=8)
	private String cepFornecedor;
	
	@OneToMany(mappedBy="fornecedor", fetch=FetchType.EAGER)
	private List<TelefoneFornecedor> telefoneFornecedor;
	
	public List<TelefoneFornecedor> getTelefoneFornecedor() {
		return telefoneFornecedor;
	}

	public void setTelefoneFornecedor(List<TelefoneFornecedor> telefoneFornecedor) {
		this.telefoneFornecedor = telefoneFornecedor;
	}

	public Integer getCodigoFornecedor() {
		return codigoFornecedor;
	}

	public void setCodigoFornecedor(Integer codigoFornecedor) {
		this.codigoFornecedor = codigoFornecedor;
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public String getNomeVendendor() {
		return nomeVendendor;
	}

	public void setNomeVendendor(String nomeVendendor) {
		this.nomeVendendor = nomeVendendor;
	}

	public String getEmailVendendor() {
		return emailVendendor;
	}

	public void setEmailVendendor(String emailVendendor) {
		this.emailVendendor = emailVendendor;
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

	public String getLogradouroFornecedor() {
		return logradouroFornecedor;
	}

	public void setLogradouroFornecedor(String logradouroFornecedor) {
		this.logradouroFornecedor = logradouroFornecedor;
	}

	public Integer getNumeroFornecedor() {
		return numeroFornecedor;
	}

	public void setNumeroFornecedor(Integer numeroFornecedor) {
		this.numeroFornecedor = numeroFornecedor;
	}

	public String getComplementoFornecedor() {
		return complementoFornecedor;
	}

	public void setComplementoFornecedor(String complementoFornecedor) {
		this.complementoFornecedor = complementoFornecedor;
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
	
	public Fornecedor() {
		// TODO Auto-generated constructor stub
	}

	public Fornecedor(Integer codigoFornecedor, String nomeFornecedor,
			String nomeVendendor, String emailVendendor, String siteFornecedor,
			String cnpjFornecedor, String logradouroFornecedor,
			Integer numeroFornecedor, String complementoFornecedor,
			String bairroFornecedor, String cidadeFornecedor,
			String estadoFornecedor, String cepFornecedor,
			List<TelefoneFornecedor> telefoneFornecedor) {
		super();
		this.codigoFornecedor = codigoFornecedor;
		this.nomeFornecedor = nomeFornecedor;
		this.nomeVendendor = nomeVendendor;
		this.emailVendendor = emailVendendor;
		this.siteFornecedor = siteFornecedor;
		this.cnpjFornecedor = cnpjFornecedor;
		this.logradouroFornecedor = logradouroFornecedor;
		this.numeroFornecedor = numeroFornecedor;
		this.complementoFornecedor = complementoFornecedor;
		this.bairroFornecedor = bairroFornecedor;
		this.cidadeFornecedor = cidadeFornecedor;
		this.estadoFornecedor = estadoFornecedor;
		this.cepFornecedor = cepFornecedor;
		this.telefoneFornecedor = telefoneFornecedor;
	}

	
	
}
