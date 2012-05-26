package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "tb_consulta")
public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_consulta", nullable = false)
    private long codigoConsulta;
    @Column(name = "data_consulta", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataConsulta;
    @Column(name = "status_consulta", nullable = false, length = 20)
    private String statusConsulta;
    @JoinColumn(name = "codigo_paciente", referencedColumnName = "codigo_paciente", nullable = false)
    @ManyToOne(optional = false)
    private Paciente codigoPaciente;
    @JoinColumn(name = "codigo_dentista", referencedColumnName = "codigo_dentista", nullable = false)
    @ManyToOne(optional = false)
    private Dentista codigoDentista;

    public Consulta() {
    }

    public Consulta(Integer codigoConsulta) {
        this.codigoConsulta = codigoConsulta;
    }

    public Consulta(long codigoConsulta, Date dataConsulta, String statusConsulta) {
        this.codigoConsulta = codigoConsulta;
        this.dataConsulta = dataConsulta;
        this.statusConsulta = statusConsulta;
    }

    public long getCodigoConsulta() {
        return codigoConsulta;
    }

    public void setCodigoConsulta(long codigoConsulta) {
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

    public Paciente getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(Paciente codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public Dentista getCodigoDentista() {
        return codigoDentista;
    }

    public void setCodigoDentista(Dentista codigoDentista) {
        this.codigoDentista = codigoDentista;
    }
    
}
