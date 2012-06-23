package modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tb_telefone_paciente")
public class TelefonePaciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefone", nullable = false)
    private long idTelefone;
    @Column(name = "ddd_telefone_paciente", nullable = false, length = 2)
    private String dddTelefonePaciente;
    @Column(name = "telefone_paciente", nullable = false, length = 9)
    private String telefonePaciente;
    
    @ManyToOne(fetch=FetchType.EAGER)
	private Paciente paciente;
    
    
    public TelefonePaciente() {
    }

    public TelefonePaciente(long idTelefone) {
        this.idTelefone = idTelefone;
    }

    public TelefonePaciente(long idTelefone, String dddTelefonePaciente, String telefonePaciente) {
        this.idTelefone = idTelefone;
        this.dddTelefonePaciente = dddTelefonePaciente;
        this.telefonePaciente = telefonePaciente;
    }

    public long getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(long idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getDddTelefonePaciente() {
        return dddTelefonePaciente;
    }

    public void setDddTelefonePaciente(String dddTelefonePaciente) {
        this.dddTelefonePaciente = dddTelefonePaciente;
    }

    public String getTelefonePaciente() {
        return telefonePaciente;
    }

    public void setTelefonePaciente(String telefonePaciente) {
        this.telefonePaciente = telefonePaciente;
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
        return "odonto.TelefonePaciente[ idTelefone=" + idTelefone + " ]";
    }
    
}
