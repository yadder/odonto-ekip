package modelo;

public class TelefoneFornecedor {
	
	private Integer codigoTelefone;
	private Integer ddd;
	private String telefone;
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
