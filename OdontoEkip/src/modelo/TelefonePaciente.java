package modelo;

public class TelefonePaciente {

	private Integer codigoTelefone;
	private Integer ddd;
	private String telefone;
	private Paciente paciente;
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
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
	
	public TelefonePaciente() {
		// TODO Auto-generated constructor stub
	}

	public TelefonePaciente(Integer codigoTelefone, Integer ddd,
			String telefone, Paciente paciente) {
		super();
		this.codigoTelefone = codigoTelefone;
		this.ddd = ddd;
		this.telefone = telefone;
		this.paciente = paciente;
	}

	
	
}
