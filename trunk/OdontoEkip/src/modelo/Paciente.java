package modelo;

import java.util.Date;

public class Paciente extends Usuario{

	private String rgPaciente;
	
	private String cpfPaciente;
	
	private Date dataNascimento;
	
	private String sexoPaciente;
	
	private String responsavelPaciente;
	
	private String statusPaciente;
	
	private String tipoConvenio;
	
	private String logradrouroPaciente;
	
	private Integer numeroPaciente;
	
	private String complementoPaciente;
	
	private String bairroPaciente;
	
	private String cidadePaciente;
	
	private String estadoPaciente;
	
	private String cepPaciente;

	public String getRgPaciente() {
		return rgPaciente;
	}

	public void setRgPaciente(String rgPaciente) {
		this.rgPaciente = rgPaciente;
	}

	public String getCpfPaciente() {
		return cpfPaciente;
	}

	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexoPaciente() {
		return sexoPaciente;
	}

	public void setSexoPaciente(String sexoPaciente) {
		this.sexoPaciente = sexoPaciente;
	}

	public String getResponsavelPaciente() {
		return responsavelPaciente;
	}

	public void setResponsavelPaciente(String responsavelPaciente) {
		this.responsavelPaciente = responsavelPaciente;
	}

	public String getStatusPaciente() {
		return statusPaciente;
	}

	public void setStatusPaciente(String statusPaciente) {
		this.statusPaciente = statusPaciente;
	}

	public String getTipoConvenio() {
		return tipoConvenio;
	}

	public void setTipoConvenio(String tipoConvenio) {
		this.tipoConvenio = tipoConvenio;
	}

	public String getLogradrouroPaciente() {
		return logradrouroPaciente;
	}

	public void setLogradrouroPaciente(String logradrouroPaciente) {
		this.logradrouroPaciente = logradrouroPaciente;
	}

	public Integer getNumeroPaciente() {
		return numeroPaciente;
	}

	public void setNumeroPaciente(Integer numeroPaciente) {
		this.numeroPaciente = numeroPaciente;
	}

	public String getComplementoPaciente() {
		return complementoPaciente;
	}

	public void setComplementoPaciente(String complementoPaciente) {
		this.complementoPaciente = complementoPaciente;
	}

	public String getBairroPaciente() {
		return bairroPaciente;
	}

	public void setBairroPaciente(String bairroPaciente) {
		this.bairroPaciente = bairroPaciente;
	}

	public String getCidadePaciente() {
		return cidadePaciente;
	}

	public void setCidadePaciente(String cidadePaciente) {
		this.cidadePaciente = cidadePaciente;
	}

	public String getEstadoPaciente() {
		return estadoPaciente;
	}

	public void setEstadoPaciente(String estadoPaciente) {
		this.estadoPaciente = estadoPaciente;
	}

	public String getCepPaciente() {
		return cepPaciente;
	}

	public void setCepPaciente(String cepPaciente) {
		this.cepPaciente = cepPaciente;
	}
	
	public Paciente() {
	
	}

	public Paciente(String rgPaciente, String cpfPaciente, Date dataNascimento,
			String sexoPaciente, String responsavelPaciente,
			String statusPaciente, String tipoConvenio,
			String logradrouroPaciente, Integer numeroPaciente,
			String complementoPaciente, String bairroPaciente,
			String cidadePaciente, String estadoPaciente, String cepPaciente) {
		super();
		this.rgPaciente = rgPaciente;
		this.cpfPaciente = cpfPaciente;
		this.dataNascimento = dataNascimento;
		this.sexoPaciente = sexoPaciente;
		this.responsavelPaciente = responsavelPaciente;
		this.statusPaciente = statusPaciente;
		this.tipoConvenio = tipoConvenio;
		this.logradrouroPaciente = logradrouroPaciente;
		this.numeroPaciente = numeroPaciente;
		this.complementoPaciente = complementoPaciente;
		this.bairroPaciente = bairroPaciente;
		this.cidadePaciente = cidadePaciente;
		this.estadoPaciente = estadoPaciente;
		this.cepPaciente = cepPaciente;
	}
	
	
}
