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
    @Column(name = "id_odontograma", nullable = false)
    private long idOdontograma;
    @Column(name = "valor_odontograma", nullable = false)
    private double valorOdontograma;
    @Column(name = "data_inicio_odontograma", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataInicioOdontograma;
    
    @Column(name = "data_fim_odontograma", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataFimOdontograma;
    
    @Column(name = "status_odontograma", nullable = false, length = 20)
    private String statusOdontograma;

    @ManyToOne(fetch=FetchType.EAGER)
	private Dentista dentista;
    
    @ManyToOne(fetch=FetchType.EAGER)
	private Paciente paciente;
    
    public Odontograma() {
    }

    public Odontograma(long idOdontograma) {
        this.idOdontograma = idOdontograma;
    }

    public Date getDataInicioOdontograma() {
		return dataInicioOdontograma;
	}

	public void setDataInicioOdontograma(Date dataInicioOdontograma) {
		this.dataInicioOdontograma = dataInicioOdontograma;
	}

	public Date getDataFimOdontograma() {
		return dataFimOdontograma;
	}

	public void setDataFimOdontograma(Date dataFimOdontograma) {
		this.dataFimOdontograma = dataFimOdontograma;
	}

	public long getIdOdontograma() {
        return idOdontograma;
    }

    public void setIdOdontograma(long idOdontograma) {
        this.idOdontograma = idOdontograma;
    }

    public double getValorOdontograma() {
        return valorOdontograma;
    }

    public void setValorOdontograma(double valorOdontograma) {
        this.valorOdontograma = valorOdontograma;
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
        return "odonto.Odontograma[ idOdontograma=" + idOdontograma + " ]";
    }
    
}
