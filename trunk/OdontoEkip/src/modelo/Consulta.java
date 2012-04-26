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
@Table(name="Consulta")
public class Consulta {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codigoConsulta;
	
	@Column(name="dataConsulta")
	@Temporal(TemporalType.DATE)
	private Date dataConsulta;
	
	@Column(name="statusConsulta", length=30 ,nullable=false)
	private String statusConsulta;

	@ManyToOne	
    @JoinColumn(name="croDentista")
	private Dentista dentista;

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

	public Dentista getDentista() {
		return dentista;
	}

	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}

	public Consulta(Integer codigoConsulta, Date dataConsulta,
			String statusConsulta, Dentista dentista) {
		super();
		this.codigoConsulta = codigoConsulta;
		this.dataConsulta = dataConsulta;
		this.statusConsulta = statusConsulta;
		this.dentista = dentista;
	}

	
	
}
