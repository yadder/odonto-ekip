package modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tb_telefone_paciente")
public class TelefonePaciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_telefone", nullable = false)
    private long codigoTelefone;
    @Column(name = "ddd_telefone_paciente", nullable = false, length = 2)
    private String dddTelefonePaciente;
    @Column(name = "telefone_paciente", nullable = false, length = 9)
    private String telefonePaciente;
    @JoinColumn(name = "codigo_paciente", referencedColumnName = "codigo_paciente", nullable = false)
    @ManyToOne(optional = false)
    private Paciente codigoPaciente;

    public TelefonePaciente() {
    }

    public TelefonePaciente(long codigoTelefone) {
        this.codigoTelefone = codigoTelefone;
    }

    public TelefonePaciente(long codigoTelefone, String dddTelefonePaciente, String telefonePaciente) {
        this.codigoTelefone = codigoTelefone;
        this.dddTelefonePaciente = dddTelefonePaciente;
        this.telefonePaciente = telefonePaciente;
    }

    public long getCodigoTelefone() {
        return codigoTelefone;
    }

    public void setCodigoTelefone(long codigoTelefone) {
        this.codigoTelefone = codigoTelefone;
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

    public Paciente getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(Paciente codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    @Override
    public String toString() {
        return "odonto.TelefonePaciente[ codigoTelefone=" + codigoTelefone + " ]";
    }
    
}
