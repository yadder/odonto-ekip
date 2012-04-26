package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TelefoneFornecedor")
public class TelefoneFornecedor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codigoTelefone;
	
	@Column(length=2)
	private Integer ddd;
	
	@Column(length=8)
	private String telefone;

	@ManyToOne	
    @JoinColumn(name="codigoFornecedor")
	private Fornecedor fornecedor;
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	
	public Integer getCodigoTelefone() {
		return codigoTelefone;
	}

	public void setCodigoTelefone(Integer codigoTelefone) {
		this.codigoTelefone = codigoTelefone;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public TelefoneFornecedor() {
		// TODO Auto-generated constructor stub
	}

	public TelefoneFornecedor(Integer codigoTelefone, Integer ddd,
			String telefone, Fornecedor fornecedor) {
		super();
		this.codigoTelefone = codigoTelefone;
		this.ddd = ddd;
		this.telefone = telefone;
		this.fornecedor = fornecedor;
	}

	
}
