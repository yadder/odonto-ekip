package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TelefonePaciente")
public class TelefonePaciente {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codigoTelefone;
	
	@Column(length=3)
	private Integer ddd;
	
	@Column(length=9)
	private String telefone;

	@ManyToOne	
    @JoinColumn(name="codigoPaciente")
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
