package modelo;

import java.util.List;

public class Dentista extends Usuario {

	private Integer croDentista;
	private List<Disponibilidade> disponibilidade;
	private List<Prescricao> prescricao;
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
