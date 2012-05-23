package modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tb_telefone_paciente")
public class TelefonePaciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_telefone", nullable = false)
    private Integer codigoTelefone;
    @Basic(optional = false)
    @Column(name = "ddd_telefone_paciente", nullable = false, length = 2)
    private String dddTelefonePaciente;
    @Basic(optional = false)
    @Column(name = "telefone_paciente", nullable = false, length = 9)
    private String telefonePaciente;
    @JoinColumn(name = "codigo_paciente", referencedColumnName = "codigo_paciente", nullable = false)
    @ManyToOne(optional = false)
    private Paciente codigoPaciente;

    public TelefonePaciente() {
    }

    public TelefonePaciente(Integer codigoTelefone) {
        this.codigoTelefone = codigoTelefone;
    }

    public TelefonePaciente(Integer codigoTelefone, String dddTelefonePaciente, String telefonePaciente) {
        this.codigoTelefone = codigoTelefone;
        this.dddTelefonePaciente = dddTelefonePaciente;
        this.telefonePaciente = telefonePaciente;
    }

    public Integer getCodigoTelefone() {
        return codigoTelefone;
    }

    public void setCodigoTelefone(Integer codigoTelefone) {
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
    public int hashCode() {
        int hash = 0;
        hash += (codigoTelefone != null ? codigoTelefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefonePaciente)) {
            return false;
        }
        TelefonePaciente other = (TelefonePaciente) object;
        if ((this.codigoTelefone == null && other.codigoTelefone != null) || (this.codigoTelefone != null && !this.codigoTelefone.equals(other.codigoTelefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "odonto.TelefonePaciente[ codigoTelefone=" + codigoTelefone + " ]";
    }
    
}
