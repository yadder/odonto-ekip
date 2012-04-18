package modelo;

public class TelefonePaciente {

	private Integer codigoTelefone;
	
	private Integer codigoPaciente;
	
	private Integer ddd;
	
	private String telefone;

	public Integer getCodigoTelefone() {
		return codigoTelefone;
	}

	public void setCodigoTelefone(Integer codigoTelefone) {
		this.codigoTelefone = codigoTelefone;
	}

	public Integer getCodigoPaciente() {
		return codigoPaciente;
	}

	public void setCodigoPaciente(Integer codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
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
	
	public TelefonePaciente() {
		// TODO Auto-generated constructor stub
	}

	public TelefonePaciente(Integer codigoTelefone, Integer codigoPaciente,
			Integer ddd, String telefone) {
		this.codigoTelefone = codigoTelefone;
		this.codigoPaciente = codigoPaciente;
		this.ddd = ddd;
		this.telefone = telefone;
	}
	
	
}
