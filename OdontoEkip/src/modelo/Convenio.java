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
@Table(name="convenio")
public class Convenio {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codigoConvenio;

	@Column(name="nomeConvenio", length=50)
	private String nomeConvenio;
	
	@OneToMany(mappedBy="convenio", fetch=FetchType.EAGER)
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
