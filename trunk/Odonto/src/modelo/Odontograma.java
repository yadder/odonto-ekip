package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "tb_odontograma")
public class Odontograma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_odontograma", nullable = false)
    private long codigoOdontograma;
    @Column(name = "valor_odontograma", nullable = false)
    private double valorOdontograma;
    @Column(name = "data_odontograma", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataOdontograma;
    @Column(name = "status_odontograma", nullable = false, length = 20)
    private String statusOdontograma;

    @ManyToOne(fetch=FetchType.EAGER)
	private Dentista dentista;
    
    @ManyToOne(fetch=FetchType.EAGER)
	private Paciente paciente;
    
    public Odontograma() {
    }

    public Odontograma(long codigoOdontograma) {
        this.codigoOdontograma = codigoOdontograma;
    }

    public Odontograma(long codigoOdontograma, double valorOdontograma, Date dataOdontograma, String statusOdontograma) {
        this.codigoOdontograma = codigoOdontograma;
        this.valorOdontograma = valorOdontograma;
        this.dataOdontograma = dataOdontograma;
        this.statusOdontograma = statusOdontograma;
    }

    public long getCodigoOdontograma() {
        return codigoOdontograma;
    }

    public void setCodigoOdontograma(long codigoOdontograma) {
        this.codigoOdontograma = codigoOdontograma;
    }

    public double getValorOdontograma() {
        return valorOdontograma;
    }

    public void setValorOdontograma(double valorOdontograma) {
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

    public Dentista getDentista() {
		return dentista;
	}

	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
    public String toString() {
        return "odonto.Odontograma[ codigoOdontograma=" + codigoOdontograma + " ]";
    }
    
}
