package modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="dentista")
@PrimaryKeyJoinColumn(name="codigoDentista")
public class Dentista extends Usuario {

	@Column(name="croDentista")
	private Integer croDentista;
	
	@OneToMany(mappedBy="dentista", fetch=FetchType.EAGER)
	private List<Disponibilidade> disponibilidade;

	@OneToMany(mappedBy="dentista", fetch=FetchType.EAGER)
	private List<Prescricao> prescricao;
	
	@OneToMany(mappedBy="dentista", fetch=FetchType.EAGER)
	private List<Consulta> consulta;
	
	public List<Prescricao> getPrescricao() {
		return prescricao;
	}

	public void setPrescricao(List<Prescricao> prescricao) {
		this.prescricao = prescricao;
	}

	public List<Consulta> getConsulta() {
		return consulta;
	}

	public void setConsulta(List<Consulta> consulta) {
		this.consulta = consulta;
	}

	public List<Disponibilidade> getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(List<Disponibilidade> disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public Integer getCroDentista() {
		return croDentista;
	}

	public void setCroDentista(Integer croDentista) {
		this.croDentista = croDentista;
	}
	
	public Dentista() {

	}

	public Dentista(Integer croDentista, List<Disponibilidade> disponibilidade,
			List<Prescricao> prescricao, List<Consulta> consulta) {
		super();
		this.croDentista = croDentista;
		this.disponibilidade = disponibilidade;
		this.prescricao = prescricao;
		this.consulta = consulta;
	}

	
}
