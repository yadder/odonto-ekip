package modelo;

import java.util.Date;

public class Odontograma {

	private Integer codigoOdontograma;
	
	private Integer codigoDentista;
	
	private Integer codigoPaciente;
	
	private Double valorOdontograma;
	
	private Date dataOdontograma;
	
	private String statusOdontograma;

	public Integer getCodigoOdontograma() {
		return codigoOdontograma;
	}

	public void setCodigoOdontograma(Integer codigoOdontograma) {
		this.codigoOdontograma = codigoOdontograma;
	}

	public Integer getCodigoDentista() {
		return codigoDentista;
	}

	public void setCodigoDentista(Integer codigoDentista) {
		this.codigoDentista = codigoDentista;
	}

	public Integer getCodigoPaciente() {
		return codigoPaciente;
	}

	public void setCodigoPaciente(Integer codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}

	public Double getValorOdontograma() {
		return valorOdontograma;
	}

	public void setValorOdontograma(Double valorOdontograma) {
		this.valorOdontograma = valorOdontograma;
	}

	public Date getDataOdontograma() {
		return dataOdontograma;
	}

	public void setDataOdontograma(Date dataOdontograma) {
		this.dataOdontograma = dataOdontograma;
	}

	public String getStatusOdontograma() {
		return statusOdontograma;
	}

	public void setStatusOdontograma(String statusOdontograma) {
		this.statusOdontograma = statusOdontograma;
	}
	
	public Odontograma() {
		// TODO Auto-generated constructor stub
	}

	public Odontograma(Integer codigoOdontograma, Integer codigoDentista,
			Integer codigoPaciente, Double valorOdontograma,
			Date dataOdontograma, String statusOdontograma) {
		this.codigoOdontograma = codigoOdontograma;
		this.codigoDentista = codigoDentista;
		this.codigoPaciente = codigoPaciente;
		this.valorOdontograma = valorOdontograma;
		this.dataOdontograma = dataOdontograma;
		this.statusOdontograma = statusOdontograma;
	}
	
	
}
