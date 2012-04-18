package modelo;

import java.util.Date;

public class Consulta {

	private Integer codigoConsulta;
	
	private Date dataConsulta;
	
	private String statusConsulta;

	public Integer getCodigoConsulta() {
		return codigoConsulta;
	}

	public void setCodigoConsulta(Integer codigoConsulta) {
		this.codigoConsulta = codigoConsulta;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public String getStatusConsulta() {
		return statusConsulta;
	}

	public void setStatusConsulta(String statusConsulta) {
		this.statusConsulta = statusConsulta;
	}
	
	public Consulta() {
		// TODO Auto-generated constructor stub
	}

	public Consulta(Integer codigoConsulta, Date dataConsulta,
			String statusConsulta) {
		this.codigoConsulta = codigoConsulta;
		this.dataConsulta = dataConsulta;
		this.statusConsulta = statusConsulta;
	}
	
	
	
}
