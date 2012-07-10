package modelo;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "tb_consulta")
public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta", nullable = false)
    private long idConsulta;
    @Column(name = "data_consulta", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataConsulta;
    @Column(name = "status_consulta", nullable = false, length = 20)
    private String statusConsulta;
    @Column(name = "hora_inicio", nullable = false)
    private Time horaInicio;
    @Column(name = "hora_fim", nullable = false)
    private Time horaFim;
    @ManyToOne(fetch=FetchType.EAGER)
	private Paciente paciente;
    @ManyToOne(fetch=FetchType.EAGER)
	private Dentista dentista;
    
    public Consulta() {
    }

    public long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(long idConsulta) {
        this.idConsulta = idConsulta;
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

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Dentista getDentista() {
		return dentista;
	}

	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Time horaFim) {
		this.horaFim = horaFim;
	}
    
}
