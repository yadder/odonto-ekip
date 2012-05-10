package modelo;

import java.util.List;

public class Convenio {

	private Integer codigoConvenio;
	private String nomeConvenio;
	private List<Paciente> paciente;

	public List<Paciente> getPaciente() {
		return paciente;
	}

	public void setPaciente(List<Paciente> paciente) {
		this.paciente = paciente;
	}

	public Integer getCodigoConvenio() {
		return codigoConvenio;
	}

	public void setCodigoConvenio(Integer codigoConvenio) {
		this.codigoConvenio = codigoConvenio;
	}

	public String getNomeConvenio() {
		return nomeConvenio;
	}

	public void setNomeConvenio(String nomeConvenio) {
		this.nomeConvenio = nomeConvenio;
	}

	public Convenio(Integer codigoConvenio, String nomeConvenio) {
		this.codigoConvenio = codigoConvenio;
		this.nomeConvenio = nomeConvenio;
	}
	
	public Convenio() {
	
	}
}
