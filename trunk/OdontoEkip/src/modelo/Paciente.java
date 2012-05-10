package modelo;

import java.util.List;

public class Paciente extends Usuario{

	private Integer codigoPaciente;
	private String responsavelPaciente;
	private String statusPaciente;
	private String logradrouroPaciente;
	private Integer numeroPaciente;
	private String complementoPaciente;
	private String bairroPaciente;
	private String cidadePaciente;
	private String estadoPaciente;
	private String cepPaciente;
	private Convenio convenio;	
	private List<TelefonePaciente> telefonePaciente;
	private List<InqueritoOdontologico> inqueritoOdontologico;
	
	
	public Integer getCodigoPaciente() {
		return codigoPaciente;
	}

	public void setCodigoPaciente(Integer codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}

	public List<InqueritoOdontologico> getInqueritoOdontologico() {
		return inqueritoOdontologico;
	}

	public void setInqueritoOdontologico(
			List<InqueritoOdontologico> inqueritoOdontologico) {
		this.inqueritoOdontologico = inqueritoOdontologico;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public List<TelefonePaciente> getTelefonePaciente() {
		return telefonePaciente;
	}

	public void setTelefonePaciente(List<TelefonePaciente> telefonePaciente) {
		this.telefonePaciente = telefonePaciente;
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

	
	
}
