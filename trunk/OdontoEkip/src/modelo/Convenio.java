package modelo;

public class Convenio {

	private Integer codigoConvenio;
	
	private String nomeConvenio;

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
