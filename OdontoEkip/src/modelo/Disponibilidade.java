package modelo;

import java.util.Date;

public class Disponibilidade {

	private Integer codigoDisponibilidade;
	
	private String diaSemana;
	
	private Date horaInicio;
	
	private Date horaFim;

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
			Date horaInicio, Date horaFim) {
		this.codigoDisponibilidade = codigoDisponibilidade;
		this.diaSemana = diaSemana;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
	}
	
	
}
