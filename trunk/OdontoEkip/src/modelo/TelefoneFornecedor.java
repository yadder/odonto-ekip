package modelo;

public class TelefoneFornecedor {

	private Integer codigoTelefone;
	
	private Integer codigoFornecedor;
	
	private Integer ddd;
	
	private String telefone;

	public Integer getCodigoTelefone() {
		return codigoTelefone;
	}

	public void setCodigoTelefone(Integer codigoTelefone) {
		this.codigoTelefone = codigoTelefone;
	}

	public Integer getCodigoFornecedor() {
		return codigoFornecedor;
	}

	public void setCodigoFornecedor(Integer codigoFornecedor) {
		this.codigoFornecedor = codigoFornecedor;
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

	public TelefoneFornecedor(Integer codigoTelefone, Integer codigoFornecedor,
			Integer ddd, String telefone) {
		this.codigoTelefone = codigoTelefone;
		this.codigoFornecedor = codigoFornecedor;
		this.ddd = ddd;
		this.telefone = telefone;
	}
	
	
}
