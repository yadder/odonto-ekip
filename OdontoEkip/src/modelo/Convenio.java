package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="convenio")
public class Convenio {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codigoConvenio;
	@Column(name="nomeConvenio", length=50)
	private String nomeConvenio;
	
	@OneToOne
    @JoinColumn(name="codigoPaciente")
	private Dentista dentista;

	public Dentista getDentista() {
		return dentista;
	}

	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
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
