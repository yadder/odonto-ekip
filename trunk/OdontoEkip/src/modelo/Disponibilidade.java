package modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Disponibilidade")
public class Disponibilidade {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codigoDisponibilidade;
	@Column(length=50)
	private String diaSemana;
	
	@Column(name="horaInicio")
	@Temporal(TemporalType.TIME)
	private Date horaInicio;
	
	@Column(name="horaFim")
	@Temporal(TemporalType.TIME)
	private Date horaFim;

	@ManyToOne	
    @JoinColumn(name="croDentista")
	private Dentista dentista;
		
	public Dentista getDentista() {
		return dentista;
	}

	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}

	public Integer getCodigoDisponibilidade() {
		return codigoDisponibilidade;
	}

	public void setCodigoDisponibilidade(Integer codigoDisponibilidade) {
		this.codigoDisponibilidade = codigoDisponibilidade;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}
	
	public Disponibilidade() {
		// TODO Auto-generated constructor stub
	}

	public Disponibilidade(Integer codigoDisponibilidade, String diaSemana,
			Date horaInicio, Date horaFim, Dentista dentista) {
		super();
		this.codigoDisponibilidade = codigoDisponibilidade;
		this.diaSemana = diaSemana;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.dentista = dentista;
	}

	
	
}
